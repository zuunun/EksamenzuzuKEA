package org.example.eksamenkea.model;

public class Employee {
    private int employee_id;
    private String email; //fungerer som username
    private String password;
    Role role;

    public Employee(int employee_id, String email, String password, Role role) {
        this.employee_id = employee_id;
        this.email = email;
        this.password = password;
        this.role = role;
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

    @Override
    public String toString() {
        return "User{" +
                "employee_id=" + employee_id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}

