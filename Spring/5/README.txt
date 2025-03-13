I used ChatGPT for this example:

mvn clean install
mvn spring-boot:run

GET: http://localhost:8080/greet/default

GET: http://localhost:8080/greet/spanish


Here’s an example of a Spring Boot application that demonstrates the use of the @Primary annotation. This example shows how Spring resolves bean conflicts by preferring the @Primary bean unless explicitly overridden using @Qualifier.
Scenario

We have two implementations of a service interface GreetingService:

    EnglishGreetingService
    SpanishGreetingService

We want EnglishGreetingService to be the default bean (@Primary) unless explicitly specified.


How It Works

    @Primary on EnglishGreetingService:
        Spring will default to using EnglishGreetingService wherever GreetingService is required unless another bean is explicitly specified using @Qualifier.

    @Qualifier:
        The @Qualifier annotation is used to explicitly inject SpanishGreetingService in the controller.

    Endpoints:
        http://localhost:8080/greet/default: Returns "Hello!" (the primary bean).
        http://localhost:8080/greet/spanish: Returns "¡Hola!" (the explicitly qualified bean).
		
		
Key Takeaways

    The @Primary annotation simplifies bean selection when multiple beans of the same type exist.
    Use @Qualifier to override the @Primary bean if needed.
    This approach maintains flexibility and clarity in dependency injection.
	
	
-> We do not need an AppConfig file to configure the beans because we are using the @Service annotation to mark the EnglishGreetingService and SpanishGreetingService classes as Spring beans. Spring Boot automatically scans and registers these beans if they are within the package structure specified by the @SpringBootApplication annotation.

Why an AppConfig is Not Needed

    Component Scanning:
        The @SpringBootApplication annotation enables component scanning in the package it resides in and its sub-packages.
        The @Service annotation marks the classes as Spring-managed beans, so they are automatically detected and registered.

    @Primary and @Qualifier Work Without Manual Configuration:
        The @Primary annotation is directly applied to the bean (EnglishGreetingService), so Spring knows which bean to prefer.
        The @Qualifier annotation is used to explicitly choose the other bean when needed.

When an AppConfig File is Needed

You would need an AppConfig file if:

    Manual Bean Configuration:
        You prefer to manually configure beans using @Bean methods instead of annotations like @Service.

    Third-Party Classes:
        If the classes (EnglishGreetingService and SpanishGreetingService) are not under your control (e.g., they come from a third-party library), and you cannot annotate them with @Service.

Optional: Example Using AppConfig

If you prefer to configure the beans manually via an AppConfig file, here's how it would look:
AppConfig.java

package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

    @Bean
    @Primary // Marking EnglishGreetingService as the primary bean
    public GreetingService englishGreetingService() {
        return new EnglishGreetingService();
    }

    @Bean
    public GreetingService spanishGreetingService() {
        return new SpanishGreetingService();
    }
}

Remove @Service Annotations

You would no longer need @Service annotations in EnglishGreetingService and SpanishGreetingService.
Which Approach to Use?

    Annotations (@Service):
        Simpler and more idiomatic in Spring Boot.
        Preferred for most use cases where you control the source code of the classes.

    AppConfig (@Bean):
        Useful for third-party classes or complex configurations (e.g., constructor injection with parameters or conditional beans).

For your scenario, using the @Service annotations is sufficient and aligns well with Spring Boot conventions