package com.r3pi.shrikhande.methods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Webservices {
	
	public static Response Get(String URI) {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.get(URI);
		return response;
		
	}
	
	public static Response Post(String URI, String stringJSON) {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		// Response response = requestSpecification.post(URI);
		Response response = requestSpecification.post(URI, stringJSON);
		return response;
		
	}
	
	public static Response Put(String URI, String stringJSON) {
		RequestSpecification requestSpecification = RestAssured.given().body(stringJSON);
		requestSpecification.contentType(ContentType.JSON);
		// Response response = requestSpecification.get(URI);
		Response response = requestSpecification.post(URI, stringJSON);
		return response;
	}	

}	




