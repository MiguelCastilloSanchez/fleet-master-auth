package com.example.auth.infrastructure.authentication.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth.entity.user.exception.UserNotFoundException;
import com.example.auth.infrastructure.authentication.dto.AuthenticationData;
import com.example.auth.infrastructure.authentication.dto.LoginResponseData;
import com.example.auth.usecase.authentication.LoginUseCase;


@RestController
public class Login {

    @Autowired
    private LoginUseCase loginUseCase;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponseData authenticate(@Valid @RequestBody AuthenticationData data) throws UserNotFoundException{
        return new LoginResponseData(loginUseCase.execute(data));
    }

}
