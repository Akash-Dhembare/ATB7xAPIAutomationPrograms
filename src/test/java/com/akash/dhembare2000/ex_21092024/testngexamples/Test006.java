package com.akash.dhembare2000.ex_21092024.testngexamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test006 {

    @Test(groups = {"qa", "sanity", "preprod"})
    public void SanityRun(){
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }

    @Test(groups = {"qa"})
    public void RegRun(){
        System.out.println("Reg");
        Assert.assertTrue(true);
    }

    @Test(groups = {"dev" , "preprod"})
    public void SmokeRun(){
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }
}
