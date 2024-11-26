package org.example.eksamenkea.controller;

import jakarta.servlet.http.HttpSession;
import org.example.eksamenkea.model.*;
import org.example.eksamenkea.service.Errorhandling;
import org.example.eksamenkea.service.ProjectService;
import org.example.eksamenkea.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
//@RequestMapping("/vedikke")
public class ProjectController {
    private ProjectService projectService;


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
    public String showWorkerOverview(HttpSession session, Model model) throws Errorhandling {
        Role userRole = (Role) session.getAttribute("userRole");
        User user = (User) session.getAttribute("user");

        if (userRole != Role.WORKER) {
            throw new Errorhandling("Unauthorized access");
        }

        Project project = projectService.getProjectByUserId(user.getUser_id());
        List<Subproject> subprojects = projectService.getAllSubprojects();

        //Task skal muligvis hentes fra taskcontroller
        //List<Task> tasks = taskService.getTasksByUserId(user.getUser_id());

        model.addAttribute("project", project);
        model.addAttribute("subprojects", subprojects);
        model.addAttribute("user", user);
        //        model.addAttribute("tasks", tasks);

        return "worker-overview";
    }
}
