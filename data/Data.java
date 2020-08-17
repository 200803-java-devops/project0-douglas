package com.github.doug;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.StringReader;

//needs to also change dependencies in pom.xml

public class Data {

    public static void main(String[] args) throws IOException, InterruptedException {

        String url = "jdbc:postgresql://5432:5432/covidData";
        String username = "douglasliu";
        String password = "douglasliu";

        String csvFilePath = "NYTDATA"; //NEEDS to figure out how to import data from there and copy to local 
 
        int batchSize = 20;
 
        Connection connection = null;


        try {
 
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
 
            String sql = "INSERT INTO covidData (county, cases, timestamp) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
 
            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
            String lineText = null;
 
            int count = 0;
 
            lineReader.readLine(); 
 
            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                String county = data[0];
                String cases = data[1];
 
                statement.setString(1, county);
                statement.setString(2, cases);
 
                statement.addBatch();
 
                if (count % batchSize == 0) {
                    statement.executeBatch();
                }
            }
 
            lineReader.close();
 
            statement.executeBatch();
 
            connection.commit();
            connection.close();
 
        } catch (IOException ex) {
            System.err.println(ex);
        } catch (SQLException ex) {
            ex.printStackTrace();
 
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



        
        // HttpClient client = HttpClient.newHttpClient();
        // HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://raw.githubusercontent.com/nytimes/covid-19-data/master/live/us-counties.csv")).build();
        // HttpResponse<String> httpResponse= client.send(request, HttpResponse.BodyHandlers.ofString());
        // StringReader csvBodyReader = new StringReader(httpResponse.body());
        // Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);


        
            // for (CSVRecord record : records) {
            //     String county = record.get("county");
                



            // }

            
        
    }

}
