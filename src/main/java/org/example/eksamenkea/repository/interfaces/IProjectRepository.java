package org.example.eksamenkea.repository.interfaces;

import org.example.eksamenkea.model.Project;
import org.example.eksamenkea.model.Subproject;
import org.example.eksamenkea.service.Errorhandling;

import java.util.List;

public interface IProjectRepository {


    void addProject(Project project) throws Errorhandling;

    List<Subproject> getSubjectsByProjectId(int projectId) throws Errorhandling;

    List<Project> getProjectsByEmployeeId(int employeeId) throws Errorhandling;

    public Project getWorkerProjectFromEmployeeId(int employeeId) throws Errorhandling;

    int getProjectIdByProjectName(String projectName) throws Errorhandling;
}
