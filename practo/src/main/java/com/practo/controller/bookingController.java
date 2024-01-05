package com.practo.controller;

import com.practo.payload.BookingDto;
import com.practo.service.bookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class bookingController {
    @Autowired
    private bookingService bookingservice;
    @PostMapping
    public ResponseEntity<String>bookAppointment(@RequestBody BookingDto dto){
    bookingservice.bookAnAppointment(dto);
return new ResponseEntity<>("booking is confirmed", HttpStatus.CREATED);
    }

}
