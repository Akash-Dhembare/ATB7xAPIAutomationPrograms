package com.akash.dhembare2000.ex_21092024.testngexamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test007 {

    @Test
    public void serverStartedOk(){
        //Assert.assertTrue(false);
        System.out.println("I will run first");
    }

    @Test(dependsOnMethods = "serverStartedOk")
    public void testmethod1(){
        System.out.println("Method1");
    }
}
