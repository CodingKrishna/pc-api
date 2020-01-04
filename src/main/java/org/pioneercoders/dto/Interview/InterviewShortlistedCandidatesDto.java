package org.pioneercoders.dto.Interview;

import org.pioneercoders.dto.user.UserDto;

public class InterviewShortlistedCandidatesDto {
	
	private Long id;
	private UserDto user;
	private JobInterviewDto jobInterview;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public JobInterviewDto getJobInterview() {
		return jobInterview;
	}
	public void setJobInterview(JobInterviewDto jobInterview) {
		this.jobInterview = jobInterview;
	}

}
