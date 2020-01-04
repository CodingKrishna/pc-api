package org.pioneercoders.dao.common.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.dao.common.InstructorDao;
import org.pioneercoders.entity.common.InstructorEntity;
import org.pioneercoders.exceptions.DBException;
import org.pioneercoders.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InstructorDaoImpl implements InstructorDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	private static final Logger log = LoggerFactory.getLogger(InstructorDaoImpl.class);

	@Override
	public InstructorEntity createInstructorInfo(InstructorEntity instructorEntity) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			instructorEntity.setId((Long)session.save(instructorEntity));
		}catch(Exception e){
			
			if(log.isErrorEnabled()){
				log.error("Exception Occred while creating Instructor  Record ["+instructorEntity.getEmailId()+"] ["+instructorEntity.getEmailId()+"]");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
			
		}
		if(log.isDebugEnabled()){
			log.debug("Instructor Record is inserted with id ["+instructorEntity.getId()+"] ["+instructorEntity.getEmailId()+"] ["+instructorEntity.getEmailId()+"]");
		}
		return instructorEntity;
	}

	@Override
	public List<InstructorEntity> getInstructorsList() throws DBException {
		// TODO Auto-generated method stub
		log.debug("Entered into InstructorList Method -->: ");
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from InstructorEntity where status='"+Constants.STATUS_ACTIVE+"'");
			return query.list();
		}catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing InstructorList Method");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}

}
