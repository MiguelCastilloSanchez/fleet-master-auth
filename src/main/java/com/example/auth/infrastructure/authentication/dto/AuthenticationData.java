package com.example.auth.infrastructure.authentication.dto;

import com.example.auth.entity.user.model.User;
import com.example.auth.usecase.authentication.dto.IAuthenticationData;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationData(

    @NotBlank
    String username,

    @NotBlank
    String password

) implements IAuthenticationData {
        public AuthenticationData(User user) {
                this(
                    user.getUsername(),
                    user.getPassword()
                );
        }
}
