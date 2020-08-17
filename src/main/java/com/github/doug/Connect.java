package com.github.doug;

import java.sql.*;

public class Connect {

    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        String url = "jdbc:postgresql://5432:5432/data";
        String username = "dougliu";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            ResultSet county = statement.executeQuery("SELECT * from County");
            while (county.next()) {
                System.out.println(county.getInt("cases"));
            }

            county.close();
            statement.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
