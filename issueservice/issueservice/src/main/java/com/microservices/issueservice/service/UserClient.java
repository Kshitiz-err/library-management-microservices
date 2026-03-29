package com.microservices.issueservice.service;

import com.microservices.issueservice.entity.UserProfile;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "UserService")
public interface UserClient {
    @GetMapping("/user-profile/{id}")
    public UserProfile getById(@PathVariable Long id);
}
