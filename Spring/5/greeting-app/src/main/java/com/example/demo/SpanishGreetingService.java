package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class SpanishGreetingService implements GreetingService {
    @Override
    public String greet() {
        return "¡Hola!";
    }
}
