package org.example;

public class MessageProcessor {
    private final MessageService messageService;

    // Constructor injection
    public MessageProcessor(MessageService messageService) {
        this.messageService = messageService;
    }

    public void processMessage(String message, String recipient) {
        messageService.sendMessage(message, recipient);
    }
}