package org.pioneercoders.dao.user.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.dao.user.ReferralDao;
import org.pioneercoders.entity.student.ReferralEntity;
import org.pioneercoders.exceptions.DBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReferralDaoImpl implements ReferralDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public static final Logger logger = LoggerFactory.getLogger(ReferralDaoImpl.class);
			
	@Override
	public ReferralEntity createReferral(ReferralEntity referralEntity) throws DBException {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.getCurrentSession();
			referralEntity.setId((Long)session.save(referralEntity));
		}catch(Exception e){
			
			if(logger.isErrorEnabled()){
				logger.error("Exception Occred while creating Referral  Records ["+referralEntity.getId()+"] ["+referralEntity.getReferralName()+"]");
				logger.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
			
		}
		if(logger.isDebugEnabled()){
			logger.debug("Refferal Record is inserted with id ["+referralEntity.getId()+"] ["+referralEntity.getReferralName()+"] ["+referralEntity.getEmailId()+"]");
		}
		return referralEntity;
	}

	@Override
	public int addReferralRecords(List<ReferralEntity> referralEntites) throws DBException {
		int row = 0;
		try {
			Session session = sessionFactory.getCurrentSession();
			for (ReferralEntity entity:referralEntites) {
			    session.save(entity);
			}
			row = 1;
		}catch(Exception e){
			throw new DBException(e.getMessage(),e);
		}
		return row;
	}

	@Override
	public List<ReferralEntity> getReferralsByUserId(Long userId) throws DBException {
			logger.debug("Entered into getReferralByUserId Methode -->: ");
			try {
				Session session = sessionFactory.getCurrentSession();
				String queryString = "from ReferralEntity where user.id="+userId;
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

	

}
