package com.example.auth.usecase.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.auth.entity.admin.exception.AdminNotFoundException;
import com.example.auth.entity.admin.gateway.AdminGateway;
import com.example.auth.entity.admin.model.Admin;

@Service
public class DeleteAdminUseCase {
   
    @Autowired
    private AdminGateway adminGateway;

    public Admin execute(Long id) throws AdminNotFoundException {
        Admin admin = adminGateway.findById(id)
            .orElseThrow(AdminNotFoundException::new);

        adminGateway.delete(id);

        return admin;
    }

}
