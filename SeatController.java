package com.example.movieBooking.controller;

import com.example.movieBooking.dto.SeatResponse;
import com.example.movieBooking.entity.Seat;
import com.example.movieBooking.services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shows")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping("/{showId}/seats")
    public List<SeatResponse> getSeats(@PathVariable String showId){
        List<SeatResponse> seats = seatService.getSeats(showId);
        return seats;
    }
}
