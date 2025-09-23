package Project;

import java.util.HashMap;
import java.util.regex.Matcher;

import org.hamcrest.Matchers;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GitHubProject {
	//SSH key to test with
	String sshkey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIF/tXtVBhWLFYB20idXqk2+0GXkBAAIej+Y4zUJzr6Gt";
	//Temp valiable to share id
	int keyid;
	//Declare the request and response specs
	RequestSpecification requestspec;
	ResponseSpecification responsespec;
	
	@BeforeClass
	public void setUp() {
		// Initialize the request specification
		requestspec = new RequestSpecBuilder().
				setBaseUri("https://api.github.com/user/keys").
				addHeader("Content-Type", "application/json").
				addHeader("Authorization", "token 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").
				addHeader("X-GitHub-Api-Version", "2022-11-28").
				build();
				// Initialize the response specification
		responsespec = new ResponseSpecBuilder().
				expectBody("title", Matchers.equalTo("TestKey")).
				expectBody("key", Matchers.equalTo(sshkey)).
				expectResponseTime(Matchers.lessThanOrEqualTo(3000L)).
				
				build();
	}
	
	@Test(priority = 1)
	public void postRequestTest() {
		// create a request body
		HashMap<String, String> reqBody = new	HashMap<String, String>();
		reqBody.put("title", "TestKey");
		reqBody.put("key", sshkey);
		//send request save response
		
		Response response = RestAssured.given().spec(requestspec).body(reqBody).log().all()
				.when().post();
		
		//  Extract the id from response of post
		
		keyid = response.then().extract().path("id");
		
		//Assertions
		
		response.then().statusCode(201).spec(responsespec).log().all();
		
		
		
		
		
	}

}
