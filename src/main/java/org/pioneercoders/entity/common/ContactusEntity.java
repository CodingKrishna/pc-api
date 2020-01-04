package org.pioneercoders.entity.common;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contactus_mst_tbl")
public class ContactusEntity {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="MOBILE_NO")
	private String mobileNo;
	
	@Column(name="EMAIL_ID")
	private String emailId;
	
	@Column(name="COMMENTS",length=5000)
	private String comments;
	
	@Column(name="CREATED_ON")
	private Date createdOn;
	
	@Column(name="STATUS")
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
		return "ContactusEntity [id=" + id + ", name=" + name + ", mobileNo="
				+ mobileNo + ", emailId=" + emailId + ", comments=" + comments
				+ ", createdOn=" + createdOn + ", status=" + status + "]";
	}
	
}
