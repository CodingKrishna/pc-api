package org.pioneercoders.entity.hr;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="jobinfo_trn_tbl")
public class JobInfoTrnEntity {
	
	private Long id;
	private JobInfoEntity job;
	private Long studentId;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="JOB_ID")
	public JobInfoEntity getJob() {
		return job;
	}
	public void setJob(JobInfoEntity job) {
		this.job = job;
	}
	
	@Column(name="STUDENT_ID")
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	@Override
	public String toString() {
		return "JobInfoTrnEntity [id=" + id + ", job=" + job + ", studentId="
				+ studentId + "]";
	}

}
