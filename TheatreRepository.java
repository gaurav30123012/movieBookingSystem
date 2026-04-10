package com.example.movieBooking.repository;

import com.example.movieBooking.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepository extends JpaRepository<Theatre,String> {
}
