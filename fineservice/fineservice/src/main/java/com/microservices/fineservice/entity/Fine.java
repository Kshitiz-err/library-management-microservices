package com.microservices.fineservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Fine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long issueId;
    private int dayLate;
    private BigDecimal amount;
    private Status status;
    private LocalDateTime createdAt;
    transient private IssueRecord issueRecord;
}
