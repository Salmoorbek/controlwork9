package com.example.controlwork9.controller;

import com.example.controlwork9.entity.Status;
import com.example.controlwork9.entity.Task;
import com.example.controlwork9.service.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {
    private final TaskService taskService;

    public MainController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping("/login")
    public String getLoginPage(@RequestParam(required = false, defaultValue = "false") Boolean error, Model model) {
        model.addAttribute("error", error);
        return "login";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/login";
    }

    @GetMapping("/")
    public String getMainPage(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "3") int size,
                              Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Task> tasks = taskService.getTasksByPage(pageable);
        model.addAttribute("tasks", tasks);
        return "index";
    }
    @GetMapping("/filter")
    public String filterTasksByStatus(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "3") int size,
                                      @RequestParam Status status,
                                      Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Task> tasks = taskService.getTasksByStatus(status, pageable);
        model.addAttribute("tasks", tasks);
        model.addAttribute("status", status);
        return "index";
    }
}
