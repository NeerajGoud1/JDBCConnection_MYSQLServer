package com.JDBC.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DatabaseTest {

    @Test
    public void testDatabaseConnection() throws SQLException, ClassNotFoundException {

        String dbURL = "jdbc:mysql://localhost:3306/seleniumautomation";
        String username = "root";
        String password = "Mailonly123_";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(dbURL, username, password);
        Statement stmt = con.createStatement();

        String query = "SELECT * FROM seleniumautomation.book_detl";
        ResultSet rs = stmt.executeQuery(query);
     
        while (rs.next()) {
            String auth = rs.getString("author");
            String tit = rs.getString("title");

            System.out.println("author: " + auth + ", title: " + tit);
        }

        
        con.close();
    }
}