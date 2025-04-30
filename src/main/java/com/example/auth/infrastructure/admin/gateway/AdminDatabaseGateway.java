package com.example.auth.infrastructure.admin.gateway;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.auth.entity.admin.gateway.AdminGateway;
import com.example.auth.entity.admin.model.Admin;
import com.example.auth.infrastructure.config.db.repository.AdminRepository;
import com.example.auth.infrastructure.config.db.schema.AdminSchema;

@Component
public class AdminDatabaseGateway implements AdminGateway {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin create(Admin admin) {
        return this.adminRepository.save(new AdminSchema(admin)).toAdmin();
    }

    @Override
    public Admin update(Admin admin) {
        return this.adminRepository.save(new AdminSchema(admin)).toAdmin();
    }

    @Override
    public void delete(Long id) {
        this.adminRepository.deleteById(id);
    }

    @Override
    public Optional<Admin> findById(Long id) {
        return adminRepository
                .findById(id)
                .map(AdminSchema::toAdmin);
    }

    @Override
    public List<Admin> findAll() {
        return adminRepository
                .findAll()
                .stream()
                .map(AdminSchema::toAdmin)
                .toList();
    }
}
