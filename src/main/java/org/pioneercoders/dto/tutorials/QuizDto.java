package org.pioneercoders.dto.tutorials;

import java.util.Date;

public class QuizDto {
	
	private Long id;
	private Long userId;
	private String technology;
	private String topic;
	private Long questions;
	private Long answered;
	private Date createdOn;
	private String status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public Long getQuestions() {
		return questions;
	}
	public void setQuestions(Long questions) {
		this.questions = questions;
	}
	public Long getAnswered() {
		return answered;
	}
	public void setAnswered(Long answered) {
		this.answered = answered;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "QuizDto [id=" + id + ", technology=" + technology + ", topic="
				+ topic + ", questions=" + questions + ", answered=" + answered
				+ ", createdOn=" + createdOn + ", status=" + status
				+ ", userId=" + userId + "]";
	}
}
