mvn clean install
mvn spring-boot:run

GET: http://localhost:8080/api/hello

1) By default, Spring Boot uses Logback as the logging implementation with SLF4J.

<!-- Spring Boot Starter for Logging (SLF4J + Logback) -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
    </dependency>
	
	
Explanation of Key Components

    SLF4J Logger:
        LoggerFactory.getLogger(Class) creates an SLF4J logger.
        Logging levels: DEBUG, INFO, WARN, ERROR.

    Spring Boot Starter:
        spring-boot-starter includes SLF4J and Logback by default.

    Configuration:
        Log levels can be adjusted in the application.properties file.