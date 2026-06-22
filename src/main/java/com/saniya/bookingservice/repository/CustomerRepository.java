package com.saniya.bookingservice.repository;

import com.saniya.bookingservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;

public interface CustomerRepository
        extends JpaRepository<Customer, Long> {
    @Query("SELECT COALESCE(SUM(c.amount),0) FROM Customer c")
    Double getTotalRevenue();
    @Query("SELECT COUNT(c) FROM Customer c")
    Long getTotalBookings();
    @Query("""
       SELECT COUNT(c)
       FROM Customer c
       WHERE c.appointmentDate = CURRENT_DATE
       """)
    Long getTodayBookings();


    boolean existsByAppointmentDateAndAppointmentSlot(
            LocalDate appointmentDate,
            String appointmentSlot
    );
}