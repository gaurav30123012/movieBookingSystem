package com.example.movieBooking.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Screen {

    @Id
    private String id;

    private String name;

    @ManyToOne
    private Theatre theatre;

}
