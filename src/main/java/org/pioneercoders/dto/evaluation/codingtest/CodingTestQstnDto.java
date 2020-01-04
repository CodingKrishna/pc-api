package org.pioneercoders.dto.evaluation.codingtest;

public class CodingTestQstnDto {
	
	private Long id;
	private String questionDesc;
	private String testCases;
	private String imgPath;
	private String sampleCode;
	private Long points;
	private String language;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuestionDesc() {
		return questionDesc;
	}
	public void setQuestionDesc(String questionDesc) {
		this.questionDesc = questionDesc;
	}
	
	public String getTestCases() {
		return testCases;
	}
	public void setTestCases(String testCases) {
		this.testCases = testCases;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	public String getSampleCode() {
		return sampleCode;
	}
	public void setSampleCode(String sampleCode) {
		this.sampleCode = sampleCode;
	}
	
	public Long getPoints() {
		return points;
	}
	public void setPoints(Long points) {
		this.points = points;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return "CodingTestQstnDto [id=" + id + ", questionDesc=" + questionDesc
				+ ", testCases=" + testCases + ", imgPath=" + imgPath + "]";
	}
}
