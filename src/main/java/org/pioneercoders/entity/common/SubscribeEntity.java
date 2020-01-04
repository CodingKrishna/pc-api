package org.pioneercoders.entity.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="subscriber_tbl")
public class SubscribeEntity {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	
	@Column(name="SUBSCRIBER_EMAIL")
	private String subscriberEmail;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubscriberEmail() {
		return subscriberEmail;
	}

	public void setSubscriberEmail(String subscriberEmail) {
		this.subscriberEmail = subscriberEmail;
	}

	@Override
	public String toString() {
		return "SubscribeEntity [id=" + id + ", subscriberEmail="
				+ subscriberEmail + "]";
	}
	
}
