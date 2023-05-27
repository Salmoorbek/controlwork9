package com.example.controlwork9.dto;

import com.example.controlwork9.entity.Role;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Builder
@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Role role;

    public UserDto(Long id, String name, String email, String password, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
