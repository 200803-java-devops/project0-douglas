package com.github.doug;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CheckCaseTest {
    Question testQuestion;

    @Before
    public void setup(){
        Question testQuestion = new Question();
    }
    

    @Test
    public void questionTest(){
        String expectedMessage = "Got it, Let's see if you are in danger of COVID \n First, are you feeling sick? \n Select \n 1: Yes \n 2: No \n 3: Back to Main Menu";
        //String actualMessage = toString().testQuestion.question();
        //assertEquals(expectedMessage, actualMessage);


    }

    
}