package org.pioneercoders.web.controllers.Interview;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.pioneercoders.dto.Interview.InterviewAssignToUsersDto;
import org.pioneercoders.dto.Interview.InterviewGroupsCandidatesDto;
import org.pioneercoders.dto.Interview.InterviewGroupsDto;
import org.pioneercoders.dto.Interview.InterviewResultsDto;
import org.pioneercoders.dto.Interview.InterviewRoundQuesAssoDto;
import org.pioneercoders.dto.Interview.InterviewShortlistedCandidatesDto;
import org.pioneercoders.dto.Interview.InterviewTypesDto;
import org.pioneercoders.dto.Interview.InterviewsDto;
import org.pioneercoders.dto.Interview.JobInterviewDto;
import org.pioneercoders.dto.Interview.RoundsDto;
import org.pioneercoders.dto.Interview.SelectedGroupsForInterviewDto;
import org.pioneercoders.dto.Interview.TechnologiesInRoundDto;
import org.pioneercoders.dto.evaluation.codingtest.CodingTestQstnDto;
import org.pioneercoders.dto.evaluation.objectivetest.ObjectiveQstnDto;
import org.pioneercoders.dto.evaluation.objectivetest.ObjectiveTestTotalResultDto;
import org.pioneercoders.dto.evaluation.taskstest.TaskDto;
import org.pioneercoders.dto.response.Response;
import org.pioneercoders.dto.student.InstituteDto;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.Interview.InterviewService;
import org.pioneercoders.services.evaluation.codingtest.CodingTestQstnService;
import org.pioneercoders.services.evaluation.tasktest.TaskService;
import org.pioneercoders.services.user.UserService;
import org.pioneercoders.utils.DateParser;
import org.pioneercoders.utils.MailContentUtil;
import org.pioneercoders.utils.MailThread;
import org.pioneercoders.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="test")
public class InterviewController {
	
	private static final String FAILED = "failed";

	private static final String SUCCESS = "success";
	
	@Autowired
	InterviewService testService;
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	CodingTestQstnService codingTestService;
	
	@Autowired
	UserService userService;
	
	@Resource(name = "msgProps")
	private Map<String, String> msgProps;
	
