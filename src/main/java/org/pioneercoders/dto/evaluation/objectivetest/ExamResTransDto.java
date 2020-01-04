package org.pioneercoders.dto.evaluation.objectivetest;

import java.util.List;

import org.pioneercoders.dto.user.UserDto;

public class ExamResTransDto {

	private UserDto user;
	private List<ObjectiveQstnUserAnsDto> examList;
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public List<ObjectiveQstnUserAnsDto> getExamList() {
		return examList;
	}
	public void setExamList(List<ObjectiveQstnUserAnsDto> examList) {
		this.examList = examList;
	}
	@Override
	public String toString() {
		return "ExamResTransDto [user=" + user + ", examList=" + examList + "]";
	}
	
}
