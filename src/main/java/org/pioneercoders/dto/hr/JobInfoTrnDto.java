package org.pioneercoders.dto.hr;

public class JobInfoTrnDto {
	
	private Long id;
	private JobInfoDto job;
	private Long studentId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public JobInfoDto getJob() {
		return job;
	}
	public void setJob(JobInfoDto job) {
		this.job = job;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	@Override
	public String toString() {
		return "JobInfoTrnDto [id=" + id + ", job=" + job + ", studentId="
				+ studentId + "]";
	}

}
