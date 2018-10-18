package com.r3pi.shrikhande.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;



public class Utilities {


	public static boolean isValidEmailAddress(String email) {
	   boolean result = true;
	   try {
	      InternetAddress emailAddr = new InternetAddress(email);
	      emailAddr.validate();
	   } catch (AddressException ex) {
	      result = false;
	   }
	   return result;
}
	
	
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
	
}
