package com.practo.controller;

import com.practo.Entity.patient;
import com.practo.service.patientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/patients")
public class patientController {
    @Autowired
    private patientService patientservice;
    @PostMapping
    public ResponseEntity<patient> createpost(@RequestBody patient patients){
      return new ResponseEntity<> (patientservice.createpatient(patients), HttpStatus.CREATED);

    }

}
