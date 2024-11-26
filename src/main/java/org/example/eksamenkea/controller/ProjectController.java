package org.example.eksamenkea.controller;

import jakarta.servlet.http.HttpSession;
import org.example.eksamenkea.model.Project;
import org.example.eksamenkea.model.Role;
import org.example.eksamenkea.model.Subproject;
import org.example.eksamenkea.model.Employee;
import org.example.eksamenkea.service.Errorhandling;
import org.example.eksamenkea.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProjectController {
    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/project-leader-overview")
    public String showProjectLeaderOverview(HttpSession session, Model model) throws Errorhandling {
        Role userRole = (Role) session.getAttribute("userRole");
        Employee employee = (Employee) session.getAttribute("employee");
        System.out.println("Employee in session: " + session.getAttribute("employee"));
        System.out.println("UserRole in session: " + session.getAttribute("userRole"));
        System.out.println(employee.getEmployee_id());
        if (userRole == Role.PROJECTLEADER) {
            List<Project> projects = projectService.getAllProjectsByEmployeeId(employee.getEmployee_id());
            model.addAttribute("projects", projects);
            return "project-leader-overview";
        }
        throw new Errorhandling("User is not authorized to view this page.");
    }


    @GetMapping("/project-leader-subproject-overview") //Amalie
    public String showProjectLeaderSubprojectOverview(@RequestParam("projectId") int projectId, @RequestParam("projectName") String projectName, HttpSession session, Model model) throws Errorhandling {
        Role employeeRole = (Role) session.getAttribute("userRole"); // Henter brugerens rolle fra sessionen
        Employee employee = (Employee) session.getAttribute("employee");

        if (employeeRole == Role.PROJECTLEADER) {
            //String name = projectService.getProjectByProjectName;
            List<Subproject> subprojects = projectService.getSubjectsByProjectId(projectId);//HENT MED DIT PROJECTID

            model.addAttribute("subprojects", subprojects);
            model.addAttribute("projectName", projectName);

            return "project-leader-subproject-overview";//returner view
        }
        throw new Errorhandling("error");
    }

    @GetMapping("/add-project") //Amalie
    public String addNewProject(HttpSession session, Model model) throws Errorhandling {
        Project project = new Project();
        Role userRole = (Role) session.getAttribute("userRole");  // Henter "userrole" fra sessionen.
        Employee employee = (Employee) session.getAttribute("user");  // Henter "user" fra sessionen.
        System.out.println("User ID fra session: " + employee.getEmployee_id());

        if (userRole == Role.PROJECTLEADER) {
            model.addAttribute("project", project);
            model.addAttribute("userId", employee.getEmployee_id());
            return "add-project-form";
        }
        throw new Errorhandling("cant add project");
    }

    @PostMapping("/project-added") //Amalie
    public String addedProject(@ModelAttribute Project project) throws Errorhandling {
        projectService.addProject(project);
        return "redirect:/project-leader-overview";
    }


}
