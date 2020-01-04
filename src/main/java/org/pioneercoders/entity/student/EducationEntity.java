package org.pioneercoders.entity.student;

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
@Table(name="user_educations_tbl")
public class EducationEntity {
	
	private Long id;
	private String educationType;
	private InstituteEntity institute;
	private UniversityEntity university;
	private String branch;
	private String yearOfPassing;
	private Float percentage;
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
	
	@Column(name="EDUCATION_TYPE")
	public String getEducationType() {
		return educationType;
	}
	public void setEducationType(String educationType) {
		this.educationType = educationType;
	}
	
	@Column(name="BRANCH_NAME")
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	@Column(name="YEAR_OF_PASSING")
	public String getYearOfPassing() {
		return yearOfPassing;
	}
	public void setYearOfPassing(String yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}
	
	@Column(name="PERCENTAGE")
	public Float getPercentage() {
		return percentage;
	}
	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	@ManyToOne
	@JoinColumn(name="INSTITUTE_ID")
	public InstituteEntity getInstitute() {
		return institute;
	}
	public void setInstitute(InstituteEntity institute) {
		this.institute = institute;
	}
	@ManyToOne
	@JoinColumn(name="UNIVERSITY_ID")
	public UniversityEntity getUniversity() {
		return university;
	}
	public void setUniversity(UniversityEntity university) {
		this.university = university;
	}
	@Override
	public String toString() {
		return "EducationEntity [id=" + id + ", educationType=" + educationType
				+ ", instituteid=" + institute + ", branch=" + branch
				+ ", yearOfPassing=" + yearOfPassing + ", percentage="
				+ percentage + ", user=" + user + "]";
	}
}
