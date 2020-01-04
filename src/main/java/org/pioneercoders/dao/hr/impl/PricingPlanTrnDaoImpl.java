package org.pioneercoders.dao.hr.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.dao.hr.PricinnPlanTrnDao;
import org.pioneercoders.entity.hr.PricingPlanTrnEntity;
import org.pioneercoders.exceptions.DBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PricingPlanTrnDaoImpl implements PricinnPlanTrnDao{

	@Autowired
	SessionFactory sessionFactory;
	
	private static final Logger log = LoggerFactory.getLogger(PricingPlanTrnDaoImpl.class);

	public PricingPlanTrnEntity createPricingPlanTrnRecord(PricingPlanTrnEntity pricingPlanTrnEntity) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			pricingPlanTrnEntity.setId((Long)session.save(pricingPlanTrnEntity));
		} catch(Exception e){
			 if(log.isErrorEnabled()) {
				 log.error("Exception Occred while creating pricingPlanTrnEntity  Record ["+pricingPlanTrnEntity.getPlan()+"] ["+pricingPlanTrnEntity.getPurchasedDate()+"]");
				 log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
		if(log.isDebugEnabled()) {
			log.debug("pricingPlanTrnEntitypricingPlanTrnEntity Record inserted with id ["+pricingPlanTrnEntity.getId()+"] ["+pricingPlanTrnEntity.getPlan()+"] ["+pricingPlanTrnEntity.getPurchasedDate()+"]");
		}
		return pricingPlanTrnEntity;
	}

	public PricingPlanTrnEntity getPricingPlanTrnRecordByHrId(Long hrId) throws DBException {
		log.debug("Entered into getJobInfoTrnList Methode -->: ");
		try {
			Session session = sessionFactory.getCurrentSession();
			String queryString = "from PricingPlanTrnEntity where user.id="+hrId;
			Query query = session.createQuery(queryString);
			return (PricingPlanTrnEntity) query.uniqueResult();
		}catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getPricingPlanTrnRecordByHrId");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
	}
	
	
	}
	
}
