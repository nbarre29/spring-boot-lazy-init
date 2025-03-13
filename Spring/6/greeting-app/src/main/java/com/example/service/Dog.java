package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class Dog implements  Animal {
    @Override
    public String sound() {
        return "Bark";
    }
}
