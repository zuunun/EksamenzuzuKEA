package org.example.eksamenkea.model;


public class Project {
    private int project_id;
    private String project_name;
    private double budget;
    private String project_description;
    private int employee_id;
    private int material_cost;
    private int employee_cost;

    public Project(int project_id, String project_name, double budget, String project_description, int employee_id, int material_cost, int employee_cost) {
        this.project_id = project_id;
        this.project_name = project_name;
        this.budget = budget;
        this.project_description = project_description;
        this.employee_id = employee_id;
        this.material_cost = material_cost;
        this.employee_cost = employee_cost;
    }

    public Project() {

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

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getEmployee_cost() {
        return employee_cost;
    }

    public void setEmployee_cost(int employee_cost) {
        this.employee_cost = employee_cost;
    }

    public int getMaterial_cost() {
        return material_cost;
    }

    public void setMaterial_cost(int material_cost) {
        this.material_cost = material_cost;
    }

    @Override
    public String toString() {
        return "Project{" +
                "project_id=" + project_id +
                ", project_name='" + project_name + '\'' +
                ", budget=" + budget +
                ", project_description='" + project_description + '\'' +
                ", employee_id=" + employee_id +
                '}';
    }
}

