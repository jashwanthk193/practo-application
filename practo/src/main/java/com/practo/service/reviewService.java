package com.practo.service;

import com.practo.Entity.Doctor;
import com.practo.Entity.patient;
import com.practo.Entity.review;
import com.practo.payload.doctorDto;
import com.practo.repository.DoctorRepository;
import com.practo.repository.PatientRepository;
import com.practo.repository.reviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class reviewService {
    @Autowired
    private DoctorRepository doctorrepo;
    @Autowired
    private PatientRepository patientrepo;

    @Autowired
    private reviewRepository reviewrepo;

    public review createreview(review reviews) {
        Doctor doctor = doctorrepo.findById(reviews.getDoctorId()).get();
        patient patient = patientrepo.findById(reviews.getPatientId()).get();
        review savedreview = null;
        if (doctor != null || (patient != null)) {

            reviewrepo.save(reviews);

        }
        return savedreview;
    }

    public doctorDto findBydoctorId(long doctorid) {
        Doctor doctor = doctorrepo.findById(doctorid).get();

            List<review> reviewed = reviewrepo.findByDoctorId(doctorid);
            double totalRating=0;
        for (review reviews:reviewed) {
            totalRating+= reviews.getRating();

        }
        double averageRating=totalRating/reviewed.size();
        double ratingPercentage=(averageRating/5.0)*100.0;
            doctorDto dtos = new doctorDto();
            dtos.setDoctor(doctor);

            dtos.setReviews(reviewed);
            dtos.setRatingPercentage(ratingPercentage);
             return dtos ;


    }
}

