package org.pioneercoders.entity.evaluation.objectivetest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="objective_question_answers_mst_tbl")
public class ObjectiveQstnAnswersEntity {
	
	private Long id;
	private Long questionId;
	private String answer;
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="QUESTION_ID")
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	@Column(name="ANSWER")
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "AnswersEntity [id=" + id + ", questionId=" + questionId
				+ ", answer=" + answer + "]";
	}
	
	

}
