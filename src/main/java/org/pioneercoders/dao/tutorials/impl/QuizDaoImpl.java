package org.pioneercoders.dao.tutorials.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.dao.tutorials.QuizDao;
import org.pioneercoders.entity.tutorials.QuizEntity;
import org.pioneercoders.exceptions.DBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QuizDaoImpl implements QuizDao{

	@Autowired
	SessionFactory sessionFactory;
	
	private static final Logger log = LoggerFactory.getLogger(QuizDaoImpl.class);
	
	@Override
	public QuizEntity createQuiz(QuizEntity quizEntity) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			quizEntity.setId((Long)session.save(quizEntity));
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while creating Quiz Record ["+quizEntity.getUserId()+"]");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
			
		} if(log.isDebugEnabled()){
			log.debug("Quiz Record inserted with id ["+quizEntity.getTechnology()+"] ["+quizEntity.getUserId()+"]");
		}
		return quizEntity;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<QuizEntity> getQuizDetailsByUserId(Long userId) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from QuizEntity where userId=:userId");
			query.setParameter("userId", userId);
			return query.list();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing QuizList Method");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}
}
