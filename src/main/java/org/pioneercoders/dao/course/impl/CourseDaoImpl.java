package org.pioneercoders.dao.course.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.dao.course.CourseDao;
import org.pioneercoders.entity.course.CourseEntity;
import org.pioneercoders.exceptions.DBException;
import org.pioneercoders.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDaoImpl implements CourseDao {

	@Autowired
	SessionFactory sessionFactory;
	
	private static final Logger log = LoggerFactory.getLogger(CourseDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<CourseEntity> getAllCourses(boolean featuredCourses) throws DBException {
		// TODO Auto-generated method stub
		log.debug("Entered into listCourses -->: ");
		try {
			Session session = sessionFactory.getCurrentSession();
			String queryString = "from CourseEntity where status='"+Constants.STATUS_ACTIVE+"'";
			if (featuredCourses) {
				queryString += "and isFeaturedCourse = true";
			}
			Query query = session.createQuery(queryString);
			return query.list();
		}catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing CourseList Data ");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}

	}

	@Override
	public CourseEntity getCourseInfo(Long courseId) throws DBException {
		// TODO Auto-generated method stub
		Query query =null;
		try {
			Session session = sessionFactory.getCurrentSession();
			query= session.createQuery("from CourseEntity where id=:courseId and status='"+Constants.STATUS_ACTIVE+"'");
			query.setParameter("courseId", courseId);
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing CourseDetailsById");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
				
		}
		if(log.isDebugEnabled()){
			log.debug("User Details Method failed");
		}
		return (CourseEntity) query.uniqueResult();
	}

}