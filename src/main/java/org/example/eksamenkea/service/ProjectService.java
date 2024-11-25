package org.example.eksamenkea.service;

import org.example.eksamenkea.model.Project;
import org.example.eksamenkea.model.Subproject;
import org.example.eksamenkea.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects() throws Errorhandling {
        return projectRepository.getAllProjects();
    }

    public List<Subproject> getAllSubprojects() throws Errorhandling {
        return projectRepository.getAllSubprojects();
    }

    public Project getProjectByUserId(int userId) throws Errorhandling{
        return projectRepository.getWorkerProjectFromUserId(userId);
    }
}
