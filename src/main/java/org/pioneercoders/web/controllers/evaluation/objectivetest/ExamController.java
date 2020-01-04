package org.pioneercoders.web.controllers.evaluation.objectivetest;

import java.util.List;

import org.pioneercoders.dto.evaluation.objectivetest.ExamDto;
import org.pioneercoders.dto.evaluation.objectivetest.ObjectiveQstnDto;
import org.pioneercoders.dto.evaluation.objectivetest.ObjectiveTestTotalResultDto;
import org.pioneercoders.dto.response.Response;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.evaluation.objectivetest.ExamService;
import org.pioneercoders.services.evaluation.objectivetest.ObjectiveQstnService;
import org.pioneercoders.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("exam")
public class ExamController {

	@Autowired
	ObjectiveQstnService questionsService;

	@Autowired
	ExamService examService;


	@RequestMapping(value = "submit", method = RequestMethod.POST)
	public @ResponseBody Response insertQuestions(@RequestBody ExamDto exam) {
		Response response = null;
		try {
			response = ResponseUtil.createResponse(true, "success", examService.insertExam(exam));
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, "failed", e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public @ResponseBody
	Response insertQuestions(@RequestBody ObjectiveQstnDto objQstnDto) {
		Response response = null;
		try {
			response = ResponseUtil.createResponse(true, "success", questionsService.insertQuestions(objQstnDto));
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, "failed", e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "examquestions", method = RequestMethod.GET)
	public @ResponseBody Response getQuestionsListByQueGroup(@RequestParam(value="userId")Long userId) {
		Response response = null;
		try {
			response = ResponseUtil.createResponse(true, "success", questionsService.getExamQuestionsForPerson(userId));
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, "failed", e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "getexamtransinfo", method = RequestMethod.GET)
	public @ResponseBody Response getExamTransInfo(@RequestParam("personalInfoId") Long personlInfoId) {
		Response response = null;
		try {
			response = ResponseUtil.createResponse(true, "success", examService.getExamTransInfo(personlInfoId));
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, "failed", e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "getexamtotalinfo", method = RequestMethod.GET)
	public @ResponseBody Response getAllExamResults() {
		Response response = null;
		try {
			List<ObjectiveTestTotalResultDto> list = examService.getAllExamResults();
			if(list!=null){
				response = ResponseUtil.createResponse(true, "success", list);
			}else{
				response = ResponseUtil.createResponse(true, "success", null);
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, "failed", e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "examresultsbyprofileid", method = RequestMethod.GET)
	public @ResponseBody Response getAllExamResultsByProfileId(@RequestParam(value="profileId")Long profileId) {
		Response response = null;
		try {
			List<ObjectiveTestTotalResultDto> list = examService.getAllExamResultsByProfileId(profileId);
			if(list!=null){
				response = ResponseUtil.createResponse(true, "success", list);
			}else{
				response = ResponseUtil.createResponse(true, "success", null);
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, "failed", e.getMessage());
		}
		return response;
	}
	
	/*@RequestMapping(value = "technologieslist", method = RequestMethod.GET)
	public @ResponseBody Response getAllTechnologies() {
		Response response = null;
		try {
			List<TechologiesDto> list = examService.getAllTechnologies();
			if(list!=null){
				response = ResponseUtil.createResponse(true, "success", list);
			}else{
				response = ResponseUtil.createResponse(true, "success", null);
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, "failed", e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="assingtechtousers")
	public @ResponseBody Response assignTechnologiesToUser(@RequestParam (value="userId")Long userId,@RequestParam(value="technologiesList")List<String> technologiesList){
		Response response = new Response();
		try {
			
			int result = examService.assingTechnologiesToUsers(userId, technologiesList);
			if(result>0){
				response = ResponseUtil.createResponse(true, "success", result);
			}else{
				response = ResponseUtil.createResponse(true, "success", "not assinged technologies"); 
			}
			
		} catch (Exception e) {
			response = ResponseUtil.createResponse(false, "failed",e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "assignedtechlist", method = RequestMethod.GET)
	public @ResponseBody Response getAssignedTechnologyList(@RequestParam (value="userId")Long userId) {
		Response response = null;
		try {
			List<TechnologyTrnDto> list = examService.getTechnlogiesListByUserId(userId);
			if(list!=null){
				response = ResponseUtil.createResponse(true, "success", list);
			}else{
				response = ResponseUtil.createResponse(true, "success", null);
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, "failed", e.getMessage());
		}
		return response;
	}*/
	
	/*@RequestMapping(value = "allexams", method = RequestMethod.GET)
	public @ResponseBody
	Response getAllExamReData() {
		Response response = null;
		try {
			response = ResponseUtil.createResponse(true, "success", examService.getAllExamReData());
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, "failed", e.getMessage());
		}
		return response;
	}*/
}
