package org.pioneercoders.dto.user;

import java.util.Date;

import org.pioneercoders.dto.common.RoleDto;

public class UserDto {
	
	private Long id;
	private String userName;
	private String emailId;
	private String  mobileNo;
	private String password;
	private String status;
	private RoleDto role;
	private Date createdOn;
	private Boolean isVisible;
	private Boolean examCompleted;

	
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}/*
	public UserDto(Long id, String userName, String emailId,
			String mobileNo, String status, RoleDto role,Date createdOn,Boolean isVisible,String interviewStatus,String ratingValue,
			Boolean reShedule,Date interviewDate,Boolean examCompleted,String interviewTiming) {
		super();
		this.id = id;
		this.userName = userName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.status = status;
		this.role = role;
		this.createdOn=createdOn;
		this.isVisible = isVisible;
		this.interviewStatus=interviewStatus;
		this.ratingValue = ratingValue;
		this.reShedule = reShedule;
		this.interviewDate = interviewDate;
		this.examCompleted = examCompleted;
		this.interviewTiming = interviewTiming;
	}*/

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		 this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public RoleDto getRole() {
		return role;
	}
	public void setRole(RoleDto role) {
		this.role = role;
	}
	
	public Date getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	public Boolean getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(Boolean isVisible) {
		this.isVisible = isVisible;
	}

	public Boolean getExamCompleted() {
		return examCompleted;
	}

	public void setExamCompleted(Boolean examCompleted) {
		this.examCompleted = examCompleted;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", userName=" + userName + ", emailId="
				+ emailId + ", mobileNo=" + mobileNo + ", password=" + password
				+ ", status=" + status + ", role=" + role + ", createdOn="
				+ createdOn + ", isVisible=" + isVisible + ", examCompleted=" + examCompleted + "]";
	}

}
