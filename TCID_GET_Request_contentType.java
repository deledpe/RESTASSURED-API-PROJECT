import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

// // Validation: StatusCode and Content validation


public class TCID_GET_Request_contentType {
	
	 @Test
		public void getUserContent() {
			
		// Specify the base url
			RestAssured.baseURI= "https://reqres.in/api/users?page=7";
		
		// Request object	
			RequestSpecification httpRequest = RestAssured.given();
			
		//As we need to store the response, create a response object and pass paramter.	
			Response response = httpRequest.request(Method.GET," 7");
			
		// Print response in console window
			String responseBody = response.getBody().asString();
			System.out.println("The response is: " + responseBody);
			
		// Content Header validation - Capture the details of header from the response.Note: you can very any object in your response 
	    // using the same approach.	
			
			String contentType=response.header("content-type");
			System.out.println(" Content Type is "+ contentType );
			Assert.assertEquals(contentType, "application/json; charset=utf-8");
			
			
			String content_encoding =response.header("content-encoding");
			System.out.println(" Content encoding is "+ content_encoding);
			Assert.assertEquals(content_encoding, "gzip");
			
			int statusCode = response.getStatusCode();
			System.out.println("The status code is: " + statusCode);
			Assert.assertEquals(statusCode, 200);
			
			
		}	
}
