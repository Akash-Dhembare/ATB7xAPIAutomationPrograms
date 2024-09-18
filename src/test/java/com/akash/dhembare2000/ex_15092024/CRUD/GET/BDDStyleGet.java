package com.akash.dhembare2000.ex_15092024.CRUD.GET;

import io.restassured.RestAssured;

public class BDDStyleGet {
    public static void main(String[] args) {
        // GET Request - https://api.zippopotam.us/IN/415004
        // URL
        // HEADER ?
        // GET Method
        // base url = https://api.zippopotam.us
        // basePath = /IN/415004
        // PayLOAD - ? NO
        // Auth - Basic, Digest, JWT, Bearer Token, OAuth 2.0 ? = No

        // Verification
        // Status Code
        // Response Body
        // Time, Headers ,Cookies

        // Gherkin -> Given, When, then -> Style ->

        // BDD - Framework different - Gherkin Syntax - (given, when, then)
        // Non BDD and still Gherkin syntax (using classes)


        // given ->
        // URL
        // HEADER ?, Cookies
        // base url = https://api.zippopotam.us
        // basePath = /IN/415004
        // Auth - Basic, Digest, JWT, Bearer Token, OAuth 2.0 ? = No


        // When  ->
        // PayLOAD - ? NO/yES - JSON. XML  -> String, Hashmap, Object class
        // GET Method


        // Then()
        // Response Validation
        //  Status Code
        //  Response Body
        //  Time, Headers ,Cookies

        test1();
        test2();




    }
    private static void test1(){
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/415004")
                .when()
                .log().all().get()
                .then()
                .log().all().statusCode(200);
    }

    private static void test2(){
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/-1")
                .when()
                .log().all().get()
                .then()
                .log().all().statusCode(200);
    }
}
