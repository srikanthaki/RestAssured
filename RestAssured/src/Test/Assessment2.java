package Test;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Assessment2 {
	RequestSpecification httpRequest = null;
	Response response = null;

	@org.testng.annotations.BeforeMethod
	public void BeforeMethod() {
		// declare the baseURL
		RestAssured.baseURI = "https://reqres.in";
		// This specifices this is HTTP Protocol Specification
		httpRequest = RestAssured.given();

}

	@Test
	public void GetWetherByNameRequest() {
		// response = httpRequest.request(Method.GET,"/api/users/2");
		//response = httpRequest.get("/api/users?page=2");
		response = httpRequest.get("api.openweathermap.org/data/2.5/weather?q=Rochester&appid=37794f5672a0102dae5c07e24fba7f8a");
		int StatusCode = response.getStatusCode();
		String StatusLine = response.getStatusLine();
		String ResponseBody = response.body().asString();
		System.out.println("Status Code = " + StatusCode);
		System.out.println("Status Line = " + StatusLine);
		System.out.println("Response Body = " + ResponseBody);
	}

}
