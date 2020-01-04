package org.pioneercoders.dao.evaluation.objectivetest.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.dao.evaluation.objectivetest.ObjectiveTestTotalResultDao;
import org.pioneercoders.entity.evaluation.objectivetest.ObjectiveTestTotalResultEntity;
import org.pioneercoders.exceptions.DBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class ObjectiveTestTotalResultDaoImpl implements ObjectiveTestTotalResultDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	private Logger logger = LoggerFactory.getLogger(ObjectiveTestTotalResultDaoImpl.class);

	@Override
	public ObjectiveTestTotalResultEntity insertObjTestTotalResult(ObjectiveTestTotalResultEntity objTestTotalResultEntity)
			throws DBException {
		try{
			Session session = sessionFactory.getCurrentSession();
			Long id = (Long)session.save(objTestTotalResultEntity);
			objTestTotalResultEntity.setId(id);
		} catch(Exception e){
		if(logger.isErrorEnabled()){
			logger.error("Exception Occred while inserting Exam Record ["+objTestTotalResultEntity.getTotalMarks()+"] ["+objTestTotalResultEntity.getUser().getId()+"]");
			logger.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
		if(logger.isDebugEnabled()){
			logger.debug("Exam Record inserted with id ["+objTestTotalResultEntity.getId()+"]  ["+objTestTotalResultEntity.getUser().getId()+"] ["+objTestTotalResultEntity.getTotalMarks()+"]");
		}
		return objTestTotalResultEntity;
	}

	@Override
	public List<ObjectiveTestTotalResultEntity> getAllObjTestData()throws DBException {
		// TODO Auto-generated method stub
		try{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ObjectiveTestTotalResultEntity");
		return query.list();
		}catch(Exception e){
			if(logger.isErrorEnabled()){
				logger.error("Exception occured while executing ExamTrnEntity list");
				logger.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}

	@Override
	public List<ObjectiveTestTotalResultEntity> getAllObjTestInfoByProfileId(Long id) throws DBException {
		// TODO Auto-generated method stub
		try{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ObjectiveTestTotalResultEntity where user.id="+id);
		return query.list();
		}catch(Exception e){
			if(logger.isErrorEnabled()){
				logger.error("Exception occured while executing ExamTrnEntity list");
				logger.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}


}
