package org.example.eksamenkea.repository.interfaces;

import org.example.eksamenkea.model.Task;

import java.sql.SQLException;
import java.util.List;

public interface ITaskRepository {

    List<Task> getTasksByProjectId(int projectId) throws SQLException;
}