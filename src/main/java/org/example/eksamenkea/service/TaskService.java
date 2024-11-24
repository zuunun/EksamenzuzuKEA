package org.example.eksamenkea.service;

import org.example.eksamenkea.model.Task;
import org.example.eksamenkea.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;


    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public List<Task> getTasksByProjectId(int projectId) throws SQLException {
        return taskRepository.getTasksByProjectId(projectId);
    }



}
