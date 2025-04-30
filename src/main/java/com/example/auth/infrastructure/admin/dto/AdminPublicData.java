package com.example.auth.infrastructure.admin.dto;

import com.example.auth.entity.admin.model.Admin;
import com.example.auth.usecase.admin.dto.IAdminPublicData;

public record AdminPublicData(
        String id,

        String username,

        String name,

        String email
) implements IAdminPublicData {
        public AdminPublicData(Admin admin) {
                this(
                    admin.getId().toString(),
                    admin.getUsername(),
                    admin.getName(),
                    admin.getEmail()
                );
        }
}