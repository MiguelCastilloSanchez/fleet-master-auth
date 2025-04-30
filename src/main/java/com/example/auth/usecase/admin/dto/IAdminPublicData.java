package com.example.auth.usecase.admin.dto;

// DTO (Data Transfer Object) interface to invert spring boot lib dependencies,
// respecting the decoupling of the use cases layer.
public interface IAdminPublicData {

    String id();

    String username();

    String name();

    String email();


}
