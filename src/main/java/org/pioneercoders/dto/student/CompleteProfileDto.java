package org.pioneercoders.dto.student;

import java.util.List;

import org.pioneercoders.dto.user.UserBasicInfoDto;
import org.pioneercoders.dto.user.UserDto;

public class CompleteProfileDto {
	
	private UserDto user;
	private List<EducationDto> education;
	private List<ProjectDto> project;
	private SkillsDto skill;
	private SocialInfoDto social;
	private List<EmployersInfoDto> employersInfo;
    private List<UserLanguagesDto> languages;
	private UserExperianceDto userExperianceInfo;
	private List<PurchasedCourseDto> purchaseCourseDto;
	private AddressDto address;
	private UserBasicInfoDto userBasicInfo;
	
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public List<EducationDto> getEducation() {
		return education;
	}
	public void setEducation(List<EducationDto> education) {
		this.education = education;
	}
	public List<ProjectDto> getProject() {
		return project;
	}
	public void setProject(List<ProjectDto> project) {
		this.project = project;
	}
	public SkillsDto getSkill() {
		return skill;
	}
	public void setSkill(SkillsDto skill) {
		this.skill = skill;
	}
	public SocialInfoDto getSocial() {
		return social;
	}
	public void setSocial(SocialInfoDto social) {
		this.social = social;
	}
	public List<EmployersInfoDto> getEmployersInfo() {
		return employersInfo;
	}
	public void setEmployersInfo(List<EmployersInfoDto> employersInfo) {
		this.employersInfo = employersInfo;
	}
	public List<UserLanguagesDto> getLanguages() {
		return languages;
	}
	public void setLanguages(List<UserLanguagesDto> languages) {
		this.languages = languages;
	}
	public UserExperianceDto getUserExperianceInfo() {
		return userExperianceInfo;
	}
	public void setUserExperianceInfo(UserExperianceDto userExperianceInfo) {
		this.userExperianceInfo = userExperianceInfo;
	}
	public List<PurchasedCourseDto> getPurchaseCourseDto() {
		return purchaseCourseDto;
	}
	public void setPurchaseCourseDto(List<PurchasedCourseDto> purchaseCourseDto) {
		this.purchaseCourseDto = purchaseCourseDto;
	}
	public AddressDto getAddress() {
		return address;
	}
	public void setAddress(AddressDto address) {
		this.address = address;
	}
	public UserBasicInfoDto getUserBasicInfo() {
		return userBasicInfo;
	}
	public void setUserBasicInfo(UserBasicInfoDto userBasicInfo) {
		this.userBasicInfo = userBasicInfo;
	}
	@Override
	public String toString() {
		return "CompleteProfileDto [user=" + user + ", education=" + education
				+ ", project=" + project + ", skillset="
				+ ", social=" + social + ", userBasicInfo="
				+ ", totalWorkExpInfo="
				+ ", purchaseCourseDto=" + purchaseCourseDto + "]";
	}
	
}
