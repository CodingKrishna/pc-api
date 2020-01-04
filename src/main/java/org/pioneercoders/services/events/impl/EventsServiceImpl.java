package org.pioneercoders.services.events.impl;

import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.pioneercoders.dao.events.EventDao;
import org.pioneercoders.dao.events.EventParticipantsDao;
import org.pioneercoders.dto.events.EventParticipantsDto;
import org.pioneercoders.dto.events.EventsDto;
import org.pioneercoders.entity.events.EventParticipantsEntity;
import org.pioneercoders.entity.events.EventsEntity;
import org.pioneercoders.exceptions.DBException;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.course.impl.CourseServiceImpl;
import org.pioneercoders.services.events.EventsService;
import org.pioneercoders.utils.CollectionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EventsServiceImpl implements EventsService{

	private static final Logger log = LoggerFactory.getLogger(CourseServiceImpl.class);

	@Autowired(required = true)
	EventDao eventsDao;
	
	@Autowired
	EventParticipantsDao eventParticipantsDao;
	
	@Override
	public List<EventsDto> getAllEvents() throws ServiceException {
		log.info("Entered into getAllEvents -->: ");
		List<EventsEntity> list;

		try {
			list = eventsDao.getAllEvens();
			List<EventsDto> eventsList = CollectionMapper.getMappingList(list.iterator(), EventsDto.class);
			log.info("Returning eventsList -->: ");
			return eventsList;
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing GetAll Events Method");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public EventParticipantsDto createEventParticipants(
			EventParticipantsDto eventParticipantsDto) throws ServiceException {
		EventParticipantsDto finalDto=null;
			try {
				EventParticipantsEntity entity = DozerBeanMapperSingletonWrapper.getInstance().map(eventParticipantsDto, EventParticipantsEntity.class);
				finalDto = DozerBeanMapperSingletonWrapper.getInstance().map(eventParticipantsDao.createEventParticipant(entity),EventParticipantsDto.class);
			} catch (DBException e) {
				throw new ServiceException(e.getMessage(), e);
			}
			return finalDto;
	}

	@Override
	public List<EventParticipantsDto> getAllEventPaticipants()
			throws ServiceException {
		log.info("Entered into getAllEventParticipants Method -->: ");
		List<EventParticipantsEntity> list;

		try {
			list = eventParticipantsDao.getAllEventParticipants();
			List<EventParticipantsDto> eventParticipantsList = CollectionMapper.getMappingList(list.iterator(), EventParticipantsDto.class);
			log.info("Returning eventParticipantsList -->: ");
			return eventParticipantsList;
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing Get AllEventParticipants Method");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<EventParticipantsDto> getEventParticipantsByUserId(Long userId)
			throws ServiceException {
		log.info("Entered into getEventParticipantsByUserId Method -->: ");
		List<EventParticipantsEntity> list;

		try {
			list = eventParticipantsDao.getEventParticipantsByUserId(userId);
			List<EventParticipantsDto> eventParticipantsList = CollectionMapper.getMappingList(list.iterator(), EventParticipantsDto.class);
			log.info("Returning getEventParticipantsByUserId data -->: ");
			return eventParticipantsList;
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getEventParticipantsByUserId method");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
	}
}
