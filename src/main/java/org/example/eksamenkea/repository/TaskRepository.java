package org.example.eksamenkea.repository;

import org.example.eksamenkea.model.Status;
import org.example.eksamenkea.model.Task;
import org.example.eksamenkea.repository.interfaces.ITaskRepository;
import org.example.eksamenkea.service.Errorhandling;
import org.example.eksamenkea.util.ConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository implements ITaskRepository {


     //Hent tasks for et specifikt projekt
    public List<Task> getTasksByProjectId(int projectId) throws Errorhandling {
        List<Task> tasks = new ArrayList<>();
        String query = "SELECT t.task_id, t.task_name, t.startdate, t.enddate, t.status, sp.subproject_id " +
                "FROM task t " +
                "JOIN subproject sp ON sp.subproject_id = t.subproject_id " +
                "WHERE sp.project_id = ?";

        try {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, projectId);

            ResultSet resultSet = preparedStatement.executeQuery();

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

            return tasks;
        } catch (SQLException e) {
            throw new Errorhandling("error");
        }
    }

    public List<Task> getWorkerTasksFromUserId(int userId) throws Errorhandling {
        List<Task> taskList = new ArrayList<>();
        String sqlQuery = "SELECT t.task_id, t.task_name, t.startdate, t.enddate, t.status, t.subproject_id " +
        "FROM task t " +
        "JOIN workertask wt ON wt.task_id = t.task_id " +
        "WHERE wt.user_id = ?";

        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement preSta = connection.prepareStatement(sqlQuery);
            preSta.setInt(1, userId);
            ResultSet resultSet = preSta.executeQuery();

            while (resultSet.next()){
                taskList.add(new Task(
                        resultSet.getInt("task_id"),
                        resultSet.getString("task_name"),
                        resultSet.getDate("startdate").toLocalDate(),
                        resultSet.getDate("enddate").toLocalDate(),
                        Status.valueOf(resultSet.getString("status").toUpperCase()),
                        resultSet.getInt("subproject_id")
                ));
            }
            return taskList;


        } catch (SQLException e) {
            throw new Errorhandling("error");
        }

    }
}
