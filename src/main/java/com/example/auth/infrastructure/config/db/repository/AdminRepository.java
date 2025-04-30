package com.example.auth.infrastructure.config.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.auth.infrastructure.config.db.schema.AdminSchema;

@Repository
public interface AdminRepository extends JpaRepository<AdminSchema, Long> {

}
