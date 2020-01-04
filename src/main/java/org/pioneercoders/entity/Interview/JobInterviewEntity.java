package org.pioneercoders.entity.Interview;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.pioneercoders.entity.hr.JobInfoEntity;

@Entity
@Table(name="job_interview_mst_tbl")
public class JobInterviewEntity {
	
	private Long id;
	private InterviewsEntity test;
	private JobInfoEntity job;
	
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
	@JoinColumn(name="INTERVIEWS_ID")
	public InterviewsEntity getTest() {
		return test;
	}
	public void setTest(InterviewsEntity test) {
		this.test = test;
	}
	@ManyToOne
	@JoinColumn(name="JOB_INFO_ID")
	public JobInfoEntity getJob() {
		return job;
	}
	public void setJob(JobInfoEntity job) {
		this.job = job;
	}
	

}
