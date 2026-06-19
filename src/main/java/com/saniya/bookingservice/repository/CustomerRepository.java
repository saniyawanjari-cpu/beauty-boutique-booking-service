package com.saniya.bookingservice.repository;

import com.saniya.bookingservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface CustomerRepository
        extends JpaRepository<Customer, Long> {

    boolean existsByAppointmentDateAndAppointmentSlot(
            LocalDate appointmentDate,
            String appointmentSlot
    );
}