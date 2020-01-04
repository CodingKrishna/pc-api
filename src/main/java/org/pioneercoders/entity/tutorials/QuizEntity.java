package org.pioneercoders.entity.tutorials;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="quiz_trn_tbl")
public class QuizEntity {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="TECHNOLOGY")
	private String technology;
	
	@Column(name="TOPIC")
	private String topic;
	
	@Column(name="QUESTIONS")
	private Long questions;
	
	@Column(name="ANSWERED")
	private Long answered;
	
	@Column(name="CREATED_ON")
	private Date createdOn;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="USER_ID")
	private Long userId;
	
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
		return "QuizEntity [id=" + id + ", technology=" + technology
				+ ", topic=" + topic + ", questions=" + questions
				+ ", answered=" + answered + ", createdOn=" + createdOn
				+ ", status=" + status + ", userId=" + userId + "]";
	}
	
	

}
