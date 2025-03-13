Added UserNotFoundException.java

GET: http://localhost:8080/users/4


com.example.userapp
├── controller
│   └── UserController.java
├── service
│   ├── UserService.java           // Interface
│   ├── UserServiceImpl.java       // Implementation
├── repository
│   ├── UserRepository.java        // Interface
│   ├── UserRepositoryImpl.java    // Implementation
├── model
│   └── User.java
├── exception
│   └── UserNotFoundException.java // New Exception Class
└── UserApplication.java


_________________________________________________________________________________________
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}

Creating UserNotFoundException as a RuntimeException has several advantages:  

1) Unchecked Exception: RuntimeException is an unchecked exception, meaning it does not need to be declared in a method's throws clause. This can lead to cleaner method signatures and less boilerplate code. 
 
2) Flexibility: It allows the exception to propagate up the call stack without requiring explicit handling at each level. This can be useful in scenarios where you want to handle the exception at a higher level in the application.  

3) Spring Framework Integration: In the context of a Spring application, using RuntimeException allows for seamless integration with Spring's exception handling mechanisms. For example, the @ResponseStatus annotation can be used to map the exception to an HTTP status code, as shown in your code. 
 
4) Simplified Error Handling: It simplifies error handling by allowing developers to focus on handling only the exceptions that they can reasonably recover from, while letting runtime exceptions bubble up to a global exception handler.
_________________________________________________________________________________________
