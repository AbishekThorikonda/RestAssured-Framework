package Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public static Logger log = LogManager.getLogger(Base.class.getName());

}
