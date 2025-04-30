package com.example.auth.infrastructure.admin.dto;

import com.example.auth.infrastructure.user.validation.formats.RightName;
import com.example.auth.infrastructure.user.validation.unique.UniqueEmail;
import com.example.auth.infrastructure.user.validation.unique.UniqueUsername;
import com.example.auth.usecase.admin.dto.IAdminUpdateData;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record AdminUpdateData(

        // If a field is not provided, it will be considered valid for size validation
        
        @Size(min = 4, max = 20)
        @UniqueUsername(message = "{unique.user.username}")
        String username,

        @Size(min = 8, max = 64)
        String password,

        @Size(min = 2, max = 60)
        @RightName(message = "{name.user.name}")
        String name,

        @Size(min = 3, max = 40)
        @Email
        @UniqueEmail(message = "{unique.user.email}")
        String email
        
        ) implements IAdminUpdateData {
}
