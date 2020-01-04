package org.pioneercoders.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class WebServiceHttpClient {

	/**
	 * send SMS through HTTP get request
	 * 
	 * @param mobileNumber -- User Mobile No
	 * @param message -- text Message to SMS.
	 */
	public static String sendSMSThroughGet(String message, String mobileNumber) {

		// Create an instance of HttpClient.
		HttpClient client = new HttpClient();
		String finalURL = prepareURL(message, mobileNumber);

		log("Method:sendSMSThroughGet  finalURL[" + finalURL + "]");
		// Create a method instance.
		GetMethod method = new GetMethod(finalURL);

		// Provide custom retry handler is necessary
		method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));

		try {
			// Execute the method.
			int statusCode = client.executeMethod(method);

			if (statusCode != HttpStatus.SC_OK) {
				WebServiceParseErrorCodes.parseErrorCodes(statusCode);
				log("Method failed: " + method.getStatusLine());
			}

			// Read the response body.
			byte[] responseBody = method.getResponseBody();

			// Deal with the response.
			return new String(responseBody);

		} catch (HttpException e) {
			log("Fatal protocol violation: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			log("Fatal transport error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			// Release the connection.
			method.releaseConnection();
		}
		return null;
	}

	/**
	 * prepare the url for by appending mobile no and message
	 * 
	 * @param mobileNumber
	 * @param message
	 * @return-- final URL
	 */
	private static String prepareURL(String message, String mobileNumber) {

		try {
			message = URLEncoder.encode(message, "UTF-8").replace("+", "%20");
		} catch (UnsupportedEncodingException e) {
			log("UnsupportedEncodingException.. plz change the encoding algo..");
			e.printStackTrace();
		}
		/*HariKrishna*/
		return "http://smshorizon.co.in/api/sendsms.php?user=HariKrishna&apikey=RaI23VZXtffNRHSIieYO&type=txt&senderid=PC-TXTMSG&mobile=" + mobileNumber + "&message=" + message;
	}

	private static void log(String msg) {
		System.out.println(msg);
	}
}
