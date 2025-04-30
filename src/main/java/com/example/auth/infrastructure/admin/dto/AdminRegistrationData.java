package com.example.auth.infrastructure.admin.dto;

import com.example.auth.infrastructure.user.validation.formats.RightName;
import com.example.auth.infrastructure.user.validation.security.RightCode;
import com.example.auth.infrastructure.user.validation.unique.UniqueEmail;
import com.example.auth.infrastructure.user.validation.unique.UniqueUsername;
import com.example.auth.usecase.admin.dto.IAdminRegistrationData;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AdminRegistrationData(

        @NotBlank
        @Size(min = 4, max = 20)
        @UniqueUsername(message = "{unique.user.username}")
        String username,

        @NotBlank
        @Size(min = 8, max = 64)
        String password,

        @NotBlank
        @Size(min = 2, max = 60)
        @RightName(message = "{right.user.name}")
        String name,

        @NotBlank
        @Size(min = 3, max = 40)
        @Email
        @UniqueEmail(message = "{unique.user.email}")
        String email,
        
        @NotBlank
        @Size(min = 5, max = 12)
        @RightCode(message = "{right.admin.code}")
        String code
        
        ) implements IAdminRegistrationData { }