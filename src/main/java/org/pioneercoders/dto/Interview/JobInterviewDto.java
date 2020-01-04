package org.pioneercoders.dto.Interview;

import org.pioneercoders.dto.hr.JobInfoDto;


public class JobInterviewDto {
	
	private Long id;
	private InterviewsDto test;
	private JobInfoDto job;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public InterviewsDto getTest() {
		return test;
	}
	public void setTest(InterviewsDto test) {
		this.test = test;
	}
	public JobInfoDto getJob() {
		return job;
	}
	public void setJob(JobInfoDto job) {
		this.job = job;
	}
	
}
