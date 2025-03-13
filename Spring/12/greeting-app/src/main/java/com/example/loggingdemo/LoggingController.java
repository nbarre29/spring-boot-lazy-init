package com.example.loggingdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
class LoggingController {
    
    // SLF4J Logger
    private static final Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @GetMapping("/hello")
    public String sayHello() {
        logger.info("INFO: sayHello() method called");
        logger.debug("DEBUG: Preparing to return Hello message");
        logger.error("ERROR: Simulating an error message");
        return "Hello, SLF4J Logging in Spring Boot!";
    }
}