package com.example.controlwork9.dto;

import lombok.Builder;

@Builder
public class AttachmentDto {
    private Long id;
    private String filename;
    private String filepath;
    private Long taskId;
}
