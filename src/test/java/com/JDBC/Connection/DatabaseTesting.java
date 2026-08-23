package com.JDBC.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.annotations.Test;

public class DatabaseTesting {

    private Connection connection;

    @Test
    public void establishDatabaseConnection() throws ClassNotFoundException, SQLException {

        // Database connection details
        String databaseURL = "jdbc:mysql://localhost:3306/seleniumautomation";
        String user = "root";
        String password = "Mailonly123_";

        // Load the MySQL JDBC driver and establish connection
        Class.forName("com.mysql.cj.jdbc.Driver");

        System.out.println("Connecting to Database");

        connection = DriverManager.getConnection(databaseURL, user, password);

        // Check if the connection is successful
        if (connection == null) {
            System.out.println("Database Connection Failed");
        } else {
            System.out.println("Database Connection Successful");
        }
    }
}