package org.pioneercoders.dto.student;

import org.pioneercoders.dto.user.UserDto;


public class SocialInfoDto {
	
	 private long id;
	 private String facebookId;
	 private String twitterId;
	 private String  skypeId;
	 private String whatsappNo;
	 private UserDto user;
	 
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFacebookId() {
		return facebookId;
	}
	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}
	public String getTwitterId() {
		return twitterId;
	}
	public void setTwitterId(String twitterId) {
		this.twitterId = twitterId;
	}
	public String getSkypeId() {
		return skypeId;
	}
	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}
	public String getWhatsappNo() {
		return whatsappNo;
	}
	public void setWhatsappNo(String whatsappNo) {
		this.whatsappNo = whatsappNo;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "SocialInfoDto [id=" + id + ", facebookId=" + facebookId
				+ ", twitterId=" + twitterId + ", skypeId=" + skypeId
				+ ", whatsappNo=" + whatsappNo + ", user=" + user + "]";
	}
	 
}
