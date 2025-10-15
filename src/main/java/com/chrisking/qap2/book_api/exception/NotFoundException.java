package com.chrisking.qap2.book_api.exception;

/**
 * Custom exception thrown when a requested resource is not found.
 */
public class NotFoundException extends RuntimeException {
    // Constructor that accepts an error message
    public NotFoundException(String message) { super(message); }
}