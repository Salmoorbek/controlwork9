package com.example.controlwork9.dto;

import com.example.controlwork9.entity.Role;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Role role;
    private Boolean enabled;

    public UserDto(Long id, String name, String email, String password, Role role, Boolean enabled) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
    }
}
