package com.example.studentmanagement.exception;


//custom exception thrown when a student is not found
public class StudentNotFoundException extends RuntimeException {

    //constructor to accept custom error message
    public StudentNotFoundException(String message) {
        super(message);
    }

}
