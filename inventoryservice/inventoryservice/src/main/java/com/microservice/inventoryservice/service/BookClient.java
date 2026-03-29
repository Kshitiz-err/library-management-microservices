package com.microservice.inventoryservice.service;

import com.microservice.inventoryservice.entity.Book;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tools.jackson.databind.util.ClassUtil;

@FeignClient(name = "CatalogServer")
public interface BookClient {
    @GetMapping("/catalog/{id}")
    public Book getById(@PathVariable Long id);
}
