package com.saniya.bookingservice.controller;
import com.saniya.bookingservice.dto.DashboardResponse;
import com.saniya.bookingservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    CustomerRepository repo;
    @GetMapping("/total-bookings")
    public Long getTotalBookings() {

        return repo.getTotalBookings();
    }
    @GetMapping("/today-bookings")
    public Long getTodayBookings() {

        return repo.getTodayBookings();
    }

    @GetMapping("/revenue")
    public Double getRevenue() {

        return repo.getTotalRevenue();
    }
    @GetMapping("/dashboard")
    public DashboardResponse getDashboard() {

        return new DashboardResponse(
                repo.getTotalRevenue(),
                repo.getTotalBookings(),
                repo.getTodayBookings()
        );
    }
}