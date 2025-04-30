package com.example.auth.infrastructure.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth.entity.admin.model.Admin;
import com.example.auth.infrastructure.admin.dto.AdminPublicData;
import com.example.auth.usecase.admin.SearchAdminUseCase;

import java.util.List;

@RestController
public class SearchAdminController {

    @Autowired
    private SearchAdminUseCase searchAdminUseCase;

    @GetMapping("/admin")
    @ResponseStatus(HttpStatus.OK)
    public List<AdminPublicData> searchAdmin() {
        List<Admin> admins = this.searchAdminUseCase.execute();

        return admins.stream().map(AdminPublicData::new).toList();
    }

}
