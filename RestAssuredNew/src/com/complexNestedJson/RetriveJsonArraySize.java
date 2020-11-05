package com.complexNestedJson;
import files.Payload;
import io.restassured.path.json.JsonPath;

public class RetriveJsonArraySize {
public static void main(String[] args) {
	//nested api copy in json editor online..check the nodes
		
	//give the number of courses
	JsonPath js = new JsonPath(Payload.CoursePrice());
	
	// Print No of courses returned by API

	int count = js.getInt("courses.size()");
	System.out.println(count);
	
	
	// Print Purchase Amount
	int totalAmount = js.getInt("dashboard.purchaseAmount");
	System.out.println(totalAmount);
	// Print Title of the first course
   //course contain 3 node
	String titleFirstCourse = js.get("courses[2].title");
	System.out.println(titleFirstCourse);
		
	}

}
