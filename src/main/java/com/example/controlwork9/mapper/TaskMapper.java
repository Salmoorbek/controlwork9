package com.example.controlwork9.mapper;

import com.example.controlwork9.dto.TaskDto;
import com.example.controlwork9.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public TaskDto from(Task task) {
        return TaskDto.builder()
                .title(task.getTitle())
                .creationDate(task.getCreationDate())
                .developerId(task.getDeveloper().getId())
                .status(task.getStatus())
                .build();
    }
}
