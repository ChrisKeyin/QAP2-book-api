package com.chrisking.qap2.book_api.exception;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Class representing an API error response.
 */
public class ApiError {
    // Timestamp when the error occurred
    private final LocalDateTime timestamp = LocalDateTime.now();

    // Error message
    private String message;

    // List of error details
    private List<String> details;

    // Constructor to initialize message and details
    public ApiError(String message, List<String> details) {
        this.message = message;
        this.details = details;
    }

    // Getter for timestamp
    public LocalDateTime getTimestamp() { return timestamp; }

    // Getter for message
    public String getMessage() { return message; }

    // Getter for details
    public List<String> getDetails() { return details; }
}