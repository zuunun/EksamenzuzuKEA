package org.example.eksamenkea.controller;

import jakarta.servlet.http.HttpSession;
import org.example.eksamenkea.model.Role;
import org.example.eksamenkea.model.Task;
import org.example.eksamenkea.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.List;

@Controller
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/overview")
    public String showTaskOverview(@RequestParam(value = "projectId", required = false) Integer projectId,
                                   @RequestParam(value = "subprojectId", required = false) Integer subprojectId,
                                   HttpSession session,
                                   Model model) throws SQLException {
        Role userRole = (Role) session.getAttribute("userRole");
        if (userRole != Role.PROJECTLEADER) {
            return "error/access-denied"; // Kun projektleder kan se denne side
        }

        // Vis tasks baseret på projekt eller subprojekt
        List<Task> tasks = taskService.getTaskByProjectOrSubProject(
                projectId != null ? projectId : 0,
                subprojectId != null ? subprojectId : 0
        );

        model.addAttribute("tasks", tasks);
        model.addAttribute("projectId", projectId);
        model.addAttribute("subprojectId", subprojectId);
        return "task-overview";
    }



}
