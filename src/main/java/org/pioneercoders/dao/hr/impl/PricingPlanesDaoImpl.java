package org.pioneercoders.dao.hr.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.dao.hr.PricingPlanesDao;
import org.pioneercoders.entity.hr.PricingPlanesEntity;
import org.pioneercoders.exceptions.DBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PricingPlanesDaoImpl implements PricingPlanesDao{

	@Autowired
	SessionFactory sessionFactory;
	
	private static final Logger log = LoggerFactory.getLogger(PricingPlanesDaoImpl.class);
	
	public PricingPlanesEntity createPricingPlanesRecord(PricingPlanesEntity entity) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			entity.setId((Long)session.save(entity));
		} catch(Exception e){
			 if(log.isErrorEnabled()) {
				 log.error("Exception Occred while creating entity  Record ["+entity.getPlanPrice()+"] ["+entity.getPlanValidity()+"]");
				 log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
			
		}
		if(log.isDebugEnabled()) {
			log.debug("PricisingPlane entity Record inserted with id ["+entity.getId()+"] ["+entity.getPlanValidity()+"] ["+entity.getStaffLogin()+"]");
		}
		return entity;
	}

	public List<PricingPlanesEntity> getPricingPlaneDetailsList() throws DBException {
		log.debug("Entered into getPricingPlaneDetailsByHrId Methode -->: ");
		try {
			Session session = sessionFactory.getCurrentSession();
			String queryString = "from PricingPlanesEntity";
			Query query = session.createQuery(queryString);
			return query.list();
		}catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getPricingPlaneDetailsList");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}

}
