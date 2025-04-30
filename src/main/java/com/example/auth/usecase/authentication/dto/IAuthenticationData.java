package com.example.auth.usecase.authentication.dto;

// DTO (Data Transfer Object) interface to invert spring boot lib dependencies,
// respecting the decoupling of the use cases layer.
public interface IAuthenticationData {

    String username();

    String password();


}