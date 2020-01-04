package org.pioneercoders.dto.Interview;

import java.util.List;

import org.pioneercoders.dto.evaluation.codingtest.CodingTestQstnDto;
import org.pioneercoders.dto.evaluation.objectivetest.ObjectiveQstnDto;
import org.pioneercoders.dto.user.UserDto;

public class InterviewResultsDto {
	
	private Long id;
	private InterviewsDto test;
	private UserDto user;
	private RoundsDto rounds;
	private Long totalQuestions;
	private List<ObjectiveQstnDto> questsList;
	private Long totalMarks;
	private CodingTestQstnDto codingTestQstn;
	private Integer points;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTotalQuestions() {
		return totalQuestions;
	}
	public void setTotalQuestions(Long totalQuestions) {
		this.totalQuestions = totalQuestions;
	}
	public List<ObjectiveQstnDto> getQuestsList() {
		return questsList;
	}
	public void setQuestsList(List<ObjectiveQstnDto> questsList) {
		this.questsList = questsList;
	}
	public InterviewsDto getTest() {
		return test;
	}
	public void setTest(InterviewsDto test) {
		this.test = test;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public RoundsDto getRounds() {
		return rounds;
	}
	public void setRounds(RoundsDto rounds) {
		this.rounds = rounds;
	}
	public Long getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(Long totalMarks) {
		this.totalMarks = totalMarks;
	}
	public CodingTestQstnDto getCodingTestQstn() {
		return codingTestQstn;
	}
	public void setCodingTestQstn(CodingTestQstnDto codingTestQstn) {
		this.codingTestQstn = codingTestQstn;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	@Override
	public String toString() {
		return "InterviewResultsDto [id=" + id + ", test=" + test + ", user="
				+ user + ", rounds=" + rounds + ", totalQuestions="
				+ totalQuestions + ", questsList=" + questsList
				+ ", totalMarks=" + totalMarks + ", codingTestQstn="
				+ codingTestQstn + ", points=" + points + "]";
	}
	
}
