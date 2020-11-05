package com.complexNestedJson;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class PrintCopiesByRpa {
	public static void main(String[] args) {
		
		JsonPath js = new JsonPath(Payload.CoursePrice());

		int count = js.getInt("courses.size()");
		System.out.println(count);
		for (int i = 0; i < count; i++) {

			String courseTitle = js.get("courses[" + i + "].title");
			if(courseTitle.equalsIgnoreCase("RPA"))
			{
			int copiescount= js.get("courses[" + i + "].copies");
			System.out.println(copiescount);
			break;  //use break so it save one iteration

		}
		
	}

}
}
