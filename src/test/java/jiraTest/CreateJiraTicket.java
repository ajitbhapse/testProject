package jiraTest;

import org.testng.annotations.BeforeTest;

import utils.URLGenerator;

public class CreateJiraTicket {
	URLGenerator UrlGenerator;
	@BeforeTest
	public void login() {
		UrlGenerator = new URLGenerator("http://localhost:8080");
		
		
	}

}
