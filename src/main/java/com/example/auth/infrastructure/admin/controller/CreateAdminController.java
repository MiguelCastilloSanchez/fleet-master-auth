package com.example.auth.infrastructure.admin.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth.infrastructure.admin.dto.AdminPublicData;
import com.example.auth.infrastructure.admin.dto.AdminRegistrationData;
import com.example.auth.usecase.admin.CreateAdminUseCase;

@RestController
public class CreateAdminController {

    @Autowired
    private CreateAdminUseCase createAdminUseCase;

    @PostMapping("/admin")
    @ResponseStatus(HttpStatus.CREATED)
    public AdminPublicData createAdmin(@Valid @RequestBody AdminRegistrationData data) {
        return new AdminPublicData(createAdminUseCase.execute(data));
    }

}
