package org.pioneercoders.dao.admin.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.dao.admin.ExpendatureDao;
import org.pioneercoders.entity.admin.ExpendatureEntity;
import org.pioneercoders.exceptions.DBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExpendatureDaoImpl implements ExpendatureDao{

	@Autowired
	SessionFactory sessionFactory;
	
	private static final Logger log = LoggerFactory.getLogger(ExpendatureDaoImpl.class);
	@Override
	public ExpendatureEntity saveExpendature(ExpendatureEntity expendatureEntity)throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			expendatureEntity.setId((Long)session.save(expendatureEntity));
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while creating Expendature Record ");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
			
		} if(log.isDebugEnabled()) {
			log.debug("Expendature Record inserted with id ["+expendatureEntity.getId()+"]");
		}
		return expendatureEntity;
	}


	@Override
	public List<ExpendatureEntity> getExpendatureList() throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from ExpendatureEntity");
			return query.list();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing ExpendatureList Method");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}


	@Override
	public List<ExpendatureEntity> getTotalExpeListByDate(String startDate,String endDate) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from ExpendatureEntity e where e.createOn between '"+startDate+"' and '"+endDate+"'");
			return query.list();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing ExpendatureList Method");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}
}
