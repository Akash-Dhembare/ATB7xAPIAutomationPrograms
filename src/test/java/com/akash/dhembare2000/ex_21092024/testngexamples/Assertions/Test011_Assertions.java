package com.akash.dhembare2000.ex_21092024.testngexamples.Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;


public class Test011_Assertions {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    String token;
    Integer bookingID;
    @Test
    public void test_Post(){
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

        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload_POST).log().all();

        Response response = requestSpecification.when().post();

        //Get validatable response to validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // 1. RestAssured Default - Hamcrest

//        validatableResponse.body("booking.firstname",Matchers.equalTo("Akash"));
//        validatableResponse.body("booking.lastname",Matchers.equalTo("Dhembare"));
//        validatableResponse.body("booking.depositpaid",Matchers.equalTo(true));
//        validatableResponse.body("bookingid",Matchers.notNullValue());


        // 2. TestNG Assertions
        // SoftAssert vs HardAssert

        // HardAssert : This means that if any assertion fails, the remaining statements in that test method will not be executed.

//        bookingID=response.then().extract().path("bookingid");
//        String firstname=response.then().extract().path("booking.firstname");


//        Assert.assertNotNull(bookingID);
//        Assert.assertEquals(firstname, "Akash");


        // SoftAssert : This means that if any assertion fails, the remaining statements in that test method will be executed.




        // 3. AssertJ Assertion
        bookingID=response.then().extract().path("bookingid");
        String firstname=response.then().extract().path("booking.firstname");

        assertThat(bookingID).isNotNull().isNotZero().isPositive();
        assertThat(firstname).isNotBlank().isNotEmpty().isNotNull().isEqualTo("Akash");





    }
}
