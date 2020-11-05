package com.reqresAutomation;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetListOfUsers {
	public static void main(String[] args) {
		// if we see square [ in response braket indicate array

		RestAssured.baseURI = "https://reqres.in/";
	

		// Get Place ("place_id", "placeid") first is query parameter and 2nd we
		// declare variable and store place id in that
		String getPlaceResponse = given().log().all().queryParam("page", "2").when().get("api/users").then()
				.assertThat().log().all().statusCode(200).extract().response().asString();
		JsonPath js1 = new JsonPath(getPlaceResponse);
		String actualAddress = js1.getString("total_pages"); // extracting place
														// address(from
														// response)
		System.out.println(actualAddress);

	
}
}