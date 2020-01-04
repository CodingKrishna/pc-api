package org.pioneercoders.dto.evaluation.codingtest;

/**
 * @author Appaji
 *
 */
public class CodeEvaluvationRespDto {

	private String compilationStatus;
	private String compilationErrors;
	private String runStatus;
	private String output;
	private String runtimeErrors;
	
	
	public String getCompilationStatus() {
		return compilationStatus;
	}
	public void setCompilationStatus(String compilationStatus) {
		this.compilationStatus = compilationStatus;
	}
	public String getCompilationErrors() {
		return compilationErrors;
	}
	public void setCompilationErrors(String compilationErrors) {
		this.compilationErrors = compilationErrors;
	}
	public String getRunStatus() {
		return runStatus;
	}
	public void setRunStatus(String runStatus) {
		this.runStatus = runStatus;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public String getRuntimeErrors() {
		return runtimeErrors;
	}
	public void setRuntimeErrors(String runtimeErrors) {
		this.runtimeErrors = runtimeErrors;
	}

	
	
}
