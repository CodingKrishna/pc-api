package org.pioneercoders.dao.events.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.dao.events.EventDao;
import org.pioneercoders.entity.events.EventsEntity;
import org.pioneercoders.exceptions.DBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class EventDaoImpl implements EventDao{

	@Autowired
	SessionFactory sessionFactory;
	
	private static final Logger log = LoggerFactory.getLogger(EventDaoImpl.class);
	
	@Override
	public List<EventsEntity> getAllEvens()throws DBException {
		log.debug("Entered into getAllEvents Methode -->: ");
		try {
			Session session = sessionFactory.getCurrentSession();
			String queryString = "from EventsEntity where eventDate >= now()";
			Query query = session.createQuery(queryString);
			return query.list();
		}catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getAllEvents ");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}

}
