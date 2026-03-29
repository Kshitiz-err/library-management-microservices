package com.microservice.authservice.controller;

import com.microservice.authservice.dto.AuthResponse;
import com.microservice.authservice.dto.LoginRequest;
import com.microservice.authservice.dto.RegisterRequest;
import com.microservice.authservice.service.AuthenticationService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    private AuthResponse login(@RequestBody LoginRequest loginRequest){
        return authenticationService.login(loginRequest);
    }

    @PostMapping("/register")
    private String register(@RequestBody RegisterRequest registerRequest){
        return authenticationService.register(registerRequest);
    }
}
