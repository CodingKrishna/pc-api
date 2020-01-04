package org.pioneercoders.entity.evaluation.objectivetest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="objective_questions_tbl")
public class ObjectQstnEntity {
	private Long id;
	private String 	questionId;
	private String  questionDesc;
	private String options;
	private String ans;
	private String quesType;
	private String quesGroup;
	
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
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	@Column(name="QUE_DESCRIPTION")
	public String getQuestionDesc() {
		return questionDesc;
	}
	public void setQuestionDesc(String questionDesc) {
		this.questionDesc = questionDesc;
	}
	@Column(name="OPTIONS")
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	@Column(name="ANSWERS")
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	@Column(name="QUE_TYPE")
	public String getQuesType() {
		return quesType;
	}
	public void setQuesType(String quesType) {
		this.quesType = quesType;
	}
	@Column(name="QUE_GROUP")
	public String getQuesGroup() {
		return quesGroup;
	}
	public void setQuesGroup(String quesGroup) {
		this.quesGroup = quesGroup;
	}
	@Override
	public String toString() {
		return "QuestionsEntity [id=" + id + ", questionId=" + questionId
				+ ", questionDesc=" + questionDesc + ", options=" + options
				+ ", ans=" + ans + ", quesType=" + quesType + ", quesGroup="
				+ quesGroup + "]";
	}
}
