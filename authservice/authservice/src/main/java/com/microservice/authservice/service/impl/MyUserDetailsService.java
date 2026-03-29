package com.microservice.authservice.service.impl;

import com.microservice.authservice.entity.User;
import com.microservice.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            User userByUsername = userRepository.findUserByUsername(username);
            if(userByUsername!=null){
                return new MyUserPrinciple(userByUsername);
            }else{
                throw new UsernameNotFoundException(username+" not found please check at your end");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
