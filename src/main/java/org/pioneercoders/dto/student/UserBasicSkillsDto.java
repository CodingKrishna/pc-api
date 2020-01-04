package org.pioneercoders.dto.student;

import org.pioneercoders.dto.user.UserDto;


public class UserBasicSkillsDto {
	
	private Long id;
	private Long commRating;
	private Long analyticalRating;
	private UserDto user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCommRating() {
		return commRating;
	}
	public void setCommRating(Long commRating) {
		this.commRating = commRating;
	}
	
	public Long getAnalyticalRating() {
		return analyticalRating;
	}
	public void setAnalyticalRating(Long analyticalRating) {
		this.analyticalRating = analyticalRating;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "SkillsetDto [id=" + id + ", skills=" + ", commRating="
				+ commRating + ", analyticalRating=" + analyticalRating
				+ ", user=" + user + "]";
	}

}
