package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class GreetingController {

    private final GreetingService primaryService;
    private final GreetingService spanishService;

    @Autowired
    public GreetingController(
        GreetingService primaryService, // This will inject the @Primary bean
        @Qualifier("spanishGreetingService") GreetingService spanishService // Explicitly specifying the Spanish bean
    ) {
        this.primaryService = primaryService;
        this.spanishService = spanishService;
    }

    @GetMapping("/default")
    public String defaultGreet() {
        return primaryService.greet(); // Uses the @Primary bean
    }

    @GetMapping("/spanish")
    public String spanishGreet() {
        return spanishService.greet(); // Uses the explicitly specified Spanish bean
    }
}
