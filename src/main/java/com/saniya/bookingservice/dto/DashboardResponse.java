package com.saniya.bookingservice.dto;

public class DashboardResponse {

    private Double totalRevenue;
    private Long totalBookings;
    private Long todayBookings;

    public DashboardResponse(
            Double totalRevenue,
            Long totalBookings,
            Long todayBookings
    ) {
        this.totalRevenue = totalRevenue;
        this.totalBookings = totalBookings;
        this.todayBookings = todayBookings;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public Long getTotalBookings() {
        return totalBookings;
    }

    public Long getTodayBookings() {
        return todayBookings;
    }
}