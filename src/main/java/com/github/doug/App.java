package com.github.doug;

import com.github.doug.data.GetData;

/**
 * This class starts the program
 * the first get Data method will ensure getting the latest data from NYT
 */

public class App {

    public static void main(String[] args) {
        
        try {
            GetData.getData();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Cases cases = new Cases();

        cases.welcome();
        cases.selection();



    }  
}