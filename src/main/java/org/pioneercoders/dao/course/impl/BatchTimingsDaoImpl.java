package org.pioneercoders.dao.course.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.dao.course.BatchTimingsDao;
import org.pioneercoders.entity.course.BatchTimingsEntity;
import org.pioneercoders.exceptions.DBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BatchTimingsDaoImpl implements BatchTimingsDao{

	@Autowired
	SessionFactory sessionFactory;
	
	private static final Logger log = LoggerFactory.getLogger(BatchTimingsDaoImpl.class);
	
	@Override
	public List<BatchTimingsEntity> getAllBatchDetailsByCourseId(Long courseId) throws DBException {
		log.debug("Entered into getAllBatchDetails Methode -->: ");
		try {
			Session session = sessionFactory.getCurrentSession();
			String queryString = "from BatchTimingsEntity where course.id="+courseId;
			Query query = session.createQuery(queryString);
			return query.list();
		}catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getAllBatchDetails");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}

}
