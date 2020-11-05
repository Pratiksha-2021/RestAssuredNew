package com.reqresAutomation;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;

public class PutUpdateDocument {
	public static void main(String[] args) {
		
		RestAssured.baseURI="https://reqres.in/";
		// update place..put http method (declaring placeid as a variable here updating address)
           //radomly giving any address making new address as variable
				given().log().all().header("Content-Type", "application/json")
						.body("{\r\n" + 
								"    \"name\": \"morpheus\",\r\n" + 
								"    \"job\": \"zion resident\"\r\n" + 
								"}")
						.when().put("api/users/2").then().assertThat().log().all().statusCode(200)
						.body("updatedAt", equalTo("2020-11-03T08:28:30.014Z"));
			}
}
