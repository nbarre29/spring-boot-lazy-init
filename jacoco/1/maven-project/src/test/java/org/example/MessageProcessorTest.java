package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MessageProcessorTest {

    @Test
    void testProcessMessage() {
        // Arrange: Create a mock MessageService
        MessageService mockMessageService = Mockito.mock(MessageService.class);

        // Inject the mock into the MessageProcessor
        MessageProcessor processor = new MessageProcessor(mockMessageService);

        String testMessage = "Hello, World!";
        String testRecipient = "example@example.com";

        // Act: Call the processMessage method
        processor.processMessage(testMessage, testRecipient);

        // Assert: Verify that the mock's sendMessage method was called with the correct arguments
        verify(mockMessageService, times(1)).sendMessage(testMessage, testRecipient);
    }
}
