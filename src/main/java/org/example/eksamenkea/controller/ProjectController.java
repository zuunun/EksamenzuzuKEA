package org.example.eksamenkea.controller;

import jakarta.servlet.http.HttpSession;
import org.example.eksamenkea.model.Project;
import org.example.eksamenkea.model.Role;
import org.example.eksamenkea.model.Subproject;
import org.example.eksamenkea.model.User;
import org.example.eksamenkea.service.Errorhandling;
import org.example.eksamenkea.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

            //tilføjes til model så det kan vises i thyme
            model.addAttribute("projects", projects);
            model.addAttribute("subprojects", subprojects);

            return "project-leader-overview";//returner view
        }
        throw new Errorhandling("error");
    }

    @GetMapping("/add-project")
    public String addNewProject(HttpSession session, Model model) throws Errorhandling {
        Project project = new Project();
        Role userRole = (Role) session.getAttribute("userRole");  // Henter "userrole" fra sessionen.
        User user = (User) session.getAttribute("user");  // Henter "user" fra sessionen.
        System.out.println("User ID fra session: " + user.getUser_id());

        if (userRole == Role.PROJECTLEADER) {
            model.addAttribute("project", project);
            model.addAttribute("userId", user.getUser_id());
            return "add-project-form";
        }
        throw new Errorhandling("cant add project");
    }

    @PostMapping("/project-added")
    public String addedProject(@ModelAttribute Project project) throws Errorhandling {
        projectService.addProject(project);
        return "redirect:/project-leader-overview";
    }


}
