package org.pioneercoders.entity.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="support_info_tbl")
public class SupportEntity {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="MOBILE_NO")
	private String mobileNo;
	
	@Column(name="EMAIL_ID")
	private String emailId;
	
	@Column(name="REQUIRED_TECHNOLOGIES")
	private String requiredTechnology;
	
	@Column(name="DESCRIPTION")
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
		return "SupportEntity [id=" + id + ", mobileNo=" + mobileNo
				+ ", emailId=" + emailId + ", requiredTechnology="
				+ requiredTechnology + ", desc=" + desc + "]";
	}
}
