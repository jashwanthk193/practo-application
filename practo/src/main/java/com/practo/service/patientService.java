package com.practo.service;

import com.practo.Entity.patient;
import com.practo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class patientService {
    @Autowired
   private PatientRepository patientrepo;
    public patient createpatient(patient patients){
        patient savedpatient = patientrepo.save(patients);
        return patients;
    }


}
