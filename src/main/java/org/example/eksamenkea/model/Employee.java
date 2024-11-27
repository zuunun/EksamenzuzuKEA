package org.example.eksamenkea.model;

public class Employee {
    private int employee_id;
    private String email; // fungerer som username
    private String password;
    private Role role; // Enum type
    private int employee_rate;
    private int max_hours; // Maksimale timer

    public Employee(int employee_id, String email, String password, Role role, int employee_rate, int max_hours) {
        this.employee_id = employee_id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.employee_rate = employee_rate;
        this.max_hours = max_hours;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getEmployee_rate() {
        return employee_rate;
    }

    public void setEmployee_rate(int employee_rate) {
        this.employee_rate = employee_rate;
    }

    public int getMax_hours() {
        return max_hours;
    }

    public void setMax_hours(int max_hours) {
        this.max_hours = max_hours;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", employee_rate=" + employee_rate +
                ", max_hours=" + max_hours +
                '}';
    }
}
