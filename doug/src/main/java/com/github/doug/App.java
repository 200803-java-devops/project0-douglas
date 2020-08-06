package com.github.doug;

import java.util.Scanner;

public class App 
{


    public static void main( String[] args )
    {   
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Hello there! Please select by typing what you would like to do \n " );
        System.out.println("1. Check Cases at My Location");
        System.out.println("2. Calculate the Possible Explosure Rate at My location");
        System.out.println("3. Report a possible case");
        System.out.println("4. Find out if I should go to the hospital");

        //try {
            int option = sc.nextInt();
        //} catch (Exception e) {
        //    System.err.println("Invalid response, Please type in only integer, such as 1, 2, 3, 4.");
        //} 



        switch (option) {
            case 1:
                Cases cases = new Cases();
                cases.checkcase();
                break;
            case 2:

                break;

            case 3:

                break;

            case 4:

                break;

            default:
            System.out.println("Please choose a valid selection by typing: 1, 2, 3, 4. ");
                break;
        }

    }  
}