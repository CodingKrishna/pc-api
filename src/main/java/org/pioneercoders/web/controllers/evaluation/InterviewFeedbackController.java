package org.pioneercoders.web.controllers.evaluation;

import java.util.List;

import org.pioneercoders.dto.evaluation.InterviewFeedbackDto;
import org.pioneercoders.dto.evaluation.UserInterviewStatusDto;
import org.pioneercoders.dto.response.Response;
import org.pioneercoders.dto.user.UserDto;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.evaluation.InterviewFeedbackService;
import org.pioneercoders.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="feedback")
public class InterviewFeedbackController {
	
	@Autowired
	InterviewFeedbackService interviewFeedbackService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody Response getFeedbackList() {
		Response response = new Response();
		try {
			List<InterviewFeedbackDto> finalData = interviewFeedbackService.getInterviewFeedbackList();
			if(finalData!=null){
				response = ResponseUtil.createResponse(true, "success",finalData);
			}else{
				response = ResponseUtil.createResponse(false, "failed","No Records Found");
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, "failed",e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/savestudentfeedback", method = RequestMethod.POST)
	public @ResponseBody Response addStudentFeedBack(@RequestBody UserInterviewStatusDto userInterviewStatusDto) {
		Response response = new Response();
		try {
			if(userInterviewStatusDto!=null){
				response = ResponseUtil.createResponse(true, "success",interviewFeedbackService.insertOrUpdateUserInterviewStatus(userInterviewStatusDto));
			}else{
				response = ResponseUtil.createResponse(false, "failed","StudetFeedBack info is saved successfully...");
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, "failed",e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/getfeedbackdetailsbyid", method = RequestMethod.GET)
	public @ResponseBody Response getFeedBackDetailsById(@RequestParam(value="userId") Long userId) {
		Response response = new Response();
		try {
			if(userId!=null){
				response = ResponseUtil.createResponse(true, "success",interviewFeedbackService.getUserInterviewStatusDetailsByUserId(userId));
			}else{
				response = ResponseUtil.createResponse(false, "failed","getFeedBackDetailsById method is failed");
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, "failed",e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/usersbyfeedback", method = RequestMethod.GET)
	public @ResponseBody Response getUserListByFeedBack() {
		Response response = new Response();
		try {
			List<UserDto> finalData = interviewFeedbackService.getUserInterviewStatusDetailsListByGoodOrExcellent();
			if(finalData!=null){
				response = ResponseUtil.createResponse(true, "success",finalData);
			}else{
				response = ResponseUtil.createResponse(false, "failed","No Records Found");
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, "failed",e.getMessage());
		}
		return response;
	}
}
