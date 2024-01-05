package com.practo.repository;

import com.practo.Entity.patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<patient,Long> {
}
