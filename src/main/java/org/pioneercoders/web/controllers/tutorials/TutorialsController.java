package org.pioneercoders.web.controllers.tutorials;

import javax.servlet.http.HttpServletResponse;

import org.pioneercoders.services.tutorials.TutorialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="tutorials")
public class TutorialsController {
	
	@Autowired
	TutorialsService tutorialsService;
	
	
	@ResponseBody
	@RequestMapping(value="gettemplate/{directory}/{fileName}",headers="Accept=text/plain")
	public String getFileByPath(@PathVariable(value = "directory") String directory,
								@PathVariable(value = "fileName") String fileName,
								@RequestParam(value = "subdir", required = false) String subdir){
		String output = tutorialsService.getFileByPath(directory, fileName, subdir);
		
		return output;
	}
	
	@RequestMapping(value="getimage/{directory}/{fileName}/{format}")
	public void getImage(HttpServletResponse response,
			@PathVariable(value = "fileName") String fileName,
			@PathVariable(value = "directory") String directory,
			@PathVariable(value = "format") String format){
		tutorialsService.getImage(response, fileName, directory, format);
	}
	
	@ResponseBody
	@RequestMapping(value="getlecturertemplate",headers="Accept=text/plain")
	public String getFileDataByPath(@RequestParam(value = "directory") String directory,
								    @RequestParam(value = "fileName") String fileName,
								    @RequestParam(value = "subdir",required = false) String subdir){
		String output = tutorialsService.getFileDataByPath(directory, fileName, subdir);
		return output;
	}
	
	@ResponseBody
	@RequestMapping(value="getvedio/{directory}/{fileName}")
	public void getVedioFileByPath(HttpServletResponse response,@PathVariable(value = "directory") String directory,@PathVariable(value = "fileName") String fileName){
		tutorialsService.getVedioFileByPath(response, directory, fileName);
	}
	
}
