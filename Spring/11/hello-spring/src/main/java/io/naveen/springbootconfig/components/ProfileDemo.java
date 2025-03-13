package io.naveen.springbootconfig.components;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProfileDemo {

    @Value("${message}")
    String message;

    @PostConstruct
    public void printMessage() {
        System.out.println("Message: " + message);
    }

}
