package com.example.auth.infrastructure.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth.entity.admin.exception.AdminNotFoundException;
import com.example.auth.entity.admin.model.Admin;
import com.example.auth.infrastructure.admin.dto.AdminPublicData;
import com.example.auth.usecase.admin.GetAdminUseCase;

@RestController
public class GetAdminController {

    @Autowired
    private GetAdminUseCase getAdminUseCase;

    @GetMapping("/admin/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AdminPublicData getAdmin(@PathVariable Long id) throws AdminNotFoundException {
        Admin admin = getAdminUseCase.execute(id);

        return new AdminPublicData(admin);
    }

}
