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
    public Object saveBooking(
            @RequestBody Customer customer
    ) {

        boolean slotExists =
                repo.existsByAppointmentDateAndAppointmentSlot(
                        customer.getAppointmentDate(),
                        customer.getAppointmentSlot()
                );

        if (slotExists) {

            return "Slot already booked";
        }

        return repo.save(customer);
    }
    @GetMapping("/pay")
    public String pay() {

        return paymentClient.makePayment();

    }
}