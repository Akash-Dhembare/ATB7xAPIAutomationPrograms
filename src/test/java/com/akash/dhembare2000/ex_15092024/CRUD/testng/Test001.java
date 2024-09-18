package com.akash.dhembare2000.ex_15092024.CRUD.testng;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Test001 {

    @Test
    public void test_get(){
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/415004")
                .when()
                .log().all().get()
                .then()
                .log().all().statusCode(200);
    }
}
