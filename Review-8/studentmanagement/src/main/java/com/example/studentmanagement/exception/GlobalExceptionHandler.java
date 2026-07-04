package com.example.studentmanagement.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//used to handle exceptions globally
//applies to all controllers in the application
@RestControllerAdvice
public class GlobalExceptionHandler {
    // handles student not found exception
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> handleStudentNotFound(StudentNotFoundException ex) {
        // returns the exception msg with http status error code 404
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // handles duplicate email exception
    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<String> DuplicateEmailException(DuplicateEmailException ex) {
        // returns the exception msg with http status error code 400
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // handles all exceptions that are not handled above
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        // returns the exception msg with http status error code 500
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
