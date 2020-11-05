package com.reqresAutomation;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class PostLoginUnsuccessful {
public static void main(String[] args) {
	
		
	RestAssured.baseURI = "https://reqres.in/";
	 given().log().all()
			.headers("Content-Type", "application/json").body("{\r\n" + 
					"    \"email\": \"sydney@fife\"\r\n" + 
					"}").when()
			.post("api/register")
			.then().log().all().assertThat().statusCode(400);

	
}

}
