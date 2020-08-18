package com.github.doug.data;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {


    public static Connection connect() throws Exception{
            
        return DriverManager.getConnection("jdbc:postgresql://localhost:2345/covidData", "douglasliu", "password");
            

    }

}
