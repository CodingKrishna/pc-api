package org.pioneercoders.dao.evaluation.codingtest.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.dao.evaluation.codingtest.CodingTestQstnDao;
import org.pioneercoders.entity.evaluation.codingtest.CodingTestQstnEntity;
import org.pioneercoders.entity.evaluation.codingtest.CodingTestResultEntity;
import org.pioneercoders.entity.evaluation.taskstest.TaskEntity;
import org.pioneercoders.exceptions.DBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class CodingTestQstnDaoImpl implements CodingTestQstnDao{
	Logger logger = LoggerFactory.getLogger(CodingTestQstnDaoImpl.class);
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public List<CodingTestQstnEntity> getAllQuestions() throws DBException {
		List<CodingTestQstnEntity> list =null;
		logger.debug("Entered into getAllQuestions Methode -->: ");
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from CodingTestQstnEntity");
			list = query.list();
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("Exception occured while executing getAllQuestions Method ");
				logger.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
		return list;
	}

	@Override
	public CodingTestQstnEntity saveQuestion(CodingTestQstnEntity codingTestQstnEntity) throws DBException {
		logger.debug("Entered into saveQuestion Methode -->: ");
		try {
			Session session = sessionFactory.getCurrentSession();
			Long id=(Long) session.save(codingTestQstnEntity);
			codingTestQstnEntity.setId(id);
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("Exception occured while executing saveQuestion Method ");
				logger.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
		return codingTestQstnEntity;
	}

	@Override
	public CodingTestResultEntity saveCodingTestResult(CodingTestResultEntity codingTestResultEntity) throws DBException {
		logger.debug("Entered into saveCodingTestResult Methode -->: ");
		try {
			
		CodingTestResultEntity oldEntity = checkRecordExistOrNotWithQuesIdandUserId(codingTestResultEntity.getCodingTestQstn().getId(),codingTestResultEntity.getUser().getId());
		Session session = sessionFactory.getCurrentSession();
		
		if(oldEntity!=null){
			oldEntity.setPoints(codingTestResultEntity.getPoints());
			session.update(oldEntity);
		}else{
			session.save(codingTestResultEntity);
		}
		return codingTestResultEntity;
		
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("Exception occured while executing saveCodingTestResult Method ");
				logger.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}

	@Override
	public List<CodingTestResultEntity> getCodingTestResultListByUserId(Long userId) throws DBException {
		List<CodingTestResultEntity> list =null;
		logger.debug("Entered into getCodingTestResultList Methode -->: ");
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from CodingTestResultEntity");
			list = query.list();
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("Exception occured while executing getCodingTestResultListByUserId Method ");
				logger.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
		return list;
	}

	@Override
	public CodingTestResultEntity checkRecordExistOrNotWithQuesIdandUserId(Long questionId, Long userId) throws DBException {
		logger.debug("Entered into saveCodingTestResult Methode -->: ");
		CodingTestResultEntity codingTestResultEntity=null;
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from CodingTestResultEntity  where codingTestQstn.id="+questionId+" and user.id="+userId);
			codingTestResultEntity = (CodingTestResultEntity) query.uniqueResult();
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("Exception occured while executing saveCodingTestResult Method ");
				logger.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
		return codingTestResultEntity;
	}

	@Override
	public CodingTestQstnEntity getCodingQstnById(Long id) throws DBException {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from CodingTestQstnEntity where id="+id);
			return (CodingTestQstnEntity) query.uniqueResult();
		}catch (Exception e) {
			
			throw new DBException(e.getMessage(), e);
		}
	}
}
