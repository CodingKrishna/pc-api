package org.pioneercoders.web.controllers.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.pioneercoders.utils.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("project")
public class ProjectsController {
	
	@Autowired
	AppConfig appConfig;
	
	@RequestMapping(value = "download/{directory}/{project}")
	public void downloadProject(HttpServletResponse response,
			@PathVariable(value = "directory") String directoryName,
			@PathVariable(value = "project") String projectName) throws IOException {
		
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=" + projectName + ".zip");
		String projectFilePath = appConfig.getTutorialDirectory() + "/" + directoryName + "/" + appConfig.getProjectsDirectory() + "/" + projectName + ".zip";
		
		File file = new File(projectFilePath);
		FileInputStream fileIn = new FileInputStream(file);
		ServletOutputStream out = response.getOutputStream();

		byte[] outputByte = new byte[(int) file.length()];
		while (fileIn.read(outputByte, 0, (int) file.length()) != -1) {
			out.write(outputByte, 0, (int) file.length());
		}
		fileIn.close();
	}
	
	@RequestMapping(value = "downloaddocu/{directory}/{document}")
	public void downloadDocuments(HttpServletResponse response,
			@PathVariable(value = "directory") String directoryName,
			@PathVariable(value = "document") String documentName) throws IOException {
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=" + documentName + ".zip");
		String downDocumentFilePath = appConfig.getTutorialDirectory() + "/" + directoryName + "/" + appConfig.getDocumentsDirectory() + "/" + documentName + ".zip"; 
		File file = new File(downDocumentFilePath);
		FileInputStream fileIn = new FileInputStream(file);
		ServletOutputStream out = response.getOutputStream();

		byte[] outputByte = new byte[(int) file.length()];
		while (fileIn.read(outputByte, 0, (int) file.length()) != -1) {
			out.write(outputByte, 0, (int) file.length());
		}
		fileIn.close();
	}
}