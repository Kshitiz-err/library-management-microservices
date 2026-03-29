package com.microservices.issueservice.service;

import com.microservices.issueservice.entity.Book;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient( name = "CatalogServer")
public interface BookClient {
    @GetMapping("/catalog/{id}")
    public Book getById(@PathVariable Long id);
}
