package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary // Marking this as the primary implementation
public class EnglishGreetingService implements GreetingService {
    @Override
    public String greet() {
        return "Hello!";
    }
}
