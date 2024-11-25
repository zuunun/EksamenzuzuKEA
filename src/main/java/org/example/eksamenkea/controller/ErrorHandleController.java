package org.example.eksamenkea.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.example.eksamenkea.service.Errorhandling;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ErrorHandleController {
    @ExceptionHandler(Errorhandling.class) //metoden skal håndterer undtagelser af typen 'Errorhandling'
    public String handleError(Model model, Exception exception, HttpServletRequest request) { //HttpServletRequest request indeholder information om HTTP-forespørgslen
        model.addAttribute("message", exception.getMessage());
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE); //hentning af fejlkode
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error/404"; // Return view med navnet 404
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error/500"; // Return view med navnet 500
            } else if (statusCode == HttpStatus.BAD_REQUEST.value()) {
                return "error/400"; // Return view med navnet 400
            } else if (statusCode == HttpStatus.BAD_GATEWAY.value()) {
                return "error/502"; // Return view med navnet 502
            }
        }
        return "error/error"; // Fallback error view
    }
}
