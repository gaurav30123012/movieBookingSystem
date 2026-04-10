package com.example.movieBooking.repository;

import com.example.movieBooking.entity.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreenRepository extends JpaRepository<Screen,String> {
}
