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

    @Override
    public List<Project> getProjectsByEmployeeId(int employeeId) throws Errorhandling {
        List<Project> projects = new ArrayList<>();
        String query = "SELECT * FROM project WHERE employee_id = ?";

        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, employeeId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    projects.add(new Project(
                            resultSet.getInt("project_id"),
                            resultSet.getString("project_name"),
                            resultSet.getDouble("budget"),
                            resultSet.getString("project_description"),
                            resultSet.getInt("employee_id"),
                            resultSet.getInt("material_cost"),
                            resultSet.getInt("employee_cost")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new Errorhandling("Failed to get projects by employee ID: " + e.getMessage());
        }
        return projects;
    }

    public int getProjectIdByProjectName(String projectName) throws Errorhandling {
        String query = "SELECT project_id FROM project WHERE project_name = ?";

        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, projectName);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("project_id");
                } else {
                    throw new Errorhandling("Project not found for name: " + projectName);
                }
            }
        } catch (SQLException e) {
            throw new Errorhandling("Failed to get project ID by project name: " + e.getMessage());
        }
    }




    @Override
    public List<Subproject> getSubjectsByProjectId(int projectId) throws Errorhandling {
        List<Subproject> subprojects = new ArrayList<>();
        String query = "SELECT * FROM subproject WHERE project_id = ?";

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(query)) {

            preparedStatement.setInt(1, projectId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    subprojects.add(new Subproject(
                            resultSet.getInt("subproject_id"),
                            resultSet.getString("subproject_name"),
                            resultSet.getString("subproject_description"),
                            resultSet.getInt("project_id")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new Errorhandling("Failed to get subprojects by project ID: " + e.getMessage());
        }
        return subprojects;
    }

    @Override
    public void addProject(Project project) throws Errorhandling {
        String sqlAddProject = "INSERT INTO project(project_name, budget, project_description, employee_id, material_cost, employee_cost) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement statement = con.prepareStatement(sqlAddProject)) {

            statement.setString(1, project.getProject_name());
            statement.setDouble(2, project.getBudget());
            statement.setString(3, project.getProject_description());
            statement.setInt(4, project.getEmployee_id());
            statement.setDouble(5, project.getMaterial_cost()); // Rettet til double
            statement.setDouble(6, project.getEmployee_cost()); // Rettet til double
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new Errorhandling("Failed to add project: " + e.getMessage());
        }
    }

    @Override
    public Project getWorkerProjectFromEmployeeId(int employeeId) throws Errorhandling {
        Project project = null;
        String query = "SELECT * FROM project WHERE employee_id = ?";

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(query)) {

            preparedStatement.setInt(1, employeeId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    project = new Project(
                            resultSet.getInt("project_id"),
                            resultSet.getString("project_name"),
                            resultSet.getDouble("budget"),
                            resultSet.getString("project_description"),
                            resultSet.getInt("employee_id"),
                            resultSet.getInt("material_cost"), // Rettet til double
                            resultSet.getInt("employee_cost") // Rettet til double
                    );
                }
            }
        } catch (SQLException e) {
            throw new Errorhandling("Failed to fetch project for user ID " + employeeId + ": " + e.getMessage());
        }
        return project;
    }
}
