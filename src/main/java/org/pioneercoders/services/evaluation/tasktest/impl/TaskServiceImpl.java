package org.pioneercoders.services.evaluation.tasktest.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.pioneercoders.dao.evaluation.tasktest.TaskDao;
import org.pioneercoders.dto.Interview.UploadedTaskFilesDto;
import org.pioneercoders.dto.evaluation.taskstest.TaskDto;
import org.pioneercoders.dto.evaluation.taskstest.UserSubmittedTaskDto;
import org.pioneercoders.entity.Interview.UploadedTaskFilesEntity;
import org.pioneercoders.entity.evaluation.taskstest.TaskAssignToUserTrnEntity;
import org.pioneercoders.entity.evaluation.taskstest.TaskEntity;
import org.pioneercoders.entity.evaluation.taskstest.UserSubmittedTaskEntity;
import org.pioneercoders.entity.user.UserEntity;
import org.pioneercoders.exceptions.DBException;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.evaluation.tasktest.TaskService;
import org.pioneercoders.utils.CollectionMapper;
import org.pioneercoders.utils.FileReadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class TaskServiceImpl implements TaskService{

private static final Logger log = LoggerFactory.getLogger(TaskServiceImpl.class);
	
	@Autowired
	TaskDao taskDao;

	@Override
	public TaskDto createTask(TaskDto taskDto) throws ServiceException {
		// TODO Auto-generated method stub
		TaskDto finalTaskDto=null;
		try {
			TaskEntity taskEntity = DozerBeanMapperSingletonWrapper.getInstance().map(taskDto, TaskEntity.class);
			finalTaskDto = DozerBeanMapperSingletonWrapper.getInstance().map(taskDao.createTask(taskEntity),TaskDto.class);

		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finalTaskDto;
	}

	@Override
	public List<TaskDto> getTasksByTechnology(String technology) throws ServiceException {
		try {
			List<TaskEntity> list = taskDao.getTaskListByTechnology(technology);
			for(int i=0;i<list.size();i++){
				try {
					list.get(i).setImagePath(FileReadUtil.updateAcronymsInFile(list.get(i).getImagePath(),"internTask"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			List<TaskDto> internTasksList = CollectionMapper.getMappingList(list.iterator(), TaskDto.class);

			log.info("Returning internTasks List -->: ");
			return internTasksList;
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing InternTasksList Methode");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<TaskDto> getTaskListByUserId(Long userId)throws ServiceException {
		try {
			List<TaskAssignToUserTrnEntity> list = taskDao.getTasksListByAssignedUserId(userId);
			List<TaskDto> taskList = new ArrayList();
			for(int i=0;i<list.size();i++){
				TaskEntity entity = taskDao.getTaskListById(list.get(i).getTask().getId());
				TaskDto dto = DozerBeanMapperSingletonWrapper.getInstance().map(entity,TaskDto.class);
				taskList.add(dto);
			}
			log.info("Returning internTasks List By UserId-->: "+userId);
			return taskList;
			
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getInternTaskTrnListByUserId Methode");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<TaskDto> getAllTasksList() throws ServiceException {
		try {
			List<TaskEntity> list = taskDao.getAllTaskList();
			for(int i=0;i<list.size();i++){
				try {
					list.get(i).setImagePath(FileReadUtil.updateAcronymsInFile(list.get(i).getImagePath(),"internTask"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			List<TaskDto> internTasksList = CollectionMapper.getMappingList(list.iterator(), TaskDto.class);

			log.info("Returning internTasks List -->: ");
			return internTasksList;
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getAllInternTasksList Methode");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public int assingTasksToUser(Long userId, List<String> taskIdsList)throws ServiceException {
	try {
			
			for(int i=0;i<taskIdsList.size();i++) {
				TaskAssignToUserTrnEntity entity = new TaskAssignToUserTrnEntity();
				
				TaskEntity task= new TaskEntity();
				task.setId(Long.parseLong(taskIdsList.get(i)));
				entity.setTask(task);
				
				UserEntity user = new UserEntity();
				user.setId(userId);
				entity.setUser(user);
				taskDao.createTaskTrn(entity);
			}
			
	    } catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public UserSubmittedTaskDto taskUploadedFiles(UserSubmittedTaskDto taskFileNamesDto) throws ServiceException {
		// TODO Auto-generated method stub
		UserSubmittedTaskDto finalInternTaskFileNamesDto = null;
		try {
			UserSubmittedTaskEntity internTaskFileNamesEntity = DozerBeanMapperSingletonWrapper.getInstance().map(taskFileNamesDto, UserSubmittedTaskEntity.class);
			finalInternTaskFileNamesDto = DozerBeanMapperSingletonWrapper.getInstance().map(taskDao.insertUploadFileNames(internTaskFileNamesEntity),UserSubmittedTaskDto.class);

		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finalInternTaskFileNamesDto;
	}

	@Override
	public List<UserSubmittedTaskDto> getUploadedFilenamesByUserId(Long userId) throws ServiceException {
		try {
			List<UserSubmittedTaskEntity> list = taskDao.getFileNameByUserId(userId);
			List<UserSubmittedTaskDto> finalList = CollectionMapper.getMappingList(list.iterator(), UserSubmittedTaskDto.class);
			log.info("Returning uploadedFilesByUserid -->: "+userId);
			return finalList;
			
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getUploadedFilenamesByUserId Methode");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public UploadedTaskFilesDto insertUploadedTaskFilesNames(
			UploadedTaskFilesDto uploadedTaskFilesDto) throws ServiceException {
		// TODO Auto-generated method stub
		UploadedTaskFilesDto finalTaskFileNamesDto = null;
		try {
			UploadedTaskFilesEntity taskFileNamesEntity = DozerBeanMapperSingletonWrapper.getInstance().map(uploadedTaskFilesDto, UploadedTaskFilesEntity.class);
			finalTaskFileNamesDto = DozerBeanMapperSingletonWrapper.getInstance().map(taskDao.insertUploadTaskFileNames(taskFileNamesEntity),UploadedTaskFilesDto.class);

		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finalTaskFileNamesDto;
	}
	

}
