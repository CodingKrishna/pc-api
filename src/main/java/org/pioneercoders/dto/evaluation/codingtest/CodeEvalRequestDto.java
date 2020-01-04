package org.pioneercoders.dto.evaluation.codingtest;

import java.util.List;
import java.util.Map;

public class CodeEvalRequestDto {

	private String language;
	private String code;
	private List<String> inputs;
	private List<Map<String,String>> testCases;
	private String output;
	
	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public List<String> getInputs() {
		return inputs;
	}


	public void setInputs(List<String> inputs) {
		this.inputs = inputs;
	}


	public List<Map<String, String>> getTestCases() {
		return testCases;
	}


	public void setTestCases(List<Map<String, String>> testCases) {
		this.testCases = testCases;
	}


	public String getOutput() {
		return output;
	}


	public void setOutput(String output) {
		this.output = output;
	}

	
	@Override
	public String toString() {
		return "CodeEvalRequestDto [languageId=" + language + ", code="
				+ code + ", inputs=" + inputs + "]";
	}
	
	
}
