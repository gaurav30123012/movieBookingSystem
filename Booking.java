package com.example.movieBooking.entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Booking {
    @Id
    private String id;

    private String userId;
    private String showId;

    @ElementCollection
    private List<String> seatIds;

    private String status;
}
