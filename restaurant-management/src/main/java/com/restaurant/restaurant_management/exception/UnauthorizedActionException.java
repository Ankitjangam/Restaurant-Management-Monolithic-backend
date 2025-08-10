package com.restaurant.restaurant_management.exception;


/**
 * Exception thrown when an unauthorized action is attempted.
 * This could be due to insufficient permissions or access rights.
 */
public class UnauthorizedActionException extends RuntimeException {
    public UnauthorizedActionException(String message) {
        super(message);
    }
}
