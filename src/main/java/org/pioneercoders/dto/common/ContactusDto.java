package org.pioneercoders.dto.common;

import java.util.Date;

public class ContactusDto {
	
	private Long id;
	private String name;
	private String mobileNo;
	private String emailId;
	private String comments;
	private Date createdOn;
	private String status;
	
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


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public Date getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "ContactusDto [id=" + id + ", name=" + name + ", mobileNo="
				+ mobileNo + ", emailId=" + emailId + ", comments=" + comments
				+ ", createdOn=" + createdOn + ", status=" + status + "]";
	}




	

}
