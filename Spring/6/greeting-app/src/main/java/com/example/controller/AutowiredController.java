package com.example.controller;

import com.example.service.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autowire")
public class AutowiredController {

    @Qualifier("cat")
    @Autowired
    private Animal animal;

    @GetMapping
    public String fetchSound() {
        return animal.sound();
    }
}
