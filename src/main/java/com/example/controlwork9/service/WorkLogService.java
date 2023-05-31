package com.example.controlwork9.service;

import com.example.controlwork9.entity.Task;
import com.example.controlwork9.entity.WorkLog;
import com.example.controlwork9.repositories.TaskRepository;
import com.example.controlwork9.repositories.WorklogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkLogService {

    private final WorklogRepository worklogRepository;
    private final TaskRepository taskRepository;

    public WorkLogService(WorklogRepository worklogRepository, TaskRepository taskRepository) {
        this.worklogRepository = worklogRepository;
        this.taskRepository = taskRepository;
    }
    public List<WorkLog> getWorklogsByTask(Long taskId) {
        return worklogRepository.findByTaskId(taskId);
    }

    public void addWorklog(Long taskId, String time, String description) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));

        WorkLog worklog = new WorkLog();
        worklog.setTask(task);
        worklog.setTimeSpent(time);
        worklog.setDescription(description);
        worklogRepository.save(worklog);
    }
}
