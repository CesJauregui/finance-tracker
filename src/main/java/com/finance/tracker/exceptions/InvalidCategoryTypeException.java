package com.finance.tracker.exceptions;

public class InvalidCategoryTypeException extends RuntimeException {
    public InvalidCategoryTypeException(String message) {
        super(message);
    }
}
