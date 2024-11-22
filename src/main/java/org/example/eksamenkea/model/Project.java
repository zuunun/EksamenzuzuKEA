package org.example.eksamenkea.model;

import java.time.LocalDate;

public class Project {
    private int project_id;
    private String project_name;
    private LocalDate startdate;
    private LocalDate enddate;
    private double budget; 
    private String description;
    private int projectleader_id;

    public Project(int project_id, String project_name, LocalDate startdate, LocalDate enddate, double budget, String description, int projectleader_id) {
        this.project_id = project_id;
        this.project_name = project_name;
        this.startdate = startdate;
        this.enddate = enddate;
        this.budget = budget;
        this.description = description;
        this.projectleader_id = projectleader_id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public LocalDate getStartdate() {
        return startdate;
    }

    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }

    public LocalDate getEnddate() {
        return enddate;
    }

    public void setEnddate(LocalDate enddate) {
        this.enddate = enddate;
    }

    public int getProjectleader_id() {
        return projectleader_id;
    }

    public void setProjectleader_id(int projectleader_id) {
        this.projectleader_id = projectleader_id;
    }

    @Override
    public String toString() {
        return "Project{" +
                "project_id=" + project_id +
                ", project_name='" + project_name + '\'' +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                ", projectleader_id=" + projectleader_id +
                '}';
    }
}
