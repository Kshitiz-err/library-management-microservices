package com.microservice.inventoryservice.entity;

import jakarta.persistence.Entity;
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
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
    private Long id;
    private String title;
    private String isbn;//international standard book number
    private String authorName;
    private  String genre;
    private String publisher;
    private int publishedYear;
    private LocalDateTime createdAt;
}

