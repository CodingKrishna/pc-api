package org.pioneercoders.entity.Interview;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="interview_groups_candidates_tbl")
public class InterviewGroupsCandidatesEntity {
	
	private Long id;
	private String candidateName;
	private String candidateEmail;
	private String candidatePhoneNumber;
	private Long groupId;
	private Long userId;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="CANDIDATE_NAME")
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	@Column(name="CANDIDATE_EMAIL_ID")
	public String getCandidateEmail() {
		return candidateEmail;
	}
	public void setCandidateEmail(String candidateEmail) {
		this.candidateEmail = candidateEmail;
	}
	@Column(name="CANDIDATE_PHONE_NUMBER")
	public String getCandidatePhoneNumber() {
		return candidatePhoneNumber;
	}
	public void setCandidatePhoneNumber(String candidatePhoneNumber) {
		this.candidatePhoneNumber = candidatePhoneNumber;
	}
	@Column(name="INTERVIEW_GROUPS_ID")
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	@Column(name="USER_ID")
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
