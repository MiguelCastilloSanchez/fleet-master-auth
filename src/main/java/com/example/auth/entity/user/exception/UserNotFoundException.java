package com.example.auth.entity.user.exception;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super("Couldn't find the user!");
    }
}
