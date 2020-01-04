package org.pioneercoders.services.events;

import java.util.List;

import org.pioneercoders.dto.events.EventParticipantsDto;
import org.pioneercoders.dto.events.EventsDto;
import org.pioneercoders.exceptions.ServiceException;

public interface EventsService {

	public List<EventsDto> getAllEvents()throws ServiceException;
	
	public EventParticipantsDto createEventParticipants(EventParticipantsDto eventParticipantsDto) throws ServiceException;
	
	public List<EventParticipantsDto> getAllEventPaticipants() throws ServiceException;
	
	public List<EventParticipantsDto> getEventParticipantsByUserId(Long userId)throws ServiceException;
	
	
}
