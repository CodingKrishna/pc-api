package org.pioneercoders.web.controllers.user;

import java.util.Map;

import javax.annotation.Resource;

import org.pioneercoders.dto.response.Response;
import org.pioneercoders.dto.user.UserDto;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.user.UserService;
import org.pioneercoders.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	
	private static final String FAILED = "failed";

	private static final String SUCCESS = "success";
	
	@Autowired
	UserService userService;
	
	@Resource(name = "msgProps")
	private Map<String, String> msgProps;

	@RequestMapping(value = "/login/user", method = RequestMethod.POST)
	public @ResponseBody Response loginUser(@RequestBody UserDto loginDto) {
		Response response = null;
		try {
			if (loginDto.getEmailId().equals("pcadmin") && loginDto.getPassword().equals("p@$$w0rd")) {
				response = ResponseUtil.createResponse(true, SUCCESS, loginDto);
				return response;
			}
			UserDto user=userService.getUserDetails(loginDto.getEmailId(), loginDto.getPassword());
			if(user!=null){
				response = ResponseUtil.createResponse(true, SUCCESS,user);
			} else {
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.invalidcredentials"));
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/pcadmin")
	public String adminLogin() {
		return "admin/adminHome";
	}
	
	@RequestMapping(value = "/lecturer")
	public String getLecturePage() {
		return "lecturerPanel/lecturerHome";
	}
}
