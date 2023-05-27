package com.example.controlwork9.dto;

import com.example.controlwork9.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private Long id;
    @Size(min = 8, max = 25)
    private String title;
    private LocalDate creationDate;
    private Long developerId;
    private Status status;
}
