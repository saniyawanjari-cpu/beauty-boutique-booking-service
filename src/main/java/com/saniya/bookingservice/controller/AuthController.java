package com.saniya.bookingservice.controller;

import com.saniya.bookingservice.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    JwtService jwtService;

    @PostMapping("/login")
    public String login() {

        return jwtService.generateToken("saniya");
    }
}