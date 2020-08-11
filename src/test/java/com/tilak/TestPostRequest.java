package com.tilak;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Test
public class TestPostRequest {

	@SuppressWarnings("unchecked")
	public void testCreateResource() {

		// 1. Specify the base URI
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

		// 2. Request Object
		RequestSpecification httpRequest = RestAssured.given();

		// 3. Prepare Request Parameter
		JSONObject requestParams = new JSONObject();
		requestParams.put("title", "Hello");
		requestParams.put("body", "far");
		requestParams.put("userId", "1");

		// add headers
		httpRequest.header("Content-type", "application/json;charset=UTF-8");

		httpRequest.body(requestParams.toJSONString());

		// 4.Response Body
		Response response = httpRequest.request(Method.POST, "/posts");

		String responseBody = response.getBody().asString();
		System.out.println("Response Body = " + responseBody);

		// status validation
		int statusCode = response.getStatusCode();
		System.out.println("Status Code = " + statusCode);
		Assert.assertEquals(statusCode, 201);

		// status Line verfication
		String statusLine = response.getStatusLine();
		System.out.println("Status Line = " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 201 Created");

	}

}
