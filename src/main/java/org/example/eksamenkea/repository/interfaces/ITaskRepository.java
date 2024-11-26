package org.example.eksamenkea.repository.interfaces;

import org.example.eksamenkea.model.Task;
import org.example.eksamenkea.service.Errorhandling;

import java.sql.SQLException;
import java.util.List;

public interface ITaskRepository {

List<Task> getTasksByProjectId(int projectId) throws Errorhandling;
    List<Task> getWorkerTasksFromUserId(int userId) throws Errorhandling;
}
