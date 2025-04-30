package com.example.auth.usecase.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.auth.entity.admin.gateway.AdminGateway;
import com.example.auth.entity.admin.model.Admin;
import com.example.auth.usecase.admin.dto.IAdminRegistrationData;

@Service
public class CreateAdminUseCase {

    @Autowired
    private AdminGateway adminGateway;

    public Admin execute(IAdminRegistrationData data) {

        Admin admin = new Admin(data.username(), data.password(), data.name(),
            data.email());

        return this.adminGateway.create(admin);
    }


}
