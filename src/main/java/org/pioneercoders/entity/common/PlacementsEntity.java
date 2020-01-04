package org.pioneercoders.entity.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="placements_info_tbl")
public class PlacementsEntity {
	
	private Long id;
	private String studentName;
	private String placedCompany;
	private String courseTaken;
	private String emailId;
	private String imgPath;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="STUDENT_NAME")
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	@Column(name="COMPANY")
	public String getPlacedCompany() {
		return placedCompany;
	}
	public void setPlacedCompany(String placedCompany) {
		this.placedCompany = placedCompany;
	}
	
	@Column(name="COURSE")
	public String getCourseTaken() {
		return courseTaken;
	}
	public void setCourseTaken(String courseTaken) {
		this.courseTaken = courseTaken;
	}
	
	@Column(name="EMAIL_ID")
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@Column(name="IMAGE_PATH")
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	@Override
	public String toString() {
		return "PlacementsEntity [id=" + id + ", studentName=" + studentName
				+ ", placedCompany=" + placedCompany + ", courseTaken="
				+ courseTaken + ", emailId=" + emailId + ", imgPath=" + imgPath
				+ "]";
	}
	
	

}
