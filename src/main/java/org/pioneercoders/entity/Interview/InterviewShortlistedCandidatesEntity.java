package org.pioneercoders.entity.Interview;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.pioneercoders.entity.user.UserEntity;

@Entity
@Table(name="interview_shortlisted_candidates_tbl")
public class InterviewShortlistedCandidatesEntity {
	
	private Long id;
	private UserEntity user;
	private JobInterviewEntity jobInterview;
	
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
	@JoinColumn(name="USER_ID")
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	@ManyToOne
	@JoinColumn(name="JOB_INTERVIEW_ID")
	public JobInterviewEntity getJobInterview() {
		return jobInterview;
	}
	public void setJobInterview(JobInterviewEntity jobInterview) {
		this.jobInterview = jobInterview;
	}
	
	
	

}