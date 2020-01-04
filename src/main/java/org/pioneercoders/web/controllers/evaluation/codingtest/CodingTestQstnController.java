package org.pioneercoders.web.controllers.evaluation.codingtest;

import java.util.List;

import org.pioneercoders.dto.evaluation.codingtest.CodingTestQstnDto;
import org.pioneercoders.dto.evaluation.codingtest.CodingTestQstnsAssignToUserTrnDto;
import org.pioneercoders.dto.evaluation.codingtest.CodingTestResultDto;
import org.pioneercoders.dto.response.Response;
import org.pioneercoders.services.evaluation.codingtest.CodingTestQstnService;
import org.pioneercoders.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="codingtest")
public class CodingTestQstnController {
	
	@Autowired
	CodingTestQstnService codingTestQstnService;
	
	@RequestMapping(value="questionslist", method=RequestMethod.GET)
	public @ResponseBody Response getAllQuestions(){
		Response response = new Response();
		try {
			List<CodingTestQstnDto> questionsList	= codingTestQstnService.getAllQuestions();
			if(questionsList!=null){
				response = ResponseUtil.createResponse(true, "success",questionsList);
			}else {
				response = ResponseUtil.createResponse(false, "failed","List Not Available");
			}
		} catch (Exception e) {
			response = ResponseUtil.createResponse(false, "failed",e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="createquestion",method=RequestMethod.POST)
	public @ResponseBody Response createQuestion(@RequestBody CodingTestQstnDto codingTestQstnDto){
		Response response = new Response();
		try {
			CodingTestQstnDto finalDto = codingTestQstnService.saveQuestion(codingTestQstnDto);
			if(finalDto!=null){
				response = ResponseUtil.createResponse(true, "success", finalDto);
			}else {
				response = ResponseUtil.createResponse(false, "failed", null);
			}
		} catch (Exception e) {
			response = ResponseUtil.createResponse(false, "failed",e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="assignquestouser")
	public @ResponseBody Response getAllQuestions(@RequestParam (value="userId")Long userId,@RequestParam(value="questIdsList")List<String> questIdsList){
		Response response = new Response();
		try {
			
			int result = codingTestQstnService.assingQuestionsToUser(userId, questIdsList);
			if(result>0){
				response = ResponseUtil.createResponse(true, "success", result);
			}else{
				response = ResponseUtil.createResponse(true, "success", "not assinged questions"); 
			}
			
		} catch (Exception e) {
			response = ResponseUtil.createResponse(false, "failed",e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="questionslistbyuserid", method=RequestMethod.GET)
	public @ResponseBody Response getAssignedQuestListByUserId(@RequestParam(value="userId")Long userId){
		Response response = new Response();
		try {
			List<CodingTestQstnsAssignToUserTrnDto> questionsList	= codingTestQstnService.getAllQuestionsByUserId(userId);
			if(questionsList!=null){
				response = ResponseUtil.createResponse(true, "success",questionsList);
			}else {
				response = ResponseUtil.createResponse(false, "failed","List Not Available");
			}
		} catch (Exception e) {
			response = ResponseUtil.createResponse(false, "failed",e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="createcodingresult",method=RequestMethod.POST)
	public @ResponseBody Response createCodingTestResult(@RequestBody CodingTestResultDto codingTestResultDto){
		Response response = new Response();
		try {
			CodingTestResultDto finalDto = codingTestQstnService.saveCodingTestResult(codingTestResultDto);
			if(finalDto!=null){
				response = ResponseUtil.createResponse(true, "success", finalDto);
			}else {
				response = ResponseUtil.createResponse(false, "failed", null);
			}
		} catch (Exception e) {
			response = ResponseUtil.createResponse(false, "failed",e.getMessage());
		}
		return response;
	}
	
}
