package com.github.doug;

import java.util.Scanner;

import com.github.doug.data.Connect;

import java.sql.*;

public class CheckCase {
    Scanner sc = new Scanner(System.in);

    public void checkCase() {
        System.out.println("For sure, please type in the name of your county:");
        String county = sc.next();
        System.out.println("\n Your county is " + county + ", are here are the current status");

        try {

            Connection con = Connect.connect();

            PreparedStatement statement = con
                    .prepareStatement("SELECT * FROM covidData WHERE county = " + "'" + county + "'");

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                System.out.println(" \n There are " + result.getInt("cases") + " cases, and there are also "
                        + result.getInt("deaths") + " deaths.");
                System.out.println(" ");

            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("\n Thank you for using the case checker");
        System.out.println("Would you like to go back to the main menu?  1. Yes  2. No \n");
        int option = sc.nextInt();

        if (option == 2) {
            sc.close();
        } else {
            System.out.println("Restarting the main menu, please wait...");
            Cases cases = new Cases();
            cases.welcome();
            cases.selection();
        }
    }

    public void listSample() {
        try {
            Connection con;

            con = Connect.connect();

            PreparedStatement statement = con.prepareStatement("SELECT * FROM covidData LIMIT 50");

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                System.out.print(result.getString("county"));
                System.out.print(" ");
                System.out.println(result.getString("cases"));
                System.out.print(" ");
                System.out.println(result.getString("deaths"));
            }

            System.out.println("Sample records have been displayed!");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Would you like to go back to the main menu? \n 1. Yes \n 2. No \n");
        int option = sc.nextInt();

        if (option == 2) {
            sc.close();
        } else {
            System.out.println("Restarting the main menu, please wait...");
            Cases cases = new Cases();
            cases.welcome();
            cases.selection();
        }
    }

}