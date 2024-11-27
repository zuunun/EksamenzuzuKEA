package org.example.eksamenkea.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String DB_URL = System.getenv("DB_URL");
    private static final String DB_USER = System.getenv("DB_USER");
    private static final String DB_PASSWORD = System.getenv("DB_PASSWORD");

    private ConnectionManager() {
        // Private constructor to prevent instantiation
    }

    public static Connection getConnection() throws SQLException {
        // Opret en ny forbindelse hver gang, så den ikke bliver inaktiv
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
