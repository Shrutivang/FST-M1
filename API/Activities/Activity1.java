package Examples;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Activity1 {

	// GET https://petstore.swagger.io/v2/pet/findByStatus?status=sold
	@Test
	public void getRequestWithQueryParam() {
		//send request, save response
		Response response =
				RestAssured.given().
				baseUri("https://petstore.swagger.io/v2/pet").
				header("Content-Type", "application/json"). 
				queryParam("status", "alive").
		when().
				get("/findByStatus");
		
		//print the status code
		//System.out.println(response.statusCode());
		//System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		
		// print the response header
		//System.out.println(response.getHeader().asList());
		//System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		
		// print the response body
			System.out.println(response.getBody().asPrettyString());
		//System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		
		
		// Extract properties from the response
		String petStatus = response.then().extract().path("[0].status");
		
		// Assertions
		//Assert.assertEquals(petStatus, "sold");
		
		//Rest assured assertions
		response.then().
		statusCode(200).
		body("[0].status", Matchers.equalTo("alive")).
		body("[0].name", Matchers.equalTo("Riley"));
	
	}
	
	// GET https://petstore.swagger.io/v2/pet/{petId}
	@Test
	public void getRequestWithPathParam()  {
		//send request to get response  and assert
		RestAssured.given().
		baseUri("https://petstore.swagger.io/v2/pet").
		header("Content-Type", "application/json").
		pathParam("petId", 77232).
		when().
			get("/{petId}"). // get("/12")
		then().
			statusCode(200).
			body("status", Matchers.equalTo("alive")). 
			body("name", Matchers.equalTo("Riley")); 
		}
}
