package apiTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
public class LearningRestAssured {

@Test
public void postMethod() {
	RestAssured.baseURI = "https://rahulshettyacademy.com";
	String res=RestAssured.given()
			  .queryParam("key", "qaclick123")
			  .header("Content-Type","application/json")
			  .body("{\r\n" + 
			  		"  \"location\": {\r\n" + 
			  		"    \"lat\": -38.383494,\r\n" + 
			  		"    \"lng\": 33.427362\r\n" + 
			  		"  },\r\n" + 
			  		"  \"accuracy\": 50,\r\n" + 
			  		"  \"name\": \"A03,Blue spring society\",\r\n" + 
			  		"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
			  		"  \"address\": \"Telco Colony,Ambegaon kd\",\r\n" + 
			  		"  \"types\": [\r\n" + 
			  		"    \"shoe park\",\r\n" + 
			  		"    \"shop\"\r\n" + 
			  		"  ],\r\n" + 
			  		"  \"website\": \"http://google.com\",\r\n" + 
			  		"  \"language\": \"French-IN\"\r\n" + 
			  		"}\r\n" + 
			  		"").when()
			  		   .post("/maps/api/place/add/json")
			  		   .then()
			  		   .extract()
			  		   .response()
			  		   .asString();
	JsonPath path  = new JsonPath(res);
	System.out.println(path.getString("place_id"));
	System.out.println("print browser "+ System.getProperty("Name"));
	if(System.getProperty("Name").equalsIgnoreCase("ajitb")) {
		System.out.println( "this is me..");
	}else {
		System.out.println("this is not me..");
	}
}
	
	}

