package org.pioneercoders.web.controllers.hr;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pioneercoders.dto.hr.ShortListedProfileDto;
import org.pioneercoders.dto.response.Response;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.hr.ShortListedProfileService;
import org.pioneercoders.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/shortlistprofiles")
public class ShortListedProfileController {
	
	private static final String FAILED = "failed";

	private static final String SUCCESS = "success";

	@Resource(name = "msgProps")
	private Map<String, String> msgProps;
	
	@Autowired
	ShortListedProfileService shortListedProfileService;
	
	@RequestMapping(value = "/addshortlistedprofile", method = RequestMethod.POST)
	public @ResponseBody
	Response addShortListedProfile(
			@RequestBody ShortListedProfileDto shortListedProfileDto) {
		Response response = new Response();
		try {
			if (shortListedProfileDto != null) {
				response = ResponseUtil.createResponse(true, SUCCESS, shortListedProfileService
										.createShortLisedProfiles(shortListedProfileDto));
			} else {
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.shortlistedprofile.creationfailed"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED, e.getMessage());
		}
		return response;

	}

	/**
	 * Method used to get list of shortListed profiles information.
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/getshortlistprofiles", method = RequestMethod.GET)
	public @ResponseBody
	Response getShortListedProfiles() {
		Response response = new Response();
		try {
			List<ShortListedProfileDto> list = shortListedProfileService
					.getShortListedProfilesList();
			if (list != null) {
				response = ResponseUtil.createResponse(true, SUCCESS, list);
			} else {
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.shortlistedprofile.list"));
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}


}
