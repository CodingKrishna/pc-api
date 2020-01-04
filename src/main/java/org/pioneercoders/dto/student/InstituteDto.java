package org.pioneercoders.dto.student;

import java.util.Date;

import org.pioneercoders.dto.user.UserDto;

public class InstituteDto {
	private Long id;
	private String instituteName;
	private UniversityDto university;
	private String collegePhoneNo;
	private Date startDate;
	private String description;
	private UserDto poId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	public String getCollegePhoneNo() {
		return collegePhoneNo;
	}
	public void setCollegePhoneNo(String collegePhoneNo) {
		this.collegePhoneNo = collegePhoneNo;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public UserDto getPoId() {
		return poId;
	}
	public void setPoId(UserDto poId) {
		this.poId = poId;
	}
	public UniversityDto getUniversity() {
		return university;
	}
	public void setUniversity(UniversityDto university) {
		this.university = university;
	}

	

}
