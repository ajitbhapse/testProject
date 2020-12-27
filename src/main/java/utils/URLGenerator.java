package utils;

public class URLGenerator {

	// For API
	
	private String REST_ENDPOINT = "/rest/api";
	private String API_VERSION = "/2";

	//Full EndPoint URLs
	public String createIssueURL = "/issue";
	public String sessionURL  = "/session";
	public URLGenerator(String instanceURL) {
		String baseURL = instanceURL+REST_ENDPOINT+API_VERSION;
		this.createIssueURL = baseURL + this.createIssueURL;
		
	}
}
