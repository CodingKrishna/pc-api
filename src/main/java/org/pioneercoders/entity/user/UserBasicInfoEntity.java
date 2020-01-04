package org.pioneercoders.entity.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_basic_profileinfo_tbl")
public class UserBasicInfoEntity {
	private Long id;
	private String profileSummary;
	private String resumePath;
	private String selfIntroVideoPath;
	private Date dob;
	private String educationLevel;
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
	
	@Column(name="PROFILE_SUMMARY")
	public String getProfileSummary() {
		return profileSummary;
	}
	public void setProfileSummary(String profileSummary) {
		this.profileSummary = profileSummary;
	}
	
	@Column(name="RESUME_PATH")
	public String getResumePath() {
		return resumePath;
	}
	public void setResumePath(String resumePath) {
		this.resumePath = resumePath;
	}
	
	@Column(name="VEDIO_PATH")
	public String getSelfIntroVideoPath() {
		return selfIntroVideoPath;
	}
	public void setSelfIntroVideoPath(String selfIntroVideoPath) {
		this.selfIntroVideoPath = selfIntroVideoPath;
	}
	
	@Column(name="DATE_OF_BIRTH")
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	@Column(name="HIGHER_EDUCATION_LEVEL")
	public String getEducationLevel() {
		return educationLevel;
	}
	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "UserBasicInfoEntity [profileSummary=" + profileSummary
				+ ", resumePath=" + resumePath + ", selfIntroVideoPath="
				+ selfIntroVideoPath + ", dob=" + dob
				+ ", languages="+ ", expectedSalary="
				+ ", cuurentSalary="
				+ ", educationLevel=" + educationLevel + ", user=" + user + "]";
	}
	
}
