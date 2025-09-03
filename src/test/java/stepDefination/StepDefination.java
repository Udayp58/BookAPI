package stepDefination;

import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import resources.ResourceAPI;
import resources.TestData;
import resources.Utility;

public class StepDefination {

	RequestSpecification request;
	static Response response;
	Utility util = new Utility();
	TestData data = new TestData();

	@Given("Add Book API Paylaod with {string} and {string}")
	public void add_book_api_paylaod_with_and(String isbn, String aisle) throws FileNotFoundException {

		request = given().spec(util.getRequestSpecification()).body(data.getAddBookPayload(isbn, aisle));
	}

	@When("user hit {string} with http {string} method")
	public void user_hit_with_http_method(String resource, String method) {
		ResourceAPI res = ResourceAPI.valueOf(resource);
		System.out.println(res.getResourceUrl());

		if (method.equalsIgnoreCase("post")) {
			response = request.when().post(res.getResourceUrl());
		} else if (method.equalsIgnoreCase("get")) {
			response = request.when().get(res.getResourceUrl());
		}

	}

	@Then("the statuscode of response is {int}")
	public void the_statuscode_of_response_is(int expectedStatusCode) {
		assertEquals(response.getStatusCode(), expectedStatusCode);
	}

	@Then("{string} in response body should be {string}")
	public void in_response_body_should_be(String key, String value) {

		assertEquals(util.getResponseValue(response, key), value);

	}

	@Given("Get Book API Paylaod")
	public void get_book_api_paylaod() throws FileNotFoundException {

		String bookId = util.getResponseValue(response, "ID");

		request = given().spec(util.getRequestSpecification()).queryParam("ID", bookId);
	}

}