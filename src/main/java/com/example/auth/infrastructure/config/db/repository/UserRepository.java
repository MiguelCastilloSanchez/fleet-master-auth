package com.example.auth.infrastructure.config.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.auth.infrastructure.config.db.schema.UserSchema;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserSchema, Long> {
  Optional<UserSchema> findByEmail(String email);

  Optional<UserSchema> findByUsername(String username);

  Collection<UserSchema> findAllByEmail(String email);

  Collection<UserSchema> findAllByUsername(String username);
}
