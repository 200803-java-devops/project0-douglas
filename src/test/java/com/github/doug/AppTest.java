package com.github.doug;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class AppTest 
{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void CasesTest()
    {   
        String expectedOutput = "Hello there! Please select by typing what you would like to do \n \n 1. Check Cases at My Location \n 2. Calculate the Possible Explosure Rate at My location \n 3. See a sample of the data retrived from server \n 4. Find out if I should go to get tested";
        Cases test1 = new Cases();
        test1.welcome();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void CheckCaseTest()
    {   
        String expectedOutput = "For sure, please type in the name of your county:";
        CheckCase test2 = new CheckCase();
        test2.checkCase();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void ExposureTest()
    {   
        String expectedOutput = "For sure, to calculate the rates, please type in the name of your county:";
        Exposure test3 = new Exposure();
        test3.checkExposure();
        assertEquals(expectedOutput, outContent.toString());
    }
    
    @Test
    public void QuestionTest()
    {   
        String expectedOutput = "Got it, Let's see if you are in danger of COVID \n First, are you feeling sick? \n Select \n 1: Yes \n 2: No \n 3: Back to Main Menu";
        Question test4 = new Question();
        test4.question();
        assertEquals(expectedOutput, outContent.toString());
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

}
