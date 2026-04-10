package com.example.movieBooking.controller;

import com.example.movieBooking.dto.BookingRequest;
import com.example.movieBooking.entity.Booking;
import com.example.movieBooking.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/create")
    public Booking createBooking(@RequestBody BookingRequest bookingRequest){
        return bookingService.book(bookingRequest);
    }

}
