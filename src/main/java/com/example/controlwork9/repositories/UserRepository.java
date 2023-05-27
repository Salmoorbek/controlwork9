package com.example.controlwork9.repositories;

import com.example.controlwork9.dto.UserDto;
import com.example.controlwork9.entity.Role;
import com.example.controlwork9.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    List<User> findByRole(Role developer);

    Optional<User> findByEmail(String username);
}
