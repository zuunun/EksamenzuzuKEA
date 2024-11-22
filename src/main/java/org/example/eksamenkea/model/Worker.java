package org.example.eksamenkea.model;

public class Worker {
    private int worker_id;
    private String worker_username;
    private String worker_email;
    private String worker_skills;
    private int estimatedtime;
    private int actualtime;
    private int task_id; //FK

    public Worker(int worker_id, String worker_username, String worker_email, String worker_skills, int estimatedtime, int actualtime, int task_id) {
        this.worker_id = worker_id;
        this.worker_username = worker_username;
        this.worker_email = worker_email;
        this.worker_skills = worker_skills;
        this.estimatedtime = estimatedtime;
        this.actualtime = actualtime;
        this.task_id = task_id;
    }

    public int getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(int worker_id) {
        this.worker_id = worker_id;
    }

    public String getWorker_username() {
        return worker_username;
    }

    public void setWorker_username(String worker_username) {
        this.worker_username = worker_username;
    }

    public String getWorker_email() {
        return worker_email;
    }

    public void setWorker_email(String worker_email) {
        this.worker_email = worker_email;
    }

    public String getWorker_skills() {
        return worker_skills;
    }

    public void setWorker_skills(String worker_skills) {
        this.worker_skills = worker_skills;
    }

    public int getEstimatedtime() {
        return estimatedtime;
    }

    public void setEstimatedtime(int estimatedtime) {
        this.estimatedtime = estimatedtime;
    }

    public int getActualtime() {
        return actualtime;
    }

    public void setActualtime(int actualtime) {
        this.actualtime = actualtime;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "worker_id=" + worker_id +
                ", worker_username='" + worker_username + '\'' +
                ", worker_email='" + worker_email + '\'' +
                ", worker_skills='" + worker_skills + '\'' +
                ", estimatedtime=" + estimatedtime +
                ", actualtime=" + actualtime +
                ", task_id=" + task_id +
                '}';
    }
}
