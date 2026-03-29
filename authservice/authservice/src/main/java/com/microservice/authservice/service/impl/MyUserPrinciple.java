package com.microservice.authservice.service.impl;

import com.microservice.authservice.entity.Role;
import com.microservice.authservice.entity.User;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MyUserPrinciple implements UserDetails {
    private User user;
    public MyUserPrinciple(User user) {
        this.user=user;
    }
    //need to add the Simple Granted Authority
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Role role = user.getRole();
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_"+role.name()));
    }

    @Override
    public @Nullable String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
}
