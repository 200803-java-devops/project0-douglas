package com.github.doug.data;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;

//needs to also change dependencies in pom.xml

public class GetData {

    public static void getData() throws Exception {

        Connection connect = Connect.connect();

        String sql = "INSERT INTO covidData (county, cases, deaths) VALUES (?, ?, ?)";
        PreparedStatement statement = connect.prepareStatement(sql);
        statement.execute();

        URL url = new URL("https://raw.githubusercontent.com/nytimes/covid-19-data/master/live/us-counties.csv");
        InputStream input = url.openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        String lineText = null;
        reader.readLine();

        while ((lineText = reader.readLine()) != null) {
            String[] data = lineText.split(",");
            String county = data[1];
            String cases = data[4];
            String deaths = data[5];
            statement.addBatch();
        }

        statement.executeBatch();

        reader.close();
        connect.commit();
        connect.close();
        
    }

}
