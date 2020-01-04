package org.pioneercoders.dto.student;

import org.pioneercoders.dto.user.UserDto;

public class EmployersInfoDto {
	
	private Long id;
	private String employer;
	private String employerStatus;
	private String monthStart;
	private String yearStart;
	private String monthEnd;
	private String yearEnd;
	private String designation;
	private String jobProfile;
	private UserDto user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmployer() {
		return employer;
	}
	public void setEmployer(String employer) {
		this.employer = employer;
	}
	public String getEmployerStatus() {
		return employerStatus;
	}
	public void setEmployerStatus(String employerStatus) {
		this.employerStatus = employerStatus;
	}
	public String getMonthStart() {
		return monthStart;
	}
	public void setMonthStart(String monthStart) {
		this.monthStart = monthStart;
	}
	public String getYearStart() {
		return yearStart;
	}
	public void setYearStart(String yearStart) {
		this.yearStart = yearStart;
	}
	public String getMonthEnd() {
		return monthEnd;
	}
	public void setMonthEnd(String monthEnd) {
		this.monthEnd = monthEnd;
	}
	public String getYearEnd() {
		return yearEnd;
	}
	public void setYearEnd(String yearEnd) {
		this.yearEnd = yearEnd;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getJobProfile() {
		return jobProfile;
	}
	public void setJobProfile(String jobProfile) {
		this.jobProfile = jobProfile;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "WorkExperianceDto [id=" + id + ", employer=" + employer
				+ ", employerStatus=" + employerStatus + ", monthStart="
				+ monthStart + ", yearStart=" + yearStart + ", monthEnd="
				+ monthEnd + ", yearEnd=" + yearEnd + ", designation="
				+ designation + ", jobProfile=" + jobProfile + ", user=" + user
				+ "]";
	}
	
	
}
