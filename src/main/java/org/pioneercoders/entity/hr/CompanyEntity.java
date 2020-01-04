package org.pioneercoders.entity.hr;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="company_mst_tbl")
public class CompanyEntity {
	
	private Long id;
	private String companyName;
	private String phoneNo;
	private String logo;
	private String companyUrl;
	private String emailId;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="COMPANY_NAME")
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@Column(name="PHONE_NO")
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	@Column(name="LOGO")
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	@Column(name="URL_PATH")
	public String getCompanyUrl() {
		return companyUrl;
	}
	public void setCompanyUrl(String companyUrl) {
		this.companyUrl = companyUrl;
	}
	
	@Column(name="EMAIL_ID")
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "CompanyEntity [id=" + id + ", companyName=" + companyName
				+ ", phoneNo=" + phoneNo + ", logo=" + logo + ", companyUrl="
				+ companyUrl + ", emailId=" + emailId + "]";
	}


	

}
