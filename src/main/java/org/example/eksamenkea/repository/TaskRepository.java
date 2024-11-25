package org.example.eksamenkea.repository;

import org.example.eksamenkea.model.Status;
import org.example.eksamenkea.model.Task;
import org.example.eksamenkea.repository.interfaces.ITaskRepository;
import org.example.eksamenkea.service.Errorhandling;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("ITASKREPOSITORY")
@Lazy
public class TaskRepository implements ITaskRepository {

    @Value("${spring.datasource.url}")
    private String DB_URL;

    @Value("${spring.datasource.username}")
    private String DB_USER;

    @Value("${spring.datasource.password}")
    private String DB_PASSWORD;


    // Hent tasks for et specifikt projekt
    public List<Task> getTasksByProjectId(int projectId) throws Errorhandling {
        List<Task> tasks = new ArrayList<>();
        String query = "SELECT t.task_id, t.task_name, t.startdate, t.enddate, t.status, sp.subproject_id " +
                "FROM task t " +
                "JOIN subproject sp ON sp.subproject_id = t.subproject_id " +
                "WHERE sp.project_id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Sæt parameteren for projekt ID
            preparedStatement.setInt(1, projectId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Læs resultater og opret Task-objekter
                while (resultSet.next()) {
                    tasks.add(new Task(
                            resultSet.getInt("task_id"),
                            resultSet.getString("task_name"),
                            resultSet.getDate("startdate").toLocalDate(),
                            resultSet.getDate("enddate").toLocalDate(),
                            Status.valueOf(resultSet.getString("status").toUpperCase()),
                            resultSet.getInt("subproject_id")
                    ));
                }
            }
        } catch (SQLException e) {
            // Kast en brugerdefineret exception med relevant besked
            throw new Errorhandling("Error fetching tasks for project ID " + projectId + ": " + e.getMessage());
        } catch (IllegalArgumentException e) {
            // Håndter situationer hvor `Status.valueOf()` fejler
            throw new Errorhandling("Invalid status value in database for project ID " + projectId + ": " + e.getMessage());
        }
        return tasks;
    }




}
