package com.restAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetAddress {
	public static void main(String[] args) {
		//push(create)
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
		
		System.out.println("i am in add");
		
		
		
// update place..put http method (declaring placeid as a variable here updating address)
         String newAddress="Summer walk Us";    //radomly giving any address making new address as variable
				given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
						.body("{\r\n" + 
								"\"place_id\":\"efde45ba4055d304df9c549499b8e945\",\r\n" + 
								"\"address\":\""+newAddress+"\",\r\n" + 
								"\"key\":\"qaclick123\"\r\n" + 
								"}")
						.when().put("maps/api/place/update/json").then().assertThat().log().all().statusCode(200)
						.body("msg", equalTo("Address successfully updated"));
				
				
		System.out.println("i am in update");
				
	
	
	// Get Place ("place_id", "placeid") first is query parameter and 2nd we declare variable and store place id in that
		String getPlaceResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid).when()
				.get("maps/api/place/get/json").then().assertThat().log().all().statusCode(200).extract().response()
				.asString();
		JsonPath js1 = new JsonPath(response);
	    String actualAddress = js1.getString("address");   // extracting place address(from response)
		System.out.println(actualAddress);
		
		
	//	Assert.assertEquals(actualAddress, newAddress);  //  newAddress is take as variable

	}
}
	
