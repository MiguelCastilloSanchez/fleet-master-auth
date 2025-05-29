package com.example.auth.entity.admin.exception;

import jakarta.persistence.EntityNotFoundException;

public class AdminNotFoundException extends EntityNotFoundException {

    public AdminNotFoundException() {
        super("Couldn't find the admin!");
    }
}
