package org.pioneercoders.dto.events;

import java.util.Date;

public class EventsDto {
	private Long id;
	private String eventOrganisedBy;
	private Date eventDate;
	private String eventName;
	private String eventDesc;
	private String imgPath;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEventOrganisedBy() {
		return eventOrganisedBy;
	}
	public void setEventOrganisedBy(String eventOrganisedBy) {
		this.eventOrganisedBy = eventOrganisedBy;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDesc() {
		return eventDesc;
	}
	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	@Override
	public String toString() {
		return "EventsDto [id=" + id + ", eventOrganisedBy=" + eventOrganisedBy
				+ ", eventDate=" + eventDate + ", eventName=" + eventName
				+ ", eventDesc=" + eventDesc + "]";
	}
	
	
	

}
