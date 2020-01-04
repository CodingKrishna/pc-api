package org.pioneercoders.entity.student;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.pioneercoders.dto.student.UniversityDto;
import org.pioneercoders.entity.user.UserEntity;

@Entity
@Table(name="institute_mst_tbl")
public class InstituteEntity {
	private Long id;
	private String instituteName;
	private UniversityEntity university;
	private String collegePhoneNo;
	private Date startDate;
	private String description;
	private UserEntity poId;
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="INSTITUTE_NAME")
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	@Column(name="COLLEGE_PHONENO")
	public String getCollegePhoneNo() {
		return collegePhoneNo;
	}
	public void setCollegePhoneNo(String collegePhoneNo) {
		this.collegePhoneNo = collegePhoneNo;
	}
	@Column(name="COLLEGE_START_DATE")
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@Column(name="COLLEGE_DESCRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@ManyToOne
	@JoinColumn(name="PO_ID")
	public UserEntity getPoId() {
		return poId;
	}
	public void setPoId(UserEntity poId) {
		this.poId = poId;
	}
	
	@ManyToOne
	@JoinColumn(name="UNIVERSITY_ID")
	public UniversityEntity getUniversity() {
		return university;
	}
	public void setUniversity(UniversityEntity university) {
		this.university = university;
	}

	
}
