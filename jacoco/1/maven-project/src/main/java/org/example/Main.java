package org.example;

public class Main {
    public static void main(String[] args) {
        // Inject the dependency via the constructor
        MessageService emailService = new EmailService();
        MessageProcessor processor = new MessageProcessor(emailService);

        // Use the processor to send a message
        processor.processMessage("Hello, World!", "example@example.com");
    }
}