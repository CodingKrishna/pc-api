package org.pioneercoders.dao.common.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.dao.common.SubscriberDao;
import org.pioneercoders.entity.common.SubscribeEntity;
import org.pioneercoders.exceptions.DBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class SubscriberDaoImpl implements SubscriberDao{
	@Autowired
	SessionFactory sessionFactory;
	
	private static final Logger log = LoggerFactory.getLogger(SubscriberDaoImpl.class);
	@Override
	public SubscribeEntity createSubscribeRecord(SubscribeEntity SubscribeEntity)
			throws DBException {
		log.debug("Entered into createSubscribeRecord Methode -->: ");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(SubscribeEntity);
		} catch (Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while creating Instructor  Record "+SubscribeEntity.getSubscriberEmail());
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
		if(log.isDebugEnabled()){
			log.debug("SubscribeEntity Record is inserted with id ["+SubscribeEntity.getId());
		}
		return SubscribeEntity;
	}

}
