package com.example.auth.usecase.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.auth.entity.admin.gateway.AdminGateway;
import com.example.auth.entity.admin.model.Admin;
import com.example.auth.usecase.admin.dto.IAdminRegistrationData;

@Service
public class CreateAdminUseCase {

    @Autowired
    private AdminGateway adminGateway;

    public Admin execute(IAdminRegistrationData data) {

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

        Admin admin = new Admin(data.username(), encryptedPassword, data.name(),
            data.email());

        return this.adminGateway.create(admin);
    }


}
