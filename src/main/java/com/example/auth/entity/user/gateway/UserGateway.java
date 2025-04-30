package com.example.auth.entity.user.gateway;

import com.example.auth.entity.user.model.User;

import java.util.Optional;

public interface UserGateway {

    Optional<User> findByUsername(String username);

}
