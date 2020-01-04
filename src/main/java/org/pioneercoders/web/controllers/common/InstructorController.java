package org.pioneercoders.web.controllers.common;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pioneercoders.dto.common.InstructorDto;
import org.pioneercoders.dto.response.Response;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.common.InstructorService;
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
@RequestMapping(value = "/instructor")
public class InstructorController {
	
	private static final String FAILED = "failed";

	private static final String SUCCESS = "success";

	@Resource(name = "msgProps")
	private Map<String, String> msgProps;
	private Logger logger = LoggerFactory.getLogger(InstructorController.class);
	
	@Autowired
	InstructorService instructorService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Response addInstructor(@RequestBody InstructorDto instructorDto) {
		Response response = new Response();
		try {
			InstructorDto finalInstructionDto = instructorService.createInstructorInfo(instructorDto);
			if(finalInstructionDto!=null){
				response = ResponseUtil.createResponse(true, SUCCESS,finalInstructionDto);
			} else{
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.instructor.creationfailed"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody Response getInstructorsList() {
		Response response = new Response();
		try {
			List<InstructorDto> instructorList = instructorService.getInstructorInfoList();
			if(instructorList!=null){
				response = ResponseUtil.createResponse(true, SUCCESS,instructorList);
			} else{
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.instructor.listfailed"));
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}

}
