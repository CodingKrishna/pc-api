package org.pioneercoders.dto.Interview;

import java.util.List;

public class SelectedGroupsForInterviewDto {
	
	private Long id;
	private List<InterviewGroupsDto> interviewGroups;
	private InterviewsDto interview;
	private InterviewGroupsDto singleInterviewGroup;
	private boolean isSelected;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<InterviewGroupsDto> getInterviewGroups() {
		return interviewGroups;
	}
	public void setInterviewGroups(List<InterviewGroupsDto> interviewGroups) {
		this.interviewGroups = interviewGroups;
	}
	public InterviewsDto getInterview() {
		return interview;
	}
	public void setInterview(InterviewsDto interview) {
		this.interview = interview;
	}
	public InterviewGroupsDto getSingleInterviewGroup() {
		return singleInterviewGroup;
	}
	public void setSingleInterviewGroup(InterviewGroupsDto singleInterviewGroup) {
		this.singleInterviewGroup = singleInterviewGroup;
	}
	public boolean isSelected() {
		return isSelected;
	}
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

}
