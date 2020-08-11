package com.tilak;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.*;

@Test
public class TestGetRequest {

	public void getTodo() {
		
		//1. Specify the base URI
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/todos";
		
		//2. Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//3.Response Body
		Response response = httpRequest.request(Method.GET, "/1");
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body = "+responseBody);
		
		//status validation
		int statusCode = response.getStatusCode();
		System.out.println("Status Code = "+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//status Line verfication
		String statusLine = response.getStatusLine();
		System.out.println("Status Line = "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}
	
}
