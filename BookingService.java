package com.example.movieBooking.services;

import com.example.movieBooking.dto.BookingRequest;
import com.example.movieBooking.entity.Booking;
import com.example.movieBooking.entity.SeatLock;
import com.example.movieBooking.repository.BookingRepository;
import com.example.movieBooking.repository.SeatLockRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookingService {

    private static final int LOCK_TIME = 5;

    @Autowired
    private SeatLockRepository seatLockRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Transactional
    public Booking book(BookingRequest bookingRequest){


        // deleting expired locks
        seatLockRepository.deleteByExpiryTimeBefore(LocalDateTime.now());

        List<SeatLock> byShowIdAndSeatIdIn = seatLockRepository.findByShowIdAndSeatIdIn(bookingRequest.getShowId(), bookingRequest.getSeatIds());

        if(!byShowIdAndSeatIdIn.isEmpty()){
            throw new RuntimeException("Seats already locked!");
        }
        List<SeatLock> newLocks = bookingRequest.getSeatIds().stream().map(seatId -> {
            SeatLock lock = new SeatLock();
            lock.setId(UUID.randomUUID().toString());
            lock.setId(seatId);
            lock.setShowId(bookingRequest.getShowId());
            lock.setUserId(bookingRequest.getUserId());
            lock.setExpiryTime(LocalDateTime.now().plusMinutes(LOCK_TIME));
            return lock;
        }).toList();

        seatLockRepository.saveAll(newLocks);

        // payment simulation
        boolean paymentStatus=true;

        if(!paymentStatus){
            throw new RuntimeException("Payment failed");
        }

        //confirm the booking
        Booking booking=new Booking();
        booking.setId(UUID.randomUUID().toString());
        booking.setShowId(bookingRequest.getShowId());
        booking.setUserId(bookingRequest.getUserId());
        booking.setSeatIds(bookingRequest.getSeatIds());
        booking.setStatus("CONFIRMED");

       return bookingRepository.save(booking);
    }
}
