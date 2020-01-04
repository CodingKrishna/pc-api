package org.pioneercoders.dto.common;

public class SubscribeDto {
	private String subscriberEmail;

	public String getSubscriberEmail() {
		return subscriberEmail;
	}

	public void setSubscriberEmail(String subscriberEmail) {
		this.subscriberEmail = subscriberEmail;
	}

	@Override
	public String toString() {
		return "SubscribeDto [subscriberEmail=" + subscriberEmail + "]";
	}

}
