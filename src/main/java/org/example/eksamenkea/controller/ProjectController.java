package org.example.eksamenkea.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.eksamenkea.model.Project;
import org.example.eksamenkea.model.Role;
import org.example.eksamenkea.model.Subproject;
import org.example.eksamenkea.model.Task;
import org.example.eksamenkea.service.Errorhandling;
import org.example.eksamenkea.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.sql.SQLException;
import java.util.List;

@Controller
//@RequestMapping("/vedikke")
public class ProjectController {
    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }


    @GetMapping("/project-leader-overview")
    public String showProjectLeaderOverview(HttpSession session, Model model) throws SQLException{
        Role userRole = (Role) session.getAttribute("userRole"); // Henter brugerens rolle fra sessionen

        if (userRole== Role.PROJECTLEADER) {
            List<Project> projects = projectService.getAllProjects();//henter alle projekter fra service
            List<Subproject> subprojects = projectService.getAllSubprojects();//henter subprojekter

            //tilføjes til model så det kan vises i thyme..
            model.addAttribute("projects", projects);
            model.addAttribute("subprojects", subprojects);

            return "project-leader-overview";//returner view
        }
        throw new SQLException("error");
    }

    @GetMapping("/worker-overview")
    public String showWorkerOverview (HttpSession session, Model model) throws SQLException {
        Role userRole = (Role) session.getAttribute("userRole");

        if (userRole != Role.WORKER) {
            return "error";
        }
        List<Project> projects //Lav en gettermetode for en workers eneste projekt, de er tilknyttet.
        List<Subproject> subprojects //lav en gettermetode for en workers subprojects.
        List<Task> tasks //lav gettermetode for en workers tasks

        model.addAttribute("project", projects);
        model.addAttribute("subProjects", subprojects);
        model.addAttribute("tasks", tasks);
    }


}
