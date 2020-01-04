package org.pioneercoders.web.controllers.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pioneercoders.dto.admin.ExpendatureDto;
import org.pioneercoders.dto.response.Response;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.admin.ExpendatureService;
import org.pioneercoders.utils.AppConfig;
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
@RequestMapping(value="expendature")
public class ExpendatureController {
	
	private static final String FAILED = "failed";

	private static final String SUCCESS = "success";

	@Resource(name = "msgProps")
	private Map<String, String> msgProps;
	
	@Autowired
	ExpendatureService expendatureService;
	
	@Autowired
	AppConfig appConfig;
	
	@RequestMapping(value = "/addexpendature", method = RequestMethod.POST)
	public @ResponseBody
	Response addExpendature(@RequestBody ExpendatureDto expendatureDto) {
		Response response = new Response();
		try {
			if (expendatureDto != null) {

				ExpendatureDto finalExpDto = expendatureService
						.saveExpendatrue(expendatureDto);
				if (finalExpDto != null) {
					response = ResponseUtil.createResponse(true, SUCCESS,
							finalExpDto);
				} else {
					response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.expendature.creationfailed"));
				}
			} else {
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.expendature.creationfailed"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/expendatureslist", method = RequestMethod.GET)
	public @ResponseBody
	Response getAllExpendaturesList() {
		Response response = new Response();
		try {
			List<ExpendatureDto> list = expendatureService.getAllExpendatureList();
			if(list!=null){
				response = ResponseUtil.createResponse(true, SUCCESS, list);
			}else{
				response = ResponseUtil.createResponse(false, FAILED, msgProps.get("error.expendature.listfailed"));
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/uploadbill", method = RequestMethod.POST)
	public @ResponseBody
	Response uploadBill(@RequestParam(value = "file") MultipartFile file,
			@RequestParam(value = "name") String fileName) {
		Response response = null;
		try {
			File directory = new File(String.valueOf(appConfig.getExpendatureBills()));
			if (!directory.exists()) {
				directory.mkdir();
			}
			String[] fileNameArray = file.getOriginalFilename().split("\\.");

			byte[] bytes = file.getBytes();
			Path path = Paths.get(directory + "\\" + fileName);
			Files.write(path, bytes);
			response = ResponseUtil.createResponse(true, SUCCESS,
					"Uploaded Successfully");
		} catch (IOException e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		} catch (Exception e) {
			response = ResponseUtil.createResponse(false, FAILED,
					e.getMessage());
		}

		return response;
	}

	

}
