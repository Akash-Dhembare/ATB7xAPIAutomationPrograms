package com.akash.dhembare2000.ex_22092024.Verification;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Verification001 {

    @Test
    public void test_verify(){
        String responseName="Akash";
        Assert.assertEquals("Akash", responseName);
    }
}
