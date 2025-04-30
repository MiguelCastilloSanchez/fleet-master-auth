package com.example.auth.infrastructure.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth.entity.admin.exception.AdminNotFoundException;
import com.example.auth.infrastructure.admin.dto.AdminPublicData;
import com.example.auth.usecase.admin.DeleteAdminUseCase;

@RestController
public class DeleteAdminController {

    @Autowired
    private DeleteAdminUseCase deleteAdminUserCase;

    @DeleteMapping("/admin/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AdminPublicData deleteAdmin(@PathVariable Long id) throws AdminNotFoundException {
        return new AdminPublicData(deleteAdminUserCase.execute(id));
    }

}
