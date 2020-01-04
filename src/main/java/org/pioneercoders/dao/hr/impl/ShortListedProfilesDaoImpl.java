package org.pioneercoders.dao.hr.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.dao.hr.ShortListedProfilesDao;
import org.pioneercoders.entity.hr.ShortListedProfileEntity;
import org.pioneercoders.exceptions.DBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class ShortListedProfilesDaoImpl implements ShortListedProfilesDao{

	@Autowired
	SessionFactory sessionFactory;
	
	private static final Logger log = LoggerFactory.getLogger(ShortListedProfilesDaoImpl.class);
	
	public ShortListedProfileEntity createProfileRecord(ShortListedProfileEntity shortListedProfileEntity) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			shortListedProfileEntity.setId((Long)session.save(shortListedProfileEntity));
		} catch(Exception e){
			 if(log.isErrorEnabled()) {
				 log.error("Exception Occred while creating shortListedProfile  Record ["+shortListedProfileEntity.getEmailId()+"] ["+shortListedProfileEntity.getName()+"]");
				 log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
			
		}
		if(log.isDebugEnabled()) {
			log.debug("shortListedProfile Record inserted with id ["+shortListedProfileEntity.getId()+"] ["+shortListedProfileEntity.getName()+"] ["+shortListedProfileEntity.getEmailId()+"]");
		}
		return shortListedProfileEntity;
	}

	public List<ShortListedProfileEntity> getShortListedProfiles()
			throws DBException {
		log.debug("Entered into getShortListedProfiles Methode -->: ");
		try {
			Session session = sessionFactory.getCurrentSession();
			String queryString = "from ShortListedProfileEntity";
			Query query = session.createQuery(queryString);
			return query.list();
		}catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getShortListedProfiles Method");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}

}
