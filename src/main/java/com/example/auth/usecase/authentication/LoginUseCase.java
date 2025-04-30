package com.example.auth.usecase.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.auth.entity.user.exception.UserNotFoundException;
import com.example.auth.usecase.authentication.dto.IAuthenticationData;
import com.example.auth.usecase.authentication.gateway.AuthenticationGateway;

@Service
public class LoginUseCase {

    @Autowired
    private AuthenticationGateway authenticationGateway;

    public String execute(IAuthenticationData data) throws UserNotFoundException{
        return this.authenticationGateway.authenticate(data.username(), data.password());
    }
}
