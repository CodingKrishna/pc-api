package org.pioneercoders.web.controllers.evaluation.task;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.pioneercoders.dto.Interview.UploadedTaskFilesDto;
import org.pioneercoders.dto.evaluation.taskstest.TaskDto;
import org.pioneercoders.dto.evaluation.taskstest.UserSubmittedTaskDto;
import org.pioneercoders.dto.response.Response;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.evaluation.tasktest.TaskService;
import org.pioneercoders.utils.AppConfig;
import org.pioneercoders.utils.FileReadUtil;
import org.pioneercoders.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="interntask")
public class TaskController {

	@Autowired
	TaskService taskService;
	
	@Autowired
	AppConfig appConfig;
	
	@ResponseBody
	@RequestMapping(value = "template/{language}", headers="Accept=text/plain")
	public String getInternTaskTemplate(@PathVariable("language") String language) {
		try {
			return FileReadUtil.getFileContent(appConfig.getInternTasksDirectory() + "/" + language.toUpperCase() + "/" + language.toLowerCase() + "_intern_task.html",  "internTask");
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
			File f = new File((appConfig.getInternTasksDirectory() + "\\IMAGES\\"), (fileName + "." + format));
			
			InputStream in = new FileInputStream(f);
			OutputStream os = response.getOutputStream();
			os.write(IOUtils.toByteArray(in));
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="uploadtask", method = RequestMethod.POST)
	public @ResponseBody Response uploadTask(
			@RequestParam(value="file") MultipartFile file,
			@RequestParam(value="folderName") String folderName,
			@RequestParam(value="name") String fileName) {
			Response response=null;
		    try {
		    	File directory = new File(String.valueOf(appConfig.getProfileInfo()));
			    if (!directory.exists()){
			        directory.mkdir();
			    }
		    	String directoryName = appConfig.getProfileInfo().concat("\\" + folderName + "\\UploadedTasks");
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
	
	@RequestMapping(value = "downloadintertask/{documentName}")
	public void downloadDocuments(HttpServletResponse response,
			@PathVariable(value = "documentName") String documentName) throws IOException {
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=" + documentName + ".zip");

		File file = new File(appConfig.getInternTaskDownload() + "/" + documentName + ".zip");
		FileInputStream fileIn = new FileInputStream(file);
		ServletOutputStream out = response.getOutputStream();

		byte[] outputByte = new byte[(int) file.length()];
		while (fileIn.read(outputByte, 0, (int) file.length()) != -1) {
			out.write(outputByte, 0, (int) file.length());
		}
		fileIn.close();
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Response addInterTask(@RequestBody TaskDto TaskDto) {
		Response response = new Response();
		try {
			TaskDto finalTaskDto = taskService.createTask(TaskDto);
			if(finalTaskDto!=null){
				response = ResponseUtil.createResponse(true, "success",finalTaskDto);
			} else{
				response = ResponseUtil.createResponse(false, "failed","Task Info is not created...");
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, "failed",e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody Response gettTaskList(@RequestParam(value="technology")String technology) {
		Response response = new Response();
		try {
			List<TaskDto> internTasksList = taskService.getTasksByTechnology(technology);
			if(internTasksList!=null){
				response = ResponseUtil.createResponse(true, "success",internTasksList);
			} else{
				response = ResponseUtil.createResponse(false, "failed","InternTasksList data is not available");
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, "failed",e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/interntaskslist", method = RequestMethod.GET)
	public @ResponseBody Response getAllInterntTaskList() {
		Response response = new Response();
		try {
			List<TaskDto> internTasksList = taskService.getAllTasksList();
			if(internTasksList!=null){
				response = ResponseUtil.createResponse(true, "success",internTasksList);
			} else{
				response = ResponseUtil.createResponse(false, "failed","InternTasksList data is not available");
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, "failed",e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="/uploadimage", method = RequestMethod.POST)
	public @ResponseBody Response uploadBill(@RequestParam(value="file") MultipartFile file,
		   @RequestParam(value="name") String fileName) {
			Response response=null;
		    try {
		    	File directory = new File(String.valueOf(appConfig.getInternTasksDirectory()+"\\IMAGES"));
			    if (! directory.exists()){
			        directory.mkdir();
			    }
		    	String[] fileNameArray = file.getOriginalFilename().split("\\.");
		    	
	            byte[] bytes = file.getBytes();
	            Path path = Paths.get(directory + "\\" +fileName);
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
	
	@RequestMapping(value="assingtaskstousers")
	public @ResponseBody Response assingTasksToUser(@RequestParam (value="userId")Long userId,@RequestParam(value="taskIdsList")List<String> taskIdsList){
		Response response = new Response();
		try {
			
			int result = taskService.assingTasksToUser(userId, taskIdsList);

			if(result>0){
				response = ResponseUtil.createResponse(true, "success", result);
			}else{
				response = ResponseUtil.createResponse(true, "success", "not assinged Tasks"); 
			}
			
		} catch (Exception e) {
			response = ResponseUtil.createResponse(false, "failed",e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/interntaskslistbyuserid", method = RequestMethod.GET)
	public @ResponseBody Response getInternTaskListByUserId(@RequestParam(value="userId")Long userId) {
		Response response = new Response();
		try {
			List<TaskDto> internTasksList = taskService.getTaskListByUserId(userId);
			if(internTasksList!=null){
				response = ResponseUtil.createResponse(true, "success",internTasksList);
			} else{
				response = ResponseUtil.createResponse(false, "failed","internTasksList data is not available");
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, "failed",e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/addinternfiles", method = RequestMethod.POST)
	public @ResponseBody Response insertInterFileNames(@RequestBody UserSubmittedTaskDto userSubmittedTaskDto) {
		Response response = new Response();
		try {
			UserSubmittedTaskDto finalDto = taskService.taskUploadedFiles(userSubmittedTaskDto);
			if(finalDto!=null){
				response = ResponseUtil.createResponse(true, "success",finalDto);
			} else{
				response = ResponseUtil.createResponse(false, "failed","Uploaded File Path is not saved properly");
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, "failed",e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/adduploadedtasksfiles", method = RequestMethod.POST)
	public @ResponseBody Response insertUploadedTaskNames(@RequestBody UploadedTaskFilesDto uploadedTaskFilesDto) {
		Response response = new Response();
		try {
			UploadedTaskFilesDto finalDto = taskService.insertUploadedTaskFilesNames(uploadedTaskFilesDto);
			if(finalDto!=null){
				response = ResponseUtil.createResponse(true, "success",finalDto);
			} else{
				response = ResponseUtil.createResponse(false, "failed","Uploaded File Path is not saved properly");
			}

		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, "failed",e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/uploadedfilesbyuserid", method = RequestMethod.GET)
	public @ResponseBody Response getUploadedFileNamesListByUserId(@RequestParam(value="userId")Long userId) {
		Response response = new Response();
		try {
			List<UserSubmittedTaskDto> uploadedFileList = taskService.getUploadedFilenamesByUserId(userId);
			if(uploadedFileList!=null){
				response = ResponseUtil.createResponse(true, "success",uploadedFileList);
			} else{
				response = ResponseUtil.createResponse(false, "failed","No files are uploaded");
			}
		} catch (ServiceException e) {
			response = ResponseUtil.createResponse(false, "failed",e.getMessage());
		}
		return response;
	}
	
	
	@RequestMapping(value = "/downloaduploadfile/{directory}/{document}/{fileFormate}")
	public void downloadResumes(HttpServletResponse response,@PathVariable(value = "directory") String directoryName,
			@PathVariable(value = "document") String documentName,
			@PathVariable(value = "fileFormate") String fileFormate) throws IOException {
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=" + documentName + "."+fileFormate);

		java.io.File file = new File(appConfig.getProfileInfo() + "/" + directoryName + "/" + documentName +"."+ fileFormate);
		FileInputStream fileIn = new FileInputStream(file);
		ServletOutputStream out = response.getOutputStream();

		byte[] outputByte = new byte[(int) file.length()];
		while (fileIn.read(outputByte, 0, (int) file.length()) != -1) {
			out.write(outputByte, 0, (int) file.length());
		}
		fileIn.close();
	}
}
