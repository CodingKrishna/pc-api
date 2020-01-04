package org.pioneercoders.dao.evaluation.objectivetest.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.dao.evaluation.objectivetest.ObjectiveQstnDao;
import org.pioneercoders.entity.evaluation.objectivetest.ObjectQstnEntity;
import org.pioneercoders.exceptions.DBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ObjectiveQstnDaoImpl implements ObjectiveQstnDao {

	@Autowired
	SessionFactory sessionFactory;
	
	private Logger logger = LoggerFactory.getLogger(ObjectiveQstnDaoImpl.class);
	
	public ObjectQstnEntity insertQuestions(ObjectQstnEntity objectQstnEntity) throws DBException {
		try{
			Session session = sessionFactory.getCurrentSession();
			Long id = (Long)session.save(objectQstnEntity);
		} catch(Exception e){
			if(logger.isErrorEnabled()){
				logger.error("Exception Occred while inserting Questions Record ["+objectQstnEntity.getQuestionId()+"] ["+objectQstnEntity.getQuesType()+"]");
				logger.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
		if(logger.isDebugEnabled()){
			logger.debug("Questions Record inserted with id ["+objectQstnEntity.getId()+"]  ["+objectQstnEntity.getQuestionId()+"] ["+objectQstnEntity.getQuesType()+"]");
		}
		return objectQstnEntity;
	}

	@SuppressWarnings("unchecked")
	public List<ObjectQstnEntity> getQuestionsByGroup(String questionGroup) throws DBException {
		try{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from ObjectQstnEntity where quesGroup='"+questionGroup+"'");
			return query.list();
		} catch(Exception e){
			if(logger.isErrorEnabled()){
				logger.error("Exception occured while executing Questions List by"+questionGroup);
				logger.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public ObjectQstnEntity getQuestionsById(Long id) throws DBException {
		try{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from ObjectQstnEntity where id="+id);
			return (ObjectQstnEntity)query.uniqueResult();
		} catch(Exception e){
			if(logger.isErrorEnabled()){
				logger.error("Exception occured while executing Questions List by"+id);
				logger.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}

	@Override
	public String getFinalQuestionId(String questionGroup) throws DBException {
		try{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from ObjectQstnEntity f where f.id = (select max(ff.id) from ObjectQstnEntity ff where ff.quesGroup = '"+questionGroup+"' )");
			ObjectQstnEntity questEntity = (ObjectQstnEntity) query.uniqueResult();
			return questEntity.getQuestionId();
		} catch(Exception e){
			if(logger.isErrorEnabled()){
				logger.error("Exception occured while executing Questions List by"+questionGroup);
				logger.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}
}
