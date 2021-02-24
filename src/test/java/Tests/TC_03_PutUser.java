package Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import Utils.Base;
import io.restassured.RestAssured;
import io.restassured.http.Method;


public class TC_03_PutUser extends Base {
	
	String name="morpheus";
	String job= "zion resident";
	
	
	@BeforeTest
	void createUser()
	{
		RestAssured.baseURI="https://reqres.in/api/users/2";
		httpRequest=RestAssured.given();
		JSONObject requestParams= new JSONObject();
		
		requestParams.put("name",name);
		requestParams.put("job",job);
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParams.toJSONString());
		response = httpRequest.request(Method.PUT);
		
	}

	
	
	@Test
	public void StatusCodeCheck()
	{
		AssertJUnit.assertEquals(response.statusCode(),200);
		System.out.println(response.getBody().asString());
	}
	
	

}
