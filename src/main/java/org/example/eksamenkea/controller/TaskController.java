package org.example.eksamenkea.controller;

import jakarta.servlet.http.HttpSession;
import org.example.eksamenkea.model.Role;
import org.example.eksamenkea.model.Task;
import org.example.eksamenkea.model.User;
import org.example.eksamenkea.service.Errorhandling;
import org.example.eksamenkea.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/project-leader-tasks/{projectId}")
    public String getTasksForSpecificProject(@PathVariable int projectId, HttpSession session, Model model) throws Errorhandling {
        Role userRole = (Role) session.getAttribute("userRole");
        if (userRole != Role.PROJECTLEADER) {
            return "error/error"; // Sørg for, at der er en skabelon i `templates/error/`
        }
       List<Task> tasks = taskService.getTasksByProjectId(projectId);
       model.addAttribute("tasks", tasks);
        model.addAttribute("project_id", projectId);
        return "project-leader-task-overview"; // Korrekt sti til skabelon
    }

    @GetMapping("/worker-overview/{projectId}")
    public String getTasksForWorkerByProjectId(@PathVariable int projectId, HttpSession session, Model model) throws Errorhandling {
        Role userRole = (Role) session.getAttribute("userRole");
        if (userRole != Role.WORKER) {
            return "error/error"; // Sørg for, at der er en skabelon i `templates/error/`
        }
        List<Task> tasks = taskService.getTasksByProjectId(projectId);
        model.addAttribute("tasks", tasks);
        model.addAttribute("project_id", projectId);
        return "worker-overview";
}
}
