package com.practo.service;

import com.practo.Entity.Booking;
import com.practo.payload.BookingDto;
import com.practo.repository.bookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class bookingService {
    @Autowired
    private bookingRepository bookingrepo;
public void bookAnAppointment(BookingDto dto){
    List<String> availableTimeSlots=new ArrayList<>();
    availableTimeSlots.add("10:15 AM");
    availableTimeSlots.add("11:15 AM");
    availableTimeSlots.add("12:15 PM");
    Booking booking = new Booking();
//    Iterator<String> iterator = availableTimeSlots.iterator();
//    while (iterator.hasNext()) {
//        String slot = iterator.next();
//        if (slot.equals(dto.getBookingTime())) {
//            booking.setBookingTime(dto.getBookingTime());
//            iterator.remove(); // Use iterator to safely remove the element
//            break;
//        }
//    }


    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    executor.scheduleAtFixedRate(() -> {
        availableTimeSlots.add("10:15 AM");
        availableTimeSlots.add("11:15 AM");
        availableTimeSlots.add("12:15 PM");
        System.out.println("Executing scheduled task at: " + LocalDateTime.now());
        // You can add your logic here for the automatic execution
    }, 0, 24, TimeUnit.HOURS); // Execute every 24 hours


    booking.setDoctorId(dto.getDoctorId());
    booking.setPatientId(dto.getPatientId());
    if(booking.getBookingTime()!=null) {
        bookingrepo.save(booking);
    }else{
        System.out.println("time slot is not available");
    }


}
}
