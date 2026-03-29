package com.library.userserver.controller;

import com.library.userserver.entity.UserProfile;
import com.library.userserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-profile")
public class UserServiceController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public UserProfile getById(@PathVariable Long id){
        return userService.getById(id);
    }
    @GetMapping
    public List<UserProfile> getAllUser(){
        return userService.getAllUser();
    }
    @PostMapping
    public UserProfile addUser(@RequestBody UserProfile userProfile){
        return userService.createUser(userProfile);
    }
    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable Long id){
        return userService.deleteById(id);
    }
}
