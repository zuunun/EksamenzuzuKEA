//package org.example.eksamenkea.controller;
//
//import org.example.eksamenkea.model.Task;
//import org.example.eksamenkea.service.TaskService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.sql.SQLException;
//import java.util.List;
//
//@Controller
//public class TaskController {
//    private final TaskService taskService;
//
//    public TaskController(TaskService taskService) {
//        this.taskService = taskService;
//    }
//    @GetMapping("/overview")
//    public String showTaskOverview(@RequestParam(value = "projectId", required = false) Integer projectId,
//                                   @RequestParam(value = "subprojectId", required = false) Integer subprojectId,
//                                   Model model) throws SQLException {
//        if (projectId == null && subprojectId == null) {
//            // Tilføj en standardhåndtering, fx vis en fejlbesked eller standarddata
//            model.addAttribute("error", "Both projectId and subprojectId are missing.");
//            return "404";
//        }
//
//        // Hent tasks afhængigt af, hvilke parametre der er tilgængelige
//        List<Task> tasks = taskService.getTaskByProjectOrSubProject(
//                projectId != null ? projectId : 0,
//                subprojectId != null ? subprojectId : 0
//        );
//
//        // Tilføj data til Thymeleaf-modellen
//        model.addAttribute("tasks", tasks);
//        model.addAttribute("projectId", projectId);
//        model.addAttribute("subprojectId", subprojectId);
//        return "task-overview";
//    }
//
//
//
//}
