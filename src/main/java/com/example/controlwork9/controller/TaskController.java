package com.example.controlwork9.controller;

import com.example.controlwork9.dto.TaskDto;
import com.example.controlwork9.entity.Attachment;
import com.example.controlwork9.entity.Task;
import com.example.controlwork9.entity.User;
import com.example.controlwork9.entity.WorkLog;
import com.example.controlwork9.service.AttachmentService;
import com.example.controlwork9.service.TaskService;
import com.example.controlwork9.service.UserService;
import com.example.controlwork9.service.WorkLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;
    private final AttachmentService attachmentService;
    private final WorkLogService worklogService;

    @Autowired
    public TaskController(TaskService taskService, UserService userService, AttachmentService attachmentService, WorkLogService worklogService) {
        this.taskService = taskService;
        this.userService = userService;
        this.attachmentService = attachmentService;
        this.worklogService = worklogService;
    }

    @GetMapping("/tasks")
    public String getAllTasks(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated()) {
            String userEmail = authentication.getName();
            model.addAttribute("userEmail", userEmail);
        }

        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/tasks/create")
    public String showCreateTaskForm(Model model) {
        List<User> developers = userService.getDevelopers();
        model.addAttribute("developers", developers);
        model.addAttribute("task", new TaskDto());
        return "create-task";
    }

    @PostMapping("/tasks/create")
    public String createTask(@ModelAttribute("task") @Valid TaskDto taskDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create-task";
        }
        System.out.println(taskDto);
        taskService.createTask(taskDto);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/{taskId}")
    public String getTaskDetails(@PathVariable("taskId") Long taskId, Model model) {
        Task task = taskService.getTaskById(taskId);
        List<WorkLog> worklogs = worklogService.getWorklogsByTask(taskId);
        List<Attachment> attachments = attachmentService.getAttachmentsByTask(taskId);
        model.addAttribute("task", task);
        model.addAttribute("worklogs", worklogs);
        model.addAttribute("attachments", attachments);
        return "task-details";
    }

    @PostMapping("/tasks/{taskId}/status")
    public ResponseEntity<String> changeTaskStatus(@PathVariable("taskId") Long taskId, @RequestParam("status") String status) {
        taskService.changeTaskStatus(taskId, status);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/tasks/{taskId}/worklogs")
    public ResponseEntity<String> addWorklog(@PathVariable("taskId") Long taskId, @RequestParam("time") String time,
                                             @RequestParam("description") String description) {
        worklogService.addWorklog(taskId, time, description);
        return ResponseEntity.ok().build();
    }
}

