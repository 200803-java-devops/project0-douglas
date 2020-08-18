package com.github.doug;

import java.util.Scanner;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This method simply asks users for their selection on what they would like to
 * do, Then, it will go ahead and create an instacne for each function in this
 * program.
 */
public class Cases {
    private static Log log = LogFactory.getLog(Cases.class);
    Scanner sc = new Scanner(System.in);
    static int option;

    public void welcome() {

        System.out.println("\nHello there! Please select by typing what you would like to do \n ");
        System.out.println("1. Check Cases at My Location");
        System.out.println("2. Calculate the Possible Explosure Rate at My location");
        System.out.println("3. See a sample of the data retrived from server");
        System.out.println("4. Find out if I should go to get tested");

        option = sc.nextInt();

    }

    public void selection() {

        log.info("Selection started successfully");

        try {
            switch (option) {
                case 1:
                    CheckCase check = new CheckCase();
                    check.checkCase();
                    break;
                case 2:
                    Exposure expo = new Exposure();
                    expo.checkExposure();
                    break;

                case 4:
                    Question ques = new Question();
                    ques.question();
                    break;

                case 3:
                    CheckCase listall = new CheckCase();
                    listall.listSample();
                    break;

                default:
                    System.out.println("Please choose a valid selection by typing: 1, 2, 3, 4. ");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Please type in a valid selection by typing: 1, 2, 3, 4.");
        }
    }

}