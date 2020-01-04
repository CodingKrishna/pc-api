package org.pioneercoders.web.controllers.tutorials;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pioneercoders.dto.response.Response;
import org.pioneercoders.dto.tutorials.QuizDto;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.tutorials.QuizService;
import org.pioneercoders.utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuitzController {
	
	private static final String FAILED = "failed";

	private static final String SUCCESS = "success";
	
	private Logger logger = LoggerFactory.getLogger(QuitzController.class);
	
	@Autowired
	QuizService quizService;
	
	@Resource(name = "msgProps")
	private Map<String, String> msgProps;
	
	// quiz related Methods
		@RequestMapping(value = "/addquiz", method = RequestMethod.POST)
		public @ResponseBody
		Response addQuiz(@RequestBody QuizDto quizDto) {
			Response response = new Response();
			try {
				if (quizDto != null) {
					response = ResponseUtil.createResponse(true, SUCCESS,
							quizService.createQuiz(quizDto));
				} else {
					response = ResponseUtil.createResponse(false, FAILED,
							msgProps.get("error.quiz.creationfailed"));
				}

			} catch (ServiceException e) {
				response = ResponseUtil.createResponse(false, FAILED,
						e.getMessage());
			}
			return response;
		}

		@RequestMapping(value = "/quizlist", method = RequestMethod.GET)
		public @ResponseBody
		Response getQuizDetailsByUserId(@RequestParam(value = "userId") Long userId) {
			Response response = new Response();
			try {
				if (userId != null) {
					List<QuizDto> quizList = quizService
							.getQuizListByUserId(userId);
					if (quizList != null) {
						response = ResponseUtil.createResponse(true, SUCCESS,
								quizList);
					} else {
						response = ResponseUtil.createResponse(false, FAILED,
								msgProps.get("error.quiz.quizisnotavailabelwithid"));
					}
				} else {
					response = ResponseUtil.createResponse(false, FAILED,
							msgProps.get("error.quiz.quizisnotavailabelwithid"));
				}

			} catch (ServiceException e) {
				response = ResponseUtil.createResponse(false, FAILED,
						e.getMessage());
			}
			return response;
		}


}