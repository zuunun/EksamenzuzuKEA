package org.example.eksamenkea.model;

import java.time.LocalDate;

public class Subproject {
    private int subproject_id;
    private String subproject_name;
    private LocalDate startdate;
    private LocalDate enddate;
    private double budget;
    private int project_id;

    public Subproject(int subproject_id, String subproject_name, LocalDate startdate, LocalDate enddate, double budget, int project_id) {
        this.subproject_id = subproject_id;
        this.subproject_name = subproject_name;
        this.startdate = startdate;
        this.enddate = enddate;
        this.budget = budget;
        this.project_id = project_id;
    }

    public int getSubproject_id() {
        return subproject_id;
    }

    public void setSubproject_id(int subproject_id) {
        this.subproject_id = subproject_id;
    }

    public String getSubproject_name() {
        return subproject_name;
    }

    public void setSubproject_name(String subproject_name) {
        this.subproject_name = subproject_name;
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

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    @Override
    public String toString() {
        return "Subproject{" +
                "subproject_id=" + subproject_id +
                ", subproject_name='" + subproject_name + '\'' +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                ", project_id=" + project_id +
                '}';
    }
}
