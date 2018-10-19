/*
 *  Home Coding Excersise- QA Assessment 
 *  Organisation: R3PI
 *  Author: Dilip Shrikhande
 *  Date: 19-October-2018
 *  
 *  Description: This test performs a Get operation for a random user & Prints user`s address 
 *  and also validates the email format.
 *  
 */


package com.r3pi.shrikhande.testscripts;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import java.util.Random;

import javax.mail.internet.InternetAddress;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.r3pi.shrikhande.methods.Webservices;
import com.r3pi.shrikhande.utils.EndpointURL;
import com.r3pi.shrikhande.utils.URL;
import com.r3pi.shrikhande.utils.Utilities;

import io.restassured.response.Response;

public class Test01_UserAddressDisplayAndCheckEmailFormat {

	Response response;
	
	@BeforeClass
	public void setup() {
		
	}
	
	
	@Test
	public void showUserEmailAddress() {
		
		String eMail;
		Integer  randomNum;
		
		// below two lines generate a random number between range 1-10
		Random rand = new Random();
		randomNum = 1 + rand.nextInt((10 - 1) + 1);
		
		// line below generates endpoint urls
		String URI = URL.fixedURL+EndpointURL.GET_USERS.getResourcePath()+"/"+Integer.toString(randomNum);
		
		
		response = Webservices.Get(URI); // calling the Get method to perform the get operation
		System.out.println("URI: "+URI);
		
		
		// In case of success the below code prints the user address and verifies the email format
		if(response.getStatusCode()==200) {
			System.out.println(response.getBody().jsonPath().get("address.street"));
			System.out.println(response.getBody().jsonPath().get("address.suite"));
			System.out.println(response.getBody().jsonPath().get("address.city"));
			System.out.println(response.getBody().jsonPath().get("address.zipcode"));
			System.out.println("--------------------------------------------------");
			System.out.println(response.getBody().jsonPath().get("email"));
			System.out.println("--------------------------------------------------");
			eMail = response.getBody().jsonPath().get("email");
			
			
			boolean emailvalidation = Utilities.isValidEmailAddress(eMail); // to check is the email format is correct
			//Assert.assertTrue(Utilities.isValidEmailAddress(eMail),"Email address:"+response.getBody().jsonPath().get("email")+" is Invalid");
			Assert.assertEquals(emailvalidation,true, "eMail:"+eMail+"  is INVALID");
			if (emailvalidation == true){
				System.out.println(eMail+"  is a VALID eMailId");
			}

		}
		
		
		
		
	}	
	

}
