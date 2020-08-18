package com.github.doug.data;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 * This method is creating a connection to the local database with port 2345
 * Once the method is called, it will be connected to the DB to access the sql.
 * 
 */
public class Connect {

    public static Connection connect() throws Exception{
            
        return DriverManager.getConnection("jdbc:postgresql://localhost:2345/covidData", "douglasliu", "password");
            

    }

}
