package com.github.doug;

import com.github.doug.data.GetData;

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