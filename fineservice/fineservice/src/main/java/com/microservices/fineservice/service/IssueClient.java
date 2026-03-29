package com.microservices.fineservice.service;

import com.microservices.fineservice.entity.IssueRecord;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "IssueService")
public interface IssueClient {
    @GetMapping("/{id}")
    public IssueRecord getById(@PathVariable Long id);
}
