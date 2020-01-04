package org.pioneercoders.dao.events;

import java.util.List;

import org.pioneercoders.entity.events.EventParticipantsEntity;
import org.pioneercoders.exceptions.DBException;

public interface EventParticipantsDao {
	
	public EventParticipantsEntity createEventParticipant(EventParticipantsEntity entity)throws DBException;
	
	public List<EventParticipantsEntity> getAllEventParticipants() throws DBException;
	
	public List<EventParticipantsEntity> getEventParticipantsByUserId(Long userId) throws DBException;

}
