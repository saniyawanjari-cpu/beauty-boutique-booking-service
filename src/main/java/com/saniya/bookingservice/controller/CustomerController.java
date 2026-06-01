package com.saniya.bookingservice.controller;

import com.saniya.bookingservice.entity.Customer;
import com.saniya.bookingservice.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.saniya.bookingservice.client.PaymentClient;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class CustomerController {

    @Autowired
    CustomerRepository repo;

    @Autowired
    PaymentClient paymentClient;

    @GetMapping
    public List<Customer> getAllBookings() {

        return repo.findAll();
    }

    @PostMapping
    public Customer saveBooking(
            @RequestBody Customer customer
    ) {

        return repo.save(customer);
    }

    @GetMapping("/pay")
    public String pay() {

        return paymentClient.makePayment();

    }
}