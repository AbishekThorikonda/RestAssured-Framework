package Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utils.Base;
import Utils.TestData;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_02_PostUser extends Base{
	
	RequestSpecification httpRequest;
	Response response;
	
	String name = TestData.GetRandomName();
	String job = TestData.GetRandomJob();	
	
	@BeforeTest
	void createUser()
	{
		RestAssured.baseURI="https://reqres.in/api/users";
		httpRequest = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("name",name);
		requestParams.put("job",job);
		
		httpRequest.header("Content-Type","application/json");
		
		httpRequest.body(requestParams.toJSONString());
		
		response = httpRequest.request(Method.POST);
		
	}
	
	@Test
	void CheckStatusCode()
	{
		int statusCode = response.getStatusCode();
		
		AssertJUnit.assertEquals(statusCode,201);
	}
	
	@Test
	void CheckContentBody()
	{
		String responseBody = response.getBody().asString();
		AssertJUnit.assertTrue(responseBody.contains("name"));
		AssertJUnit.assertTrue(responseBody.contains("job"));
		AssertJUnit.assertTrue(responseBody.contains("id"));
		
		System.out.println(responseBody);
	}
	
	
	
}
