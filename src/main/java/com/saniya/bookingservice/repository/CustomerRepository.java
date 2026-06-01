package com.saniya.bookingservice.repository;

import com.saniya.bookingservice.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository
        extends JpaRepository<Customer, Long> {

}