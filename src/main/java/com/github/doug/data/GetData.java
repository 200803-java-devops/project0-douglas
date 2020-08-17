package com.github.doug.data;

import java.io.*;
import java.net.URL;
import java.sql.*;

//needs to also change dependencies in pom.xml

public class GetData {

    // public static Connection connect(){

    //     String url = "jdbc:postgresql://localhost:5432/covidData";
    //     String username = "douglasliu";
    //     String password = "password";
    
    //         try {
    //             Class.forName("org.postgresql.Driver");
    //             Connection conn = DriverManager.getConnection(url, username, password);
    //             return conn;
    
    //         } catch (SQLException e) {
    //             System.out.println("Failed to Connect");
    //         } catch (java.lang.ClassNotFoundException e) {
    //             System.out.println(e.getMessage());
    //         }
    //         return null;
    
    // }

    public static void getData() throws Exception {

        //Connection con = connect();
        Connection con = null;
        con = DriverManager.getConnection("jdbc:postgresql://localhost:1111/covidData", "douglasliu", "password");
        con.setAutoCommit(false);

        String sql = "INSERT INTO covidData (county, cases, deaths) VALUES (?, ?, ?)";
        PreparedStatement statement = con.prepareStatement(sql);

        URL url = new URL("https://raw.githubusercontent.com/nytimes/covid-19-data/master/live/us-counties.csv");
        InputStream input = url.openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        String lineText = null;
        reader.readLine();

        while ((lineText = reader.readLine()) != null) {
            String[] data = lineText.split(",");

            String county = data[1];
            statement.setString(1, county);

            try {
                int cases = Integer.parseInt(data[4]);
                statement.setInt(2, cases);
            } catch (NumberFormatException e) {
                int cases = 0;
                statement.setInt(2, cases);
            }
            //int cases = Integer.parseInt(data[4]);

            try {
                int deaths = Integer.parseInt(data[5]);
                statement.setInt(3, deaths);
            } catch (NumberFormatException e) {
                int deaths = 0;
                statement.setInt(3, deaths);
            }
            //int deaths = Integer.parseInt(data[5]);

            
            //statement.setInt(2, cases);
            //statement.setInt(3, deaths);
            statement.addBatch();
        }

        statement.executeBatch();

        reader.close();
        con.commit();
        con.close();
        
    }

}
