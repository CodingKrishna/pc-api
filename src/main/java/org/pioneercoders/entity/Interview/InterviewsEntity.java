package org.pioneercoders.entity.Interview;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.pioneercoders.entity.hr.JobInfoEntity;
import org.pioneercoders.entity.user.UserEntity;

@Entity
@Table(name="interviews_mst_tbl")
public class InterviewsEntity {
	
	private Long id;
	private UserEntity user;
	private String testName;
	private String description;
	private Date startDate;
	private Date endDate;
	private InterviewTypesEntity interviewType;
	private JobInfoEntity jobInfo;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="TEST_NAME")
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name="START_DATE")
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@Column(name="END_DATE")
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@ManyToOne
	@JoinColumn(name="INTERVIEW_TYPE_ID")
	public InterviewTypesEntity getInterviewType() {
		return interviewType;
	}
	public void setInterviewType(InterviewTypesEntity interviewType) {
		this.interviewType = interviewType;
	}
	@ManyToOne
	@JoinColumn(name="USER_ID")
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	@OneToOne
	@JoinColumn(name="JOB_INFO_ID")
	public JobInfoEntity getJobInfo() {
		return jobInfo;
	}
	public void setJobInfo(JobInfoEntity jobInfo) {
		this.jobInfo = jobInfo;
	}
	
	
	
	
	

}
