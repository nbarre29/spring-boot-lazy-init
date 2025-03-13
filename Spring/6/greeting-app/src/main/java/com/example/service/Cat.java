package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class Cat implements  Animal {
    @Override
    public String sound() {
        return "Meow";
    }
}
