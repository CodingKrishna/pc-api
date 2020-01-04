package org.pioneercoders.dto.student;

import java.util.Date;

import org.pioneercoders.dto.user.UserDto;

public class InterviewDto {
	
    private Long id;
	private Boolean reShedule;
	private Date interviewDate;
	private String interviewTiming;
	private Boolean examCompleted;
	private UserDto user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getReShedule() {
		return reShedule;
	}
	public void setReShedule(Boolean reShedule) {
		this.reShedule = reShedule;
	}
	public Date getInterviewDate() {
		return interviewDate;
	}
	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}
	public String getInterviewTiming() {
		return interviewTiming;
	}
	public void setInterviewTiming(String interviewTiming) {
		this.interviewTiming = interviewTiming;
	}
	public Boolean getExamCompleted() {
		return examCompleted;
	}
	public void setExamCompleted(Boolean examCompleted) {
		this.examCompleted = examCompleted;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "InterviewDto [id=" + id + ", reShedule=" + reShedule
				+ ", interviewDate=" + interviewDate + ", interviewTiming="
				+ interviewTiming + ", examCompleted=" + examCompleted
				+ ", user=" + user + "]";
	}
}
