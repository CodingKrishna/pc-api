package org.pioneercoders.dto.student;

import java.util.List;

public class SkillsDto {

	private List<TechSkillDto> techskills;
	private UserBasicSkillsDto basicSkills;

	public List<TechSkillDto> getTechskills() {
		return techskills;
	}
	public void setTechskills(List<TechSkillDto> techskills) {
		this.techskills = techskills;
	}
	public UserBasicSkillsDto getBasicSkills() {
		return basicSkills;
	}
	public void setBasicSkills(UserBasicSkillsDto basicSkills) {
		this.basicSkills = basicSkills;
	}
	@Override
	public String toString() {
		return "SkillsDto [techskills=" + techskills + ", basicSkills="
				+ basicSkills + "]";
	}
	
}
