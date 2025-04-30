package com.example.auth.entity.admin.exception;

public class AdminNotFoundException extends Exception {

    public AdminNotFoundException() {
        super("Couldn't find the admin!");
    }
}
