package com.akash.dhembare2000.ex_15092024.CRUD.testng;

import org.testng.annotations.*;

public class Test002 {
    @BeforeSuite
    void demo1(){
        System.out.println("BeforeSuite");
    }
    @BeforeTest
    void demo2(){
        System.out.println("BeforeTest");
    }

    @BeforeClass
    void demo3(){
        System.out.println("BeforeClass");
    }

    @BeforeMethod
    void demo4(){
        System.out.println("BeforeMethod");
    }

    @Test
    void test(){
        System.out.println("Test");
    }

    @AfterMethod
    void demo5(){
        System.out.println("AfterMethod");
    }

    @AfterClass
    void demo6(){
        System.out.println("AfterClass");
    }

    @AfterTest
    void demo7(){
        System.out.println("AfterTest");
    }

    @AfterSuite
    void demo8(){
        System.out.println("AfterSuite");
    }
}
