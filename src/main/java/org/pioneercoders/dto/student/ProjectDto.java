package org.pioneercoders.dto.student;


import java.util.Date;

import org.pioneercoders.dto.user.UserDto;


public class ProjectDto {
	
	private Long id;
	private String projectTitle;
	private String desc;
	private Date startDate;
	private Date endDate;
	private String responsibilities;
	private ProjectDomainDto projectdomain;
	private UserDto user;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getResponsibilities() {
		return responsibilities;
	}
	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public ProjectDomainDto getProjectdomain() {
		return projectdomain;
	}
	public void setProjectdomain(ProjectDomainDto projectdomain) {
		this.projectdomain = projectdomain;
	}
	@Override
	public String toString() {
		return "ProjectDto [id=" + id + ", projectTitle=" + projectTitle
				+ ", desc=" + desc + ", startDate=" + startDate + ", endDate="
				+ endDate + ", responsibilities=" + responsibilities
				+ ", user=" + user + "]";
	}

}
