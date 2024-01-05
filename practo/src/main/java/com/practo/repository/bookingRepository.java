package com.practo.repository;

import com.practo.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bookingRepository extends JpaRepository<Booking,Long> {
}
