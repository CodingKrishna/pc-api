package org.pioneercoders.dto.evaluation.objectivetest;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.dozer.Mapping;

public class ObjectiveQstnDto {
	private Long id;
	private String 	questionId;
	private String  questionDesc;
	private String[] options;
	private String ans;
	private String quesType;
	private String quesGroup;
	private String code;
	private boolean isSelected;
	
	@JsonIgnore
	private String optionsString;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getQuestionDesc() {
		return questionDesc;
	}
	public void setQuestionDesc(String questionDesc) {
		this.questionDesc = questionDesc;
	}
	public String[] getOptions() {
		return options;
	}
	public void setOptions(String[] options) {
		this.options = options;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	public String getQuesType() {
		return quesType;
	}
	public void setQuesType(String quesType) {
		this.quesType = quesType;
	}
	
	@Mapping("options")
	public String getOptionsString() {
		return StringUtils.join(options, "@@");
	}

	public void setOptionsString(String optionsString) {
		this.optionsString = optionsString;
		this.options = optionsString.split("@@");
	}
	
	public String getQuesGroup() {
		return quesGroup;
	}
	public void setQuesGroup(String quesGroup) {
		this.quesGroup = quesGroup;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public boolean isSelected() {
		return isSelected;
	}
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	@Override
	public String toString() {
		return "QuestionsDto [id=" + id + ", questionId=" + questionId
				+ ", questionDesc=" + questionDesc + ", options="
				+ Arrays.toString(options) + ", ans=" + ans + ", quesType="
				+ quesType + ", optionsString=" + optionsString + "]";
	}
	
}
