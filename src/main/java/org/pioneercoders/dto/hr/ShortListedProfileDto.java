package org.pioneercoders.dto.hr;

public class ShortListedProfileDto {
	
	private Long id;
	private String emailId;
	private String name;
	private String message;
	private String mobileNo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "ShortListedProfileDto [id=" + id + ", emailId=" + emailId
				+ ", name=" + name + ", message=" + message + "]";
	}
	
}
