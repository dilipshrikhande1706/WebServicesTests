package com.r3pi.shrikhande.testscripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import static io.restassured.RestAssured.given;

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
		
		Integer  randomNum;
		Random rand = new Random();
		randomNum = 1 + rand.nextInt((10 - 1) + 1);
		
		Gson gson = new GsonBuilder().create();
		GetPosts getPosts[];
		
		// String URI = URL.fixedURL+EndpointURL.GET_POST_BYUSERID.getResourcePath()+Integer.toString(randomNum);
	//	String URI =  URL.fixedURL+EndpointURL.POST_POSTS.getResourcePath();//.getResourcePath()+Integer.toString(randomNum);
	//	String URI =  "http://jsonplaceholder.typicode.com/posts";
				
	//	System.out.println(URI);
		
		//String stringJSON = generateStringFromResource("/src/test/java/com/r3pi/shrikhande/testdata/Test03Payload.json");
		String stringJSON = "  {\n    \"userId\": 1,\n    \"title\": \"XYZ sunt aut cbcxbfacere repellat provident occaecati excepturi optio reprehenderit\",\n    \"body\": \"SSS quia vcbcxbet suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n  }";
		
		System.out.println(stringJSON);
		//response = Webservices.Post(URI, "{\n    \"userId\": 1,\n    \"title\": \"XYZ sunt aut cbcxbfacere repellat provident occaecati excepturi optio reprehenderit\",\n    \"body\": \"SSS quia vcbcxbet suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n  }");
		//RequestSpecification requestSpecification = RestAssured.given().contentType(ContentType.JSON).body(stringJSON);
		
		
		//RequestSpecification requestSpecification = RestAssured.given().body(stringJSON);
		//requestSpecification.contentType(ContentType.JSON);
		//Response response = requestSpecification.post(URI, stringJSON);
		
		
		
		String myJson = "  {\\n    \\\"userId\\\": 1,\\n    \\\"title\\\": \\\"XYZ sunt aut cbcxbfacere repellat provident occaecati excepturi optio reprehenderit\\\",\\n    \\\"body\\\": \\\"SSS quia vcbcxbet suscipit\\\\nsuscipit recusandae consequuntur expedita et cum\\\\nreprehenderit molestiae ut ut quas totam\\\\nnostrum rerum est autem sunt rem eveniet architecto\\\"\\n  }";
    	RestAssured.baseURI  = "http://jsonplaceholder.typicode.com/posts";	

    	Response r = given(). contentType("application/json").
    	body(myJson).
        when().
        post("");
		//System.out.println(response);
		//System.out.println(response.getStatusCode());
		
		/*if(response.getStatusCode()==200) {
			
			

			 //String str = FileUtils.readFileToString("/src/test/java/com/r3pi/shrikhande/testdata/Test03Payload.json");
			 //String strin = generateStringFromResource("/src/test/java/com/r3pi/shrikhande/testdata/Test03Payload.json");
			
		getPosts= gson.fromJson(response.getBody().asString(),GetPosts[].class);
		


				boolean bolid= (getPosts[i].getId() == (int)getPosts[i].getId());
				boolean boltitle= (getPosts[i].getTitle() != null);
				boolean bolbody= (getPosts[i].getBody() != null);
				
				
				AssertJUnit.assertEquals(bolid,true, "ID:"+(getPosts[i].getId())+"  is INVALID");

			
				if (bolid == true)
				{
					System.out.println("ID:"+(getPosts[i].getId())+"    :is a VALID ID");
	
				}

				AssertJUnit.assertEquals(boltitle,true, "title:"+(getPosts[i].getTitle())+"  is INVALID");

		
				
				if (boltitle == true) {
					System.out.println(getPosts[i].getTitle()+"    :is a VALID title");
				}
				

				AssertJUnit.assertEquals(boltitle,true, "title:"+(getPosts[i].getBody())+"  is INVALID");

				if (bolbody == true) {
			
					System.out.println(getPosts[i].getBody()+"    :is a VALID Body");
					System.out.println("--------------------------------------------------------------------------------------------");
				}
				

				}*/
			
			
			
			
	
	}
	
	
	
}
