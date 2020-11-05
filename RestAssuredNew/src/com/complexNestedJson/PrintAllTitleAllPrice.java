package com.complexNestedJson;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class PrintAllTitleAllPrice {
	public static void main(String[] args) {

		JsonPath js = new JsonPath(Payload.CoursePrice());

		int count = js.getInt("courses.size()");
		System.out.println(count);
		for (int i = 0; i < count; i++) {

			String courseTitle = js.get("courses[" + i + "].title");

			String AllPrice = js.get("courses[" + i + "].price");
			System.out.println(AllPrice);
			System.out.println(courseTitle);

		}
	}
}
