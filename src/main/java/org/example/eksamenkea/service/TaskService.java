package org.example.eksamenkea.service;

import org.example.eksamenkea.model.Task;
import org.example.eksamenkea.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;


    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public List<Task> getTasksByProjectId(int projectId) throws Errorhandling {
        return taskRepository.getTasksByProjectId(projectId);
    }

    public List<Task> getTasksByUserId(int userId) throws Errorhandling {
        return taskRepository.getWorkerTasksFromUserId(userId);
    }



}
