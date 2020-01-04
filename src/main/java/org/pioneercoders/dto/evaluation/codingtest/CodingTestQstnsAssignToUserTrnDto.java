package org.pioneercoders.dto.evaluation.codingtest;

import org.pioneercoders.dto.user.UserDto;

public class CodingTestQstnsAssignToUserTrnDto {
	private Long id;
	private CodingTestQstnDto question;
	private UserDto user;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CodingTestQstnDto getQuestion() {
		return question;
	}
	public void setQuestion(CodingTestQstnDto question) {
		this.question = question;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "CodingTestQstnsTrnDto [id=" + id + ", question=" + question
				+ ", user=" + user + "]";
	}
	
	
	
}
