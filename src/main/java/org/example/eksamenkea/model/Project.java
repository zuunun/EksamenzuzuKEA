package org.example.eksamenkea.model;

import java.time.LocalDate;

public class Project {
    private int project_id;
    private String project_name;
    private LocalDate startdate;
    private LocalDate enddate;
    private double budget;
    private String project_description;
    private int projectleader_id;

    public Project(int project_id, String project_name, LocalDate startdate, LocalDate enddate, double budget, String project_description, int projectleader_id) {
        this.project_id = project_id;
        this.project_name = project_name;
        this.startdate = startdate;
        this.enddate = enddate;
        this.budget = budget;
        this.project_description = project_description;
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

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getProject_description() {
        return project_description;
    }

    public void setProject_description(String project_description) {
        this.project_description = project_description;
    }

    public int getProjectleader_id() {
        return projectleader_id;
    }

    public void setProjectleader_id(int projectleader_id) {
        this.projectleader_id = projectleader_id;
    }
}
