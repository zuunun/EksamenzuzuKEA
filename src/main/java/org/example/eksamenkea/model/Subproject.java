package org.example.eksamenkea.model;

import java.time.LocalDate;

public class Subproject {
    private int subproject_id;
    private String subproject_name;
    private String subproject_description;
    private int project_id;

    public Subproject(int subproject_id, String subproject_name, String subproject_description, int project_id) {
        this.subproject_id = subproject_id;
        this.subproject_name = subproject_name;
        this.subproject_description = subproject_description;
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

    public String getSubproject_description() {
        return subproject_description;
    }

    public void setSubproject_description(String subproject_description) {
        this.subproject_description = subproject_description;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }
}
