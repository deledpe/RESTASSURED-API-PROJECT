import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TCID002_POST_Request {
	
	
	
	@Test
	public void Create_User()
	{ 
	 RestAssured.baseURI ="https://reqres.in/api/users";
	 RequestSpecification request = RestAssured.given();
	 
	 JSONObject requestParams = new JSONObject();
	 requestParams.put("Name", "Benson"); // Cast
	 requestParams.put("Job", "Leader");
	
	 
	 request.body(requestParams.toJSONString());
	 Response response = request.post("/users");
	 
	// Status code validation
			int statusCode = response.getStatusCode();
			System.out.println("The status code is: " + statusCode);
			Assert.assertEquals(statusCode, 201);
			
	  // Status line verification
			String statusLine = response.getStatusLine();
			System.out.println("The status line is: " + statusLine);
			Assert.assertEquals(statusLine, "HTTP/1.1 201 Created");
			
			
			String id = response.jsonPath().get("id");
			System.out.println("The user id: " + id);
//			Assert.assertEquals(id,"");			
				
	}

}
