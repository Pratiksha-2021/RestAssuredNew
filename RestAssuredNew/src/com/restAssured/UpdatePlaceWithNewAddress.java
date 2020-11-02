package com.restAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class UpdatePlaceWithNewAddress {
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
		
		
		
// update place..put http method (declaring placeid as a variable here updating address)
         String newAddress="Summer walk india";    //radomly giving any address making new address as variable
				given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
						.body("{\r\n" + 
								"\"place_id\":\"b8b5f156a030e207d2c34e4d70e7d712\",\r\n" + 
								"\"address\":\""+newAddress+"\",\r\n" + 
								"\"key\":\"qaclick123\"\r\n" + 
								"}")
						.when().put("maps/api/place/update/json").then().assertThat().log().all().statusCode(200)
						.body("msg", equalTo("Address successfully updated"));
				
	
	
	
	
	
	
	}
}
