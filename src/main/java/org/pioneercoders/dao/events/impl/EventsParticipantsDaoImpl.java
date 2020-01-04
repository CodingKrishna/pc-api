package org.pioneercoders.dao.events.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.dao.events.EventParticipantsDao;
import org.pioneercoders.entity.events.EventParticipantsEntity;
import org.pioneercoders.exceptions.DBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EventsParticipantsDaoImpl implements EventParticipantsDao{

	@Autowired
	SessionFactory sessionFactory;
	
	private static final Logger logger = LoggerFactory.getLogger(EventsParticipantsDaoImpl.class);
	
	@Override
	public EventParticipantsEntity createEventParticipant(EventParticipantsEntity eventParticipantsEntity)
			throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			eventParticipantsEntity.setId((Long)session.save(eventParticipantsEntity));
		}catch(Exception e){
			
			if(logger.isErrorEnabled()){
				logger.error("Exception Occred while creating EventParticipants  Records ["+eventParticipantsEntity.getId()+"] ["+eventParticipantsEntity.getEvent().getId()+"]");
				logger.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
		if(logger.isDebugEnabled()){
			logger.debug("EventParticipants Record is inserted with id ["+eventParticipantsEntity.getId()+"] ["+eventParticipantsEntity.getEvent().getEventName()+"] ["+eventParticipantsEntity.getEvent().getEventName()+"]");
		}
		return eventParticipantsEntity;
	}

	@Override
	public List<EventParticipantsEntity> getAllEventParticipants() throws DBException {
		logger.debug("Entered into getAllEventParticipants Methode -->: ");
		try {
			Session session = sessionFactory.getCurrentSession();
			String queryString = "from EventParticipantsEntity ";
			Query query = session.createQuery(queryString);
			return query.list();
		}catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("Exception occured while executing getAllEventParticipants ");
				logger.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}

	@Override
	public List<EventParticipantsEntity> getEventParticipantsByUserId(
			Long userId) throws DBException {
		logger.debug("Entered into getEventParticipantsByUserId Methode -->: ");
		try {
			Session session = sessionFactory.getCurrentSession();
			String queryString = "from EventParticipantsEntity where user.id="+userId;
			Query query = session.createQuery(queryString);
			return query.list();
		}catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("Exception occured while executing getEventParticipantsByUserId");
				logger.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}
	
	
}
