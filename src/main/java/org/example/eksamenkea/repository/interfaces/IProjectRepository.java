package org.example.eksamenkea.repository.interfaces;

import org.example.eksamenkea.model.Project;
import org.example.eksamenkea.model.Subproject;
import org.example.eksamenkea.model.User;
import org.example.eksamenkea.service.Errorhandling;
import java.util.List;

public interface IProjectRepository {

    List<Project> getAllProjects() throws Errorhandling;

    List<Subproject> getAllSubprojects() throws Errorhandling;

    public void addProject(Project project) throws Errorhandling;
}
