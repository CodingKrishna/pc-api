package org.pioneercoders.dto.student;

public class UniversityDto {
	private Long id;
	private String universityName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	@Override
	public String toString() {
		return "UniversityDto [id=" + id + ", universityName=" + universityName
				+ "]";
	}
	
	
	
}
