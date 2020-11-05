package com.reqresAutomation;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetDelayed {
	public static void main(String[] args) {

		// /api/users?delay=3
		RestAssured.baseURI = "https://reqres.in/";

		// Get Place ("place_id", "placeid") first is query parameter and 2nd we
		// declare variable and store place id in that
		         given().log().all().queryParam("delay", "3").when().get("api/users").then().assertThat().log().all()
				.statusCode(200);

	}

}
