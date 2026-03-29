package com.library.userserver.service;

import com.library.userserver.entity.UserProfile;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List<UserProfile> getAllUser();
    UserProfile getById(Long id);
    UserProfile createUser(UserProfile userProfile);
    boolean deleteById(Long id);
}
