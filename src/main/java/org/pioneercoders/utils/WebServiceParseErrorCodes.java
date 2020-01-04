package org.pioneercoders.utils;
/**

 * Yahoo! Web Services Search Example: Parse returned error codes
 *
 * @author Daniel Jones www.danieljones.org
 * Copyright 2007
 * 
 * This example illustrates how to parse a Yahoo! Web Service
 * XML error response codes.
 * 
 * HTTP Status Error Codes:
 * 400  Bad request. The parameters passed to the service did not match as expected. The Message should tell you what was missing or incorrect.
 * 403 	Forbidden. You do not have permission to access this resource, or are over your rate limit.
 * 503 	Service unavailable. An internal problem prevented us from returning data to you.
 */

public class WebServiceParseErrorCodes {	
	
	public static void parseErrorCodes(int statusCode){
        
        	switch (statusCode) {
	    		case 400: {
	    			log("Bad request. The parameters passed to the service did not match as expected. The Message should tell you what was missing or incorrect."); 
	    			log("Change the parameter appcd to appid and this error message will go away.");
	    			break;
	    		}
	    		case 403: {
	    			log("Forbidden. You do not have permission to access this resource, or are over your rate limit.");
	    			break;
	    		}
	    		case 503: {
	    			log("Service unavailable. An internal problem prevented us from returning data to you.");
	    			break;
	    		}
	    		default: log("Your call to Varnasco! Web Services returned an unexpected  HTTP status of: " + statusCode);
        }
	}
	
	private static void log(String aMessage){
	    System.out.println(aMessage);
	  }
}