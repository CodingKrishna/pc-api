package org.pioneercoders.dao.hr.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.dao.hr.CompanyDao;
import org.pioneercoders.entity.hr.CompanyEntity;
import org.pioneercoders.exceptions.DBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDaoImpl implements CompanyDao{

	@Autowired
	SessionFactory sessionFactory;
	
	private static final Logger log = LoggerFactory.getLogger(CompanyDaoImpl.class);
	
	public CompanyEntity createCompanyRecord(CompanyEntity companyEntity)
			throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			companyEntity.setId((Long)session.save(companyEntity));
		} catch(Exception e){
			 if(log.isErrorEnabled()) {
				 log.error("Exception Occred while creating Company  Record ["+companyEntity.getCompanyName()+"] ["+companyEntity.getPhoneNo()+"]");
				 log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
			
		}
		if(log.isDebugEnabled()) {
			log.debug("Company Record inserted with id ["+companyEntity.getId()+"] ["+companyEntity.getPhoneNo()+"] ["+companyEntity.getCompanyName()+"]");
		}
		return companyEntity;
	}

	public List<CompanyEntity> getCompaniesList() throws DBException {
		log.debug("Entered into getCompaniesList Methode -->: ");
		try {
			Session session = sessionFactory.getCurrentSession();
			String queryString = "from CompanyEntity";
			Query query = session.createQuery(queryString);
			return query.list();
		}catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getCompaniesList Method");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}

	public CompanyEntity getCompanyById(Long id) throws DBException {
		Query query =null;
		try {
			Session session = sessionFactory.getCurrentSession();
			query= session.createQuery("from CompanyEntity where id=:id");
			query.setParameter("id", id);
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing getCompanyById Method");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
				
		}
			if(log.isDebugEnabled()){
				log.debug("getCompanyById Method failed");
			}
			return (CompanyEntity) query.uniqueResult();
	}
	
}
