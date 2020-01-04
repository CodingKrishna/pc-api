package org.pioneercoders.entity.events;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="events_tbl")
public class EventsEntity {

	private Long id;
	private String eventOrganisedBy;
	private Date eventDate;
	private String eventName;
	private String eventDesc;
	private String imgPath;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="ORGANISED_BY")
	public String getEventOrganisedBy() {
		return eventOrganisedBy;
	}
	public void setEventOrganisedBy(String eventOrganisedBy) {
		this.eventOrganisedBy = eventOrganisedBy;
	}
	
	@Column(name="EVENT_DATE")
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	
	@Column(name="EVENT_NAME")
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	@Column(name="EVENT_DESCRIPTION")
	public String getEventDesc() {
		return eventDesc;
	}
	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}
	
	@Column(name="IMAGE_PATH")
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	@Override
	public String toString() {
		return "EventsEntity [id=" + id + ", eventOrganisedBy="
				+ eventOrganisedBy + ", eventDate=" + eventDate
				+ ", eventName=" + eventName + ", eventDesc=" + eventDesc + "]";
	}
	
	
}
