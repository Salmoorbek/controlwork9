package com.example.controlwork9.mapper;

import com.example.controlwork9.dto.UserDto;
import com.example.controlwork9.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public static UserDto from(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
