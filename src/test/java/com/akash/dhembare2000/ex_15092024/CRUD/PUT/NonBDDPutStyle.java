package com.akash.dhembare2000.ex_15092024.CRUD.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDPutStyle {
    //2973
    //token
    //Payload - {
    //    "firstname" : "Akash",
    //    "lastname" : "Dhembare",
    //    "totalprice" : 111,
    //    "depositpaid" : true,
    //    "bookingdates" : {
    //        "checkin" : "2018-01-01",
    //        "checkout" : "2019-01-01"
    //    },
    //    "additionalneeds" : "Breakfast"
    //}

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void test_put_positive_tc(){
        String payload="{\n" +
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
        String bookingid="3367";
        String token="6576a413856163b";

        requestSpecification=RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+ bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(payload).log().all();

        Response response = requestSpecification.when().put();

        //Get validatable response to validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);



    }



}
