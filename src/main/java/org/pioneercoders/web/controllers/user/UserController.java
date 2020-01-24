package org.pioneercoders.web.controllers.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.pioneercoders.dto.common.LanguagesDto;
import org.pioneercoders.dto.common.MessageDto;
import org.pioneercoders.dto.common.PlacementsDto;
import org.pioneercoders.dto.common.SubscribeDto;
import org.pioneercoders.dto.common.SupportDto;
import org.pioneercoders.dto.common.TechnologiesDto;
import org.pioneercoders.dto.hr.ShortListedProfileDto;
import org.pioneercoders.dto.hr.UserSearchDto;
import org.pioneercoders.dto.hr.UserSearchResultsDto;
import org.pioneercoders.dto.response.Response;
import org.pioneercoders.dto.student.AddressDto;
import org.pioneercoders.dto.student.CompleteProfileDto;
import org.pioneercoders.dto.student.EducationDto;
import org.pioneercoders.dto.student.EmployersInfoDto;
import org.pioneercoders.dto.student.ProfileWithLanguageDto;
import org.pioneercoders.dto.student.ProjectDomainDto;
import org.pioneercoders.dto.student.ProjectDto;
import org.pioneercoders.dto.student.ReferralDto;
import org.pioneercoders.dto.student.SocialInfoDto;
import org.pioneercoders.dto.student.TechSkillDto;
import org.pioneercoders.dto.student.UserExperianceDto;
import org.pioneercoders.dto.user.UserDto;
import org.pioneercoders.entity.student.EducationEntity;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.user.UserService;
import org.pioneercoders.utils.AppConfig;
import org.pioneercoders.utils.DateParser;
import org.pioneercoders.utils.MailContentUtil;
import org.pioneercoders.utils.MailThread;
import org.pioneercoders.utils.ResponseUtil;
import org.pioneercoders.utils.SMSThread;
import org.pioneercoders.utils.SMSUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import sun.misc.BASE64Decoder;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	private static final String FAILED = "failed";

	private static final String SUCCESS = "success";

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Resource(name = "msgProps")
	private Map<String, String> msgProps;

	@Autowired
	UserService userService;
	
	@Autowired
	AppConfig appConfig;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody
	Response addUser(@RequestBody UserDto userDto, HttpServletRequest request) {
		Response response = new Response();
		String url = getHostUrl(request) + "/user/activation";
		try {
			UserDto finalUserDto = userService.createUser(userDto, url);
			if (finalUserDto != null) {
				response = ResponseUtil.createResponse(true, SUCCESS,
						finalUserDto);
			} else {
				response = ResponseUtil.createResponse(false, FAILED, 
						msgProps.get("error.emailexist"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;

	}

	@RequestMapping(value = "/updatestatus", method = RequestMethod.GET)
	public @ResponseBody
	Response updateUserByStatus(@RequestBody UserDto userDto) {
		Response response = new Response();
		try {
			UserDto finalUserDto = userService.updateStatus(userDto);
			if (finalUserDto != null) {
				response = ResponseUtil.createResponse(true, SUCCESS,
						finalUserDto);
			} else {
				response = ResponseUtil.createResponse(false, FAILED,
						msgProps.get("error.statusupdatefailed"));
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/getuser", method = RequestMethod.GET)
	public @ResponseBody
	Response getUsersList(
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "list", required = false) boolean listRequired,
			@RequestParam(value = "status", required = false) String status,
			@RequestParam(value = "emailId", required = false) String emailId,
			@RequestParam(value = "mobileNo", required = false) String mobileNo) {
		Response response = new Response();

		if (logger.isDebugEnabled()) {
			logger.debug("Getting usersList by either of data [" + id + "] listRequired["+
					listRequired+"] status["+status+"] emailId["+emailId+"] mobileNo["+mobileNo+"]");
		}
		try {
			UserDto finalUserDto = null;
			if (listRequired) {
				List<UserDto> finalUsersList = userService.getUsersList(status);
				if (finalUsersList != null) {
					response = ResponseUtil.createResponse(true, SUCCESS,
							finalUsersList);
				} else {
					response = ResponseUtil.createResponse(false, FAILED,
							msgProps.get("error.usersnotavailablewithstatus")+" "+status);
				}
			} else if (id != null) {
				finalUserDto = userService.getUserDtoById(id);
				if (finalUserDto != null) {
					response = ResponseUtil.createResponse(true, SUCCESS,
							finalUserDto);
				} else {
					response = ResponseUtil.createResponse(false, FAILED,
							msgProps.get("error.usernotavaliablewithid")+" "+id);
				}
			} else if (mobileNo != null && emailId != null) {
				finalUserDto = userService.getUserDetailsByEmailOrMobile(
						emailId, mobileNo);
				if (finalUserDto != null) {
					response = ResponseUtil.createResponse(true, SUCCESS,
							finalUserDto);
				} else {
					response = ResponseUtil.createResponse(false, FAILED,
							msgProps.get("error.usernotavaliablewithemailormobile")+" "+emailId+" "+mobileNo);
				}
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/updateuser", method = RequestMethod.POST)
	public @ResponseBody
	Response updateUser(@RequestBody UserDto userDto) {
		Response response = new Response();
		try {
			if (userService.updateStatus(userDto) != null) {
				response = ResponseUtil.createResponse(true, SUCCESS,
						userService.updateUser(userDto));
			} else {
				response = ResponseUtil.createResponse(false, FAILED,
						msgProps.get("error.statusupdatefailed"));
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/updateuserisvisible", method = RequestMethod.GET)
	public @ResponseBody
	Response updateUserIsVisibleByUserId(
			@RequestParam(value = "isVisible") Boolean isVisible,
			@RequestParam(value = "userId") Long userId) {
		Response response = new Response();
		try {
			response = ResponseUtil.createResponse(true, SUCCESS,
					userService.updateUserVisibilityById(isVisible, userId));
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/updatemobileno", method = RequestMethod.GET)
	public @ResponseBody
	Response updateMobileNoByUserId(
			@RequestParam(value = "mobileNo") String mobileNo,
			@RequestParam(value = "userId") Long userId) {
		Response response = new Response();
		try {
			response = ResponseUtil.createResponse(true, SUCCESS,
					userService.updateMobileNoByUserId(userId, mobileNo));
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/userlistbyvisibility", method = RequestMethod.GET)
	public @ResponseBody
	Response getUserListByVisibility() {
		Response response = new Response();
		try {
			List<CompleteProfileDto> list = userService
					.getUsersListByVisibility();
			response = ResponseUtil.createResponse(true, SUCCESS, list);

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/uploadprofilepic", method = RequestMethod.POST)
	public @ResponseBody
	Response updateUserProfilePic(@RequestBody String imageStr,
			@RequestParam(value = "userId") Long userId,
			@RequestParam(value = "userName") String userName) {
		if (imageStr != null) {
			try {
				String encodePrefix = "base64,";
				String formatSuffix = imageStr.substring(
						imageStr.indexOf("/") + 1, imageStr.indexOf(";"));
				String crntImage = imageStr.substring((imageStr
						.indexOf(encodePrefix) + encodePrefix.length()));
				byte dearr[] = new BASE64Decoder().decodeBuffer(crntImage);
				File directory = new File(appConfig.getProfileInfo() + "//" + userId + "-" + userName);

				if (!directory.exists()) {
					directory.mkdirs();
				}

				FileOutputStream fos = new FileOutputStream(new File(directory,
						"ProfileImage" + "." + formatSuffix));

				fos.write(dearr);
				fos.close();
				return ResponseUtil.createResponse(true,
						"Successfully uploaded", null);
			} catch (IOException e) {
				e.printStackTrace();
				return ResponseUtil.createResponse(false,
						"Profile pic not uploaded", e);
			}
		}
		return ResponseUtil.createResponse(false, "Profile pic not uploaded",
				null);
	}

	@RequestMapping("getprofilepic")
	public void getProfilePic(@RequestParam("userId") Long userId,
			@RequestParam("folderPath") String folderPath,
			HttpServletResponse response) {
		/*String fileFolderPath = appConfig.getProfileInfo().concat("\\").concat(folderPath);
		String[] files = new File(fileFolderPath)
				.list();// PROFILE_PICS_ROOT_PATH
		String fileName = null;
		for (String fn : files) {
			if (fn.split("\\.")[0].equals("ProfileImage")) {
				fileName = fn.split("\\.")[0] + "." + fn.split("\\.")[1];
			}
		}
		try {
			fileName = (fileName == null) ? "dummy_profile.png" : fileName;
			File file = new File(new File(fileFolderPath), fileName);
			InputStream in = new FileInputStream(file);
			OutputStream os = response.getOutputStream();
			os.write(IOUtils.toByteArray(in));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/

	}

	@RequestMapping(value = "/updateinterviewstatus", method = RequestMethod.GET)
	public @ResponseBody
	Response updateUserInterviewStatusByUserId(
			@RequestParam(value = "userId") Long userId,
			@RequestParam(value = "interviewStatus") String interviewStatus,
			@RequestParam(value = "reShedule") Boolean reShedule,
			@RequestParam(value = "interviewDate") String interviewDate,
			@RequestParam(value = "interviewTiming") String interviewTiming) {
		Response response = new Response();
		
		if (logger.isDebugEnabled()) {
			logger.debug("updateinterviewstatus with data userId[" + userId + "] interviewStatus["+
					interviewStatus+"] reShedule["+reShedule+"] interviewDate["+interviewDate+"] interviewTiming["+interviewTiming+"]");
		}
		
		Date newDate = null;
		if (interviewDate != null) {
			newDate = DateParser.strToDate(interviewDate);
		}
		try {
			response = ResponseUtil.createResponse(true, SUCCESS, userService
					.updateUserInterviewDetailsByUserId(userId,
							interviewStatus, reShedule, newDate,
							interviewTiming));
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/updateuserbybasicinfo", method = RequestMethod.POST)
	public @ResponseBody
	Response updateUserByBasicInfo(@RequestBody UserDto userDto) {
		Response response = new Response();
		try {
			response = ResponseUtil.createResponse(true, SUCCESS,
					userService.updateUserByBasicInfo(userDto));
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/addeducation", method = RequestMethod.POST)
	public @ResponseBody
	Response addEducation(@RequestBody CompleteProfileDto educationsList) {
		Response response = new Response();
		try {
			if (educationsList != null) {
				CompleteProfileDto finalDto = userService
						.createEducationInfo(educationsList.getEducation());
				if (finalDto != null) {
					response = ResponseUtil.createResponse(true, SUCCESS,
							finalDto);
				} else {
					response = ResponseUtil.createResponse(false, FAILED,
							msgProps.get("error.user.edicationdetailssavefailed"));
				}
			} else {
				response = ResponseUtil.createResponse(false, FAILED,
						msgProps.get("error.user.edicationdetailssavefailed"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/updateeducation", method = RequestMethod.POST)
	public @ResponseBody
	Response updateEducation(@RequestBody EducationDto educationDto) {
		Response response = new Response();
		try {
			if (educationDto != null) {
				response = ResponseUtil.createResponse(true, SUCCESS,
						userService.updateEducationInfo(educationDto));
			} else {
				response = ResponseUtil.createResponse(false, FAILED,
						msgProps.get("error.user.edicationdetailsupdatefailed"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/deleteeducation")
	public @ResponseBody
	Response deleteEducation(@RequestParam(value = "userId") Long userId,
			@RequestParam(value = "eduType") String eduType) {
		Response response = new Response();
		int result;
		try {

			result = userService.deleteEducationInfoByUserIdAndType(userId,
					eduType);
			if (result > 0) {
				response = ResponseUtil.createResponse(true, SUCCESS,
						msgProps.get("succes.user.edicationdetailsdeletesuccess"));
			} else {
				response = ResponseUtil.createResponse(false, FAILED,
						msgProps.get("error.user.edicationdetailsdeletefailed"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/updateaddress", method = RequestMethod.POST)
	public @ResponseBody
	Response addAddress(@RequestBody AddressDto addressDto) {
		Response response = new Response();
		try {
			if (addressDto != null) {

				AddressDto finalAddressDto = userService
						.createAddressInfo(addressDto);
				if (finalAddressDto != null) {
					response = ResponseUtil.createResponse(true, SUCCESS,
							finalAddressDto);
				} else {
					response = ResponseUtil.createResponse(false, FAILED,
							msgProps.get("error.user.addresscreationfailed"));
				}
			} else {
				response = ResponseUtil.createResponse(false, FAILED,
						msgProps.get("error.user.addresscreationfailed"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}
	@RequestMapping(value = "/getcitylist", method = RequestMethod.GET)
	public @ResponseBody Response getCityList(){
		Response response = new Response();
		try{
			response = ResponseUtil.createResponse(true, SUCCESS, userService.getCityList());
		}
		catch(ServiceException ex){
			response = ResponseUtil.createResponse(false, FAILED, ex.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/getstatelist", method = RequestMethod.GET)
	public @ResponseBody Response getStateList(){
		Response response = new Response();
		try{
			response = ResponseUtil.createResponse(true, SUCCESS, userService.getStateList());
		}
		catch(ServiceException ex){
			response = ResponseUtil.createResponse(false, FAILED, ex.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/getcountrylist", method = RequestMethod.GET)
	public @ResponseBody Response getCountryList(){
		Response response = new Response();
		try{
			response = ResponseUtil.createResponse(true, SUCCESS, userService.getCountryList());
		}
		catch(ServiceException ex){
			response = ResponseUtil.createResponse(false, FAILED, ex.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/addproject", method = RequestMethod.POST)
	public @ResponseBody
	Response addProject(@RequestBody CompleteProfileDto projectsList) {
		Response response = new Response();
		try {
			if (projectsList != null) {
				response = ResponseUtil
						.createResponse(true, SUCCESS, userService
								.createProjectInfo(projectsList.getProject()));
			} else {
				response = ResponseUtil.createResponse(false, FAILED,
						msgProps.get("error.user.projectdetailssavefailed"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/updateproject", method = RequestMethod.POST)
	public @ResponseBody
	Response updateProject(@RequestBody ProjectDto projectDto) {
		Response response = new Response();
		try {
			if (projectDto != null) {
				response = ResponseUtil.createResponse(true, SUCCESS,
						userService.updateProjectInfo(projectDto));
			} else {
				response = ResponseUtil.createResponse(false, FAILED,
						msgProps.get("error.user.projectdetailsupdatefailed"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/deleteproject")
	public @ResponseBody
	Response deleteProject(@RequestParam(value = "userId") Long userId,
			@RequestParam(value = "projectName") String projectName) {
		Response response = new Response();
		int result;
		try {
			result = userService.deleteProjectByUserIdAndProjectName(userId,
					projectName);
			if (result > 0) {
				response = ResponseUtil.createResponse(true, SUCCESS,
						msgProps.get("success.user.projectdetailsdeletesuccess"));
			} else {
				response = ResponseUtil.createResponse(false, FAILED,
						msgProps.get("error.user.projectdetailsdeletefailed"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/getprojectdomainlist", method = RequestMethod.GET)
	public @ResponseBody
	Response getProjectDomainList() {
		Response response = new Response();
		try {
			List<ProjectDomainDto> projectdomain = userService.getProjectDomainList();
			if (projectdomain!= null) {
				response = ResponseUtil.createResponse(true, SUCCESS,projectdomain);
			} else {
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.projectdomain.failed"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/technologieslist", method = RequestMethod.GET)
	public @ResponseBody
	Response getAllTechnologies() {
		Response response = new Response();
		try {
			List<TechnologiesDto> technologiesDto = userService.getAllTechnologiesList();
			if (technologiesDto!= null) {
				response = ResponseUtil.createResponse(true, SUCCESS,technologiesDto);
			} else {
				response = ResponseUtil.createResponse(false, FAILED,
						msgProps.get("error.technologies.failed"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/addskills", method = RequestMethod.POST)
	public @ResponseBody
	Response addTechSkills(@RequestBody CompleteProfileDto skills) {
		Response response = new Response();
		try {
			if (skills!= null) {
				response = ResponseUtil.createResponse(true, SUCCESS,
						userService.createTechSkillRecord(skills.getSkill()));
			} else {
				response = ResponseUtil.createResponse(false, FAILED,
						msgProps.get("error.skills.creationfailed"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/techskillsbyuserid", method = RequestMethod.GET)
	public @ResponseBody
	Response getTechSkillsListByUserId(@RequestParam("userId") Long userId) {
		Response response = new Response();
		try {
			List<TechSkillDto> techSkillsList = userService.getTechSkillRecordsByUserId(userId);
			if (techSkillsList != null) {
				response = ResponseUtil.createResponse(true, SUCCESS,
						techSkillsList);
			} else {
				response = ResponseUtil.createResponse(false, FAILED,
						msgProps.get("error.technical.skills.notavaiable"));
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/languageslist", method = RequestMethod.GET)
	public @ResponseBody
	Response getAllLanguagesList() {
		Response response = new Response();
		try {
			List<LanguagesDto> languageslist= userService.getAllLanguagesList();
			if (languageslist!= null) {
				response = ResponseUtil.createResponse(true, SUCCESS,languageslist);
			} else {
				response = ResponseUtil.createResponse(false, FAILED,
						msgProps.get("error.languages.retrievefailed"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}
	@RequestMapping(value = "/completedata", method = RequestMethod.GET)
	public @ResponseBody
	Response getUserCompleteInfo(@RequestParam(value = "userId") Long userId) {
		Response response = new Response();
		try {
			if (userId != null) {
				response = ResponseUtil.createResponse(true, SUCCESS,
						userService.getCompleteProfile(userId));
			} else {
				response = ResponseUtil.createResponse(false, FAILED,
						msgProps.get("error.completeprofile.usernotavalable"));
			}
			if(logger.isDebugEnabled()){
				logger.debug(msgProps.get("error.completeprofile.failed"),userId);
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "roles", method = RequestMethod.GET)
	public @ResponseBody
	Response getAllRoles(HttpServletRequest request) {
		Response response = null;
		try {
			response = ResponseUtil.createResponse(true, SUCCESS,
					userService.getAllRoles());
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, e.getMessage(), e);
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "updatestatusandrole", method = RequestMethod.POST)
	public @ResponseBody
	Response updateStatusAndRoleForUsers(
			@RequestBody Map<String, Object> requestData) {
		List<Integer> userIds = (List<Integer>) requestData.get("userIds");
		Integer selectedRoleId = (Integer) requestData.get("selectedRole");
		String statusString = (String) requestData.get("status");
		Response response = new Response();
		try {
			response = ResponseUtil.createResponse(true, SUCCESS, userService
					.updateStatusAndRoleForUsers(userIds, selectedRoleId,
							statusString));
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "activation", method = RequestMethod.GET)
	public String getTrainingProfileById(
			@RequestParam("id") String decriptedId,
			@RequestParam("roleId") Long roleId, HttpServletRequest request) {
		try {
			byte[] data = new BASE64Decoder().decodeBuffer(decriptedId);
			userService.activateUserStatusById(
					Long.parseLong(new String(data)), roleId);
		} catch (ServiceException e) {
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:../#/home.html";
	}

	private String getHostUrl(HttpServletRequest request) {
		String serverName = request.getServerName();
		String applicationName = request.getContextPath();

		String base_url = "http://" + serverName;
		if (!serverName.contains("www")) {
			base_url = base_url + ":" + request.getServerPort();
		}
		return base_url + applicationName;
	}

	@RequestMapping(value = "/addreferral", method = RequestMethod.POST)
	public @ResponseBody
	Response addRefferal(@RequestBody ReferralDto referralDto) {
		Response response = new Response();
		try {
			if (referralDto != null) {
				response = ResponseUtil.createResponse(true, SUCCESS,
						userService.createReferral(referralDto));
			} else {
				response = ResponseUtil.createResponse(false, FAILED,
						"Referral is not created");
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/addreferrals", method = RequestMethod.POST)
	public @ResponseBody
	Response addRefferalRecords(@RequestBody List<ReferralDto> referralData) {
		Response response = new Response();
		try {
			System.out.println(referralData);
			response = ResponseUtil.createResponse(true, SUCCESS,
					userService.addReferralData(referralData));
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/referralslist", method = RequestMethod.GET)
	public @ResponseBody
	Response getRefferenceListByUserId(@RequestParam("userId") Long userId) {
		Response response = new Response();
		try {
			List<ReferralDto> referralsList = userService
					.getReferralsByUserId(userId);
			if (referralsList != null) {
				response = ResponseUtil.createResponse(true, SUCCESS,
						referralsList);
			} else {
				response = ResponseUtil.createResponse(false, FAILED,
						msgProps.get("error.referals.notavaiable"));
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/addsupport", method = RequestMethod.POST)
	public @ResponseBody
	Response addSupport(@RequestBody SupportDto supportDto) {
		Response response = new Response();
		try {
			if (supportDto != null) {
				response = ResponseUtil.createResponse(true, SUCCESS,
						userService.createSupport(supportDto));
			} else {
				response = ResponseUtil.createResponse(false, FAILED,
						msgProps.get("error.supportcreationfailed"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/supportslist", method = RequestMethod.GET)
	public @ResponseBody
	Response getSupportsList() {
		Response response = new Response();
		try {
			List<SupportDto> list = userService.getAllSupportsList();
			response = ResponseUtil.createResponse(true, SUCCESS, list);

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/placementslist", method = RequestMethod.GET)
	public @ResponseBody
	Response getPlacementsList() {
		Response response = new Response();
		try {
			List<PlacementsDto> list = userService.getPlacementsList();
			response = ResponseUtil.createResponse(true, SUCCESS, list);

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/sms", method = RequestMethod.GET)
	public @ResponseBody
	Response sendSmsToUser(@RequestParam(value = "smsData") String smsData,
			@RequestParam(value = "mobileNo") String mobileNo) {
		Response response = new Response();
		SMSThread smsThread = new SMSThread(smsData, mobileNo);
		Thread smsth = new Thread(smsThread);
		smsth.start();
		response = ResponseUtil.createResponse(true, SUCCESS,
				msgProps.get("success.smssent"));
		return response;
	}

	@RequestMapping(value = "/smstousers", method = RequestMethod.POST)
	public @ResponseBody
	Response sendSmsToUsers(@RequestBody MessageDto messageDto) {
		Response response = new Response();
		if (messageDto.getMobileNo() != null) {
			response = ResponseUtil.createResponse(
					true,
					SUCCESS,
					SMSUtil.sendSMS(messageDto.getMobileNo(),
							messageDto.getMessage()));
		}
		if (messageDto.getEmailIds() != null) {
			String mailContent = new MailContentUtil()
					.sendMailToUser(messageDto.getFilePath());
			for (int i = 0; i < messageDto.getEmailIds().size(); i++) {
				MailThread mailThread = new MailThread(messageDto.getEmailIds()
						.get(i), msgProps.get("email.registration.subject"), mailContent);
				Thread t = new Thread(mailThread);
				t.start();
				// int value =new
				// SendMailUtil().sendMail(messageDto.getEmailIds().get(i),"Pioneer Coders Registration.",mailContent);
			}
		}
		return response;
	}

	@RequestMapping(value = "/subscribe", method = RequestMethod.GET)
	public @ResponseBody
	Response saveSubscriberEmail(
			@RequestParam("subscriberEmail") String subscriberEmail) {
		Response response = new Response();
		SubscribeDto dto = new SubscribeDto();
		dto.setSubscriberEmail(subscriberEmail);
		try {
			response = ResponseUtil.createResponse(true, SUCCESS,
					userService.createSubscriberInfo(dto));
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/mail", method = RequestMethod.GET)
	public @ResponseBody
	Response sendMailToUser(@RequestParam(value = "emailId") String emailId,
			@RequestParam(value = "filePath") String filePath) {
		Response response = new Response();
		String content = new MailContentUtil().sendMailToUser(filePath);
		MailThread mailThread = new MailThread(emailId,
				msgProps.get("email.invitation.subject"), content);
		Thread t = new Thread(mailThread);
		t.start();
		// int value =new SendMailUtil().sendMail(emailId,
		// "Invitation From Pioneercoders", content);

		return response;
	}

	@RequestMapping(value = "/uploadresume", method = RequestMethod.POST)
	public @ResponseBody
	Response uploadResume(@RequestParam(value = "file") MultipartFile file,
			@RequestParam(value = "folderName") String folderName,
			@RequestParam(value = "name") String fileName) {
		Response response = null;
		try {
			File directory = new File(String.valueOf(appConfig.getProfileInfo()));
			String directoryName = appConfig.getProfileInfo().concat("\\" + folderName);
			directory = new File(String.valueOf(directoryName));
			if (!directory.exists()) {
				directory.mkdir();
			}
			// String[] fileNameArray = file.getOriginalFilename().split("\\.");

			/*
			 * for (File fileData : files) { if
			 * (fileData.getName().equals("Resume")) { fileData.delete(); byte[]
			 * bytes = file.getBytes(); Path path = Paths.get(directoryName +
			 * "\\" +fileName); Files.write(path, bytes); } }
			 */

			byte[] bytes = file.getBytes();
			Path path = Paths.get(directoryName + "\\" + fileName);
			Files.write(path, bytes);
			response = ResponseUtil.createResponse(true, SUCCESS,
					msgProps.get("success.resumeuploaded"));
		} catch (IOException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		} catch (Exception e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}

		return response;
	}

	@RequestMapping(value = "/uploadvedio", method = RequestMethod.POST)
	public @ResponseBody
	Response uploadIntroductionVedio(
			@RequestParam(value = "file") MultipartFile file,
			@RequestParam(value = "folderName") String folderName,
			@RequestParam(value = "name") String fileName) {
		Response response = null;
		try {
			File directory = new File(String.valueOf(appConfig.getProfileInfo()));
			if (!directory.exists()) {
				directory.mkdir();
			}
			String directoryName = appConfig.getProfileInfo().concat("\\" + folderName);
			directory = new File(String.valueOf(directoryName));
			if (!directory.exists()) {
				directory.mkdir();
			}

			byte[] bytes = file.getBytes();
			Path path = Paths.get(directoryName + "\\" + fileName);
			Files.write(path, bytes);
			response = ResponseUtil.createResponse(true, SUCCESS,
					msgProps.get("success.videouploaded"));
		} catch (IOException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		} catch (Exception e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}

		return response;
	}

	@RequestMapping(value = "/addsocialinfo", method = RequestMethod.POST)
	public @ResponseBody
	Response addSocialInfo(@RequestBody SocialInfoDto socialInfoDto) {
		Response response = new Response();
		try {
			if (socialInfoDto != null) {
				SocialInfoDto finalSocialInfoDto = userService
						.createSocialInfo(socialInfoDto);
				if (finalSocialInfoDto != null) {
					response = ResponseUtil.createResponse(true, SUCCESS,
							finalSocialInfoDto);
				} else {
					response = ResponseUtil.createResponse(false, FAILED,
							msgProps.get("error.socialinfofailed"));
				}
			} else {
				response = ResponseUtil.createResponse(false, FAILED,
						msgProps.get("error.socialinfofailed"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/updatesocialinfo", method = RequestMethod.POST)
	public @ResponseBody
	Response updateEducation(@RequestBody SocialInfoDto socialInfoDto) {
		Response response = new Response();
		try {
			if (socialInfoDto != null) {
				response = ResponseUtil.createResponse(true, SUCCESS,
						userService.updateSocialInfo(socialInfoDto));
			} else {
				response = ResponseUtil.createResponse(false, FAILED,
						msgProps.get("error.socialinfo.updatefailed"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/addemployerinfo", method = RequestMethod.POST)
	public @ResponseBody
	Response addWorkExpInfo(@RequestBody CompleteProfileDto employersInfo) {
		Response response = new Response();
		try {
			if (employersInfo != null) {
				CompleteProfileDto finalDto = userService
						.createEmployersInfo(employersInfo.getEmployersInfo());
				if (finalDto != null) {
					response = ResponseUtil.createResponse(true, SUCCESS,
							finalDto);
				} else {
					response = ResponseUtil.createResponse(false, FAILED,
							msgProps.get("error.employer.creationfailed"));
				}
			} else {
				response = ResponseUtil.createResponse(false, FAILED,
						msgProps.get("error.employer.creationfailed"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/deleteemployerinfo")
	public @ResponseBody
	Response deleteWorkExp(@RequestParam(value = "userId") Long userId,
			@RequestParam(value = "empType") String empType) {
		Response response = new Response();
		int result;
		try {
			result = userService.deleteEmployerInfoByUserIdAndType(userId, empType);
			if (result > 0) {
				response = ResponseUtil.createResponse(true, SUCCESS,
						msgProps.get("success.employer.deletionsuccess"));
			} else {
				response = ResponseUtil.createResponse(false, FAILED,
						msgProps.get("error.employer.deletionfailed"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/updateemployerinfo", method = RequestMethod.POST)
	public @ResponseBody
	Response updateEducation(@RequestBody EmployersInfoDto employersInfo) {
		Response response = new Response();
		try {
			if (employersInfo != null) {
				response = ResponseUtil.createResponse(true, SUCCESS,
						userService.updateEmployersInfo(employersInfo));
			} else {
				response = ResponseUtil.createResponse(false, FAILED,
						msgProps.get("error.employer.updatefailed"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/userslistbyuserids", method = RequestMethod.POST)
	public @ResponseBody
	Response getUsersList(@RequestBody ArrayList<Integer> userIds) {
		Response response = new Response();
		try {
			if (userIds.size() > 0) {
				List<UserDto> usersList = userService.getUsersListData(userIds);
				if (usersList != null) {
					response = ResponseUtil.createResponse(true, SUCCESS,
							usersList);
				} else {
					response = ResponseUtil.createResponse(false, FAILED,
							msgProps.get("error.userlistnotavailabel"));
				}
			} else {
				response = ResponseUtil.createResponse(false, FAILED,
						msgProps.get("error.userlistnotavailabel"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/sendsms", method = RequestMethod.POST)
	public @ResponseBody
	Response sendSMS(@RequestBody ShortListedProfileDto shortListedProfileDto) {
		Response response = new Response();
		SMSThread smsThread = new SMSThread(shortListedProfileDto.getMessage(),
				shortListedProfileDto.getMobileNo());
		Thread smsth = new Thread(smsThread);
		smsth.start();
		// String result = SMSUtil.sendSMS(shortListedProfileDto.getMessage(),
		// shortListedProfileDto.getMobileNo());
		/*
		 * if(result!=null){ response = ResponseUtil.createResponse(true,
		 * "success",result); }else{ response =
		 * ResponseUtil.createResponse(true, "failed","not yet sended sms"); }
		 */

		return response;

	}

	@RequestMapping(value = "/sendmail", method = RequestMethod.POST)
	public @ResponseBody
	Response sendMail(@RequestBody ShortListedProfileDto profileDto) {
		Response response = new Response();
		String mailContent = new MailContentUtil()
				.sendMailToProfileUser(profileDto);
		MailThread mailThread = new MailThread(profileDto.getEmailId(),
				msgProps.get("email.pchrportal.subject"), mailContent);
		Thread t = new Thread(mailThread);
		t.start();
		// int value = new
		// SendMailUtil().sendMail(profileDto.getEmailId(),"PC HR Portal ",mailContent);
		response = ResponseUtil.createResponse(true, SUCCESS,
				msgProps.get("email.sendsuccss"));
		return response;

	}
	
	@RequestMapping(value = "/addbasicinfo", method = RequestMethod.POST)
	public @ResponseBody
	Response addBasicInfo(@RequestBody ProfileWithLanguageDto profileWithLanguages) {
		Response response = new Response();
		try {
			if (profileWithLanguages != null) {
				response = ResponseUtil.createResponse(true, SUCCESS,
						userService.createUserBasicInfo(profileWithLanguages));
			} else {
				response = ResponseUtil.createResponse(false, FAILED,
						msgProps.get("error.basicinfo.creationfailed"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

/*	@RequestMapping(value = "/updatebasicinfo", method = RequestMethod.POST)
	public @ResponseBody
	Response updateUserBasicInfo(@RequestBody UserBasicInfoDto userBasicInfoDto) {
		Response response = new Response();
		try {
			if (userBasicInfoDto != null) {
				response = ResponseUtil.createResponse(true, "success",
						userService.updateUserBasicInfo(userBasicInfoDto));
			} else {
				response = ResponseUtil.createResponse(false, "failed",
						"UserBasicInfo details is updated successfully...");
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, "failed",
					e.getMessage());
		}
		return response;
	}*/

	@RequestMapping(value = "/downloadresumes/{directory}/{document}/{fileFormate}")
	public void downloadResumes(HttpServletResponse response,
			@PathVariable(value = "directory") String directoryName,
			@PathVariable(value = "document") String documentName,
			@PathVariable(value = "fileFormate") String fileFormate)
			throws IOException {
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ documentName + "." + fileFormate);
		java.io.File file = new File(appConfig.getProfileInfo() + "/" + directoryName + "/"
				+ documentName + "." + fileFormate);
		FileInputStream fileIn = new FileInputStream(file);
		ServletOutputStream out = response.getOutputStream();

		byte[] outputByte = new byte[(int) file.length()];
		while (fileIn.read(outputByte, 0, (int) file.length()) != -1) {
			out.write(outputByte, 0, (int) file.length());
		}
		fileIn.close();
	}

	@RequestMapping(value = "/addexperianceinfo", method = RequestMethod.POST)
	public @ResponseBody
	Response addExpectationInfo(@RequestBody UserExperianceDto userExperianceDto) {
		Response response = new Response();
		try {
			if (userExperianceDto != null) {
				response = ResponseUtil.createResponse(true, SUCCESS,
						userService.createUserExperianceInfo(userExperianceDto));
			} else {
				response = ResponseUtil.createResponse(false, FAILED,
						msgProps.get("error.experince.creationfailed"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/getUsersBySalaryRange", method = RequestMethod.POST)
	public @ResponseBody
	Response getUsersBySalaryRange(@RequestBody UserExperianceDto userExperianceDto) {
		Response response = new Response();
		try {
			if (userExperianceDto != null) {
				String curentSalary = userExperianceDto.getCurentSalaryInLakhs();
				response = ResponseUtil.createResponse(true, SUCCESS,
						userService.getUsersBySalaryRange(curentSalary));
			} else {
				response = ResponseUtil.createResponse(false, FAILED,
						msgProps.get("error.users.salaryrange"));
			}


		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/getUsersByQualification", method = RequestMethod.POST)
	public @ResponseBody
	Response getUsersByQualification(@RequestBody EducationEntity educationEntity) {
		Response response = new Response();
		try {
			if (educationEntity != null) {
				String qualification = educationEntity.getEducationType();
				response = ResponseUtil.createResponse(true, SUCCESS,
						userService.getUsersByQualification(qualification));
			} else {
				response = ResponseUtil.createResponse(false, FAILED,
						msgProps.get("error.users.qualification"));
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/getusersbypercentage", method = RequestMethod.POST)
	public @ResponseBody
	Response getUsersByPercentage(@RequestBody EducationEntity educationEntity) {
		Response response = new Response();
		try {
			if (educationEntity != null) {
				Float percentage = educationEntity.getPercentage();
				response = ResponseUtil.createResponse(true, SUCCESS,
						userService.getUsersBypercentage(percentage));
			} else {
				response = ResponseUtil.createResponse(false, FAILED,
						msgProps.get("error.users.percentage"));
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}
	
	
	@RequestMapping(value = "/getinstitutelist", method = RequestMethod.GET)
	public @ResponseBody
	Response getInstituteList() {
		Response response = new Response();
		try {
				response = ResponseUtil.createResponse(true, SUCCESS,
						userService.getInstituteList());
			}
		 catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/getuniversitylist", method = RequestMethod.GET)
	public @ResponseBody
	Response getUniversityList() {
		Response response = new Response();
		try {
				response = ResponseUtil.createResponse(true, SUCCESS,
						userService.getUniversityList());
			}
		 catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}
	
	
	@RequestMapping(value = "/updateexperianceinfo", method = RequestMethod.POST)

	public @ResponseBody
	Response updateExpectationsInfo(@RequestBody UserExperianceDto userExperianceDto) {
		Response response = new Response();
		try {
			if (userExperianceDto != null) {
				response = ResponseUtil.createResponse(true, SUCCESS,
						userService.updateUserExperianceInfo(userExperianceDto));
			} else {
				response = ResponseUtil.createResponse(false, FAILED,
						msgProps.get("error.user.experience.updatefailed"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/getuserslistbyrole", method = RequestMethod.GET)
	public @ResponseBody
	Response getUsersListByRole() {
		Response response = new Response();
		try {
			List<CompleteProfileDto> finalData = userService.getUsersListByRole();
			if (finalData != null) {
				response = ResponseUtil.createResponse(true, SUCCESS,
						finalData);
			} else {
				response = ResponseUtil.createResponse(false, FAILED,
						msgProps.get("error.userslist.byrole.notavailable"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/changepassword")
	public String getChangePasswordPage() {
		return "user/checkeEmailIdPage";
	}

	@RequestMapping(value = "/forgetpassword", method = RequestMethod.GET)
	public @ResponseBody
	Response sendTemplateToUser(@RequestParam(value = "emailId") String emailId,HttpServletRequest request) {
		String url = getHostUrl(request) + "/user/generatepassword";
		Response response = new Response();
		String mailContent = new MailContentUtil().sendMailForForgetPassword(
				emailId, url);
		MailThread mailThread = new MailThread(emailId, msgProps.get("email.forgotpwd.subject"),
				mailContent);
		Thread t = new Thread(mailThread);
		t.start();
		/*
		 * int value = new
		 * SendMailUtil().sendMail(emailId,"From Pioneercoders .",mailContent);
		 * if(value>0){ response = ResponseUtil.createResponse(true,
		 * "success","mail Sent successfully"); }else{ response =
		 * ResponseUtil.createResponse(true,
		 * "failed","mail is failed due to network"); }
		 */
		return response;
	}

	@RequestMapping(value = "/generatepassword")
	public String getGeneratePage(
			@RequestParam(value = "emailId") String emailId) {
		return "user/generatePassword";
	}

	@RequestMapping(value = "/updatepassword", method = RequestMethod.POST)
	public @ResponseBody
	Response updatePasswordByEmailId(@RequestBody UserDto useDto) {
		Response response = new Response();
		try {
			int resultData = userService.updateUserPasswordByEmailId(
					useDto.getEmailId(), useDto.getPassword());
			if (resultData > 0) {
				response = ResponseUtil.createResponse(true, SUCCESS,
						resultData);
			} else {
				response = ResponseUtil.createResponse(true, SUCCESS,
						resultData);
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	
	/*
	 * @RequestMapping(value="totalexpbydates", method=RequestMethod.POST)
	 * 
	 * @ResponseBody public Response getTotaExpDate(@RequestParam("startDate")
	 * String startDate,@RequestParam("endDate") String endDate){ Response
	 * response = new Response(); try{ response =
	 * ResponseUtil.createResponse(true, "success",
	 * userService.getTotalExpeAmountByDate(startDate, endDate));
	 * 
	 * }catch(ServiceException e){ response = ResponseUtil.createResponse(false,
	 * "failed", e.getMessage()); } return response; }
	 */

	@RequestMapping("selfintroductionvedio")
	public void getSelfIntroductionVedio(
			@RequestParam("vedioPath") String vedioPath,
			@RequestParam("folderPath") String folderPath,
			HttpServletResponse response) {
		String finalFolder = appConfig.getProfileInfo().concat("\\").concat(folderPath);
		String[] files = new File(finalFolder).list();// PROFILE_PICS_ROOT_PATH
		String fileName = null;
		for (String fn : files) {
			if (fn.split("\\.")[0].equals(vedioPath.split("\\.")[0])) {
				fileName = fn.split("\\.")[0] + "." + fn.split("\\.")[1];
			}
		}
		try {
			File file = new File(new File(finalFolder), fileName);
			InputStream in = new FileInputStream(file);
			OutputStream os = response.getOutputStream();
			os.write(IOUtils.toByteArray(in));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping("getresume")
	public void getViewResume(@RequestParam("resumePath") String resumePath,
			@RequestParam("folderPath") String folderPath,
			HttpServletResponse response) {
		System.out.println(resumePath);
		String finalFolder = appConfig.getProfileInfo().concat("\\").concat(folderPath);
		String[] files = new File(finalFolder).list();// PROFILE_PICS_ROOT_PATH
		String fileName = null;
		response.setContentType("application/pdf");
		for (String fn : files) {
			if (fn.split("\\.")[0].equals(resumePath.split("\\.")[0])) {
				fileName = fn.split("\\.")[0] + "." + fn.split("\\.")[1];
			}
		}
		try {
			File file = new File(new File(finalFolder), fileName);
			InputStream in = new FileInputStream(file);
			OutputStream os = response.getOutputStream();
			os.write(IOUtils.toByteArray(in));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	@RequestMapping(value = "/getuserslistbysearchpreference", method = RequestMethod.POST)
	public @ResponseBody
	Response getuserslistbysearchpreference(@RequestBody UserSearchDto usersearchdto) {
		Response response = new Response();
		try {
			System.out.println(usersearchdto.getAddress().getCity().getId());
			List<UserSearchResultsDto> usersearchresultsdto = userService.getuserslistbysearchpreference(usersearchdto);
			if (usersearchresultsdto != null) {
				response = ResponseUtil.createResponse(true, SUCCESS, 
						usersearchresultsdto);
			} else {
				response = ResponseUtil.createResponse(false, FAILED,
						"No Records Found");
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}
	
}
