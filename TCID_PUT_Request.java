
// Validation: StatusCode, StatusLine and id


import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TCID_PUT_Request {
	
	@Test
	public void Update_User() {
	
	int id = 7;
	
	 RestAssured.baseURI ="https://reqres.in/api/users";
	 RequestSpecification request = RestAssured.given();
	 
	 JSONObject requestParams = new JSONObject();
//	 requestParams.put("Name", "James"); // Cast
//	 requestParams.put("Job", "Leader");
	 
	 requestParams.put("email", "michael.lawson@reqres.in"); // Cast
	 requestParams.put("first_name", "James");
	 requestParams.put("last_name", "Lawson"); // Cast
	 requestParams.put("avatar", "https://s3.amazonaws.com/uifaces/faces/twitter/follettkyle/128.jpg"); 
	 
	 request.body(requestParams.toJSONString());
	 Response response = request.put("/update/"+ "id");
	 
	// Status code validation
			int statusCode = response.getStatusCode();
			System.out.println("The status code is: " + statusCode);
			Assert.assertEquals(statusCode, 200);
			
	  // Status line verification
			String statusLine = response.getStatusLine();
			System.out.println("The status line is: " + statusLine);
			Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
			
			
			String empid = response.jsonPath().get("id");
			System.out.println("The user id: " + empid);
//			Assert.assertEquals(id,"");			
				
	}


}
