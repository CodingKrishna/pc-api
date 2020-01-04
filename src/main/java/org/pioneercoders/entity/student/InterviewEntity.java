package org.pioneercoders.entity.student;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.pioneercoders.entity.user.UserEntity;

@Entity
@Table(name="user_interview_tbl")
public class InterviewEntity {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="RESHEDULE")
	private Boolean reShedule;

	@Column(name="INTERVIEW_DATE")
	private Date interviewDate;

	@Column(name="INTERVIEW_TIMING")
	private String interviewTiming;
	
	@Column(name="IS_EXAM_COMPLETED")
	private Boolean examCompleted;
	
	@OneToOne
	@JoinColumn(name="USER_ID")
	private UserEntity user;

	
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

	public Boolean getExamCompleted() {
		return examCompleted;
	}

	public void setExamCompleted(Boolean examCompleted) {
		this.examCompleted = examCompleted;
	}

	public String getInterviewTiming() {
		return interviewTiming;
	}

	public void setInterviewTiming(String interviewTiming) {
		this.interviewTiming = interviewTiming;
	}

	@Override
	public String toString() {
		return "InterviewEntity [id=" + id + ", reShedule=" + reShedule
				+ ", interviewDate=" + interviewDate + ", interviewTiming="
				+ interviewTiming + ", examCompleted=" + examCompleted
				+ ", user=" + user + "]";
	}
	
}
