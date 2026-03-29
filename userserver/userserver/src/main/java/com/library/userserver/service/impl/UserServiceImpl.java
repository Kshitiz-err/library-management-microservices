package com.library.userserver.service.impl;

import com.library.userserver.entity.UserProfile;
import com.library.userserver.repository.UserProfileRepository;
import com.library.userserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public List<UserProfile> getAllUser() {
        return userProfileRepository.findAll();
    }

    @Override
    public UserProfile getById(Long id) {
        return userProfileRepository.findById(id).orElseThrow(()->new RuntimeException(" USER BY ID"+id+" NOT FOUND"));
    }

    @Override
    public UserProfile createUser(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    @Override
    public boolean deleteById(Long id) {
        try{
            userProfileRepository.deleteById(id);
            return true;
        }catch (Exception exception){
            System.err.println(exception.getMessage());
            exception.printStackTrace();
            return false;
        }
    }
}
