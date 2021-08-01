
// Sample code

//Sample code


import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TCID002_POST_Request1 {
	
	@Test
	void Create_User() {

				RestAssured.baseURI= "https://jsonplaceholder.typicode.com/posts";
		
				RequestSpecification httpRequest = RestAssured.given();

		       JSONObject requestparams = new JSONObject(); 
		       
		       requestparams.put("username","JohnD");
		       requestparams.put("EMail","test@gmail.com");
		       requestparams.put("Address","123 London road");
		       requestparams.put("Phone","02545565676787");
		       requestparams.put("Webesite","www.johd.com");
		       
 
		       httpRequest.header("Content-Type","Appplication/json");
		       
		       httpRequest.body(requestparams.toJSONString()); // attach data to the above request
		              
		       Response response = httpRequest.request(Method.POST,"/posts");
		      
				String responseBody = response.getBody().asString();
				System.out.println("The response is: " + responseBody);

				int statusCode = response.getStatusCode();
				System.out.println("The status code is: " + statusCode);
				Assert.assertEquals(statusCode, 201);
				

				String statusLine = response.getStatusLine();
				System.out.println("The status line is: " + statusLine);
				Assert.assertEquals(statusLine, "HTTP/1.1 201 OK");
				
				
				String id = response.jsonPath().get("id");
				System.out.println("The user id: " + id);
//				Assert.assertEquals(id,"");
				
				
				
			}
	

}
