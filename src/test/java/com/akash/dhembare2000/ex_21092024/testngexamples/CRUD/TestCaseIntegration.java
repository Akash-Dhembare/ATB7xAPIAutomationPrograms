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

        bookingID =  response.jsonPath().getString("bookingid")
        return bookingID;
    }

    @Test
    public void test_update_request_put(){

    }

    @Test
    public void test_update_request_get(){

    }

    @Test
    public void test_delete_booking(){

    }

    @Test
    public void test_after_delete_request_get(){

    }
}
