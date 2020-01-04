package org.pioneercoders.dao.evaluation;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.entity.evaluation.UserKnownAppsEntity;
import org.pioneercoders.exceptions.DBException;
import org.pioneercoders.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserKnownAppsDaoImpl implements UserKnownAppsDao{

	@Autowired
	SessionFactory sessionFactory;
	
	private static final Logger log = LoggerFactory.getLogger(UserKnownAppsDaoImpl.class);
	


	@Override
	public UserKnownAppsEntity createUserKnownAppsInfo(UserKnownAppsEntity userKnownAppsEntity) throws DBException {
		try {
			userKnownAppsEntity.setStatus(Constants.STATUS_ACTIVE);
			userKnownAppsEntity.setCreatedOn(Constants.CREATED_ON());
			Session session = sessionFactory.getCurrentSession();
			userKnownAppsEntity.setId((Long)session.save(userKnownAppsEntity));
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while creating Evaluation  Record ");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
			
		} if(log.isDebugEnabled()){
			log.debug("Evaluation Record inserted with id ["+userKnownAppsEntity.getId()+"]");
		}
		return userKnownAppsEntity;
	}

	@Override
	public UserKnownAppsEntity getUserKnownAppsInfoByUserId(Long userId) throws DBException {
		Query query =null;
		try {
			Session session = sessionFactory.getCurrentSession();
			query= session.createQuery("from UserKnownAppsEntity where userId=:userId");
			query.setParameter("userId", userId);
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing EvaluationListByUserId Method");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
				
		} if(log.isDebugEnabled()) {
				log.debug("EvaluationDetailsByUserId Method failed");
			}
			return (UserKnownAppsEntity) query.uniqueResult();
	}



}
