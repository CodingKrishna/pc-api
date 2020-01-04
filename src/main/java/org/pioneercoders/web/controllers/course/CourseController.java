package org.pioneercoders.web.controllers.course;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.pioneercoders.dto.course.BatchTimingDto;
import org.pioneercoders.dto.course.CourseDto;
import org.pioneercoders.dto.response.Response;
import org.pioneercoders.dto.student.PurchasedCourseDto;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.course.CourseService;
import org.pioneercoders.utils.AppConfig;
import org.pioneercoders.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/course")
public class CourseController {
	
	private static final String FAILED = "failed";

	private static final String SUCCESS = "success";

	@Resource(name = "msgProps")
	private Map<String, String> msgProps;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	AppConfig appConfig;
	
	@RequestMapping(value = "/courselist", method = RequestMethod.GET)
	public @ResponseBody Response getAllCourses(@RequestParam(value = "featured", required = false) boolean featuredCourses) {
		Response response = new Response();
		try {
			List<CourseDto> courseList= courseService.getAllCourses(featuredCourses);
			if(courseList!=null){
				response = ResponseUtil.createResponse(true, SUCCESS,courseList);
			} else{
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.course.courselist"));
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/courseinfo/{courseId}", method = RequestMethod.GET)
	public @ResponseBody Response getCourse(@PathVariable("courseId") Long courseId) {
		Response response = new Response();
		try {
			CourseDto courseDto = courseService.getCourseInfo(courseId);
			if(courseDto!=null){
				response = ResponseUtil.createResponse(true, SUCCESS,courseDto);
			} else{
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.course.courseinfobycourseid")+courseId);
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="getimage/{directory}/{fileName}/{format}")
	public void getImage(HttpServletResponse response,
			@PathVariable(value = "fileName") String fileName,
			@PathVariable(value = "directory") String directory,
			@PathVariable(value = "format") String format){
		try {
			File f = new File((appConfig.getCoursesDirectory()+ "\\" + directory +"\\"), (fileName + "." + format));
			
			InputStream in = new FileInputStream(f);
			OutputStream os = response.getOutputStream();
			os.write(IOUtils.toByteArray(in));
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/batchdetails", method = RequestMethod.GET)
	public @ResponseBody Response getAllBatchDetailsByCourseId(@RequestParam("courseId") Long courseId) {
		Response response = new Response();
		try {
			List<BatchTimingDto> batchTimingsList= courseService.getBatchTimingDetailsByCourseId(courseId);
			if(batchTimingsList!=null){
				response = ResponseUtil.createResponse(true, SUCCESS,batchTimingsList);
				System.out.println(batchTimingsList);
			} else{
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.course.batchdetailsbycourseid")+courseId);
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/addpurchaseddetails", method = RequestMethod.POST)
	public @ResponseBody Response addInstructor(@RequestBody PurchasedCourseDto purchasedCourseDto) {
		Response response = new Response();
		try {
			PurchasedCourseDto purchasedCourseDtoData = courseService.createPurchasedCourseRecord(purchasedCourseDto);
			if(purchasedCourseDtoData!=null){
				response = ResponseUtil.createResponse(true, SUCCESS,purchasedCourseDtoData);
			} else{
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.course.purchaseddetailscreationfailed"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/purchasedcourses", method = RequestMethod.GET)
	public @ResponseBody Response getPurchasedCoursesListByUserId(@RequestParam("userId") Long userId) {
		Response response = new Response();
		try {
			List<PurchasedCourseDto> purchasedCoursesList= courseService.getPurchasedCoursesByUserId(userId);
			if(purchasedCoursesList!=null){
				response = ResponseUtil.createResponse(true, SUCCESS,purchasedCoursesList);
			} else{
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.course.purchaseddetailslist"));
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}
}
