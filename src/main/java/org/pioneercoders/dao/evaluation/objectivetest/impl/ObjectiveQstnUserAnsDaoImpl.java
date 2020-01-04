package org.pioneercoders.dao.evaluation.objectivetest.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.dao.evaluation.objectivetest.ObjectiveQstnUserAnsDao;
import org.pioneercoders.entity.evaluation.objectivetest.ObjectiveQstnUserAnsEntity;
import org.pioneercoders.exceptions.DBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class ObjectiveQstnUserAnsDaoImpl implements ObjectiveQstnUserAnsDao {


	@Autowired
	SessionFactory sessionFactory;
	
	private Logger logger = LoggerFactory.getLogger(ObjectiveQstnUserAnsDaoImpl.class);

	@Override
	public ObjectiveQstnUserAnsEntity insertObjQstnUserAnsRecord(ObjectiveQstnUserAnsEntity objectiveQstnUserAnsEntity)
			throws DBException {
		try{
			Session session = sessionFactory.getCurrentSession();
			Long id = (Long)session.save(objectiveQstnUserAnsEntity);
			objectiveQstnUserAnsEntity.setId(id);
		} catch(Exception e){
		if(logger.isErrorEnabled()){
			logger.error("Exception Occred while inserting Exam Record ["+objectiveQstnUserAnsEntity.getAnswer()+"] ["+objectiveQstnUserAnsEntity.getIsAnswered()+"]");
			logger.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
		if(logger.isDebugEnabled()){
			logger.debug("Exam Record inserted with id ["+objectiveQstnUserAnsEntity.getId()+"]  ["+objectiveQstnUserAnsEntity.getQuesId()+"] ["+objectiveQstnUserAnsEntity.getId()+"]");
		}
		return objectiveQstnUserAnsEntity;
	}

	@Override
	public List<ObjectiveQstnUserAnsEntity> getAllObjQstnUserAnsRecordsList()
			throws DBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ObjectiveQstnUserAnsEntity> getObjQstnUserAnsRecordByPersonalInfoId(Long personalInfoId) throws DBException {
		// TODO Auto-generated method stub
		try{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ExamReEntity order by personalEntity.id desc");
		return query.list();
		}catch(Exception e){
			if(logger.isErrorEnabled()){
				logger.error("Exception occured while executing ExamReEntity list");
				logger.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}

	@Override
	public void flushSession() {
		Session session = sessionFactory.getCurrentSession();
		session.flush();
	}
	
}
