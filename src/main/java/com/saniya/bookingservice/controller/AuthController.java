package com.saniya.bookingservice.controller;
import com.saniya.bookingservice.dto.LoginRequest;
import java.util.Optional;
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
    public String login(
            @RequestBody LoginRequest request
    ) {

        Optional<User> userOptional =
                userRepository.findByUsername(
                        request.getUsername()
                );

        if(userOptional.isEmpty()) {
            return "User Not Found";
        }

        User user = userOptional.get();

        boolean passwordMatches =
                passwordEncoder.matches(
                        request.getPassword(),
                        user.getPassword()
                );

        if(!passwordMatches) {
            return "Invalid Password";
        }

        return jwtService.generateToken(
                user.getUsername()
        );
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