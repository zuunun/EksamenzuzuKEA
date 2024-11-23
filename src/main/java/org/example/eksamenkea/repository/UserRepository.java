package org.example.eksamenkea.repository;

import org.example.eksamenkea.model.Role;
import org.example.eksamenkea.model.User;
import org.example.eksamenkea.repository.interfaces.IUserRepository;
import org.example.eksamenkea.service.Errorhandling;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository("DEPARTMENT_REPOSITORY_STUB")
public class UserRepository implements IUserRepository {
    @Value("${spring.datasource.url}")
    private String DB_URL;

    @Value("${spring.datasource.username}")
    private String DB_USER;

    @Value("${spring.datasource.password}")
    private String DB_PASSWORD;

    //DB_USER=eksamenkea;DB_PASSWORD=Enstorko!;DB_URL=jdbc:mysql://eksamenkeasql.mysql.database.azure.com:3306
    //DB_USER=root;DB_PASSWORD=amalie;DB_URL=jdbc:mysql://localhost:3306/project_management
    @Override
    public User signIn(String email, String password) throws Errorhandling {
        User user = null;

        try {
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String SQLUser = "SELECT * FROM user WHERE email = ? AND password = ?;";
            PreparedStatement pstmt = con.prepareStatement(SQLUser);
            System.out.println("prepared stament build");
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            System.out.println("now ex query");
            ResultSet resultSet = pstmt.executeQuery();
            System.out.println("executed");
            if (resultSet.next()) {
                int user_id = resultSet.getInt("user_id");
//                String roleStr = resultSet.getString("role_id");
//                Role role_id = Role.valueOf(roleStr);
                System.out.println(user_id);
                user = new User(user_id, email, password, Role.PROJECTLEADER);
            }

        } catch (SQLException e) {
            throw new Errorhandling("Sign in error");
        }
        return user;
    }

}
