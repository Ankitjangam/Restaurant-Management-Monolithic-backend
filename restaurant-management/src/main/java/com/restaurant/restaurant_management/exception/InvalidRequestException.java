package com.restaurant.restaurant_management.exception;


/**
 * Custom exception class to handle invalid requests in the restaurant management system.
 * This exception is thrown when a request does not meet the required criteria or contains invalid data.
 */
public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException(String message) {
        super(message);
    }
}
