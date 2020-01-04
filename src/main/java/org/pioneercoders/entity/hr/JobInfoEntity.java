package org.pioneercoders.entity.hr;

import java.util.Date;

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
@Table(name="job_info_mst")
public class JobInfoEntity {
	
	private Long id;
	private String jobTitle;
	private String jobDescription;
	private String location;
	private Date postedDate;
	private Date closedDate;
	private String requiredSkills;
	private CompanyEntity company;
	private UserEntity user;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="JOB_TITLE")
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	@Column(name="JOB_DESCRIPTION")
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	
	@Column(name="LOCATION")
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Column(name="POSTED_DATE")
	public Date getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}
	
	@Column(name="CLOSED_DATE")
	public Date getClosedDate() {
		return closedDate;
	}
	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}
	
	@Column(name="REQUIRED_SKILLS")
	public String getRequiredSkills() {
		return requiredSkills;
	}
	
	
	public void setRequiredSkills(String requiredSkills) {
		this.requiredSkills = requiredSkills;
	}
	
	@ManyToOne
	@JoinColumn(name="COMPANY_ID")
	public CompanyEntity getCompany() {
		return company;
	}
	public void setCompany(CompanyEntity company) {
		this.company = company;
	}
	
	@ManyToOne
	@JoinColumn(name="HR_ID")
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "JobInfoEntity [id=" + id + ", jobTitle=" + jobTitle
				+ ", jobDescription=" + jobDescription + ", location="
				+ location + ", postedDate=" + postedDate + ", closedDate="
				+ closedDate + ", requiredSkills=" + requiredSkills
				+ ", company=" + company + "]";
	}
	
}
