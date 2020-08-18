package com.github.doug;

import com.github.doug.data.GetData;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This class starts the program the first get Data method will ensure getting
 * the latest data from NYT
 */

public class App {

    private static Log log = LogFactory.getLog(App.class);

    public static void main(String[] args) {

        log.info("App started successfully");

        try {
            GetData.getData();
        } catch (Exception e) {
            System.err.println("Not able to get database");
            e.printStackTrace();
        }
        Cases cases = new Cases();

        cases.welcome();
        cases.selection();

    }
}