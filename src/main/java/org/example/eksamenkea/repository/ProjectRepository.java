package org.example.eksamenkea.repository;

import org.example.eksamenkea.model.Project;
import org.example.eksamenkea.model.Subproject;
import org.example.eksamenkea.model.User;
import org.example.eksamenkea.repository.interfaces.IProjectRepository;
import org.example.eksamenkea.service.Errorhandling;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("IPROJECTREPOSITORY")
@Lazy
public class ProjectRepository implements IProjectRepository {
    @Value("${spring.datasource.url}")
    private String DB_URL;

    @Value("${spring.datasource.username}")
    private String DB_USER;

    @Value("${spring.datasource.password}")
    private String DB_PASSWORD;

    public List<Project> getAllProjects() throws Errorhandling {//ZUZU
        List<Project> projects = new ArrayList<>();
        String query = "SELECT project_id, project_name, budget, project_description, projectleader_id FROM project";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                projects.add(new Project(
                        resultSet.getInt("project_id"),
                        resultSet.getString("project_name"),
                        resultSet.getDouble("budget"),
                        resultSet.getString("project_description"),
                        resultSet.getInt("projectleader_id")
                ));
            }
        } catch (SQLException e) {
            // Brug Errorhandling med en meningsfuld besked
            throw new Errorhandling("Failed to fetch projects from the database: " + e.getMessage());
        }
        return projects;
    }



    public List<Subproject> getAllSubprojects() throws Errorhandling {//ZUZU
        List<Subproject> subprojects = new ArrayList<>();
        String query = "SELECT * FROM subproject";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                subprojects.add(new Subproject(
                        resultSet.getInt("subproject_id"),
                        resultSet.getString("subproject_name"),
                        resultSet.getString("subproject_description"),
                        resultSet.getInt("project_id")
                ));
            }
        } catch (SQLException e) {
            throw new  Errorhandling("Failed to fetch projects from the database: " + e.getMessage());
        }
        return subprojects;
    }

    public List<Project> getAllProjectsByWorkerID(User user) throws SQLException{
        List<Project> projects = new ArrayList<>();
        String sqlQuery ="SELECT * FROM project WHERE user_id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery)) {

            while (resultSet.next()) {
                projects.add(new Project(
                        resultSet.getInt
                ))
            }
    }
return projects;
    }
}
