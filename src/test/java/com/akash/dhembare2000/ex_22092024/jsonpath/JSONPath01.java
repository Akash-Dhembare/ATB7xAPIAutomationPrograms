package com.akash.dhembare2000.ex_22092024.jsonpath;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class JSONPath01 {

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
        requestSpecification.body(payload_POST);

        Response response = requestSpecification.when().post();
        System.out.println(response.asString());

        JsonPath jsonPath=new JsonPath(response.asString());
        String bookingid=jsonPath.getString("bookingid");
        String firstname=jsonPath.getString("booking.firstname");
        String checkout=jsonPath.getString("booking.bookingdates.checkout");

        System.out.println(bookingid);
        System.out.println(firstname);
        System.out.println(checkout);

        assertThat(bookingid).isNotNull().isNotBlank().isGreaterThan("0");
        assertThat(firstname).isEqualTo("Akash").isNotNull().isNotBlank();
        assertThat(checkout).isNotNull().isNotBlank();

        Assert.assertEquals(firstname, "Akash");
    }
}
