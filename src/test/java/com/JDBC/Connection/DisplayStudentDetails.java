package com.JDBC.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayStudentDetails {

    public static void main(String[] args) {

        String databaseURL = "jdbc:mysql://localhost:3306/seleniumautomation";
        String user = "root";
        String password = "Mailonly123_";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(databaseURL, user, password);
            Statement stmt = con.createStatement();

            String query = "SELECT * FROM seleniumautomation.stu_detl";
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("------------------------------------------------------------");
            System.out.printf("%-10s %-15s %-15s %-10s%n",
                    "Stu Code", "Student Name", "Dept Code", "Fine");
            System.out.println("------------------------------------------------------------");

            while (rs.next()) {

                String stuCode = rs.getString("stu_code");
                String studentName = rs.getString("name");
                String deptCode = rs.getString("dept_code");
                String fine = rs.getString("fine");

                System.out.printf("%-10s %-15s %-15s %-10s%n",
                        stuCode,
                        studentName,
                        deptCode,
                        fine);
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}