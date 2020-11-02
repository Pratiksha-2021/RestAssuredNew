package com.restAssured;
import io.restassured.RestAssured;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.Payload;

public class AddAssertion {
	public static void main(String[] args) {
		
	//for encapsulation body in seperate payload class
	
	//interested on scope
	
	
	RestAssured.baseURI = "https://rahulshettyacademy.com";
    given().log().all().queryParam("key", "qaclick123")
	.headers("Content-Type", "application/json").body(Payload.AddPlace()).when()
	        .post("maps/api/place/add/json")
	        .then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))  //assertion on body(see respone)
			.header("Server", "Apache/2.4.18 (Ubuntu)");//assertion on header
			
	
}
}


