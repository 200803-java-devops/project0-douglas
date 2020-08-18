package com.github.doug.data;

import java.io.*;
import java.net.URL;
import java.sql.*;

/**
 * This class is used to get the latest covid data from the New York Times github
 * It then will simplify the data by only getting the county, cases, and death information
 * Those data will then be added to the covidData SQL for further uses.
 */

public class GetData {



    public static void getData() throws Exception {

        Connection con = Connect.connect();
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
