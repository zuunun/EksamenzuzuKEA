package org.example.eksamenkea.model;

import java.time.LocalDate;

public class Task {
    private int task_id;
    private String task_name;
    private LocalDate startdate;
    private LocalDate enddate;
    Status status;
    private int cost;
    private int user_id;
    private int subproject_id; //FK

    public Task(int task_id, String task_name, LocalDate startdate, LocalDate enddate, Status status, int cost, int user_id, int subproject_id) {
        this.task_id = task_id;
        this.task_name = task_name;
        this.startdate = startdate;
        this.enddate = enddate;
        this.status = status;
        this.cost = cost;
        this.user_id = user_id;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getSubproject_id() {
        return subproject_id;
    }

    public void setSubproject_id(int subproject_id) {
        this.subproject_id = subproject_id;
    }
}
