package org.example.eksamenkea.repository;

import org.example.eksamenkea.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class UserRepository {
    @Value("${spring.datasource.url}")
    private String DB_URL;

    @Value("${spring.datasource.username}")
    private String DB_USER;

    @Value("${spring.datasource.password}")
    private String DB_PASSWORD;

    //DB_USER=eksamenkea;DB_PASSWORD=Enstorko!;DB_URL=jdbc:mysql://eksamenkeasql.mysql.database.azure.com:3306

    public User signIn(String email, String password) {
        User user = null;

        try {
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String SQLUser = "SELECT * FROM user WHERE email = ? AND password = ?;";
            PreparedStatement pstmt = con.prepareStatement(SQLUser);
            pstmt.setString(1, email);
            pstmt.setString(1, password);
            ResultSet resultSet = pstmt.executeQuery();

            if(resultSet.next()) {
                int user_id = resultSet.getInt("user_id");
                int role_id = resultSet.getInt("role_id");
                user= new User(user_id, email, password, role_id);
            }

        } catch (SQLException e) {
            System.out.println("error"); //anden handling kræves
        }
        return user;
    }

}
