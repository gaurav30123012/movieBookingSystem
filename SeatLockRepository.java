package com.example.movieBooking.repository;

import com.example.movieBooking.entity.SeatLock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SeatLockRepository extends JpaRepository<SeatLock, String> {
    List<SeatLock> findByShowIdAndSeatIdIn(String showId, List<String> seatIds);

    void deleteByExpiryTimeBefore(LocalDateTime time);
}
