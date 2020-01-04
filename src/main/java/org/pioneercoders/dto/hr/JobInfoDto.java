package org.pioneercoders.dto.hr;

import java.util.Date;

import org.pioneercoders.dto.user.UserDto;

public class JobInfoDto {
	
	private Long id;
	private String jobTitle;
	private String jobDescription;
	private String location;
	private Date postedDate;
	private Date closedDate;
	private String requiredSkills;
	private CompanyDto company;
	private UserDto user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}
	public Date getClosedDate() {
		return closedDate;
	}
	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}
	public String getRequiredSkills() {
		return requiredSkills;
	}
	public void setRequiredSkills(String requiredSkills) {
		this.requiredSkills = requiredSkills;
	}
	public CompanyDto getCompany() {
		return company;
	}
	public void setCompany(CompanyDto company) {
		this.company = company;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "JobInfoDto [id=" + id + ", jobTitle=" + jobTitle
				+ ", jobDescription=" + jobDescription + ", location="
				+ location + ", postedDate=" + postedDate + ", closedDate="
				+ closedDate + ", requiredSkills=" + requiredSkills
				+ ", company=" + company + ", user=" + user + "]";
	}
	

}
