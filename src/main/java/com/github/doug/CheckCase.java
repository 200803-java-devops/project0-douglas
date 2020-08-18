package com.github.doug;

import java.util.Scanner;

import com.github.doug.data.Connect;

import java.sql.*;

public class CheckCase {

    public void checkCase() {
        System.out.println("For sure, please type in the name is your county:");
        Scanner sc = new Scanner(System.in);
        String county = sc.next();
        sc.close();
        System.out.println("Your county is " + county + ", are there are here are the current cases:");

        try {

            Connection con = Connect.connect();

            PreparedStatement statement = con.prepareStatement("SELECT cases FROM covidData where county = " + county);

            ResultSet result;

            result = statement.executeQuery();

            while (result.next()) {
                int num = result.getInt("cases");
                System.out.print(num);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Thank you for using the program!");
        System.out.println("Now directing to the main menu, please wait...");
        Cases cases = new Cases();
        cases.welcome();
        cases.selection();

    }

    public void listSample() {
        try {
        Connection con;
        
        con = Connect.connect();
        
        PreparedStatement statement = con.prepareStatement("SELECT * FROM covidData LIMIT 30");
        
        ResultSet result = statement.executeQuery();
        

        while(result.next()){
            System.out.print(result.getString("county"));
            System.out.print(" ");
            System.out.println(result.getString("cases"));  
        }

        System.out.println("Sample records have been displayed!");
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    System.out.println("Now directing to the main menu, please wait...");
    Cases cases = new Cases();
    cases.welcome();
    cases.selection();

    }
    
}