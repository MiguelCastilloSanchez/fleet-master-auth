package com.example.auth.usecase.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.auth.entity.admin.exception.AdminNotFoundException;
import com.example.auth.entity.admin.gateway.AdminGateway;
import com.example.auth.entity.admin.model.Admin;
import com.example.auth.usecase.admin.dto.IAdminUpdateData;

@Service
public class UpdateAdminUseCase {
    
    @Autowired
    private AdminGateway adminGateway;

    public Admin execute(Long id, IAdminUpdateData data) throws AdminNotFoundException {
        Admin customer = this.adminGateway.findById(id)
                .orElseThrow(AdminNotFoundException::new);

        if(data.username() != null && !data.username().isBlank())
            customer.setUsername(data.username());

        if(data.password() != null && !data.password().isBlank())
            customer.setPassword(data.password());

        if(data.name() != null && !data.name().isBlank())
            customer.setName(data.name());

        if(data.email() != null && !data.email().isBlank())
            customer.setEmail(data.email());

        return this.adminGateway.update(customer);
    }

}
