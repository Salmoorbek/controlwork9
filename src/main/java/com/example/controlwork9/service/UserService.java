package com.example.controlwork9.service;

import com.example.controlwork9.dto.UserDto;
import com.example.controlwork9.dto.UserRegisterDto;
import com.example.controlwork9.entity.Role;
import com.example.controlwork9.entity.User;
import com.example.controlwork9.exceptions.UserAlreadyExistsException;
import com.example.controlwork9.mapper.UserMapper;
import com.example.controlwork9.mapper.UserRegisterMapper;
import com.example.controlwork9.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole().name())
                .build();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + id));
    }

    public void createUser(UserRegisterDto user) {
        if (userRepository.existsByEmail(user.getEmail())){
            throw new UserAlreadyExistsException("The client with this email is already registered");
        }

        var usr = User.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(passwordEncoder.encode(user.getPassword()))
                .role(Role.DEVELOPER)
                .enabled(true)
                .build();

        UserRegisterMapper.from(userRepository.save(usr));
    }

    public List<User> getDevelopers() {
        return userRepository.findByRole(Role.DEVELOPER);
    }
    public void updateUser(Long id, UserDto userDto) {
        User user = getUserById(id);
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public UserDto getUserDtoById(Long id) {
        return UserMapper.from(userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + id)));
    }
}

