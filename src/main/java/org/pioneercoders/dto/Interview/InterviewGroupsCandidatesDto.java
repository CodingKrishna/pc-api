package org.pioneercoders.dto.Interview;


public class InterviewGroupsCandidatesDto {
	
	private Long id;
	private String candidateName;
	private String candidateEmail;
	private String candidatePhoneNumber;
	private Long groupId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public String getCandidateEmail() {
		return candidateEmail;
	}
	public void setCandidateEmail(String candidateEmail) {
		this.candidateEmail = candidateEmail;
	}
	public String getCandidatePhoneNumber() {
		return candidatePhoneNumber;
	}
	public void setCandidatePhoneNumber(String candidatePhoneNumber) {
		this.candidatePhoneNumber = candidatePhoneNumber;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	
	

}
