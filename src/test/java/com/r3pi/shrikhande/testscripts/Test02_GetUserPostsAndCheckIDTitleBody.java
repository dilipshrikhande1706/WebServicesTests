package com.r3pi.shrikhande.testscripts;

import java.util.Random;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.r3pi.shrikhande.methods.Webservices;
import com.r3pi.shrikhande.pojoclass.GetPosts;
import com.r3pi.shrikhande.utils.EndpointURL;
import com.r3pi.shrikhande.utils.URL;
import com.r3pi.shrikhande.utils.Utilities;

import io.restassured.response.Response;

public class Test02_GetUserPostsAndCheckIDTitleBody {

	Response response;
	
	@BeforeClass
	public void setup() {
		
	}
	

	
	@Test
	public void checkIDTitleBody() {
		
		Integer  randomNum;
		Random rand = new Random();
		randomNum = 1 + rand.nextInt((10 - 1) + 1);
		
		Gson gson = new GsonBuilder().create();
		GetPosts getPosts[];
		
		String URI = URL.fixedURL+EndpointURL.GET_POST_BYUSERID.getResourcePath()+Integer.toString(randomNum);
		System.out.println("URI: "+URI);
		response = Webservices.Get(URI);
		boolean bod;
		
		
		if(response.getStatusCode()==200) {
			
		
		getPosts= gson.fromJson(response.getBody().asString(),GetPosts[].class);
		
		
			for (int i=1; i<getPosts.length;i++) {
				

				boolean bolid= (getPosts[i].getId() == (int)getPosts[i].getId());
				boolean boltitle= (getPosts[i].getTitle() != null);
				boolean bolbody= (getPosts[i].getBody() != null);
				
				
				Assert.assertEquals(bolid,true, "ID:"+(getPosts[i].getId())+"  is INVALID");

			
				if (bolid == true)
				{
					System.out.println("ID:"+(getPosts[i].getId())+"    :is a VALID ID");
	
				}

				Assert.assertEquals(boltitle,true, "title:"+(getPosts[i].getTitle())+"  is INVALID");

		
				
				if (boltitle == true) {
					System.out.println(getPosts[i].getTitle()+"    :is a VALID title");
				}
				

				Assert.assertEquals(boltitle,true, "title:"+(getPosts[i].getBody())+"  is INVALID");

				if (bolbody == true) {
			
					System.out.println(getPosts[i].getBody()+"    :is a VALID Body");
					System.out.println("--------------------------------------------------------------------------------------------");
				}
				

				}
			}
			
			
			
	
	}
	
	
	
}
