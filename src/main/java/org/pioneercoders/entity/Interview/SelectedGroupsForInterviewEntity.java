package org.pioneercoders.entity.Interview;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="selected_groups_for_interview_tbl")
public class SelectedGroupsForInterviewEntity {
	
	private Long id;
	private InterviewGroupsEntity interviewGroups;
	private InterviewsEntity interview;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name = "INTERVIEW_GROUP_ID")
	public InterviewGroupsEntity getInterviewGroups() {
		return interviewGroups;
	}
	public void setInterviewGroups(InterviewGroupsEntity interviewGroups) {
		this.interviewGroups = interviewGroups;
	}
	@ManyToOne
	@JoinColumn(name = "INTERVIEW_ID")
	public InterviewsEntity getInterview() {
		return interview;
	}
	public void setInterview(InterviewsEntity interview) {
		this.interview = interview;
	}

}
