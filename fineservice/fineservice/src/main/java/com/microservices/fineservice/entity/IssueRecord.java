package com.microservices.fineservice.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Component
@Getter
@Setter
public class IssueRecord {
    private Long id;
    private Long userId;
    private Long bookId;
    private LocalDate issueDate;
    private LocalDate dueDate;
    @Nullable
    private LocalDate returnDate;
    private Status status;
    private LocalDateTime createdAt;
}
