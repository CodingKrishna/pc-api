package org.pioneercoders.web.controllers.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.pioneercoders.utils.AppConfig;
import org.pioneercoders.utils.FileReadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("casestudy")
public class CaseSheetController {

	@Autowired
	AppConfig appConfig;
	
	@ResponseBody
	@RequestMapping(value = "template/{language}", headers="Accept=text/plain")
	public String getCaseSheetTemplate(@PathVariable("language") String language) {
		try {
			return FileReadUtil.getFileContent(appConfig.getCaseStudiesDirectory() + "/" + language.toUpperCase() + "/" + language.toLowerCase() + "_casestudeis.html",  "caseStudy");
		} catch (IOException e) {
			e.printStackTrace();
			return "No Case Studies Found For Langauage: " + language;
		}
	}
	
	@RequestMapping(value="getimage/{fileName}/{format}")
	public void getImage(HttpServletResponse response,
			@PathVariable(value = "fileName") String fileName,
			@PathVariable(value = "format") String format){
		try {
			File f = new File((appConfig.getCaseStudiesDirectory() + "\\IMAGES\\"), (fileName + "." + format));
			
			InputStream in = new FileInputStream(f);
			OutputStream os = response.getOutputStream();
			os.write(IOUtils.toByteArray(in));
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
