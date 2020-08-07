package com.github.doug;


public class App 
{


    public static void main( String[] args )
    {   
        Cases cases = new Cases();

        cases.welcome();


        switch (cases.option) {
            case 1:
                cases.checkcase();
                break;
            case 2:
                cases.rate();
                break;

            case 3:
                cases.report();
                break;

            case 4:
                cases.question();
                break;

            default:
            System.out.println("Please choose a valid selection by typing: 1, 2, 3, 4. ");
                break;
        }

    }  
}