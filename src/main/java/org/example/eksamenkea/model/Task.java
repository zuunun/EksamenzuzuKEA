package org.example.eksamenkea.model;

import java.time.LocalDate;

public class Task {
    private int task_id;
    private String task_name;
    private LocalDate startdate;
    private LocalDate enddate;
    Status status;
    //private int duration;
    private int subproject_id; //FK
    private int employee_id; //FK
    private int estimated_hours; // Antal forventede timer
    private int actual_hours; // Antal faktiske timer brugt


    public Task(int task_id, String task_name, LocalDate startdate, LocalDate enddate, Status status,
                int subproject_id, int employee_id, int estimated_hours, int actual_hours) {
        this.task_id = task_id;
        this.task_name = task_name;
        this.startdate = startdate;
        this.enddate = enddate;
        this.status = status;
        //this.duration = duration;
        this.subproject_id = subproject_id;
        this.employee_id = employee_id;
        this.estimated_hours = estimated_hours;
        this.actual_hours = actual_hours;
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

//    public int getDuration() {
//        return duration;
//    }
//
//    public void setDuration(int duration) {
//        this.duration = duration;
//    }

    public int getSubproject_id() {
        return subproject_id;
    }

    public void setSubproject_id(int subproject_id) {
        this.subproject_id = subproject_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getEstimated_hours() {
        return estimated_hours;
    }

    public void setEstimated_hours(int estimated_hours) {
        this.estimated_hours = estimated_hours;
    }

    public int getActual_hours() {
        return actual_hours;
    }

    public void setActual_hours(int actual_hours) {
        this.actual_hours = actual_hours;
    }

    @Override
    public String toString() {
        return "Task{" +
                "task_id=" + task_id +
                ", task_name='" + task_name + '\'' +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                ", status=" + status +
//                ", duration=" + duration +
                ", subproject_id=" + subproject_id +
                ", employee_id=" + employee_id +
                ", estimated_hours=" + estimated_hours +
                ", actual_hours=" + actual_hours +
                '}';
    }


}
