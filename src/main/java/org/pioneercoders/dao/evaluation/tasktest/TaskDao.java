package org.pioneercoders.dao.evaluation.tasktest;

import java.util.List;

import org.pioneercoders.entity.Interview.UploadedTaskFilesEntity;
import org.pioneercoders.entity.evaluation.taskstest.TaskAssignToUserTrnEntity;
import org.pioneercoders.entity.evaluation.taskstest.TaskEntity;
import org.pioneercoders.entity.evaluation.taskstest.UserSubmittedTaskEntity;
import org.pioneercoders.exceptions.DBException;

public interface TaskDao {
	
	public TaskEntity createTask(TaskEntity TaskEntity) throws DBException;
	
	public List<TaskEntity> getTaskListByTechnology(String technology)throws DBException;
	
	public TaskAssignToUserTrnEntity createTaskTrn(TaskAssignToUserTrnEntity taskAssignToUserTrnEntity) throws DBException;
	
	public List<TaskAssignToUserTrnEntity> getTasksListByAssignedUserId(Long userId)throws DBException;
	
	public List<TaskEntity> getAllTaskList()throws DBException;
	
	public TaskEntity getTaskListById(Long id)throws DBException;
	
	public UserSubmittedTaskEntity insertUploadFileNames(UserSubmittedTaskEntity userSubmittedTaskEntity) throws DBException;
	
	public UploadedTaskFilesEntity insertUploadTaskFileNames(UploadedTaskFilesEntity uploadedTaskFilesEntity) throws DBException;

	public List<UserSubmittedTaskEntity> getFileNameByUserId(Long userId)throws DBException;
}