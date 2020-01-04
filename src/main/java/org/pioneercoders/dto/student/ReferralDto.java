package org.pioneercoders.dto.student;

import org.pioneercoders.dto.user.UserDto;

public class ReferralDto {
	
	private Long id;
	private String referralName;
	private String mobileNo;
	private String emailId;
	private UserDto user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReferralName() {
		return referralName;
	}
	public void setReferralName(String referralName) {
		this.referralName = referralName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "ReferralDto [id=" + id + ", referralName=" + referralName
				+ ", mobileNo=" + mobileNo + ", emailId=" + emailId + ", user="
				+ user + "]";
	}
	
	

}
