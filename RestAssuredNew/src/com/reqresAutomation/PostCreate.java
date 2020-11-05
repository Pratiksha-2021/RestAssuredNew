package com.reqresAutomation;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class PostCreate {
 public static void main(String[] args) {
		
	 
		RestAssured.baseURI = "https://reqres.in/";
		 given().log().all()
				.headers("Content-Length", "0").body("{\r\n" + 
						"    \"id\": \"18\",\r\n" + 
						"    \"createdAt\": \"2020-11-03T07:55:39.719Z\"\r\n" + 
						"}").when()
				.post("api/users")
				.then().log().all().assertThat().statusCode(200);
	
		
	}

}
