package com.example.studentmanagement.exception;

// custom exception thrown when email already exists
public class DuplicateEmailException extends RuntimeException {

    // constructor to pass error message
    public DuplicateEmailException(String message) {
        super(message);
    }
}
