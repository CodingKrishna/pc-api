package org.pioneercoders.dao.user.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.dao.user.TechSkillDao;
import org.pioneercoders.entity.common.TechnologiesEntity;
import org.pioneercoders.entity.student.EmployersInfoEntity;
import org.pioneercoders.entity.student.TechSkillEntity;
import org.pioneercoders.exceptions.DBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TechSkillDaoImpl implements TechSkillDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public static final Logger logger = LoggerFactory.getLogger(TechSkillDaoImpl.class);

	@Override
	public List<TechnologiesEntity> getAllTechnologies() throws DBException {
		logger.debug("Entered into TechnologiesList Methode -->: ");
		try {
			Session session = sessionFactory.getCurrentSession();
			String queryString = "from TechnologiesEntity";
			Query query = session.createQuery(queryString);
			return query.list();
		}catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("Exception occured while executing getReferralsByUserId ");
				logger.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}
		
	@Override
	public TechSkillEntity createTechSkillRecord(TechSkillEntity techSkillEntity)throws DBException {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.getCurrentSession();
			techSkillEntity.setId((Long)session.save(techSkillEntity));
		}catch(Exception e){
			
			if(logger.isErrorEnabled()){
				logger.error("Exception Occred while creating TechSkill Records ["+techSkillEntity.getId()+"]");
				logger.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
			
		}
		if(logger.isDebugEnabled()){
			logger.debug("Refferal Record is inserted with id ["+techSkillEntity.getId()+"] ["+techSkillEntity.getTechnology()+"]");
		}
		return techSkillEntity;
	}

	@Override
	public List<TechSkillEntity> getTechSkillRecordsByUserId(Long userId)
			throws DBException {
		logger.debug("Entered into getReferralByUserId Methode -->: ");
		try {
			Session session = sessionFactory.getCurrentSession();
			String queryString = "from TechSkillEntity where user.id="+userId;
			Query query = session.createQuery(queryString);
			return query.list();
		}catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("Exception occured while executing getReferralsByUserId ");
				logger.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}

	@Override
	public TechSkillEntity updateTechSkillRecord(TechSkillEntity techSkillEntity)throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(techSkillEntity);
		}catch(Exception e){
			
			if(logger.isErrorEnabled()){
				logger.error("Exception Occred while creating Referral  Records ["+techSkillEntity.getId()+"]");
				logger.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
			
		}
		if(logger.isDebugEnabled()){
			logger.debug("Refferal Record is inserted with id ["+techSkillEntity.getId()+"] ["+techSkillEntity.getTechnology()+"]");
		}
		return techSkillEntity;
	}

	@Override
	public TechSkillEntity getTechSkillRecordByUserIdAndTechId(Long userId,Long techId) throws DBException {
		logger.debug("Entered into getReferralByUserId Methode -->: ");
		try {
			Session session = sessionFactory.getCurrentSession();
			String queryString = "from TechSkillEntity where user.id="+userId+"and technology.id="+techId;
			Query query = session.createQuery(queryString);
			return (TechSkillEntity) query.uniqueResult();
		}catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("Exception occured while executing getTechSkillRecordByUserIdAndTechId ");
				logger.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}

	@Override
	public int deleteTechSkillByUserId(Long userId) throws DBException {
		// TODO Auto-generated method stub
		Query query;
		try {
			Session session = sessionFactory.getCurrentSession();
			query= session.createQuery("delete from TechSkillEntity where user.id=:userId");
			query.setParameter("userId", userId);
		}catch(Exception e){
			if(logger.isErrorEnabled()){
				logger.error("Exception Occred while Deleting TechSKills By userId");
				logger.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
				
		}
			if(logger.isDebugEnabled()){
				logger.debug("delete TechSkills Record By UserIdfailed");
			}
			return query.executeUpdate();
	}

	@Override
	public List<TechSkillEntity> saveOrUpdateTechSkill(List<TechSkillEntity> techSkillList) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			for(TechSkillEntity technologyInfo :techSkillList){
				session.saveOrUpdate(technologyInfo);
			}
			session.flush();
		} catch(Exception e){
			throw new DBException(e.getMessage(),e);
			
		}
		return techSkillList;
	}


}