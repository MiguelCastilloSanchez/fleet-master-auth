package com.example.auth.usecase.authentication.gateway;

public interface AuthenticationGateway {
    String authenticate(String username, String password);
}
