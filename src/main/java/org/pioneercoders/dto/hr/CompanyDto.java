package org.pioneercoders.dto.hr;
public class CompanyDto {
	
	private Long id;
	private String companyName;
	private String phoneNo;
	private String logo;
	private String companyUrl;
	private String emailId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getCompanyUrl() {
		return companyUrl;
	}
	public void setCompanyUrl(String companyUrl) {
		this.companyUrl = companyUrl;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "CompanyDto [id=" + id + ", companyName=" + companyName
				+ ", phoneNo=" + phoneNo + ", logo=" + logo + ", companyUrl="
				+ companyUrl + ", emailId=" + emailId + "]";
	}
	
	

}
