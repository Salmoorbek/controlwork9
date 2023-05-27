package com.example.controlwork9.service;

import com.example.controlwork9.dto.TaskDto;
import com.example.controlwork9.entity.Status;
import com.example.controlwork9.entity.Task;
import com.example.controlwork9.entity.User;
import com.example.controlwork9.exceptions.InvalidStatusChangeException;
import com.example.controlwork9.repositories.TaskRepository;
import com.example.controlwork9.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new NotFoundException("Task not found"));
    }

    public List<Task> getTasksByStatus(String status) {
        return taskRepository.findByStatus(status);
    }

    public void createTask(TaskDto taskDto) {
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setCreationDate(LocalDate.now());
        User developer = userRepository.findById(taskDto.getDeveloperId())
                .orElseThrow(() -> new NotFoundException("Developer not found"));
        task.setDeveloper(developer);
        task.setStatus(taskDto.getStatus());
        taskRepository.save(task);
    }

    public void changeTaskStatus(Long taskId, String newStatus) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new NotFoundException("Task not found"));

        Status currentStatus = task.getStatus();
        Status requestedStatus = Status.valueOf(newStatus.toUpperCase());

        if (currentStatus.ordinal() > requestedStatus.ordinal()) {
            throw new InvalidStatusChangeException("Invalid status change");
        }

        task.setStatus(requestedStatus);
        taskRepository.save(task);
    }

}

