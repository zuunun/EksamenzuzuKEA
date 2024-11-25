package org.example.eksamenkea.repository;

import org.example.eksamenkea.model.Project;
import org.example.eksamenkea.model.Subproject;
import org.example.eksamenkea.repository.interfaces.IProjectRepository;
import org.example.eksamenkea.service.Errorhandling;
import org.example.eksamenkea.util.ConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProjectRepository implements IProjectRepository {

    public List<Project> getAllProjects() throws Errorhandling {
        List<Project> projects = new ArrayList<>();
        String query = "SELECT project_id, project_name, budget, project_description, user_id FROM project";

        try {
            Connection con = ConnectionManager.getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                projects.add(new Project(
                        resultSet.getInt("project_id"),
                        resultSet.getString("project_name"),
                        resultSet.getDouble("budget"),
                        resultSet.getString("project_description"),
                        resultSet.getInt("user_id")
                ));
            }
            return projects;
        } catch (SQLException e) {
            throw new Errorhandling("failed to get all projects");
        }
    }



        public List<Subproject> getAllSubprojects () throws Errorhandling {
            List<Subproject> subprojects = new ArrayList<>();
            String query = "SELECT * FROM subproject";

            try {
                Connection con = ConnectionManager.getConnection();
                 Statement statement = con.createStatement();
                 ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    subprojects.add(new Subproject(
                            resultSet.getInt("subproject_id"),
                            resultSet.getString("subproject_name"),
                            resultSet.getString("subproject_description"),
                            resultSet.getInt("project_id")
                    ));
                }
                return subprojects;
            } catch (SQLException e) {
                throw new Errorhandling("failed to get all subprojects ");
            }
        }

        public Project getProjetByUserId (int userId) throws Errorhandling {
        Project project = null;
        String sqlQuery = "SELECT project_id, project_name, budget, project_description, user_id FROM project WHERE user_id = " + userId;

        try {Connection connection = ConnectionManager.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        while (resultSet.next()) {
           project = new Project(
                   resultSet.getInt("project_id"),
                   resultSet.getString("project_name"),
                   resultSet.getDouble("budget"),
                   resultSet.getString("project_description"),
                   resultSet.getInt("user_id")
           );
        }

        }catch (SQLException e) {
            throw new Errorhandling("failed to get all subprojects ");
        }
            return project;
    }
    }
