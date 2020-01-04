package org.pioneercoders.entity.events;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.pioneercoders.entity.user.UserEntity;

@Entity
@Table(name="eventparticipants_trn_tbl")
public class EventParticipantsEntity {
	
	private long id;
	private UserEntity user;
	private EventsEntity event;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="USER_ID")
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="EVENT_ID")
	public EventsEntity getEvent() {
		return event;
	}
	public void setEvent(EventsEntity event) {
		this.event = event;
	}
	@Override
	public String toString() {
		return "EventParticipantsEntity [id=" + id + ", user=" + user
				+ ", event=" + event + "]";
	}
	
}
