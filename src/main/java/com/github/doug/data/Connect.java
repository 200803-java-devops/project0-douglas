package com.github.doug.data;

import java.sql.*;

public class Connect {


public static Connection connect(){

    String url = "jdbc:postgresql://5432:5432/covidData";
    String username = "douglasliu";
    String password = "douglasliu";

        try {
            Class.forName("org.postgresql.Driver");
            Connection connect = DriverManager.getConnection(url, username, password);
            return connect;

        } catch (SQLException e) {
            System.out.println("Failed to Connect");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return null;
}


}
