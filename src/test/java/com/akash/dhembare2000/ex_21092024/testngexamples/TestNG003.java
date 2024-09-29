package com.akash.dhembare2000.ex_21092024.testngexamples;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG003 {
    //PUT
    String token;
    Integer bookingID;

    @BeforeTest
    public String getToken(){
        token="123";
        return token;
    }

    @BeforeTest
    public void getTokenAndBookingID(){
        token=getToken();
        //POST Req -
        //POST code
        bookingID=123;
    }

    @Test
    public void testPutReq(){
        System.out.println(token);
        System.out.println(bookingID);
    }

    @Test
    public void testPutReq2(){
        System.out.println(token);
        System.out.println(bookingID);
    }

    @Test
    public void testPutReq3(){
        System.out.println(token);
        System.out.println(bookingID);
    }


}
