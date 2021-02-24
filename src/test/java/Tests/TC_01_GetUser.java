package Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utils.Base;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC_01_GetUser extends Base{
	
	@BeforeTest
	public void before_test() throws InterruptedException
	{
		log.info("TEST HAS STARTED");
		RestAssured.baseURI="https://reqres.in/api/users/2";
		httpRequest=RestAssured.given();
		response = httpRequest.request(Method.GET);
		log.info("TEST HAS PAUSED");
		Thread.sleep(2000);
	}
	
	@Test
	void CheckStatusCode()
	{	
		log.info("TEST HAS Started");
		int statuscode= response.getStatusCode();
		AssertJUnit.assertEquals(statuscode, 200);
	}
	
	@Test
	void CheckResponseBody()
	{
		String responseBody = response.getBody().asString();
		AssertJUnit.assertTrue(responseBody.contains("id"));
		
	}
	
	@Test
	void CheckResponseTime()
	{
		long responseTime = response.getTime();
		
		AssertJUnit.assertTrue(responseTime < 2000);
	}
	
	

}
