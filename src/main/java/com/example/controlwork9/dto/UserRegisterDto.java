package com.example.controlwork9.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDto {
    @Size(max = 25)
    private String name;
    @Size(max = 25)
    private String email;
    @Size(max = 16)
    private String password;
}