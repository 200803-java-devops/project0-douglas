package com.github.doug;
import java.util.Scanner;

public class Cases {

    Scanner sc = new Scanner(System.in);
    static int option;

    public void welcome(){

        System.out.println("Hello there! Please select by typing what you would like to do \n " );
        System.out.println("1. Check Cases at My Location");
        System.out.println("2. Calculate the Possible Explosure Rate at My location");
        System.out.println("3. Report a possible case");
        System.out.println("4. Find out if I should go to the hospital");

        option = sc.nextInt();
    }

    public static int choice() {
        return option;
    }

    public void checkcase(){
        System.out.println("For sure, please type in your zip code:");
        option = sc.nextInt();
        System.out.println("Your zip code is " + option + ".");
    }

    public void rate(){
        //tbd added with data.java
    }

    public void report(){
        
    }

    public void question(){
        
    }
    
}