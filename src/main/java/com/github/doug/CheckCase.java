package com.github.doug;


import java.util.Scanner;
import java.sql.*;


public class CheckCase {
    public void checkcase(){
        System.out.println("For sure, please type in your zip code:");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        System.out.println("Your zip code is " + option + ".");


        String url = "jdbc:postgresql://5432:5432/data";
        String username = "douglasliu";
        String password = "douglasliu";
        Connection connection = DriverManager.getConnection(url, username, password);




        
    }
    
}