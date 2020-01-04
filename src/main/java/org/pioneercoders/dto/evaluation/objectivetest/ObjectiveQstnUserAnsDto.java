package org.pioneercoders.dto.evaluation.objectivetest;

import org.dozer.Mapping;
import org.pioneercoders.dto.user.UserDto;

public class ObjectiveQstnUserAnsDto {
	private Long id;
	private String answer;
	private String actualAnswer;
	private ObjectiveQstnDto quesId;
	private Boolean isAnswered;

	@Mapping("personalEntity")
	private UserDto user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getActualAnswer() {
		return actualAnswer;
	}

	public void setActualAnswer(String actualAnswer) {
		this.actualAnswer = actualAnswer;
	}

	public ObjectiveQstnDto getQuesId() {
		return quesId;
	}

	public void setQuesId(ObjectiveQstnDto quesId) {
		this.quesId = quesId;
	}

	public Boolean getIsAnswered() {
		return isAnswered;
	}

	public void setIsAnswered(Boolean isAnswered) {
		this.isAnswered = isAnswered;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ObjectiveQstnUserAnsDto [id=" + id + ", answer=" + answer
				+ ", actualAnswer=" + actualAnswer + ", quesId=" + quesId
				+ ", isAnswered=" + isAnswered + ", user=" + user + "]";
	}
}
