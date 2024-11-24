package org.example.eksamenkea.repository.interfaces;

import org.example.eksamenkea.model.Project;
import org.example.eksamenkea.model.Subproject;

import java.sql.SQLException;
import java.util.List;

public interface IProjectRepository {

    List<Project> getAllProjects() throws SQLException;

    List<Subproject> getAllSubprojects() throws SQLException;


}
