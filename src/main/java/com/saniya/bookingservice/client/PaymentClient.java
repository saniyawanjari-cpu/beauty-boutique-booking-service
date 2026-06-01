package com.saniya.bookingservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "payment-service")
public interface PaymentClient {

    @GetMapping("/pay")
    String makePayment();
}