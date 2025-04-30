package com.example.auth.usecase.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.auth.entity.admin.gateway.AdminGateway;
import com.example.auth.entity.admin.model.Admin;

@Service
public class SearchAdminUseCase {
    
    @Autowired
    private AdminGateway adminGateway;

    public List<Admin> execute() {
        return this.adminGateway.findAll();
    }


}
