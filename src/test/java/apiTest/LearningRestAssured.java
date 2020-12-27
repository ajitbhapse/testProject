package apiTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
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
	System.out.println(System.getProperty("BROWSER"));
}
	@Test
	public void getMethod() {
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		String res = RestAssured.given()
					.param("key", "qaclick123")
					.param("place_id", "198a85b53da5b2529c4c2f861fc0ab2c")
					.when()
					.get("maps/api/place/get/json")
					.then()
					.extract()
					.response()
					.asString();
		System.out.println(res);
		
		/*String responseBody = res.getBody().asString();
		System.out.println(res.getStatusLine());
		System.out.println(res.getHeaders().getValue("Server"));
		
		JsonPath jpath = new JsonPath(responseBody);
		System.out.println(jpath.getString("address"));*/
					
	}

	 @Test
	 public void addBook() {
		RestAssured.baseURI = "http://216.10.245.166/";
		 Response rsp = RestAssured.given()
		 			.header("Content-Type","application/json")
		 			.body("{\r\n" + 
		 					"\"name\" : \"java\",\r\n" + 
		 					"\"isbn\" :\"123cd\",\r\n" + 
		 					"\"aisle\" :\"2788\",\r\n" + 
		 					"\"author\" :\"ajit bhapse\"\r\n" + 
		 					"}").when()
		 			        .post("Library/Addbook.php");
		 String response = rsp.getBody().asString();
		 JsonPath jPath = new JsonPath(response);
		 System.out.println(jPath.getString("msg"));
	 }
	 
	 

		private LearningRestAssured getOuterType() {
			return LearningRestAssured.this;
		}
	}

