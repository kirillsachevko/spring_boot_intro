package com.epam.spring_boot_intro.exception;

public class CustomerException extends RuntimeException{
    public CustomerException() {
    }

    public CustomerException(String message) {
        super(message);
    }
}
