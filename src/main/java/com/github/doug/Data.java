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
        
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://raw.githubusercontent.com/nytimes/covid-19-data/master/live/us-counties.csv")).build();
            HttpResponse<String> httpResponse= client.send(request, HttpResponse.BodyHandlers.ofString());
            StringReader csvBodyReader = new StringReader(httpResponse.body());
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
            for (CSVRecord record : records) {
                String county = record.get("county");

            // testing

            System.out.println(county);

            }

            
        
    }

}
