import org.junit.Test;

// End to end validation


// Validation: StatusCode, StatusLine




public class TCID_GET_Created_User {
	
	 @Test
		public void getUserList() {
			
		// Specify the base url
			RestAssured.baseURI= "https://reqres.in/api/users?page=7";
		
		// Request object	
			RequestSpecification httpRequest = RestAssured.given();
			
		//As we need to store the response, create a response object 	
			Response response = httpRequest.request(Method.GET," 7");
			
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
			
			// Get the status code
			int statusCode = response.getStatusCode();
			System.out.println("The status code is: " + statusCode);
			Assert.assertEquals(statusCode, 200);
			
			
		}	
	  
	 @Test
		public void Update_User() {
		
		int id = 7;
		
		 RestAssured.baseURI ="https://reqres.in/api/users";
		 RequestSpecification request = RestAssured.given();
		 
		 JSONObject requestParams = new JSONObject();
//		 requestParams.put("Name", "James"); // Cast
//		 requestParams.put("Job", "Leader");
		 
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
//				Assert.assertEquals(id,"");			
					
		}
	 @Test
		public void Create_User1() { 
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
				Assert.assertEquals(id,"");			
					
		}

		
		
}
