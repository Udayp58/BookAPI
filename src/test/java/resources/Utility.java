package resources;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utility {

	static RequestSpecification req;
	
	public RequestSpecification getRequestSpecification() throws FileNotFoundException {
		if (req == null) {
			PrintStream log = new PrintStream(new FileOutputStream("log.txt"));
			req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
					.addHeader("Content-Type", "application/json").addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();

			return req;
		}
		return req;
	}
	
	public String getResponseValue (Response response, String key)
	{
		String res = response.asString();
		JsonPath js = new JsonPath(res);
		return js.getString(key);
		
	}

}
