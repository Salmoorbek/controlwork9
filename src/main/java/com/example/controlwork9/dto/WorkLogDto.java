package com.example.controlwork9.dto;

import lombok.Builder;

@Builder
public class WorkLogDto {
    private Long id;
    private Long taskId;
    private String timeSpent;
    private String description;
}
