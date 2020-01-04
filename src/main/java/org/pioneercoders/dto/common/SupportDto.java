package org.pioneercoders.dto.common;

public class SupportDto {
	
	private Long id;
	private String name;
	private String mobileNo;
	private String emailId;
	private String requiredTechnology;
	private String desc;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getRequiredTechnology() {
		return requiredTechnology;
	}
	public void setRequiredTechnology(String requiredTechnology) {
		this.requiredTechnology = requiredTechnology;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "SupportDto [id=" + id + ", mobileNo=" + mobileNo + ", emailId="
				+ emailId + ", requiredTechnology=" + requiredTechnology
				+ ", desc=" + desc + "]";
	}
	
	
	
	
}
