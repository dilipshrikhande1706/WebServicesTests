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
	
/*	
	@Test
	public void showUsers() {
		String URI = URL.fixedURL+EndpointURL.GET_USERS.getResourcePath();
		System.out.println(URI);
		response = Webservices.Get(URI);
		System.out.println(response.getBody().asString());
		
	}	*/
	
	@Test
	public void showUserEmailAddress() {
		
		String eMail;
		Integer  randomNum;
		Random rand = new Random();
		randomNum = 1 + rand.nextInt((10 - 1) + 1);
		
		String URI = URL.fixedURL+EndpointURL.GET_USERS.getResourcePath()+"/"+Integer.toString(randomNum);
		response = Webservices.Get(URI);
		System.out.println("URI: "+URI);
		
		
		if(response.getStatusCode()==200) {
			System.out.println(response.getBody().jsonPath().get("address.street"));
			System.out.println(response.getBody().jsonPath().get("address.suite"));
			System.out.println(response.getBody().jsonPath().get("address.city"));
			System.out.println(response.getBody().jsonPath().get("address.zipcode"));
			System.out.println("--------------------------------------------------");
			System.out.println(response.getBody().jsonPath().get("email"));
			System.out.println("--------------------------------------------------");
			eMail = response.getBody().jsonPath().get("email");
			
			boolean emailvalidation = Utilities.isValidEmailAddress(eMail);
			//Assert.assertTrue(Utilities.isValidEmailAddress(eMail),"Email address:"+response.getBody().jsonPath().get("email")+" is Invalid");
			Assert.assertEquals(emailvalidation,true, "eMail:"+eMail+"  is INVALID");
			if (emailvalidation == true){
				System.out.println(eMail+"  is a VALID eMailId");
			}

		}
		
		
		
		
	}	
	

}
