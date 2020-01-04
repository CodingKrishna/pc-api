package org.pioneercoders.web.controllers.common;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pioneercoders.dto.common.ContactusDto;
import org.pioneercoders.dto.response.Response;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.common.ContactusService;
import org.pioneercoders.utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/contactus")
public class ContactusController {
	
	private static final String FAILED = "failed";

	private static final String SUCCESS = "success";

	@Resource(name = "msgProps")
	private Map<String, String> msgProps;
	private Logger logger = LoggerFactory.getLogger(ContactusController.class);
	
	@Autowired
	ContactusService contactusService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Response addContactUsInfo(@RequestBody ContactusDto contactusDto) {
		Response response = new Response();
		try {
			response = ResponseUtil.createResponse(true, SUCCESS,contactusService.createContactusInfo(contactusDto));

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.contactus.creationfailed"));
		}
		return response;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody Response getContactUsInfoList() {
		Response response = new Response();
		try {
			List<ContactusDto> list = contactusService.getContactusInfoList();
			if(list!=null){
				response = ResponseUtil.createResponse(true, SUCCESS,list);
			} else{
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.contactus.listfailed"));
			}
			
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}

}
