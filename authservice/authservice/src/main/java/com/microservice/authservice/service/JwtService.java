package com.microservice.authservice.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public interface JwtService {
    Key getSignKey();
    String generateToken(UserDetails userDetails);
    String extractUsername(String token);

    boolean validateToken(String token, UserDetails userDetails);
}
