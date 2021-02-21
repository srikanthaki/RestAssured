package Test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	RequestSpecification httpRequest = null;
	Response response = null;

	@org.testng.annotations.BeforeMethod
	public void BeforeMethod() {
		// declare the baseURL
		RestAssured.baseURI = "https://reqres.in";
		// This specifices this is HTTP Protocol Specification
		httpRequest = RestAssured.given();
	}

	@Test(priority = 0)
	public void GetSingleUserRequest() {
		// response = httpRequest.request(Method.GET,"/api/users/2");
		response = httpRequest.get("/api/users?page=2");
		int StatusCode = response.getStatusCode();
		String StatusLine = response.getStatusLine();
		String ResponseBody = response.body().asString();
		System.out.println("Status Code = " + StatusCode);
		System.out.println("Status Line = " + StatusLine);
		System.out.println("Response Body = " + ResponseBody);
	}

	@Test(priority = 1)
	public void GetListofUserRequest() {
		// response = httpRequest.request(Method.GET,"/api/users/2");
		response = httpRequest.queryParam("Pahe", 2).get("/api/users");
		int StatusCode = response.getStatusCode();
		String StatusLine = response.getStatusLine();
		String ResponseBody = response.body().asString();
		System.out.println("Status Code = " + StatusCode);
		System.out.println("Status Line = " + StatusLine);
		System.out.println("Response Body = " + ResponseBody);
	}

	@Test(priority = 2)
	public void PostCreateRequest() {
		// import packages doen using short cut Ctrl+Shift+O
		// specify the type of the request
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "morpheus");
		requestParams.put("job", "zion resident");
		httpRequest.body(requestParams.toJSONString());
		Response response = httpRequest.post("/api/users");
		int statusCode = response.getStatusCode();
		String statusLine = response.getStatusLine();
		String responseBody = response.getBody().asString();
		System.out.println("Response Status Code : " + statusCode);
		System.out.println("Response Status Line : " + statusLine);
		System.out.println("Response Body : " + responseBody);
	}

	@Test(priority = 3)
	public void UpdateUserRequest() {
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "morpheus");
		requestParams.put("job", "leader");
		httpRequest.body(requestParams.toJSONString());
		Response response = httpRequest.queryParam("Pahe", 2).put("/api/users");
		int statusCode = response.getStatusCode();
		String statusLine = response.getStatusLine();
		String responseBody = response.getBody().asString();
		System.out.println("Response Status Code : " + statusCode);
		System.out.println("Response Status Line : " + statusLine);
		System.out.println("Response Body : " + responseBody);
	}

	@Test(priority = 4)
	public void deleteUser() {
		// response = httpRequest.request(Method.GET,"/api/users/2");
		response = httpRequest.queryParam("Pahe", 2).delete("/api/users");
		int StatusCode = response.getStatusCode();
		String StatusLine = response.getStatusLine();
		String ResponseBody = response.body().asString();
		System.out.println("Status Code = " + StatusCode);
		System.out.println("Status Line = " + StatusLine);
		System.out.println("Response Body = " + ResponseBody);
	}

}
