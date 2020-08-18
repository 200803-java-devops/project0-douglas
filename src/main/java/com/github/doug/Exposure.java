package com.github.doug;
import com.github.doug.data.Connect;

import java.util.Scanner;
import java.sql.*;





public class Exposure {

    public void checkExposure() {
        double rate = 0;
        System.out.println("For sure, to calculate the rates, please type in the name of your county:");
        Scanner sc = new Scanner(System.in);
        String county = sc.next();
        System.out.println("Your county is " + county + ", are here are the current status");

        try {

            Connection con = Connect.connect();

            PreparedStatement statement = con
                    .prepareStatement("SELECT * FROM covidData WHERE county = " + "'" + county + "'");

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                rate = (double) result.getInt("deaths") / result.getInt("cases");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(" \n The fatility rate for your location is " + rate + " , which this means that: ");

        if (rate > 0.1) {
            System.out.println(
                    "Your county's medical service is really bad, please make sure to review: Find out if I should get tested");

        } else if (rate > 0.05) {
            System.out.println(
                    "Your county's medical service is doing below the average, please review: Find out if I should get tested");

        } else if (rate > 0.03) {
            System.out.println(
                    "Your county's medical service is doing okay, please review: Find out if I should get tested");
        } else {
            System.out.println(
                    "Your county's medical service is doing above average, if you want, please review: Find out if I should get tested");
        }

        System.out.println(" \n Thank you for using the exposure checker!");
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

}
