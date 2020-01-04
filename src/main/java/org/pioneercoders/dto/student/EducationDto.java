package org.pioneercoders.dto.student;

import org.pioneercoders.dto.user.UserDto;


public class EducationDto {
	
	private Long id;
	private String educationType;
	private InstituteDto institute;
	private UniversityDto university;
	private String branch;
	private String yearOfPassing;
	private Float percentage;
	private UserDto user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEducationType() {
		return educationType;
	}
	public void setEducationType(String educationType) {
		this.educationType = educationType;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getYearOfPassing() {
		return yearOfPassing;
	}
	public void setYearOfPassing(String yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}
	public Float getPercentage() {
		return percentage;
	}
	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public InstituteDto getInstitute() {
		return institute;
	}
	public void setInstitute(InstituteDto institute) {
		this.institute = institute;
	}
	public UniversityDto getUniversity() {
		return university;
	}
	public void setUniversity(UniversityDto university) {
		this.university = university;
	}
	@Override
	public String toString() {
		return "EducationDto [id=" + id + ", educationType=" + educationType
				+ ", instituteid=" + institute + ", branch=" + branch
				+ ", yearOfPassing=" + yearOfPassing + ", percentage="
				+ percentage + ", user=" + user + "]";
	}

}
