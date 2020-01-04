package org.pioneercoders.dao.evaluation.objectivetest.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.dao.evaluation.objectivetest.ObjectiveQstnAnswersDao;
import org.pioneercoders.entity.evaluation.objectivetest.ObjectiveQstnAnswersEntity;
import org.pioneercoders.exceptions.DBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class ObjectiveQstnAnswersDaoImpl implements ObjectiveQstnAnswersDao {

	
	@Autowired
	SessionFactory sessionFactory;
	
	private Logger logger = LoggerFactory.getLogger(ObjectiveQstnAnswersDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ObjectiveQstnAnswersEntity> getAllAnswers() throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			return session.createQuery("from ObjectiveQstnAnswersEntity").list();
		} catch(Exception e) {
			if(logger.isErrorEnabled()) {
				logger.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}

	@Override
	public ObjectiveQstnAnswersEntity insertAnswers(ObjectiveQstnAnswersEntity objectiveQstnAnswersEntity) throws DBException {
		try{
			Session session = sessionFactory.getCurrentSession();
			Long id = (Long)session.save(objectiveQstnAnswersEntity);
		} catch(Exception e){
			if(logger.isErrorEnabled()){
				logger.error("Exception Occred while inserting Answers Record ["+objectiveQstnAnswersEntity.getQuestionId()+"]");
				logger.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
		if(logger.isDebugEnabled()){
			logger.debug("Answers Record inserted with id ["+objectiveQstnAnswersEntity.getId()+"]  ["+objectiveQstnAnswersEntity.getQuestionId()+"]");
		}
		return objectiveQstnAnswersEntity;
	}

}