	@SuppressWarnings("null")
	@RequestMapping(value = "/createtest", method = RequestMethod.POST)
	public @ResponseBody Response createTest(@RequestBody InterviewsDto testDto) {
		Response response = new Response();
		try {
			InterviewsDto createdtestDto = testService.createTest(testDto);
			if (createdtestDto != null) {
				response = ResponseUtil.createResponse(true, SUCCESS,createdtestDto);
			} else {
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.test.creationfailed"));
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/gettestlist", method = RequestMethod.GET)
	public @ResponseBody Response getTestList(@RequestParam(value="userId") Long userId, HttpSession session) {
		Response response = new Response();
		try {
			List<InterviewsDto> list = testService.getTestList(userId);
			if (list != null) {
				response = ResponseUtil.createResponse(true, SUCCESS,list);
			} else {
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.test.testisnotavailabelwithuserid")+userId);
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/getrounds", method = RequestMethod.GET)
	public @ResponseBody Response getPatterns() {
		Response response = new Response();
		try {
			List<RoundsDto> list = testService.getRounds();
			if (list != null) {
				response = ResponseUtil.createResponse(true, SUCCESS,list);
			} else {
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.test.roundsinfo"));
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/getquestionsbytechandrounds", method = RequestMethod.POST)
	public @ResponseBody Response getQuestionsByTechAndRounds(@RequestBody TechnologiesInRoundDto technologiesInRoundDto) {
		Response response = new Response();
		List<ObjectiveQstnDto> dto = null;
		List<TaskDto> taskDto = null;
		List<CodingTestQstnDto> codingTestDto = null;
		try {
			for(int i=0;i<technologiesInRoundDto.getRound().size();i++){
				if(technologiesInRoundDto.getRound().get(i).getPatternName().equalsIgnoreCase("Quiz")){
					dto = testService.getQuestionsByTechAndRounds(technologiesInRoundDto);
					if(dto!=null){
						response = ResponseUtil.createResponse(true, SUCCESS, dto);
					}
				}
				else if(technologiesInRoundDto.getRound().get(i).getPatternName().equalsIgnoreCase("Tasks")){
					taskDto = taskService.getAllTasksList();
					if(taskDto!=null){
						response = ResponseUtil.createResponse(true, SUCCESS,taskDto);
					}
				}else if(technologiesInRoundDto.getRound().get(i).getPatternName().equalsIgnoreCase("Coding")){
					codingTestDto = codingTestService.getAllQuestions();
					if(codingTestDto!=null){
						response = ResponseUtil.createResponse(true, SUCCESS,codingTestDto);
					}
				}
			}
		
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/saveQuestions", method = RequestMethod.POST)
	public @ResponseBody Response saveQuestions(@RequestBody InterviewRoundQuesAssoDto testRoundQuesAssoDto) {
		Response response = new Response();
		try {
			Long count = testService.saveQuestions(testRoundQuesAssoDto);
			if (count != 0) {
				response = ResponseUtil.createResponse(true, SUCCESS,count);
			} else {
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.test.interviewroundquestionscreationfailed"));
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/getquestionsforusers", method = RequestMethod.POST)
	public @ResponseBody Response getQuestionsForUsers(@RequestParam (value="testId") Long testId,@RequestParam (value="round") String round) {
		Response response = new Response();
		try {
			if(round.equalsIgnoreCase("Quiz")){
				List<ObjectiveQstnDto> dto = testService.getQuestionsForUsers(testId);
				if (dto != null) {
					response = ResponseUtil.createResponse(true, SUCCESS,dto);
				} else {
					response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.test.interviewquizquestionsbytestid")+testId);
				}
			}else if(round.equalsIgnoreCase("Coding")){
				List<CodingTestQstnDto> dto = testService.getCodingQstnsForUsers(testId);
				if (dto != null) {
					response = ResponseUtil.createResponse(true, SUCCESS,dto);
				} else {
					response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.test.interviewprogramsbytestid")+testId);
				}
			}else if(round.equalsIgnoreCase("Tasks")){
				List<TaskDto> dto = testService.getTasksForUsers(testId);
				if (dto != null) {
					response = ResponseUtil.createResponse(true, SUCCESS,dto);
				} else {
					response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.test.interviewprogramsbytestid")+testId);
				}
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/getalltests", method = RequestMethod.GET)
	public @ResponseBody Response getAllTests(@RequestParam (value="userId") Long userId) {
		Response response = new Response();
		try {
			List<InterviewsDto> list = testService.getAllTests(userId);
			if (list != null) {
				response = ResponseUtil.createResponse(true, SUCCESS,list);
			} else {
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.test.testlistnotavailabel")+userId);
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/getusertestresults", method = RequestMethod.GET)
	public @ResponseBody Response getUserTestResults(@RequestParam(value="testId") Long testId) {
		Response response = new Response();
		try {
			List<ObjectiveTestTotalResultDto> list = testService.getUserTestResults(testId);
			if (list != null) {
				response = ResponseUtil.createResponse(true, SUCCESS,list);
			} else {
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.test.testresultsbytestid")+testId);
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/submitexam", method = RequestMethod.POST)
	public @ResponseBody Response insertQuestions(@RequestBody InterviewResultsDto testResultsDto) {
		Response response = null;
		try {
			response = ResponseUtil.createResponse(true, SUCCESS, testService.submitExam(testResultsDto));
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED, e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/gettestresultsforuser", method = RequestMethod.GET)
	public @ResponseBody Response getTestResultsForUser(@RequestParam(value="userId") Long userId) {
		Response response = new Response();
		try {
			List<InterviewResultsDto> list = testService.getTestResultsForUser(userId);
			if (list != null) {
				response = ResponseUtil.createResponse(true, SUCCESS,list);
			} else {
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.test.testresultsbyuserid")+userId);
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/gettestresultsforhr", method = RequestMethod.GET)
	public @ResponseBody Response getTestResultsForHr(@RequestParam(value="testId") Long testId) {
		Response response = new Response();
		try {
			List<InterviewResultsDto> list = testService.getTestResultsForHr(testId);
			if (list != null) {
				response = ResponseUtil.createResponse(true, SUCCESS,list);
			} else {
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.test.testresultsforhrbytestid")+testId);
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "savejobinterview", method = RequestMethod.POST)
	public @ResponseBody Response saveJobInterview(@RequestBody JobInterviewDto jobInterviewDto) {
		Response response = null;
		JobInterviewDto finalJobInterviewDto = null;
		try {
			finalJobInterviewDto = testService.saveJobInterview(jobInterviewDto);
			if(finalJobInterviewDto!=null){
				response = ResponseUtil.createResponse(true, SUCCESS, finalJobInterviewDto);
			}else{
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.jobinterviewcreationfailed"));	
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED, e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "saveinterviewshortlistedcandidates", method = RequestMethod.POST)
	public @ResponseBody Response saveInterviewShortlistedCandidates(@RequestBody InterviewShortlistedCandidatesDto interviewShortlistedCandidatesDto) {
		Response response = null;
		InterviewShortlistedCandidatesDto updatedInterviewShorlistedCandidatesDto = null;
		try {
			updatedInterviewShorlistedCandidatesDto = testService.saveInterviewShortlistedCandidates(interviewShortlistedCandidatesDto);
			if(updatedInterviewShorlistedCandidatesDto!=null){
				response = ResponseUtil.createResponse(true, SUCCESS, updatedInterviewShorlistedCandidatesDto);
			}else{
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.interviewshortlistedcandidatedcreationfailed"));
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED, e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/getjobinterviewbytestid", method = RequestMethod.GET)
	public @ResponseBody Response getJobInterviewByTestId(@RequestParam(value="testId") Long testId) {
		Response response = new Response();
		try {
			JobInterviewDto dto = testService.getJobInterviewByTestId(testId);
			if (dto != null) {
				response = ResponseUtil.createResponse(true, SUCCESS,dto);
			} else {
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.jobinterviewbytestid")+testId);
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "saveinterviewgroups", method = RequestMethod.POST)
	public @ResponseBody Response saveInterviewGroups(@RequestBody InterviewGroupsDto interviewGroupsDto) {
		Response response = null;
		InterviewGroupsDto dto = null;
		try {
			dto = testService.saveInterviewGroups(interviewGroupsDto);
			if(dto!=null){
				response = ResponseUtil.createResponse(true, SUCCESS, dto);
			}else{
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.interviewgroups.creationfailed"));
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED, e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/uploadcandidatesinexcel", method = RequestMethod.POST)
	public @ResponseBody Response uploadcandidatesinexcel(@RequestParam(value = "file") MultipartFile excelfile,@RequestParam(value = "groupId") Long groupId) {
		Response response = null;
		InterviewGroupsCandidatesDto interviewgroupcandidatesdto = null;
		try {
			List<InterviewGroupsCandidatesDto> dtolist = new ArrayList<InterviewGroupsCandidatesDto>();
			int i = 0;
			XSSFWorkbook workbook = new XSSFWorkbook(excelfile.getInputStream());
			XSSFSheet worksheet = workbook.getSheetAt(0);
			while (i <= worksheet.getLastRowNum()) {
				interviewgroupcandidatesdto = new InterviewGroupsCandidatesDto();
				XSSFRow row = worksheet.getRow(i++);
		//		interviewgroupcandidatesdto.setId((int) row.getCell(0).getNumericCellValue());
				interviewgroupcandidatesdto.setGroupId(groupId);
				interviewgroupcandidatesdto.setCandidateName(row.getCell(0).getStringCellValue());
				interviewgroupcandidatesdto.setCandidateEmail(row.getCell(1).getStringCellValue());
				interviewgroupcandidatesdto.setCandidatePhoneNumber(NumberToTextConverter.toText(row.getCell(2).getNumericCellValue()));
				dtolist.add(interviewgroupcandidatesdto);
			}			
			response = ResponseUtil.createResponse(true, SUCCESS, testService.saveInterviewGroupsCandidates(dtolist));
		} catch (Exception e) {
			response = ResponseUtil.createResponse(false, FAILED, e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "getallinterviewgroups", method = RequestMethod.POST)
	public @ResponseBody Response getAllInterviewGroups(@RequestParam(value="loginId") Long userId) {
		Response response = null;
		List<InterviewGroupsDto> dto = null;
		try {
			dto = testService.getAllInterviewGroups(userId);
			if(dto!=null){
				response = ResponseUtil.createResponse(true, SUCCESS, dto);
			}else{
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.allinterviewgroups")+userId);
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED, e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "getcandidatesbygroupid", method = RequestMethod.GET)
	public @ResponseBody Response getInterviewCandidatesByGroupId(@RequestParam(value="groupId") Long groupId) {
		Response response = null;
		List<InterviewGroupsCandidatesDto> dto = null;
		try {
			dto = testService.getInterviewCandidatesByGroupId(groupId);
			if(dto!=null){
				response = ResponseUtil.createResponse(true, SUCCESS, dto);
			}else{
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.candidatesbygroupid"));
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED, e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "restrictusersonlinetest", method = RequestMethod.POST)
	public @ResponseBody Response restrictUsersOnlineTest(@RequestBody InterviewResultsDto testResultsDto) {
		Response response = null;
		try {
			Long testId = testResultsDto.getTest().getId();
			Long userId = testResultsDto.getUser().getId();
			Long roundId = testResultsDto.getRounds().getId();
			
			response = ResponseUtil.createResponse(true, SUCCESS, testService.restrictUsersOnlineTest(testId, userId, roundId));
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED, e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "sendmail", method = RequestMethod.GET)
	public @ResponseBody Response sendMail(@RequestParam (value="Email") String EmailId,
											@RequestParam (value="userName") String userName,
											@RequestParam (value="phoneNumber") String phoneNumber) {
		Response response = null;
		try {
			String subject = "Invitation from HR";
			MailContentUtil mail = new MailContentUtil();
			String mailFromHr =mail.sendMailToUserFromHr();
			MailThread sendMail = new MailThread(EmailId, subject, mailFromHr);
			Thread t = new Thread(sendMail);
			t.start();
			response = ResponseUtil.createResponse(true, SUCCESS,"successfully sent");
		} catch (Exception e) {
			response = ResponseUtil.createResponse(false, FAILED, e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "restrictusersonlinetestbydates", method = RequestMethod.GET)
	public @ResponseBody Response restrictUsersOnlineTestByDates(@RequestParam(value="fromDate") String frDate,
																@RequestParam(value="toDate") String tDate,
																@RequestParam(value="testId") Long testId) {
		Response response = null;
		Date fromDate = DateParser.strToDate(frDate);
		Date toDate = DateParser.strToDate(tDate);
		try {
			response = ResponseUtil.createResponse(true, SUCCESS, testService.restrictUsersOnlineTestByDates(fromDate, toDate, testId));
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED, e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "getinterviewtypeslist", method = RequestMethod.GET)
	public @ResponseBody Response getInterviewTypesList() {
		Response response = null;
		List<InterviewTypesDto> dto = null;
		try {
			dto =  testService.getInterviewTypesList();
			if(dto!=null){
				response = ResponseUtil.createResponse(true, SUCCESS, testService.getInterviewTypesList());
			}else{
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.interviewtypeslist"));
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED, e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/getprivatetestlist", method = RequestMethod.GET)
	public @ResponseBody Response getPrivateTestList(@RequestParam(value="userId") Long userId, HttpSession session) {
		Response response = new Response();
		try {
			List<InterviewsDto> list = testService.getPrivateTestList(userId);
			if (list != null) {
				response = ResponseUtil.createResponse(true, SUCCESS,list);
			} else {
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.privatetestlist"));
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}
	

	@RequestMapping(value = "/saveSelectedGroupsForInterview", method = RequestMethod.POST)
	public @ResponseBody Response saveSelectedGroupsForInterview(@RequestBody SelectedGroupsForInterviewDto selectedGroupsForInterviewDto) {
		Response response = new Response();
		try {
			testService.saveSelectedGroupsForInterview(selectedGroupsForInterviewDto);
			response = ResponseUtil.createResponse(true, SUCCESS,"saved");
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/getSelectedGroupsForInterviewByTestId", method = RequestMethod.GET)
	public @ResponseBody Response getSelectedGroupsForInterviewByTestId(@RequestParam (value="interviewId") Long interviewId) {
		Response response = new Response();
		try {
			List<SelectedGroupsForInterviewDto> list = testService.getSelectedGroupsForInterviewByTestId(interviewId);
			if (list != null) {
				response = ResponseUtil.createResponse(true, SUCCESS,list);
			} else {
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.selectedgroupsforinterviewbytestid")+interviewId);
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "getinterviewassigntousersbyuserid", method = RequestMethod.GET)
	public @ResponseBody Response getInterviewAssignToUsersByUserId(@RequestParam (value="userId") Long userId) {
		Response response = null;
		List<InterviewAssignToUsersDto> dto = null;
		try {
			dto = testService.getInterviewAssignToUsersByUserId(userId);
			if(dto!=null){
				response = ResponseUtil.createResponse(true, SUCCESS, dto);
			}else{
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.interviewassigntousersbyuserid"));
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED, e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/savePoCollegeDetails", method = RequestMethod.POST)
	public @ResponseBody Response savePoCollegeDetails(@RequestBody InstituteDto instituteDto) {
		Response response = new Response();
		try {
			InstituteDto collegeDto = testService.savePoCollegeDetails(instituteDto);
			if (collegeDto != null) {
				response = ResponseUtil.createResponse(true, SUCCESS,collegeDto);
			} else {
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.pocollegedetailscreationfailed"));
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/getPoCollegedetailsById", method = RequestMethod.GET)
	public @ResponseBody Response getPoCollegedetailsById(@RequestParam (value="poId") Long poId) {
		Response response = new Response();
		try {
			InstituteDto collegeDto = testService.getPoCollegedetailsById(poId);
			if (collegeDto != null) {
				response = ResponseUtil.createResponse(true, SUCCESS,collegeDto);
			} else {
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.pocollegedetailsbyid"));
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}
	
}