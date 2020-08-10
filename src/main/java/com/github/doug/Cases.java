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

    public void selection(){
        
        try {
            switch (option) {
                case 1:
                    checkcase();
                    break;
                case 2:
                    rate();
                    break;

                case 3:
                    report();
                    break;

                case 4:
                    question();
                    break;

                default:
                System.out.println("Please choose a valid selection by typing: 1, 2, 3, 4. ");
                    break;
          }
        } catch (final Exception e) {
        System.err.println("Please type in a valid selection by typing: 1, 2, 3, 4.");
        }
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
        System.out.println("For sure, Let's see if you are in danger of COVID");
        System.out.println("First, are you feeling sick?");
        System.out.println("Select 1: Yes or 2:No ");
        option = sc.nextInt();
        if (option == 1){
            System.out.println("Sorrt to hear that, can you let me know if you have 1:Been in Contact or 2:Recently...");
        } else {
            System.out.println("That's good...");
        }
    }
    
}