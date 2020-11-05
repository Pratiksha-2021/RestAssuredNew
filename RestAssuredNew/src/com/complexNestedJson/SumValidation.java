package com.complexNestedJson;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {
	@Test
	public void sumOfCouseEvaluation(){
		int sum=0;
	
		JsonPath js = new JsonPath(Payload.CoursePrice());

		int count = js.getInt("courses.size()");
		System.out.println(count);
		for (int i = 0; i < count; i++) {


			int  AllPrice = js.get("courses[" + i + "].price");
			
			int copies = js.get("courses[" + i + "].copies");
			int amount= AllPrice * copies;
			System.out.println(amount);
			sum= sum+amount;
			
		}
	System.out.println(sum);
	int purchaseAmount =js.getInt("dashboard.purchaseAmount");
	Assert.assertEquals(sum, purchaseAmount);
	
	
	
	
	}
		
		
		
		
		
		
		
		
		
	}


