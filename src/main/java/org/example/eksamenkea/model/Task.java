package org.example.eksamenkea.model;

import java.time.LocalDate;

public class Task {
    private int task_id;
    private String task_name;
    private String task_description;
    private LocalDate startdate;
    private LocalDate enddate;
    private LocalDate deadline;
    private int estimated_time;
    private String status;
    private double cost;
    private int subproject_id; //FK

    public Task(int task_id, String task_name, LocalDate startdate, LocalDate enddate, int subproject_id) {
        this.task_id = task_id;
        this.task_name = task_name;
        this.startdate = startdate;
        this.enddate = enddate;
        this.subproject_id = subproject_id;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
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

    public int getSubproject_id() {
        return subproject_id;
    }

    public void setSubproject_id(int subproject_id) {
        this.subproject_id = subproject_id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "task_id=" + task_id +
                ", task_name='" + task_name + '\'' +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                ", subproject_id=" + subproject_id +
                '}';
    }
}
