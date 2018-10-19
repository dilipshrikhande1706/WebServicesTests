/*
 *  Home Coding Excersise- QA Assessment 
 *  Organisation: R3PI
 *  Author: Dilip Shrikhande
 *  Date: 19-October-2018
 *  
 *  Description: This is a pojo class where the raw JSON is converted to pojo- Used as an alternative to JSON Path finder
 *  
 *  
 *  
 */

package com.r3pi.shrikhande.pojoclass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetPosts {

@SerializedName("userId")
@Expose
private Integer userId;
@SerializedName("id")
@Expose
private Integer id;
@SerializedName("title")
@Expose
private String title;
@SerializedName("body")
@Expose
private String body;

public Integer getUserId() {
return userId;
}

public void setUserId(Integer userId) {
this.userId = userId;
}

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

public String getBody() {
return body;
}

public void setBody(String body) {
this.body = body;
}

}