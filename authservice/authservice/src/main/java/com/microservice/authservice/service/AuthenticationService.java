package com.microservice.authservice.service;

import com.microservice.authservice.dto.AuthResponse;
import com.microservice.authservice.dto.LoginRequest;
import com.microservice.authservice.dto.RegisterRequest;

public interface AuthenticationService {
    String register(RegisterRequest registerRequest);

    AuthResponse login(LoginRequest loginRequest);
}
