package org.example.eksamenkea.repository;

import org.example.eksamenkea.model.Employee;
import org.example.eksamenkea.repository.interfaces.IEmployeeRepository;
import org.example.eksamenkea.service.Errorhandling;
import org.example.eksamenkea.util.ConnectionManager;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository("IUSERREPOSITORY")
@Lazy //angiver at denne bean kun bliver initialiseret når den er nødvendig, og ikke ved opstart
public class EmployeeRepository implements IEmployeeRepository {

    //DB_USER=eksamenkea;DB_PASSWORD=Enstorko!;DB_URL=jdbc:mysql://eksamenkeasql.mysql.database.azure.com:3306
    //DB_USER=root;DB_PASSWORD=amalie;DB_URL=jdbc:mysql://localhost:3306/project_management

    public Employeerepository() {
    }

    @Override
    public Employee signIn(String email, String password) throws Errorhandling { //Amalie
        Employee employee = null;
        try {
            Connection con = ConnectionManager.getConnection();
            String SQLUser = "SELECT * FROM user WHERE email = ? AND password = ?;";
            PreparedStatement pstmt = con.prepareStatement(SQLUser); //brug af prepared stmt for at undgå sql injection
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                int employee_id = resultSet.getInt("employee_id");
                Boolean role_id = resultSet.getBoolean("role_id");
                employee = new Employee(employee_id, email, password, role_id);
            }

        } catch (SQLException e) {
            throw new Errorhandling("Sign in error" + e.getMessage()); //brugerdefineret exception
        }
        return employee;
    }
}
