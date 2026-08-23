package com.JDBC.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PrintOrderDetails {

    public static void main(String[] args) {

        String databaseURL = "jdbc:mysql://localhost:3306/seleniumautomation";
        String user = "root";
        String password = "Mailonly123_";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(databaseURL, user, password);
            Statement stmt = con.createStatement();

            String query = "SELECT * FROM seleniumautomation.ORDER_NEW";
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("--------------------------------------------------------------------------");
            System.out.printf("%-10s %-22s %-12s %-15s %-12s%n",
                    "Order ID", "Order Date", "Order Mode", "Customer ID", "Order Total");
            System.out.println("--------------------------------------------------------------------------");

            while (rs.next()) {

                int orderId = rs.getInt("ORDER_ID");
                String orderDate = rs.getString("ORDER_DATE");
                String orderMode = rs.getString("ORDER_MODE");
                int customerId = rs.getInt("CUSTOMER_ID");
                double orderTotal = rs.getDouble("ORDER_TOTAL");

                System.out.printf("%-10d %-22s %-12s %-15d %-12.2f%n",
                        orderId,
                        orderDate,
                        orderMode,
                        customerId,
                        orderTotal);
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}