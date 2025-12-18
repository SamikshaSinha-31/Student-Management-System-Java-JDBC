package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Utility class for managing JDBC connections
public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/student_db";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    private DBConnection() {}

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
            return null;
        }
    }
}
