package org.pioneercoders.dto.evaluation.objectivetest;

import org.pioneercoders.dto.user.UserDto;

public class ObjectiveTestTotalResultDto {
	private Long id;
	private UserDto user;
	private Long totalMarks;
	private Long totalQuestions;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public Long getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(Long totalMarks) {
		this.totalMarks = totalMarks;
	}
	
	public Long getTotalQuestions() {
		return totalQuestions;
	}
	public void setTotalQuestions(Long totalQuestions) {
		this.totalQuestions = totalQuestions;
	}
	@Override
	public String toString() {
		return "ExamTrnDto [id=" + id + ", technology="
				+ ", user=" + user + ", totalMarks=" + totalMarks
				+ ", totalQuestions=" + totalQuestions + "]";
	}

	
}
