package org.example.eksamenkea.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static Connection conn;

        private ConnectionManager() {// Private constructor to prevent instantiation
        }

        public static Connection getConnection() {
            if (conn != null) {
                return conn; // Hvis vi allerede har forbindelse, så brug denne
            }

            String DB_URL = System.getenv("DB_URL"); //hente variablene
            String DB_USER = System.getenv("DB_USER");
            String DB_PASSWORD = System.getenv("DB_PASSWORD");

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("Failed to connect to db");
            e.printStackTrace();
        }
        return conn;
    }


}


