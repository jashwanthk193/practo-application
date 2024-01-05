package com.practo.repository;


import com.practo.Entity.review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface reviewRepository extends JpaRepository<review,Long> {
List<review> findByDoctorId(long doctorId);
}
