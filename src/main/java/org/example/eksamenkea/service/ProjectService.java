package org.example.eksamenkea.service;

import org.example.eksamenkea.model.Project;
import org.example.eksamenkea.model.Subproject;
import org.example.eksamenkea.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    public List<Project> getAllProjectsByEmployeeId(int employeeId) throws Errorhandling {
        return projectRepository.getProjectsByEmployeeId(employeeId);

    }

    public List<Subproject> getAllSubprojects() throws Errorhandling {
        return projectRepository.getAllSubprojects();
    }
    public void addProject(Project project) throws Errorhandling {
         projectRepository.addProject(project);
    }
}
