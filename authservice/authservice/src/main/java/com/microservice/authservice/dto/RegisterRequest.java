package com.microservice.authservice.dto;


import com.microservice.authservice.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
//@AllArgsConstructor
public class RegisterRequest {
    private String username;
    private String password;
    //private boolean isAccountActive;
    //private LocalDateTime createdAt;
    //private Role role;
}
