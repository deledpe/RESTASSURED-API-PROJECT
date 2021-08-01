

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class TCID001_GET_User_List {
	

    @Test
	public void getUserList() {
		
	
	// Specify the base url
		RestAssured.baseURI= "https://reqres.in/api/users?page=2";
	
	// Request object	
		RequestSpecification httpRequest = RestAssured.given();
		
	//As we need to store the response, create a response object 	
		Response response = httpRequest.request(Method.GET," 2");
		
	// Print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("The response is: " + responseBody);
		
	// Status code validation
		int statusCode = response.getStatusCode();
		System.out.println("The status code is: " + statusCode);
		Assert.assertEquals(statusCode, 200);
		
  // Status line verification
		String statusLine = response.getStatusLine();
		System.out.println("The status line is: " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		
		
	}

}
