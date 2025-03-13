package com.example.userapp.service;

import com.example.userapp.model.User;
import com.example.userapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
    }

    public List<User> getUsers(String name, Integer age) {
        List<User> allUsers = userRepository.findAll();
        return allUsers.stream()
                .filter(user -> (name == null || user.getName().equalsIgnoreCase(name)) &&
                                (age == null || user.getAge().equals(age)))
                .collect(Collectors.toList());
    }
}
