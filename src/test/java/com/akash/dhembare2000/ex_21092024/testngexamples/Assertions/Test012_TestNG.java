package com.akash.dhembare2000.ex_21092024.testngexamples.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test012_TestNG {

//    // SoftAssert : This means that if any assertion fails, the remaining statements in that test method will be executed.

    @Test
    public void softAssertExample() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(false); // This will not stop execution.
        System.out.println("This line will be executed.");
        softAssert.assertAll(); // This will report all collected errors.
    }
    // HardAssert : This means that if any assertion fails, the remaining statements in that test method will not be executed.

    @Test
    public void hardAssertExample() {
        Assert.assertTrue(false);
        System.out.println("This line will not execute");
    }


}
