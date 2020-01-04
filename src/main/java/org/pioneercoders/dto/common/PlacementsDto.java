package org.pioneercoders.dto.common;

public class PlacementsDto {
	
	private Long id;
	private String studentName;
	private String placedCompany;
	private String courseTaken;
	private String emailId;
	private String imgPath;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getPlacedCompany() {
		return placedCompany;
	}
	public void setPlacedCompany(String placedCompany) {
		this.placedCompany = placedCompany;
	}
	public String getCourseTaken() {
		return courseTaken;
	}
	public void setCourseTaken(String courseTaken) {
		this.courseTaken = courseTaken;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	@Override
	public String toString() {
		return "PlacementsDto [id=" + id + ", studentName=" + studentName
				+ ", placedCompany=" + placedCompany + ", courseTaken="
				+ courseTaken + ", emailId=" + emailId + ", imgPath=" + imgPath
				+ "]";
	}
	
	
	

}
