package org.example.eksamenkea.controller;

import jakarta.servlet.http.HttpSession;
import org.example.eksamenkea.model.*;
import org.example.eksamenkea.service.Errorhandling;
import org.example.eksamenkea.service.ProjectService;
import org.example.eksamenkea.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
//@RequestMapping("/vedikke")
public class ProjectController {
    private ProjectService projectService;
    private TaskService taskService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }


    @GetMapping("/project-leader-overview")
    public String showProjectLeaderOverview(HttpSession session, Model model) throws Errorhandling {
        Role userRole = (Role) session.getAttribute("userRole"); // Henter brugerens rolle fra sessionen

        if (userRole == Role.PROJECTLEADER) {
            List<Project> projects = projectService.getAllProjects();//henter alle projekter fra service
            List<Subproject> subprojects = projectService.getAllSubprojects();//henter subprojekter

            //tilføjes til model så det kan vises i thyme..
            model.addAttribute("projects", projects);
            model.addAttribute("subprojects", subprojects);

            return "project-leader-overview";//returner view
        }
        throw new Errorhandling("error");
    }


    //HAR JEG GJORT NOGET FORKERT VED AT INSTANSIERE TASKCONTROLER OG TASKSERVICE HER??
    @GetMapping("/worker-overview")
    public String showWokerOverview(HttpSession session, Model model) throws Errorhandling {

        Role userRole = (Role) session.getAttribute("userRole");
        User user = (User) session.getAttribute("user");
        Project project = null;

        if (userRole == Role.WORKER) {
           project = projectService.getProjectByUserId(user.getUser_id());
            //List<Subproject> subprojects = projectService.getAllSubprojects();
            List<Task> taskList = taskService.getTasksByProjectId(project.getProject_id());

            model.addAttribute("project", project);
            model.addAttribute("tasks", taskList);
            //model.addAttribute("subprojects", subprojects);
            model.addAttribute("user", user);

            return "worker-overview";
        }
        throw new Errorhandling("error");
    }
}
