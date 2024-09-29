package com.akash.dhembare2000.ex_21092024.testngexamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test009 {

    @Test
    public void test01(){
        Assert.assertTrue(true);
    }

    @Test (enabled = false) //will skip this testcase
    public void test02(){
        Assert.assertTrue(false);
    }

    @Test
    public void test03(){
        Assert.assertTrue(true);
    }
}
