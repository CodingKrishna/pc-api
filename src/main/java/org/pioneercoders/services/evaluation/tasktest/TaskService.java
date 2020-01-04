package org.pioneercoders.services.evaluation.tasktest;

import java.util.List;

import org.pioneercoders.dto.Interview.UploadedTaskFilesDto;
import org.pioneercoders.dto.evaluation.taskstest.TaskDto;
import org.pioneercoders.dto.evaluation.taskstest.UserSubmittedTaskDto;
import org.pioneercoders.exceptions.ServiceException;

public interface TaskService {

	public TaskDto createTask(TaskDto TaskDto) throws ServiceException;
	
	public List<TaskDto> getTasksByTechnology(String technology)throws ServiceException;
	
	public List<TaskDto> getTaskListByUserId(Long userId) throws ServiceException;
	
	public List<TaskDto> getAllTasksList()throws ServiceException;
	
	public int assingTasksToUser(Long userId,List<String> taskIdsList) throws ServiceException;
	
	public UserSubmittedTaskDto taskUploadedFiles(UserSubmittedTaskDto taskFileNamesDto) throws ServiceException;

	public UploadedTaskFilesDto insertUploadedTaskFilesNames(UploadedTaskFilesDto uploadedTaskFilesDto) throws ServiceException;

	public List<UserSubmittedTaskDto> getUploadedFilenamesByUserId(Long userId)throws ServiceException;
}
