package com.example.controlwork9.repositories;

import com.example.controlwork9.entity.Status;
import com.example.controlwork9.entity.Task;
import com.example.controlwork9.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByDeveloper(User developer);
    List<Task> findByStatusOrderByCreationDateDesc(Status status);

    List<Task> findByStatus(String status);

}
