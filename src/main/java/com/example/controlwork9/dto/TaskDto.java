package com.example.controlwork9.dto;

import com.example.controlwork9.entity.Status;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class TaskDto {
    private Long id;
    private String title;
    private LocalDate creationDate;
    private Long developerId;
    private Status status;
}
