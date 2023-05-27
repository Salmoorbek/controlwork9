package com.example.controlwork9.controller;

import com.example.controlwork9.exceptions.InvalidStatusChangeException;
import com.example.controlwork9.exceptions.UserAlreadyExistsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.webjars.NotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidStatusChangeException.class)
    public ModelAndView handleException(Exception ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", "Произошла ошибка при обработке запроса");
        return modelAndView;
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ModelAndView handleNotFoundException(NotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", "пользователь уже существует!");
        return modelAndView;
    }
}
