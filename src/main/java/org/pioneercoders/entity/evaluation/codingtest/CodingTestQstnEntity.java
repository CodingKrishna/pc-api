package org.pioneercoders.entity.evaluation.codingtest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="coding_test_qtn_tbl")
public class CodingTestQstnEntity {
	
	private Long id;
	private String questionDesc;
	private String testCases;
	private String imgPath;
	private String sampleCode;
	private Long points;
	private String language;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="QUESTION_DESC")
	public String getQuestionDesc() {
		return questionDesc;
	}
	public void setQuestionDesc(String questionDesc) {
		this.questionDesc = questionDesc;
	}

	public void setTestCases(String testCases) {
		this.testCases = testCases;
	}
	@Column(name="TEST_CASES")
	public String getTestCases() {
		return testCases;
	}
	
	@Column(name="IMG_PATH")
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	@Column(name="SAMPLE_CODE")
	public String getSampleCode() {
		return sampleCode;
	}
	public void setSampleCode(String sampleCode) {
		this.sampleCode = sampleCode;
	}
	
	@Column(name="POINTS")
	public Long getPoints() {
		return points;
	}
	public void setPoints(Long points) {
		this.points = points;
	}
	
	@Column(name="LANGUAGE")
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return "CodingTestQstnEntity [id=" + id + ", questionDesc="
				+ questionDesc + ", TestCases=" + testCases + ", imgPath="
				+ imgPath + "]";
	}
	
	
	
	
	
	
}
