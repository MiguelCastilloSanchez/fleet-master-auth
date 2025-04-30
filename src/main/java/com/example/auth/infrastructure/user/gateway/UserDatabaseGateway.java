package com.example.auth.infrastructure.user.gateway;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.auth.entity.user.gateway.UserGateway;
import com.example.auth.entity.user.model.User;
import com.example.auth.infrastructure.config.db.repository.UserRepository;
import com.example.auth.infrastructure.config.db.schema.UserSchema;

@Component
public class UserDatabaseGateway implements UserGateway{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findByUsername(String username) {
                return userRepository
                .findByUsername(username)
                .map(UserSchema::toUser);
    }
    
}
