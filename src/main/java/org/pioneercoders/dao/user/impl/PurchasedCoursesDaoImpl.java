package org.pioneercoders.dao.user.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.dao.user.PurchasedCoursesDao;
import org.pioneercoders.entity.student.PurchasedCourseEntity;
import org.pioneercoders.exceptions.DBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class PurchasedCoursesDaoImpl implements PurchasedCoursesDao{

	@Autowired
	SessionFactory sessionFactory;
	
	private static final Logger log = LoggerFactory.getLogger(PurchasedCoursesDaoImpl.class);
	
	@Override
	public PurchasedCourseEntity createPurchasedCourseRecord(PurchasedCourseEntity purchaseCourseEntity)
			throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			purchaseCourseEntity.setId((Long)session.save(purchaseCourseEntity));
		}catch(Exception e){
			
			if(log.isErrorEnabled()){
				log.error("Exception Occred while creating PurchasedCourses  Records ["+purchaseCourseEntity.getId()+"] ["+purchaseCourseEntity.getCourseId().getId()+"]");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
			
		}
		if(log.isDebugEnabled()){
			log.debug("PurchasedCourses Record is inserted with id ["+purchaseCourseEntity.getId()+"] ["+purchaseCourseEntity.getId()+"] ["+purchaseCourseEntity.getUser().getUserName()+"]");
		}
		return purchaseCourseEntity;
	}

	@Override
	public List<PurchasedCourseEntity> getPurchasedCoursesByUserId(Long userId)
			throws DBException {
		log.debug("Entered into getPurchasedCoursesByUserId Methode -->: ");
		try {
			Session session = sessionFactory.getCurrentSession();
			String queryString = "from PurchasedCourseEntity where user.id="+userId;
			Query query = session.createQuery(queryString);
			return query.list();
		}catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getPurchasedCoursesByUserId ");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}

}
