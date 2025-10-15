package com.chrisking.qap2.book_api.exception;


import java.time.LocalDateTime;
import java.util.List;


public class ApiError {
    private final LocalDateTime timestamp = LocalDateTime.now();
    private String message;
    private List<String> details;


    public ApiError(String message, List<String> details) {
        this.message = message;
        this.details = details;
    }


    public LocalDateTime getTimestamp() { return timestamp; }
    public String getMessage() { return message; }
    public List<String> getDetails() { return details; }
}