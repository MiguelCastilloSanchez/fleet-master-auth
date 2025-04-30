package com.example.auth.infrastructure.config.db.schema;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Users")
public abstract class UserSchema extends AbstractEntitySchema<Long> {

    @NotBlank
    @Column(length = 20, unique = true)
    private String username;

    @NotBlank
    @Column(nullable = false, length = 40, unique = true)
    private String email;

    @NotBlank
    @Column(nullable = false, length = 64)
    private String password;

    @NotBlank
    @Column(nullable = false, length = 60)
    private String name;

    @NotBlank
    @Column(nullable = false, length = 20)
    protected String role;

    @Column(nullable = false)
    private boolean enabled;

    public UserSchema(String username, String password, String name, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.enabled = true;
    }

    public UserSchema() {
        this.enabled = true;
    }

    public UserSchema(Long id, String username, String name, String email, String password) {
        this.setId(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.username = username;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
