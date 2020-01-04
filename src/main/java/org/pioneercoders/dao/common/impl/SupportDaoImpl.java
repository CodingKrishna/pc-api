package org.pioneercoders.dao.common.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.dao.common.SupportDao;
import org.pioneercoders.entity.common.SupportEntity;
import org.pioneercoders.exceptions.DBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class SupportDaoImpl implements SupportDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public static final Logger logger = LoggerFactory.getLogger(SupportDaoImpl.class);
	
	@Override
	public SupportEntity createSupportRecord(SupportEntity supportEntity) throws DBException {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.getCurrentSession();
			supportEntity.setId((Long)session.save(supportEntity));
		}catch(Exception e){
			
			if(logger.isErrorEnabled()){
				logger.error("Exception Occred while creating Support  Record ["+supportEntity.getId()+"] ["+supportEntity.getEmailId()+"]");
				logger.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
			
		}
		if(logger.isDebugEnabled()){
			logger.debug("Support Record is inserted with id ["+supportEntity.getId()+"] ["+supportEntity.getMobileNo()+"] ["+supportEntity.getEmailId()+"]");
		}
		return supportEntity;
	}

	@Override
	public List<SupportEntity> getAllSupports() throws DBException {
		logger.debug("Entered into getAllSupports Methode -->: ");
		try {
			Session session = sessionFactory.getCurrentSession();
			String queryString = "from SupportEntity ";
			Query query = session.createQuery(queryString);
			return query.list();
		}catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("Exception occured while executing getAllSupports");
				logger.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}
}
