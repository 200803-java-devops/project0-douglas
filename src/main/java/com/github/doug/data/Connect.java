package com.github.doug.data;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {


    public static Connection connect() throws Exception{
        try{
            
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:1111/covidData", "douglasliu", "password");
            
            return conn;
        } catch(Exception e){System.out.println(e);}
        
        return null;
    }

}
