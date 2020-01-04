package org.pioneercoders.entity.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.pioneercoders.entity.common.RoleEntity;

@Entity
@Table(name="user_mst_tbl")
public class UserEntity {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="USERNAME")
	private String userName;
	
	@Column(name="EMAILID")
	private String emailId;
	
	@Column(name="MOBILENO")
	private String  mobileNo;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="STATUS")
	private String status;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ROLE_ID")
	private RoleEntity role;
	
	@Column(name="CREATED_ON")
	private Date createdOn;
	
	@Column(name="VISIBILITY")
	private Boolean isVisible;
	
	@Column(name="IS_EXAM_COMPLETED")
	private Boolean examCompleted;
	
	
	public UserEntity() {
		super();
	}

	public UserEntity(Long id, String userName, String emailId, String mobileNo, String status,RoleEntity role, Date createdOn,Boolean isVisible,Boolean examCompleted) {
		super();
		this.id = id;
		this.userName = userName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.status = status;
		this.role = role;
		this.createdOn =createdOn;
		this.isVisible=isVisible;
		this.examCompleted=examCompleted;
	}
	
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
	
	
	public RoleEntity getRole() {
		return role;
	}
	public void setRole(RoleEntity role) {
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

	
	
	

}
