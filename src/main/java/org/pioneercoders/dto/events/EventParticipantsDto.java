package org.pioneercoders.dto.events;

import org.pioneercoders.dto.user.UserDto;

public class EventParticipantsDto {
	private long id;
	private UserDto user;
	private EventsDto event;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public EventsDto getEvent() {
		return event;
	}
	public void setEvent(EventsDto event) {
		this.event = event;
	}
	@Override
	public String toString() {
		return "EventParticipantsDto [id=" + id + ", user=" + user + ", event="
				+ event + "]";
	}

}
