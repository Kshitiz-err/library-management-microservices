package com.microservice.authservice.service.impl;

import com.microservice.authservice.dto.AuthResponse;
import com.microservice.authservice.dto.LoginRequest;
import com.microservice.authservice.dto.RegisterRequest;
import com.microservice.authservice.entity.Role;
import com.microservice.authservice.entity.User;
import com.microservice.authservice.repository.UserRepository;
import com.microservice.authservice.service.AuthenticationService;
import com.microservice.authservice.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class AuthServiceImpl implements AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserDetailsService userDetailsService;
    @Override
    public String register(RegisterRequest registerRequest) {
        User user= new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setCreatedAt(LocalDateTime.now());
        user.setRole(Role.MEMBER);
        user.setAccountActive(true);
        User save = userRepository.save(user);
        return "User Registered successfully";
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(), loginRequest.getPassword()
                )
        );
        String token="Not found User with name: "+loginRequest.getUsername();
        if(authenticate.isAuthenticated()){
            UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
            token = jwtService.generateToken(userDetails);

        }AuthResponse authResponse=new AuthResponse();
        authResponse.setToken(token);
        authResponse.setUsername(loginRequest.getUsername());
        return authResponse;
    }
}
