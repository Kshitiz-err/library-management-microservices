package com.microservices.issueservice.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserProfile {
    private Long id;
    private Long auth_User_id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;
    private MemberShip memberShip;
    private LocalDateTime createdAt;
    //private Role role;
}
