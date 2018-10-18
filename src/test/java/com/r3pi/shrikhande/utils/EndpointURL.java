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
