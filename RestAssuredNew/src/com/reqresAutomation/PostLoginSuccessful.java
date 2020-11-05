package com.reqresAutomation;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class PostLoginSuccessful {
	public static void main(String[] args) {
		RestAssured.baseURI = "https://reqres.in/";
		String response = given().log().all().headers("Content-Type", "application/json")
				.body("{\r\n" + "\"email\": \"eve.holt@reqres.in\",\r\n" + "    \"password\": \"cityslicka\"\r\n" + "}")
				.when().post("api/login").then().log().all().extract().response().asString();

		System.out.println(response);

		// jsonpath take i/p as a string and converting to json
		JsonPath js = new JsonPath(response);
		String placeid = js.getString("token"); // extracting place id(from
												// response)
		System.out.println(placeid);
	}

}
