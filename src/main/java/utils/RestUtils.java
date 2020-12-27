package utils;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.response.Response;

class RestUtils{
	private SessionFilter filter;
	
	public SessionFilter getFilter() {
		return filter;
	}

	public void setFilter(SessionFilter filter) {
		this.filter = filter;
	}

	/**
	 * method to generate session filter
	 * @param url
	 */
	public void generateSessionFilter(Map<String,String> data) {
		RestAssured.given()
				   .header("content-type", "application/json")
				   .filter(filter)
				   .body("{ \"username\": \""+data.get("username")+"\", \r\n" + 
							"  \"password\": \""+data.get("password")+"\" }")
				   .post(data.get("url"));
 			setFilter(filter);
	}
	
	/**
	 * post method 
	 * @param url
	 * @param body
	 * @return
	 */
	public Response postMethod(String url,String body) {
		Response res = RestAssured.given()
							      .header("Content-Type","application/json")
							      .filter(getFilter())
							      .body(body)
							      .post(url);
		return res;
	}
	
	
}