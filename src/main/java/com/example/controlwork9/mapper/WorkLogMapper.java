package com.example.controlwork9.mapper;

import com.example.controlwork9.dto.WorkLogDto;
import com.example.controlwork9.entity.WorkLog;
import org.springframework.stereotype.Component;

@Component
public class WorkLogMapper {
    public WorkLogDto from(WorkLog workLog) {
        return WorkLogDto.builder()
                .timeSpent(workLog.getTimeSpent())
                .description(workLog.getDescription())
                .build();
    }
}
