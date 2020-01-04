package org.pioneercoders.utils;

import org.pioneercoders.dto.response.Response;

public class ResponseUtil {

	public static Response createResponse(boolean isSuccess, String statusMsg, Object response) {
		Response responseObj = new Response();
		responseObj.setIsSuccess(isSuccess);
		responseObj.setStatus(statusMsg);
		responseObj.setResponse(response);
		return responseObj;
	}
}
