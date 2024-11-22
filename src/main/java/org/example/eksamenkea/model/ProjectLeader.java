package org.example.eksamenkea.model;

public class ProjectLeader {
    private int projectleader_id;
    private String projectleader_name;
    private String email;
    private String password;

    public ProjectLeader(int projectleader_id, String projectleader_name, String email, String password) {
        this.projectleader_id = projectleader_id;
        this.projectleader_name = projectleader_name;
        this.email = email;
        this.password = password;
    }

    public int getProjectleader_id() {
        return projectleader_id;
    }

    public void setProjectleader_id(int projectleader_id) {
        this.projectleader_id = projectleader_id;
    }

    public String getProjectleader_name() {
        return projectleader_name;
    }

    public void setProjectleader_name(String projectleader_name) {
        this.projectleader_name = projectleader_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectleader_id=" + projectleader_id +
                ", projectleader_name='" + projectleader_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
