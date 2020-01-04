package org.pioneercoders.web.controllers.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.pioneercoders.dto.response.Response;
import org.pioneercoders.utils.AppConfig;
import org.pioneercoders.utils.FileReadUtil;
import org.pioneercoders.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="campus")
public class CampusTaskController {

	@Autowired
	AppConfig appConfig;

	String caseStudies = new FileReadUtil().getProperty("CASESTUDIES_TASK_DOWNLOAD");
	
	/*@ResponseBody
	@RequestMapping(value = "template/{language}", headers="Accept=text/plain")
	public String getInternTaskTemplate(@PathVariable("language") String language) {
		try {
			return FileReadUtil.getFileContent(campusTaskRootPath + "/" + language.toUpperCase() + "/" + language.toLowerCase() + "_intern_task.html",  "internTask");
		} catch (IOException e) {
			e.printStackTrace();
			return "No Intern Task Found For Langauage: " + language;
		}
	}
	
	@RequestMapping(value="getimage/{fileName}/{format}")
	public void getImage(HttpServletResponse response,
			@PathVariable(value = "fileName") String fileName,
			@PathVariable(value = "format") String format){
		try {
			File f = new File((campusTaskRootPath + "\\IMAGES\\"), (fileName + "." + format));
			
			InputStream in = new FileInputStream(f);
			OutputStream os = response.getOutputStream();
			os.write(IOUtils.toByteArray(in));
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	
	@RequestMapping(value="uploadtask", method = RequestMethod.POST)
	public @ResponseBody Response uploadTask(
			@RequestParam(value="file") MultipartFile file,
			@RequestParam(value="folderName") String folderName,
			@RequestParam(value="name") String fileName) {
			Response response=null;
		    try {
		    	File directory = new File(String.valueOf(appConfig.getCampusUploadedRoot()));
			    if (! directory.exists()){
			        directory.mkdir();
			    }
		    	String directoryName = appConfig.getCampusUploadedRoot().concat("\\" + folderName);
				directory = new File(String.valueOf(directoryName));
			    if (! directory.exists()){
			        directory.mkdir();
			    }
		    	String[] fileNameArray = file.getOriginalFilename().split("\\.");
		    	
	            byte[] bytes = file.getBytes();
	            Path path = Paths.get(directoryName + "\\" +fileName + "." + fileNameArray[fileNameArray.length-1]);
	            Files.write(path, bytes);
	            response = ResponseUtil.createResponse(true, "success","Uploaded Successfully");
	        } catch (IOException e) {
	            response = ResponseUtil.createResponse(false, "failed",e.getMessage());
	        }
		    catch (Exception e) {
	            response = ResponseUtil.createResponse(false, "failed",e.getMessage());
	        }
		    
		    return response;
	}
	
	@RequestMapping(value = "downloadcasestudies/{documentName}")
	public void downloadDocuments(HttpServletResponse response,
			@PathVariable(value = "documentName") String documentName) throws IOException {
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=" + documentName + ".zip");

		File file = new File(caseStudies + "/" + documentName + ".zip");
		FileInputStream fileIn = new FileInputStream(file);
		ServletOutputStream out = response.getOutputStream();

		byte[] outputByte = new byte[(int) file.length()];
		while (fileIn.read(outputByte, 0, (int) file.length()) != -1) {
			out.write(outputByte, 0, (int) file.length());
		}
		fileIn.close();
	}

}
