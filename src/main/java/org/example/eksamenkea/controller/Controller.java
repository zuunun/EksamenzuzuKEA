package org.example.eksamenkea.controller;

import org.example.eksamenkea.service.Errorhandling;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
public class Controller {

    @ExceptionHandler(Errorhandling.class)
    public String handleError(Model model, Exception exception) {
        model.addAttribute("message", exception.getMessage());
        return "error";
    }
}
