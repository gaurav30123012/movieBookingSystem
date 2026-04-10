package com.example.movieBooking.services;

import com.example.movieBooking.dto.SeatResponse;
import com.example.movieBooking.entity.Movie;
import com.example.movieBooking.entity.Seat;
import com.example.movieBooking.entity.SeatLock;
import com.example.movieBooking.repository.SeatLockRepository;
import com.example.movieBooking.repository.SeatRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private SeatLockRepository seatLockRepository;

    public List<SeatResponse> getSeats(String showId){

        List<Seat> seats = seatRepository.findAll();
        List<SeatLock> lockSeats = seatLockRepository.findAll();

        Set<String> lockedSeat = lockSeats.stream().filter(lock -> lock.getExpiryTime().isAfter(LocalDateTime.now()))
                .map(SeatLock::getSeatId).collect(Collectors.toSet());

        return seats.stream().map(seat->new SeatResponse(seat.getId(),lockedSeat.contains(seat.getId())?"LOCKED":"AVAILABLE")).
                collect(Collectors.toList());

    }
}
