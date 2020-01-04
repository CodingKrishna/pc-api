package org.pioneercoders.dto.user;

import java.util.Date;
import java.util.List;

import org.pioneercoders.dto.student.UserLanguagesDto;

public class UserBasicInfoDto {
	private Long id;
	private String profileSummary;
	private String resumePath;
	private String selfIntroVideoPath;
	private Date dob;
	private List<UserLanguagesDto> languages;
	private UserDto user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProfileSummary() {
		return profileSummary;
	}
	public void setProfileSummary(String profileSummary) {
		this.profileSummary = profileSummary;
	}
	public String getResumePath() {
		return resumePath;
	}
	public void setResumePath(String resumePath) {
		this.resumePath = resumePath;
	}
	public String getSelfIntroVideoPath() {
		return selfIntroVideoPath;
	}
	public void setSelfIntroVideoPath(String selfIntroVideoPath) {
		this.selfIntroVideoPath = selfIntroVideoPath;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}

	public List<UserLanguagesDto> getLanguages() {
		return languages;
	}
	public void setLanguages(List<UserLanguagesDto> languages) {
		this.languages = languages;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "UserBasicInfoDto [id=" + id + ", profileSummary="
				+ profileSummary + ", resumePath=" + resumePath
				+ ", selfIntroVideoPath=" + selfIntroVideoPath + ", dob=" + dob
			    + ", languages=" + languages
				+ ", user=" + user + "]";
	}
}
