package com.restAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Parsing_Json_Extracting_Id {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123")
				.headers("Content-Type", "application/json").body(Payload.AddPlace())
				.when().post("maps/api/place/add/json")
				.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
				.header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString(); // printing
																								// response
																								// in
																								// console
		System.out.println(response);
		
		//jsonpath take i/p as a string and converting   to json
		JsonPath js = new JsonPath(response);
		String placeid = js.getString("place_id"); // extracting place id(from response)
		System.out.println(placeid);

	}

}
