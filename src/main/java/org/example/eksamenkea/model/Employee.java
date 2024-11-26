package org.example.eksamenkea.model;

public class Employee {
    private int employee_id;
    private String email; //fungerer som username
    private String password;
    Role role_id;

    public Employee(int user_id, String email, String password, Role role_id) {
        this.employee_id = employee_id;
        this.email = email;
        this.password = password;
        this.role_id = role_id;
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

    public Role getRole_id() {
        return role_id;
    }

    public void setRole_id(Role role_id) {
        this.role_id = role_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "employee_id=" + employee_id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role_id=" + role_id +
                '}';
    }
}

