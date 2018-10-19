/*
 *  Home Coding Excersise- QA Assessment 
 *  Organisation: R3PI
 *  Author: Dilip Shrikhande
 *  Date: 19-October-2018
 *  
 *  Description: This class contains methods to perform Get, Post and Put operations
 *  
 *  
 *  
 */



package com.r3pi.shrikhande.methods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Webservices {
	
	// Below metheods is for Get Operation- accepts URI as a parameter and returns the WS response
	public static Response Get(String URI) {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.get(URI);
		return response;
		
	}
	
	// Below metheods is for Post Operation- accepts URI & JSON as a parameter and returns the WS response
	public static Response Post(String URI, String stringJSON) {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.post(URI, stringJSON);
		return response;
		
	}
	
	// Below metheods is for Put Operation- accepts URI & JSON as a parameter and returns the WS response
	public static Response Put(String URI, String stringJSON) {
		RequestSpecification requestSpecification = RestAssured.given().body(stringJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.post(URI, stringJSON);
		return response;
	}	

}	




