package org.pioneercoders.dto.student;

import java.util.List;

import org.pioneercoders.dto.user.UserBasicInfoDto;

public class ProfileWithLanguageDto {

	private UserBasicInfoDto userBasicProfile;
	
	private List<TechSkillDto> techskills;

	public UserBasicInfoDto getUserBasicProfile() {
		return userBasicProfile;
	}

	public void setUserBasicProfile(UserBasicInfoDto userBasicProfile) {
		this.userBasicProfile = userBasicProfile;
	}

	public List<TechSkillDto> getTechskills() {
		return techskills;
	}

	public void setTechskills(List<TechSkillDto> techskills) {
		this.techskills = techskills;
	}

	@Override
	public String toString() {
		return "ProfileWithLanguageDto [userBasicProfile=" + userBasicProfile
				+ ", techskills=" + techskills + "]";
	}
	
}
