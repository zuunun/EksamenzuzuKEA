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

    public String getProjectNameBySubprojectId(int subprojectId)throws Errorhandling {
        return projectRepository.getProjectNameBySubprojectId(subprojectId);
    }



    public List<Subproject> getSubjectsByProjectId(int projectId) throws Errorhandling {
        return projectRepository.getSubjectsByProjectId(projectId);
    }

        public void addProject(Project project) throws Errorhandling {
         projectRepository.addProject(project);
    }
}
