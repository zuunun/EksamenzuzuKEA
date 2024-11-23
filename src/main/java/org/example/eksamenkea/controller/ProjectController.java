package org.example.eksamenkea.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.eksamenkea.model.Project;
import org.example.eksamenkea.model.Role;
import org.example.eksamenkea.model.Subproject;
import org.example.eksamenkea.service.Errorhandling;
import org.example.eksamenkea.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
//@RequestMapping("/vedikke")
public class ProjectController {
    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }


    @ExceptionHandler(Errorhandling.class) //metoden skal håndterer undtagelser af typen 'Errorhandling'
    public String handleError(Model model, Exception exception, HttpServletRequest request) { //HttpServletRequest request indeholder information om HTTP-forespørgslen
        model.addAttribute("message", exception.getMessage());
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE); //hentning af fejlkode
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "404"; //retuner view med navnet 404
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "500"; //retuner view med navnet 404
            }
        }
        return "error";
    }

    @GetMapping("/project-leader-overview")
    public String showProjectLeaderOverview(HttpSession session, Model model) throws SQLException {
        // Henter brugerens rolle fra sessionen
        Role userRole = (Role) session.getAttribute("userRole");

        System.out.println("User role: " + userRole); // ekstra info

        if (userRole != Role.PROJECTLEADER) {//hvis bruger ik har rolle som PL returnes error
            return "error/error";
        }

        List<Project> projects = projectService.getAllProjects();//henter alle projekter fra service
        List<Subproject> subprojects = projectService.getAllSubprojects();//henter subprojekter

        //tilføjes til model så det kan vises i thyme..
        model.addAttribute("projects", projects);
        model.addAttribute("subprojects", subprojects);

        return "project-leader-overview";//returner view
    }


}
