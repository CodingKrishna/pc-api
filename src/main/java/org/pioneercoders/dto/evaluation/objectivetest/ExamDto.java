package org.pioneercoders.dto.evaluation.objectivetest;

import java.util.List;

import org.pioneercoders.dto.user.UserDto;

public class ExamDto {
	private Long id;
	private List<ObjectiveQstnDto> questsList;
	private String technology;
	private UserDto user;
	private Long totalQuestions;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<ObjectiveQstnDto> getQuestsList() {
		return questsList;
	}
	public void setQuestsList(List<ObjectiveQstnDto> questsList) {
		this.questsList = questsList;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	
	public Long getTotalQuestions() {
		return totalQuestions;
	}
	public void setTotalQuestions(Long totalQuestions) {
		this.totalQuestions = totalQuestions;
	}
	@Override
	public String toString() {
		return "ExamDto [id=" + id + ", questsList=" + questsList
				+ ", technology=" + technology + ", user=" + user
				+ ", totalQuestions=" + totalQuestions + "]";
	}
	

} 
