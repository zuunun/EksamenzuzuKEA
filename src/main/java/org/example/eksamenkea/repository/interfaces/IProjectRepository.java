package org.example.eksamenkea.repository.interfaces;

import org.example.eksamenkea.model.Project;
import org.example.eksamenkea.model.Subproject;
import org.example.eksamenkea.service.Errorhandling;
import java.util.List;

public interface IProjectRepository {


    public void addProject(Project project) throws Errorhandling;

    public List<Subproject> getSubjectsByProjectId(int projectId) throws Errorhandling;

}
