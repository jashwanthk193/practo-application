package com.practo.repository;

import com.practo.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository  extends JpaRepository<Doctor,Long> {

        List<Doctor> findByNameContainingOrSpecializationContaining(String name, String specialization);
        // You can add more custom search queries if needed


}
