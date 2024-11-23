//package org.example.eksamenkea.repository;
//
//import org.example.eksamenkea.model.Status;
//import org.example.eksamenkea.model.Task;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Repository;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class TaskRepository {
//
//    @Value("${spring.datasource.url}")
//    private String DB_URL;
//
//    @Value("${spring.datasource.username}")
//    private String DB_USER;
//
//    @Value("${spring.datasource.password}")
//    private String DB_PASSWORD;
//
//    public List<Task> getTaskByProjectOrSubProject(int projectId, int subProjectId) throws SQLException {
//        List<Task> tasks = new ArrayList<>();
//        String query = "SELECT t.task_id, t.task_name, t.startdate, t.enddate, t.status, sp.subproject_id " +
//                "FROM task t " +
//                "JOIN subproject sp ON t.subproject_id = sp.subproject_id " +
//                "JOIN project p ON sp.project_id = p.project_id " +
//                "WHERE p.project_id = ? OR sp.subproject_id = ?";
//        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//            preparedStatement.setObject(1, projectId);
//            preparedStatement.setObject(2, subProjectId);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                tasks.add(new Task(
//                        resultSet.getInt("task_id"),
//                        resultSet.getString("task_name"),
//                        resultSet.getDate("startdate").toLocalDate(),
//                        resultSet.getDate("enddate").toLocalDate(),
//                        Status.valueOf(resultSet.getString("status").toUpperCase()),
//                        resultSet.getInt("subproject_id")
//                ));
//            }
//        }
//        return tasks;
//    }
//
//    public List<Task> getTaskByWorker(Integer workerId) {
//        List<Task> tasks = new ArrayList<>();
//        String query = "SELECT t.task_id, t.task_name, t.startdate, t.enddate, t.status, sp.subproject_id " +
//                "FROM task t " +
//                "JOIN workertask wt ON t.task_id = wt.task_id " +
//                "JOIN subproject sp ON t.subproject_id = sp.subproject_id " +
//                "WHERE wt.user_id = ?";
//        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//            preparedStatement.setObject(1, workerId);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                tasks.add(new Task(
//                        resultSet.getInt("task_id"),
//                        resultSet.getString("task_name"),
//                        resultSet.getDate("startdate").toLocalDate(),
//                        resultSet.getDate("enddate").toLocalDate(),
//                        Status.valueOf(resultSet.getString("status").toUpperCase()),
//                        resultSet.getInt("subproject_id")
//                ));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException("Error fetching tasks for worker with ID: " + workerId, e);
//        }
//        return tasks;
//    }
//}
