package org.pioneercoders.dto.evaluation.codingtest;

import org.pioneercoders.dto.user.UserDto;

public class CodingTestResultDto {
	
	private Long id;
	private CodingTestQstnDto codingTestQstn;
	private Long points;
	private UserDto user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CodingTestQstnDto getCodingTestQstn() {
		return codingTestQstn;
	}
	public void setCodingTestQstn(CodingTestQstnDto codingTestQstn) {
		this.codingTestQstn = codingTestQstn;
	}
	public Long getPoints() {
		return points;
	}
	public void setPoints(Long points) {
		this.points = points;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "CodingTestResultDto [id=" + id + ", codingTestQstn="
				+ codingTestQstn + ", points=" + points + ", user=" + user
				+ "]";
	}
	
	
}
