package com.example.controlwork9.mapper;

import com.example.controlwork9.dto.UserRegisterDto;
import com.example.controlwork9.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserRegisterMapper {
    public static UserRegisterDto from(User user) {
        return UserRegisterDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
