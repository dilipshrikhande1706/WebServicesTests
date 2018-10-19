/*
 *  Home Coding Excersise- QA Assessment 
 *  Organisation: R3PI
 *  Author: Dilip Shrikhande
 *  Date: 19-October-2018
 *  
 *  Description: This test performs a Post operation (title & body as pay load) for a random user and
 *  the verifies the response code
 *  
 */


package com.r3pi.shrikhande.testscripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.json.JSONObject;
import org.testng.Assert;



import com.r3pi.shrikhande.methods.Webservices;
import com.r3pi.shrikhande.pojoclass.GetPosts;
import com.r3pi.shrikhande.utils.EndpointURL;
import com.r3pi.shrikhande.utils.URL;
import com.r3pi.shrikhande.utils.Utilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test03_PostTitleBodyforUser {

	Response response;
	
	@BeforeClass
	public void setup() {
		
	}
	

	
	@Test
	public void postTitleBody() {
		
		boolean responseCode;
		Integer  randomNum;
		
		// below two lines generate a random number between range 1-10
		Random rand = new Random();
		randomNum = 1 + rand.nextInt((10 - 1) + 1);

		// line below generates endpoint urls
		String URI = URL.fixedURL+EndpointURL.POST_POST_BYUSERID.getResourcePath()+Integer.toString(randomNum);	
	    System.out.println(URI);
		
	    // in the lines below we create a json object and pass the key-value data (it is hard coded at the moment, but
	    // when I return back from holidays I will try to put this data in a json file
	    JSONObject jsonObj = new JSONObject()
                .put("title","XYZ sunt aut cbcxbfacere repellat provident occaecati excepturi optio reprehenderit\\\\\\\",\\\\n    \\\\\\")
                .put("body","XYZ sunt aut cbcxbfacere repellat provident occaecati excepturi optio reprehenderit\\\\\\\",\\\\n    \\\\\\");

	    
	    // here we perform the post operation (I haven`t used the method that I wrote as I did not have enough time to debug)
			Response response= given()
			.contentType("application/json")  
			.body(jsonObj.toString())   
			.post(URI);
			
			
			responseCode = (response.getStatusCode() == 201); // here we check if the Post operation was successful
			
			System.out.println("Status Code : "+response.getStatusCode());
			Assert.assertEquals(responseCode, true, "Post operation was sucessfull");
	
	}
	
	
	
}
