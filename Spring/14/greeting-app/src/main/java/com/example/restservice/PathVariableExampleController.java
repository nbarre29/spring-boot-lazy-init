package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PathVariableExampleController {

    @GetMapping("/users/{id}")
    public String getUserById(@PathVariable("id") int userId) {
        return "User ID: " + userId;
    }
}
