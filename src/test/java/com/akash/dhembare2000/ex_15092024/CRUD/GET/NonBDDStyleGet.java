package com.akash.dhembare2000.ex_15092024.CRUD.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NonBDDStyleGet {
    static RequestSpecification rp= RestAssured.given();

    public static void main(String[] args) {
        // Rest Assured Provide us the lot of classes.
        rp.baseUri("https://api.zippopotam.us");
        test_non_bdd1();
        test_non_bdd2();
    }

    private static void test_non_bdd1() {
        rp.basePath("/IN/415004");
        rp.when().get();
        rp.then().log().all().statusCode(200);
    }

    private static void test_non_bdd2() {
            rp.basePath("/IN/-1");
            rp.when().get();
            rp.then().log().all().statusCode(404);


    }


}
