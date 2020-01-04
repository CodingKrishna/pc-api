package org.pioneercoders.web.controllers.hr;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.pioneercoders.dto.hr.CompanyDto;
import org.pioneercoders.dto.hr.JobInfoDto;
import org.pioneercoders.dto.hr.JobInfoTrnDto;
import org.pioneercoders.dto.response.Response;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.hr.CompanyService;
import org.pioneercoders.services.hr.JobInfoService;
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
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/job")
public class JobInfoController {
	
	private static final String FAILED = "failed";

	private static final String SUCCESS = "success";
	
	private static final Logger log = LoggerFactory.getLogger(JobInfoController.class);
	
	@Autowired
	JobInfoService jobInfoService;
	
	@Autowired
	CompanyService companyService;
	
	@Resource(name = "msgProps")
	private Map<String, String> msgProps;
	
	String PATH = "D:/PCHRPORTAL";
	/**
	 * Method used to save posted job's information.
	 * 
	 * @param jobInfoEntity
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/createjob", method = RequestMethod.POST)
	public @ResponseBody Response saveJobInfo(@RequestBody JobInfoDto jobInfoDto) {
		Response response = new Response();
		try {
			JobInfoDto finalJobInfoDto = jobInfoService.createJobInfoRecord(jobInfoDto);
			if(finalJobInfoDto!=null){
				response = ResponseUtil.createResponse(true, SUCCESS,finalJobInfoDto);
			} else{
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.job.creationfailed"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}
	
	/**
	 * Method used to get list of job's information.
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/getjobs", method = RequestMethod.GET)
	public @ResponseBody  Response getJobsListByHrId(@RequestParam(value="hrId")Long hrId) {
		Response response = new Response();
		try {
			List<JobInfoDto> list = jobInfoService.getAllJobsByHrId(hrId);
			if(list!=null){
				response = ResponseUtil.createResponse(true, SUCCESS,list);
			} else{
				response = ResponseUtil.createResponse(false, FAILED,msgProps.get("error.job.listbyhrid"));
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}
	
	/**
	 * Method used to update posted job's information.
	 * 
	 * @param jobInfoEntity
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/updatejob", method = RequestMethod.POST)
	public @ResponseBody Response updateJobInfo(@RequestBody JobInfoDto jobInfoDto) {
		Response response = new Response();
		try {
			JobInfoDto finalJobInfoDto = jobInfoService.updateJobInfo(jobInfoDto);
			if(finalJobInfoDto!=null){
				response = ResponseUtil.createResponse(true, SUCCESS,finalJobInfoDto);
			} else{
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.job.updatefailed"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}
	
	/**
	 * Method used to save posted company's information.
	 * 
	 * @param jobInfoEntity
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/createcompany", method = RequestMethod.POST)
	public @ResponseBody Response saveCompanyInfo(@RequestBody CompanyDto companyDto) {
		Response response = new Response();
		try {
			CompanyDto finalCompanyDto = companyService.createCompanyRecord(companyDto);
			if(finalCompanyDto!=null){
				response = ResponseUtil.createResponse(true, SUCCESS,finalCompanyDto);
			} else{
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.company.creationfailed"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}
	
	/**
	 * Method used to get list of job's information.
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/getcompanies", method = RequestMethod.GET)
	public @ResponseBody  Response getCompaniesList() {
		Response response = new Response();
		try {
			List<CompanyDto> list = companyService.getAllCompaniesList();
			if(list!=null){
				response = ResponseUtil.createResponse(true, SUCCESS,list);
			} else{
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.company.companieslist"));
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}

	@RequestMapping(value="/createjobtrn", method = RequestMethod.POST)
	public @ResponseBody Response saveJobInfoTrn(@RequestBody JobInfoTrnDto jobInfoTrnDto) {
		Response response = new Response();
		try {
			JobInfoTrnDto finalJobInfoTrnDto = jobInfoService.createJobInfoTrnRecord(jobInfoTrnDto);
			if(finalJobInfoTrnDto!=null){
				response = ResponseUtil.createResponse(true, SUCCESS,finalJobInfoTrnDto);
			} else{
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.jobtrn.creationfailed"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}
	
	/**
	 * Method used to get list of job's information.
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/getstudentsbyjobid", method = RequestMethod.GET)
	public @ResponseBody  Response getJobTrnListByJobId(@RequestParam(value="jobId")Long jobId) {
		Response response = new Response();
		try {
			List<JobInfoTrnDto> list = jobInfoService.getJobInfoTrnListByJobId(jobId);
			if(list!=null){
				response = ResponseUtil.createResponse(true, SUCCESS,list);
			} else{
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.jobtrn.jobtrninfolistfailed"));
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="uploadcompanyimg", method = RequestMethod.POST)
	public @ResponseBody Response uploadTask(
			@RequestParam(value="file") MultipartFile file,
			@RequestParam(value="name") String fileName) {
			Response response=null;
		    try {
		    	File directory = new File(String.valueOf(PATH));
			    if (! directory.exists()){
			        directory.mkdir();
			    }
		    	
		    	String[] fileNameArray = file.getOriginalFilename().split("\\.");
		    	
	            byte[] bytes = file.getBytes();
	            Path path = Paths.get(directory + "\\" +fileName + "." + fileNameArray[fileNameArray.length-1]);
	            Files.write(path, bytes);
	            response = ResponseUtil.createResponse(true, SUCCESS,"Uploaded Successfully");
	        } catch (IOException e) {
	            response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
	        }
		    catch (Exception e) {
	            response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
	        }
		    
		    return response;
	}
	
	@RequestMapping(value="getcompanylogo" ,method = RequestMethod.GET)
	public void getImage(HttpServletResponse response,
			@RequestParam(value = "fileName") String fileName,
			@RequestParam(value = "format") String format){
		try {
			File f = new File((PATH),(fileName + "." + format));
			
			InputStream in = new FileInputStream(f);
			OutputStream os = response.getOutputStream();
			os.write(IOUtils.toByteArray(in));
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/getjobinfotrnbystudentid", method = RequestMethod.GET)
	public @ResponseBody  Response getJobInfoTrnListByStudentId(@RequestParam(value="studentId")Long studentId,
															@RequestParam(value="jobId")Long jobId) {
		Response response = new Response();
		int listsize = 0;
		try {
			List<JobInfoTrnDto> list = jobInfoService.getJobInfoTrnListByStudentId(studentId,jobId);
			if(list!=null){
				listsize = list.size();
				response = ResponseUtil.createResponse(true, SUCCESS,listsize);
			} else{
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.jobtrn.jobtrninfobyjobidfailed"));
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,e.getMessage());
		}
		return response;
	}
	
}
