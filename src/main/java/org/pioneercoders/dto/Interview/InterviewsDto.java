package org.pioneercoders.dto.Interview;

import java.util.Date;
import java.util.List;

import org.pioneercoders.dto.common.TechnologiesDto;
import org.pioneercoders.dto.hr.JobInfoDto;
import org.pioneercoders.dto.user.UserDto;

public class InterviewsDto {
	
	private Long id;
	private UserDto user;
	private String testName;
	private String description;
	private Date startDate;
	private Date endDate;
	private InterviewTypesDto interviewType;
	private JobInfoDto jobInfo;
	/**
	 * this properties are used while creating test.
	 */
	private List<RoundsDto> testRounds;
	private List<TechnologiesDto> testTechnologies;
	
	/**
	 * This properties are used while retreving the test.
	 */
	private List<InterviewRoundsDto> testRoundsList;
	private List<InterviewTechnologiesDto> testTechnologiesList;
	
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
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public InterviewTypesDto getInterviewType() {
		return interviewType;
	}
	public void setInterviewType(InterviewTypesDto interviewType) {
		this.interviewType = interviewType;
	}
	public List<RoundsDto> getTestRounds() {
		return testRounds;
	}
	public void setTestRounds(List<RoundsDto> testRounds) {
		this.testRounds = testRounds;
	}
	public List<TechnologiesDto> getTestTechnologies() {
		return testTechnologies;
	}
	public void setTestTechnologies(List<TechnologiesDto> testTechnologies) {
		this.testTechnologies = testTechnologies;
	}
	public List<InterviewRoundsDto> getTestRoundsList() {
		return testRoundsList;
	}
	public void setTestRoundsList(List<InterviewRoundsDto> testRoundsList) {
		this.testRoundsList = testRoundsList;
	}
	public List<InterviewTechnologiesDto> getTestTechnologiesList() {
		return testTechnologiesList;
	}
	public void setTestTechnologiesList(
			List<InterviewTechnologiesDto> testTechnologiesList) {
		this.testTechnologiesList = testTechnologiesList;
	}
	public JobInfoDto getJobInfo() {
		return jobInfo;
	}
	public void setJobInfo(JobInfoDto jobInfo) {
		this.jobInfo = jobInfo;
	}
	
	
	
	
}
