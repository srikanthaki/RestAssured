package com.reqres.packag;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import org.testng.internal.Systematiser;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Assessment extends TestBase {
	public static RequestSpecification httpRequest = null;
	public static Response response = null;

	@org.testng.annotations.BeforeMethod
	public void BeforeMethod() {
		logger.info("********statrt of  class**********");
		// declare the baseURL
		RestAssured.baseURI = "https://reqres.in";
		// This specifices this is HTTP Protocol Specification
		httpRequest = RestAssured.given();
	}

	@Test(priority = 2)
	public void PostRequest() {
		System.out.println("To Update users");
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "morpheus");
		requestParams.put("job", "zion resident");
		httpRequest.body(requestParams.toJSONString());
		Response response = httpRequest.post("/api/users");
		int StatusCode = response.getStatusCode();
		String StatusLine = response.getStatusLine();
		String ResponseBody = response.body().asString();
		logger.info("****Inside checkStatusCode*******");
		System.out.println("Status Code = " + StatusCode);
		logger.info("Status Code ==>"+StatusCode);
		System.out.println("Status Line = " + StatusLine);
		logger.info("*******Inside checkResponseBody*******");
		System.out.println("Response Body = " + ResponseBody);
		logger.info("Response Body ==>"+ResponseBody);
	}

	@Test(priority = 1)
	public void GetSingleUserRequest() {
		// response = httpRequest.request(Method.GET,"/api/users/2");
		System.out.println("To get List of users");
		response = httpRequest.get("/api/users?page=2");
		int StatusCode = response.getStatusCode();
		String StatusLine = response.getStatusLine();
		String ResponseBody = response.body().asString();
		logger.info("****Inside checkStatusCode*******");
		System.out.println("Status Code = " + StatusCode);
		logger.info("Status Code ==>"+StatusCode);
		System.out.println("Status Line = " + StatusLine);
		logger.info("*******Inside checkResponseBody*******");
		System.out.println("Response Body = " + ResponseBody);
		logger.info("Response Body ==>"+ResponseBody);
	}

}
