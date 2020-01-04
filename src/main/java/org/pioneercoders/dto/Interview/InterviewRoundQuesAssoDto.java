package org.pioneercoders.dto.Interview;

import java.util.List;

import org.pioneercoders.dto.evaluation.codingtest.CodingTestQstnDto;
import org.pioneercoders.dto.evaluation.objectivetest.ObjectiveQstnDto;
import org.pioneercoders.dto.evaluation.taskstest.TaskDto;

public class InterviewRoundQuesAssoDto {
	
	private InterviewsDto test;
	private RoundsDto rounds;
	private List<ObjectiveQstnDto> objectQuestions;
	private List<TaskDto> taskQuestions;
	private List<CodingTestQstnDto> codingTestQuestions;
	private ObjectiveQstnDto singleObjectQuestion;
	
	public RoundsDto getRounds() {
		return rounds;
	}
	public void setRounds(RoundsDto rounds) {
		this.rounds = rounds;
	}
	public InterviewsDto getTest() {
		return test;
	}
	public void setTest(InterviewsDto test) {
		this.test = test;
	}
	public List<ObjectiveQstnDto> getObjectQuestions() {
		return objectQuestions;
	}
	public void setObjectQuestions(List<ObjectiveQstnDto> objectQuestions) {
		this.objectQuestions = objectQuestions;
	}
	public ObjectiveQstnDto getSingleObjectQuestion() {
		return singleObjectQuestion;
	}
	public void setSingleObjectQuestion(ObjectiveQstnDto singleObjectQuestion) {
		this.singleObjectQuestion = singleObjectQuestion;
	}
	public List<TaskDto> getTaskQuestions() {
		return taskQuestions;
	}
	public void setTaskQuestions(List<TaskDto> taskQuestions) {
		this.taskQuestions = taskQuestions;
	}
	public List<CodingTestQstnDto> getCodingTestQuestions() {
		return codingTestQuestions;
	}
	public void setCodingTestQuestions(List<CodingTestQstnDto> codingTestQuestions) {
		this.codingTestQuestions = codingTestQuestions;
	}
	@Override
	public String toString() {
		return "TestRoundQuesAssoDto [test=" + test + ", rounds=" + rounds
				+ ", objectQuestions=" + objectQuestions + ", taskQuestions="
				+ taskQuestions + ", codingTestQuestions="
				+ codingTestQuestions + ", singleObjectQuestion="
				+ singleObjectQuestion + "]";
	}
}
