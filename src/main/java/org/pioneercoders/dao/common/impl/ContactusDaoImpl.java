package org.pioneercoders.dao.common.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.dao.common.ContactusDao;
import org.pioneercoders.entity.common.ContactusEntity;
import org.pioneercoders.exceptions.DBException;
import org.pioneercoders.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContactusDaoImpl implements ContactusDao{

	@Autowired
	SessionFactory sessionFactory;
	
	private static final Logger log = LoggerFactory.getLogger(ContactusDaoImpl.class);
	
	@Override
	public ContactusEntity createContactusInfo(ContactusEntity contactusEntity)
			throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			contactusEntity.setId((Long)session.save(contactusEntity));
		}catch(Exception e){
			
			if(log.isErrorEnabled()){
				log.error("Exception Occred while creating ContactUs  Record ["+contactusEntity.getEmailId()+"] ["+contactusEntity.getEmailId()+"]");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
			
		}
		if(log.isDebugEnabled()){
			log.debug("Contactus Record is inserted with id ["+contactusEntity.getId()+"] ["+contactusEntity.getEmailId()+"] ["+contactusEntity.getEmailId()+"]");
		}
		return contactusEntity;
	}

	@Override
	public List<ContactusEntity> getContactusInfoList() throws DBException {
		// TODO Auto-generated method stub
		log.debug("Entered into ContactusList Method -->: ");
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from ContactusEntity where status='"+Constants.STATUS_ACTIVE+"'");
			return query.list();
		}catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing ContactusEntity list Method");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}

}
