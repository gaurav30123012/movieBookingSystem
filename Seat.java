package com.example.movieBooking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Seat {
    @Id
    private String id;

    private String rowNumber;
    private int seatNumber;

    @ManyToOne
    private Screen screen;
}
