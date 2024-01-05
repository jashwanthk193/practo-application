package com.practo.controller;

import com.practo.Entity.review;
import com.practo.payload.doctorDto;
import com.practo.service.reviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
public class reviewController {
    @Autowired
    private reviewService reviewservice;
    @PostMapping
    public ResponseEntity<review> createreview(@RequestBody review reviews){
        return new ResponseEntity<>(reviewservice.createreview(reviews), HttpStatus.CREATED);
    }
    @GetMapping("/{doctorId}")
    public ResponseEntity<doctorDto> findBydoctorId(@PathVariable  long doctorId){
        doctorDto dto = reviewservice.findBydoctorId(doctorId);
        return new ResponseEntity<>(dto,HttpStatus.OK) ;
    }
}
