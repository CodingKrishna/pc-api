package org.pioneercoders.dto.Interview;

import java.util.List;


public class InterviewRoundsDto{

	private Long id;
	private InterviewsDto test;
	
	private RoundsDto testRounds;
	private List<RoundsDto> testRoundsList;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public RoundsDto getTestRounds() {
		return testRounds;
	}
	public void setTestRounds(RoundsDto testRounds) {
		this.testRounds = testRounds;
	}
	public InterviewsDto getTest() {
		return test;
	}
	public void setTest(InterviewsDto test) {
		this.test = test;
	}
	public List<RoundsDto> getTestRoundsList() {
		return testRoundsList;
	}
	public void setTestRoundsList(List<RoundsDto> testRoundsList) {
		this.testRoundsList = testRoundsList;
	}
	
}
