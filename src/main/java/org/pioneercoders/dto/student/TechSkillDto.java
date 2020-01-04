package org.pioneercoders.dto.student;

import org.pioneercoders.dto.common.TechnologiesDto;
import org.pioneercoders.dto.user.UserDto;

public class TechSkillDto {

	private Long id;
	private TechnologiesDto technology;
	private UserDto user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TechnologiesDto getTechnology() {
		return technology;
	}
	public void setTechnology(TechnologiesDto technology) {
		this.technology = technology;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "TechnologyTrnDto [id=" + id + ", technology=" + technology
				+ ", user=" + user + "]";
	}
	
	
}
