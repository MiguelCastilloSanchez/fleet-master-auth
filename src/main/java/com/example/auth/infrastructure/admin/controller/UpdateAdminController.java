package com.example.auth.infrastructure.admin.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.auth.entity.admin.exception.AdminNotFoundException;
import com.example.auth.infrastructure.admin.dto.AdminPublicData;
import com.example.auth.infrastructure.admin.dto.AdminUpdateData;
import com.example.auth.usecase.admin.UpdateAdminUseCase;

@RestController
public class UpdateAdminController {

    @Autowired
    private UpdateAdminUseCase updateAdminUseCase;

    @PutMapping("/admin/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AdminPublicData updateAdmin(@PathVariable Long id, @Valid @RequestBody AdminUpdateData data) throws AdminNotFoundException {
        return new AdminPublicData(updateAdminUseCase.execute(id, data));
    }

}
