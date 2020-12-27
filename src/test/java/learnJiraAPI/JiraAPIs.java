/*package learnJiraAPI;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.getSession.Root;
public class JiraAPIs {
	
	@Test
	public void generateSession() {
		SessionFilter filter = new SessionFilter();
		RestAssured.baseURI = "http://localhost:8080/";
		Response res = RestAssured.given()
								  .header("content-type", "application/json")
								  .body("{ \"username\": \"ajitbhapse\", \r\n" + 
										"  \"password\": \"Bl@ckperl27\" }")
								  .when()
								  .post("rest/auth/1/session");
		Root root = res.getBody().as(Root.class);
		System.out.println(root.getSession().getValue());
		System.out.println(filter.getSessionId());
		//return filter;
		String responseBody = res.getBody().asString();
		JsonPath path = new JsonPath(responseBody);
		return path.getString("session.name") +"="+path.getString("session.value");
	}
	
	@Test
	public void createJiraTicket() {
		RestAssured.baseURI = "http://localhost:8080/";
		Response res =  RestAssured.given()
									.header("Content-Type","application/json")
									.filter(generateSession())
									.body("{\r\n" + 
											"   \"fields\":{\r\n" + 
											"      \"project\":{\r\n" + 
											"         \"key\":\"LEAR\"\r\n" + 
											"      },\r\n" + 
											"      \"summary\":\"This is create using API request-Ajit\",\r\n" + 
											"      \"description\":\"This is my first jira created using API\",\r\n" + 
											"      \"issuetype\":{\r\n" + 
											"         \"name\":\"Bug\"\r\n" + 
											"      },\r\n" + 
											"       \"assignee\": {\r\n" + 
											"            \"name\": \"ajitbhapse\"\r\n" + 
											"        } \r\n" + 
											"   }\r\n" + 
											"}")
									.when()
									.post("rest/api/2/issue");
		JsonPath jPath = new JsonPath(res.getBody().asString());
		System.out.println(jPath.getString("id") +":"+jPath.getString("key") +":"+jPath.getString("self"));
	}
	
	@Test
	public void postJiraComments() {
	RestAssured.baseURI = "http://localhost:8080/";
	Response res = RestAssured.given()
							  .pathParam("issueIdOrKey", "LEAR-31")
						      .header("Content-Type","application/json")
						      .body("{\r\n" + 
						      		"    \"body\": \"what is the status of this ticket.\",\r\n" + 
						      		"    \"visibility\": {\r\n" + 
						      		"        \"type\": \"role\",\r\n" + 
						      		"        \"value\": \"Administrators\"\r\n" + 
						      		"    }\r\n" + 
						      		"}")
						      .filter(generateSession())
						      .when()
						      .post("/rest/api/2/issue/{issueIdOrKey}/comment");
			JsonPath path = new JsonPath(res.getBody().asString());
			System.out.println(path.getString("self"));
	}
	
	@Test
	public void multiPartAttachment() {
		
		RestAssured.baseURI = "http://localhost:8080/";
		RestAssured.given()
				   .pathParam("issueIdOrKey", "LEAR-31")
				   .header("Content-Type","multipart/form-data")
				   .header("X-Atlassian-Token","no-check")
				   .filter(generateSession())
				   .multiPart("file",new File("C:/Users/abhapse/Downloads/compilation-error.txt"))
			   	   .when()
			   	   .post("/rest/api/2/issue/{issueIdOrKey}/attachments");
	}
	
	@Test
	public void getJiraIssue()
	{
		RestAssured.baseURI = "http://localhost:8080/";
		Response res = RestAssured.given()
							   .filter(generateSession())
							   .pathParam("issueIdOrKey", "LEAR-31")
							   .queryParam("fields", "comment")
							   .when()
							   .get("/rest/api/2/issue/{issueIdOrKey}");
		JsonPath path = new JsonPath(res.getBody().asString());
		System.out.println(path.getString("fields.comment.comments.body"));
	}
	
	@Test
	public void OAuth() {
				
		
	}
}
*/