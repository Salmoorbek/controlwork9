package com.example.controlwork9.controller;

import com.example.controlwork9.dto.UserDto;
import com.example.controlwork9.dto.UserRegisterDto;
import com.example.controlwork9.entity.User;
import com.example.controlwork9.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable("id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-details";
    }

    @GetMapping("/users/create")
    public String createUserForm(Model model) {
        model.addAttribute("user", new UserRegisterDto());
        System.out.println("==============");
        return "user-create";
    }

    @PostMapping("/users/create")
    public String createUser(@ModelAttribute("user") @Valid UserRegisterDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user-create";
        }
        System.out.println(userDto);
        userService.createUser(userDto);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}/edit")
    public String editUserForm(@PathVariable("id") Long id, Model model) {
        UserDto userDto = userService.getUserDtoById(id);
        model.addAttribute("userDto", userDto);
        return "user-edit";
    }

    @PostMapping("/users/{id}/edit")
    public String editUser(@PathVariable("id") Long id, @Valid @ModelAttribute("userDto") UserDto userDto,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user-edit";
        }

        userService.updateUser(id, userDto);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}/delete")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

}
