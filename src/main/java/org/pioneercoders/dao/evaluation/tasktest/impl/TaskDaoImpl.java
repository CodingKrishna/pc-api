package org.pioneercoders.dao.evaluation.tasktest.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.dao.evaluation.tasktest.TaskDao;
import org.pioneercoders.entity.Interview.UploadedTaskFilesEntity;
import org.pioneercoders.entity.evaluation.taskstest.TaskAssignToUserTrnEntity;
import org.pioneercoders.entity.evaluation.taskstest.TaskEntity;
import org.pioneercoders.entity.evaluation.taskstest.UserSubmittedTaskEntity;
import org.pioneercoders.exceptions.DBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TaskDaoImpl implements  TaskDao{

	@Autowired
	SessionFactory sessionFactory;
	
	private static final Logger log = LoggerFactory.getLogger(TaskDaoImpl.class);
	
	@Override
	public TaskEntity createTask(TaskEntity taskEntity) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			taskEntity.setId((Long)session.save(taskEntity));
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occred while creating InternTask  Record ["+taskEntity.getImagePath()+"] ["+taskEntity.getQuestion()+"]");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
			
		}
		if(log.isDebugEnabled()){
			log.debug("taskEntity Record is inserted with id ["+taskEntity.getId()+"] ["+taskEntity.getImagePath()+"] ["+taskEntity.getQueDescription()+"]");
		}
		return taskEntity;
	}

	@Override
	public List<TaskEntity> getTaskListByTechnology(String technology)
			throws DBException {
		// TODO Auto-generated method stub
		log.debug("Entered into InternTaskListByTechnology Method -->: ");
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from TaskEntity where technology='"+technology+"'");
			return query.list();
		}catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing InternTaskListByTechnology Method");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}

	@Override
	public TaskAssignToUserTrnEntity createTaskTrn(TaskAssignToUserTrnEntity taskAssignToUserTrnEntity)
			throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			taskAssignToUserTrnEntity.setId((Long)session.save(taskAssignToUserTrnEntity));
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occred while creating InternTaskTrn Record ["+taskAssignToUserTrnEntity.getTask().getId()+"] ["+taskAssignToUserTrnEntity.getUser().getId()+"]");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
			
		}
		if(log.isDebugEnabled()){
			log.debug("internTaskTrnEntity Record is inserted with id ["+taskAssignToUserTrnEntity.getId()+"] ["+taskAssignToUserTrnEntity.getTask().getId()+"] ["+taskAssignToUserTrnEntity.getUser().getId()+"]");
		}
		return taskAssignToUserTrnEntity;
	}

	@Override
	public List<TaskAssignToUserTrnEntity> getTasksListByAssignedUserId(Long userId) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from TaskAssignToUserTrnEntity where user.id="+userId);
			return query.list();
		}catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getInternTasksListByUserId Method");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}

	@Override
	public List<TaskEntity> getAllTaskList() throws DBException {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from TaskEntity");
			return query.list();
		}catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getAllInternTaskList Method");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}

	@Override
	public TaskEntity getTaskListById(Long id) throws DBException {
		// TODO Auto-generated method stub
		log.debug("Entered into InternTaskListByTechnology Method -->: ");
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from TaskEntity where id="+id);
			return (TaskEntity) query.uniqueResult();
		}catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing InternTaskListByTechnology Method");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}

	}

	@Override
	public UserSubmittedTaskEntity insertUploadFileNames(UserSubmittedTaskEntity userSubmittedTaskEntity) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			userSubmittedTaskEntity.setId((Long)session.save(userSubmittedTaskEntity));
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occred while creating InternTask  Record ["+userSubmittedTaskEntity.getFileName()+"]");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
			
		}
		if(log.isDebugEnabled()){
			log.debug("userSubmittedTaskEntity Record is inserted with id ["+userSubmittedTaskEntity.getFileName()+"]");
		}
		return userSubmittedTaskEntity;
	}

	@Override
	public List<UserSubmittedTaskEntity> getFileNameByUserId(Long userId) throws DBException {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from InternTaskFileNamesEntity where user.id = "+userId);
			return query.list();
		}catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getFileNameByUserId Method");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}

	@Override
	public UploadedTaskFilesEntity insertUploadTaskFileNames(UploadedTaskFilesEntity uploadedTaskFilesEntity) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			uploadedTaskFilesEntity.setId((Long)session.save(uploadedTaskFilesEntity));
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occred while creating InternTask  Record ["+uploadedTaskFilesEntity.getFileName()+"]");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
			
		}
		if(log.isDebugEnabled()){
			log.debug("userSubmittedTaskEntity Record is inserted with id ["+uploadedTaskFilesEntity.getFileName()+"]");
		}
		return uploadedTaskFilesEntity;
	}

}
