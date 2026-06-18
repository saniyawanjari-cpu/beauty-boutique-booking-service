package com.saniya.bookingservice.controller;

import com.saniya.bookingservice.dto.RegisterRequest;
import com.saniya.bookingservice.entity.User;
import com.saniya.bookingservice.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.saniya.bookingservice.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtService jwtService;

    @PostMapping("/login")
    public String login() {

        return jwtService.generateToken("saniya");
    }
    @PostMapping("/register")
    public String register(
            @RequestBody RegisterRequest request
    ) {

        User user = new User();

        user.setUsername(
                request.getUsername()
        );

        user.setPassword(
                passwordEncoder.encode(
                        request.getPassword()
                )
        );

        user.setRole("CUSTOMER");

        userRepository.save(user);

        return "User Registered Successfully";
    }
}