package org.pioneercoders.dao.events;

import java.util.List;

import org.pioneercoders.entity.events.EventsEntity;
import org.pioneercoders.exceptions.DBException;

public interface EventDao {
	public List<EventsEntity> getAllEvens() throws DBException;
}
