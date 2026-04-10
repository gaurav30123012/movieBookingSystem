package com.example.movieBooking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class SeatLock {
    @Id
    private String id;

    private String seatId;
    private String showId;
    private String userId;
    private LocalDateTime expiryTime;
}
