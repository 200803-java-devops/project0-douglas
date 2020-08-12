package com.github.doug;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Question {
    Scanner sc = new Scanner(System.in);
    static int option;

    public void question() {
        System.out.println("Got it, Let's see if you are in danger of COVID");
        System.out.println("First, are you feeling sick?");
        System.out.println("Select \n 1: Yes \n 2: No \n 3: Back to Main Menu");
        option = sc.nextInt();
        if (option == 1) {
            System.out.println(
                    "Sorry to hear that, can you let me know if you \n 1. Have been in close contact who tested posited for COVID  \n 2: Have not been in contect with anyone who tested posited for COVID \n 3: Restart Selection");
            option = sc.nextInt();
            if (option == 1) {
                System.out.println(
                        "Have you had fever, cough, or other symptoms? \n 1. Yes \n 2. No \n \n 3. Restart Selection");
                option = sc.nextInt();
                if (option == 1) {
                    System.out.println(
                            "You should go get tested as soon as possible while maintaining social distance, opening your testing site locations via browser...");
                    if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                        try {
                            Desktop.getDesktop().browse(new URI(
                                    "https://www.hhs.gov/coronavirus/community-based-testing-sites/index.html"));
                            System.out.println("Thank you for using the program!");
                            System.out.println("Now directing to the main menu, please wait...");
                            Cases cases = new Cases();
                            cases.welcome();
                            cases.selection();
                        } catch (IOException e) {
                            System.out.println("Browser Error");
                            e.printStackTrace();
                        } catch (URISyntaxException e) {
                            System.out.println("Browser Error");
                            e.printStackTrace();
                        }
                    }
                } else if (option == 2) {
                    System.out.println(
                            "You should self quarantine for at least 14 days at home. Would you like to: \n 1. Go back to the main menu \n 2. Check more COVID related resources \n 3. Leave");
                    option = sc.nextInt();
                    if (option == 1) {
                        System.out.println("Restarting the main menu, please wait...");
                        Cases cases = new Cases();
                        cases.welcome();
                        cases.selection();
                    } else if (option == 2) {
                        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                            try {
                                Desktop.getDesktop().browse(new URI(
                                        "https://www.cdc.gov/coronavirus/2019-ncov/prevent-getting-sick/index.html"));
                                System.out.println("Thank you for using the program!");
                                System.out.println("Now directing to the main menu, please wait...");
                                Cases cases = new Cases();
                                cases.welcome();
                                cases.selection();
                            } catch (IOException e) {
                                System.out.println("Browser Error");
                                e.printStackTrace();
                            } catch (URISyntaxException e) {
                                System.out.println("Browser Error");
                                e.printStackTrace();
                            }
                        }
                    } else {
                        System.out.println("Thank you for using the program!");
                        System.out.println("Now directing to the main menu, please wait...");
                        Cases cases = new Cases();
                        cases.welcome();
                        cases.selection();
                    }
                } else {
                    System.out.println("Restarting the selection, please wait...");
                    Question ques = new Question();
                    ques.question();
                }
            } else if (option == 2) {
                System.out.println(
                        "Have you had fever, cough, or other symptoms? \n 1. Yes \n 2. No \n 3. Restart Selection");
                option = sc.nextInt();
                if (option == 1) {
                    System.out.println(
                            "You might still be in danger, and you should self quarantine for at least 14 days at home, directing you to the CDC information site...");
                    if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                        try {
                            Desktop.getDesktop().browse(new URI(
                                    "https://www.cdc.gov/coronavirus/2019-ncov/prevent-getting-sick/index.html"));
                        } catch (IOException e) {
                            System.out.println("Browser Error");
                            e.printStackTrace();
                        } catch (URISyntaxException e) {
                            System.out.println("Browser Error");
                            e.printStackTrace();
                        }
                        System.out.println("Thank you for using the program!");
                        System.out.println("Now directing to the main menu, please wait...");
                        Cases cases = new Cases();
                        cases.welcome();
                        cases.selection();
                    } else if (option == 2) {
                        System.out.println(
                                "You should not be in immediate danger, please stay safe by continuing social distance, and talk to your doctor if you do not feel well. Would you like to go back to the main menu? \1. Yes \2 2. No");
                        option = sc.nextInt();
                        if (option == 1) {
                            System.out.println("Restarting the main menu, please wait...");
                            Cases cases = new Cases();
                            cases.welcome();
                            cases.selection();
                        } else {
                            System.out.println("Restarting the main menu, please wait...");
                            Cases cases = new Cases();
                            cases.welcome();
                            cases.selection();
                        }
                    } else {
                        System.out.println("Restarting the selection, please wait...");
                        Question ques = new Question();
                        ques.question();
                    }

                } else if (option == 2) {
                    System.out.println(
                            "You should not be in immediate danger, please stay safe by continuing social distance, and talk to your doctor if you do not feel well. Would you like to go back to the main menu? \1. Yes \2 2. No");
                    option = sc.nextInt();
                    if (option == 1) {
                        System.out.println("Restarting the main menu, please wait...");
                        Cases cases = new Cases();
                        cases.welcome();
                        cases.selection();
                    } else {
                        System.out.println("Restarting the main menu, please wait...");
                        Cases cases = new Cases();
                        cases.welcome();
                        cases.selection();
                    }
                } else {
                    System.out.println("Restarting the selection, please wait...");
                    Question ques = new Question();
                    ques.question();
                }
            } else {
                System.out.println("Restarting the main menu, please wait...");
                Cases cases = new Cases();
                cases.welcome();
                cases.selection();
            }
        } else if (option == 2) {
            System.out
                    .println("That's good. Have been in close contact who tested posited for COVID? \n 1:Yes \n 2:No");
            option = sc.nextInt();
            if (option == 1) {
                System.out.println(
                        "You might still be in danger, and you should self quarantine for at least 14 days at home.");
                System.out.println(
                        "Would you like to: \n 1. Go back to the main menu \n 2. Check more COVID related resources \3. Leave");
                option = sc.nextInt();
                if (option == 1) {
                    System.out.println("Restarting the main menu, please wait...");
                    Cases cases = new Cases();
                    cases.welcome();
                    cases.selection();
                } else if (option == 2) {
                    if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                        try {
                            Desktop.getDesktop().browse(new URI(
                                    "https://www.cdc.gov/coronavirus/2019-ncov/prevent-getting-sick/index.html"));
                            System.out.println("Thank you for using the program!");
                            System.out.println("Now directing to the main menu, please wait...");
                            Cases cases = new Cases();
                            cases.welcome();
                            cases.selection();
                        } catch (IOException e) {
                            System.out.println("Browser Error");
                            e.printStackTrace();
                        } catch (URISyntaxException e) {
                            System.out.println("Browser Error");
                            e.printStackTrace();
                        }
                    }
                } else {
                    System.out.println("Thank you for using the program");
                    System.out.println("Now directing to the main menu, please wait...");
                    Cases cases = new Cases();
                    cases.welcome();
                    cases.selection();
                }
            } else if (option == 2) {
                System.out.println(
                        "You should not be in immediate danger, please stay safe by continuing social distance, and talk to your doctor if you do not feel well. Would you like to go back to: \n 1. Go back to Main Menu \n 2. Check Additional Resources \n 3. Close the program ");
                option = sc.nextInt();
                if (option == 1) {
                    System.out.println("Restarting the main menu, please wait...");
                    Cases cases = new Cases();
                    cases.welcome();
                    cases.selection();
                } else if (option == 2) {
                    if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                        try {
                            Desktop.getDesktop().browse(new URI(
                                    "https://www.cdc.gov/coronavirus/2019-ncov/prevent-getting-sick/index.html"));

                            System.out.println("Thank you for using the program!");
                            System.out.println("Now directing to the main menu, please wait...");
                            Cases cases = new Cases();
                            cases.welcome();
                            cases.selection();

                        } catch (IOException e) {
                            System.out.println("Browser Error");
                            e.printStackTrace();
                        } catch (URISyntaxException e) {
                            System.out.println("Browser Error");
                            e.printStackTrace();
                        }
                    }
                } else {
                    System.out.println("Thank you for using the program!");
                    System.out.println("Now directing to the main menu, please wait...");
                    Cases cases = new Cases();
                    cases.welcome();
                    cases.selection();
                }
            } else {
                System.out.println("Thank you for using the program!");
                System.out.println("Now directing to the main menu, please wait...");
                Cases cases = new Cases();
                cases.welcome();
                cases.selection();

            }

        }

    }

}