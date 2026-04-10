package com.example.movieBooking.repository;

import com.example.movieBooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository  extends JpaRepository<Booking, String> {
}
