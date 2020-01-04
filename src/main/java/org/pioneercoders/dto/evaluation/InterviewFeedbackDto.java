package org.pioneercoders.dto.evaluation;

public class InterviewFeedbackDto {
	
	private Long id;
	private String feedbackDesc;
	private String type;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFeedbackDesc() {
		return feedbackDesc;
	}
	public void setFeedbackDesc(String feedbackDesc) {
		this.feedbackDesc = feedbackDesc;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "FeedbackDto [id=" + id + ", feedbackDesc=" + feedbackDesc
				+ ", type=" + type + "]";
	}
	
}
