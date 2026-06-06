package com.organization.leavemanagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    // Database URL
    private static final String URL =
            "jdbc:mysql://localhost:3306/leave_management";

    // MySQL username
    private static final String USER = "root";

    // MySQL password
    private static final String PASSWORD = "Zachariah71";

    // Method to get database connection
    public static Connection getConnection()
            throws SQLException {

        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }
}