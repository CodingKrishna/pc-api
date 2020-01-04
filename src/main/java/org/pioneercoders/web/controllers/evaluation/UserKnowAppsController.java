package org.pioneercoders.web.controllers.evaluation;
import org.pioneercoders.dto.evaluation.UserKnownAppsDto;
import org.pioneercoders.dto.response.Response;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.evaluation.UserKnownAppsService;
import org.pioneercoders.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="userknownapps")
public class UserKnowAppsController {
	
	@Autowired
	UserKnownAppsService userKnownAppsService;
	
	@RequestMapping(value = "/adduserknowapps", method = RequestMethod.POST)
	public @ResponseBody
	Response addEvaluationInfo(@RequestBody UserKnownAppsDto userKnowAppsDto) {
		Response response = new Response();
		try {
			if (userKnowAppsDto != null) {
				response = ResponseUtil.createResponse(true, "success",
						userKnownAppsService.createUserKnownApps(userKnowAppsDto));
			} else {
				response = ResponseUtil.createResponse(false, "failed",
						"Education is added successfully...");
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, "failed",
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/getuserknowappsinfo", method = RequestMethod.GET)
	public @ResponseBody
	Response getEvaluationDetailsByUserId(
			@RequestParam(value = "userId") Long userId) {
		Response response = new Response();
		try {
			if (userId != null) {
				UserKnownAppsDto finalDto = userKnownAppsService
						.getUserKnownAppsDetailsByUserId(userId);
				if (finalDto != null) {
					response = ResponseUtil.createResponse(true, "success",
							finalDto);
				} else {
					response = ResponseUtil.createResponse(false, "failed",
							"Evaluation Details is not available with this id");
				}
			} else {
				response = ResponseUtil.createResponse(false, "failed",
						"Evaluation Details is not available with this id");
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, "failed",
					e.getMessage());
		}
		return response;
	}

}

