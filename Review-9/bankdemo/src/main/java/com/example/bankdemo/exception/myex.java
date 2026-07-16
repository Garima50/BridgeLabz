package com.example.bankdemo.exception;

public class myex  extends RuntimeException{

    public myex(){
        super("User Not Found, Sorry");
    }
}
