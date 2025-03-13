package com.example.userapp.service;

import com.example.userapp.model.User;

import java.util.List;

public interface UserService {
    User getUserById(Long userId);
    List<User> getUsers(String name, Integer age);
}
