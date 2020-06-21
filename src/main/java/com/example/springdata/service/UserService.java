package com.example.springdata.service;

import com.example.springdata.domain.model.User;
import com.example.springdata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 */
@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User find(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
    }


    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
