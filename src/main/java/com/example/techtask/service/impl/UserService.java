package com.example.techtask.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.techtask.model.User;
import com.example.techtask.repository.UserRepository;
import java.util.List;

@Service
public class UserService implements com.example.techtask.service.UserService {
    
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public User findUser(){
        return userRepository.findUser();
    }

    public List<User> findUsers(){
        return userRepository.findUsers();
    }
}
