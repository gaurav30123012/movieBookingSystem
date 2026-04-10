package com.example.movieBooking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Movie {
    @Id
    private String id;
    private String name;
    private int duration;
    private String language;
}
