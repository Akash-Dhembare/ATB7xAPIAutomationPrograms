package com.akash.dhembare2000.ex_21092024.testngexamples.CRUD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCaseIntegration {

    // Create a Token
    // Create a Booking
    // Perform a PUT request
    // Verify that PUT is success by GET request
    // Delete the ID
    // Verify it doesn't exist GET Request

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    String token;
    String bookingID;

    public String getToken(){
        String payload="{\n" +
                "       \"username\" : \"admin\",\n" +
                "        \"password\" : \"password123\"\n" +
                "    }";

        //Given - Request Specification
        RequestSpecification r=RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON).log().all();
        r.body(payload);

        //When - Response

        Response response= r.when().post();

        //Then -  ValidatableResponse
        //Validation
        ValidatableResponse validatableResponse= response.then().log().all().statusCode(200);

        //Extract the token
        token= response.jsonPath().getString("token");
        System.out.println(token);
        return token;
    }


    public String getBookingID(){
        String payload_POST="{\n" +
                "    \"firstname\" : \"Akash\",\n" +
                "    \"lastname\" : \"Dhembare\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"lunch\"\n" +
                "}";

        requestSpecification=RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload_POST).log().all();

        Response response = requestSpecification.when().post();

        //Get validatable response to validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        bookingID =  response.jsonPath().getString("bookingid");
        System.out.println(bookingID);
        return bookingID;
    }

    //@Test(priority = 1)
    @Test
    //public void test_01_update_request_put(){
    public void test_update_request_put(){
        token = getToken();
        bookingID = getBookingID();

        String payloadPUT= "{\n" +
                "    \"firstname\" : \"Anshul\",\n" +
                "    \"lastname\" : \"Jitendra\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(payloadPUT).log().all();

        Response response = requestSpecification.when().put();


        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

    }

   // @Test(priority = 2)
   // @Test(dependsOnMethods = "test_update_request_put")
    @Test
   // public void test_02_update_request_get(){
    public void test_update_request_get(){

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        Response response = requestSpecification.when().get();


        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        System.out.println(bookingID);
    }

    //@Test(priority = 3)
    @Test
   // @Test(dependsOnMethods = "test_update_request_get")
    //public void test_03_delete_booking(){
    public void test_delete_booking(){

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        Response response = requestSpecification.when().delete();


        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);
        System.out.println(bookingID);
        System.out.println(token);
    }


   // @Test(priority = 4)
    @Test
   // @Test(dependsOnMethods = "test_delete_booking")
    //public void test_04_after_delete_request_get(){
    public void test_after_delete_request_get(){
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        Response response = requestSpecification.when().get();


        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(404);
        System.out.println(bookingID);
    }
}
