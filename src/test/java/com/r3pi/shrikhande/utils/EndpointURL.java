/*
 *  Home Coding Excersise- QA Assessment 
 *  Organisation: R3PI
 *  Author: Dilip Shrikhande
 *  Date: 19-October-2018
 *  
 *  Description: This below enum is where we strore resource endpoints and are later used in tests to 
 *  form endpoint URIs on the fly
 *  
 *  
 *  
 */



package com.r3pi.shrikhande.utils;

public enum EndpointURL {

	GET_USERS	("/users"),
	GET_A_USER	("/users/"),
	GET_POSTS	("/posts"),
	GET_POST	("/posts/1"),
	GET_COMMENTS("/posts/1/comments"),	
	GET_COMMENT_BYPOSTID("/comments?postId=1"),	
	GET_POST_BYUSERID	("/posts?userId="),
	POST_POSTS("/posts"),
	POST_POST_BYUSERID	("/posts?userId="),
	UPDATE_POST("/posts/1"),	
	DELETE_POST("/posts/1");

	
	String resourcePath;

	private EndpointURL(String resourcePath) {
		this.resourcePath = resourcePath;
	}

	public String getResourcePath() {
		return this.resourcePath;
	}

	public String getResourcePath(String data) {
		return this.resourcePath+data;
	}
	

	
}
