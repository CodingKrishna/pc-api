
package org.pioneercoders.entity.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.pioneercoders.entity.user.UserEntity;

@Entity
@Table(name="user_employers_info_tbl")
public class EmployersInfoEntity {
	
	private Long id;
	private String employer;
	private String employerStatus;
	private String monthStart;
	private String yearStart;
	private String monthEnd;
	private String yearEnd;
	private String designation;
	private String jobProfile;
	private UserEntity user;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="EMPLOYER")
	public String getEmployer() {
		return employer;
	}
	public void setEmployer(String employer) {
		this.employer = employer;
	}
	
	@Column(name="EMPLOYER_STATUS")
	public String getEmployerStatus() {
		return employerStatus;
	}
	public void setEmployerStatus(String employerStatus) {
		this.employerStatus = employerStatus;
	}
	
	
	@Column(name="START_MONTH")
	public String getMonthStart() {
		return monthStart;
	}
	public void setMonthStart(String monthStart) {
		this.monthStart = monthStart;
	}
	@Column(name="START_YEAR")
	public String getYearStart() {
		return yearStart;
	}
	public void setYearStart(String yearStart) {
		this.yearStart = yearStart;
	}
	@Column(name="END_MONTH")
	public String getMonthEnd() {
		return monthEnd;
	}
	public void setMonthEnd(String monthEnd) {
		this.monthEnd = monthEnd;
	}
	@Column(name="END_YEAR")
	public String getYearEnd() {
		return yearEnd;
	}
	public void setYearEnd(String yearEnd) {
		this.yearEnd = yearEnd;
	}
	@Column(name="DESIGNATION")
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	@Column(name="JOB_PROFILE")
	public String getJobProfile() {
		return jobProfile;
	}
	public void setJobProfile(String jobProfile) {
		this.jobProfile = jobProfile;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "WorkExperianceEntity [id=" + id + ", employer=" + employer
				+ ", employerStatus=" + employerStatus + ", monthStart="
				+ monthStart + ", yearStart=" + yearStart + ", monthEnd="
				+ monthEnd + ", yearEnd=" + yearEnd + ", designation="
				+ designation + ", jobProfile=" + jobProfile + ", user=" + user
				+ "]";
	}
	
	
}
