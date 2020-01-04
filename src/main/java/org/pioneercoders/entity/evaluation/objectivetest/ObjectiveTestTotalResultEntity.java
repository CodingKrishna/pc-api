package org.pioneercoders.entity.evaluation.objectivetest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.pioneercoders.entity.user.UserEntity;

@Entity
@Table(name="objective_test_total_results_tbl")
public class ObjectiveTestTotalResultEntity {

	private Long id;
	private UserEntity user;
	private Long totalMarks;
	private Long totalQuestions;
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PERSIONAL_ID")
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	@Column(name="TOTAL_MARKS")
	public Long getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(Long totalMarks) {
		this.totalMarks = totalMarks;
	}
	@Column(name="TOTAL_QUESTIONS")
	public Long getTotalQuestions() {
		return totalQuestions;
	}
	public void setTotalQuestions(Long totalQuestions) {
		this.totalQuestions = totalQuestions;
	}
	@Override
	public String toString() {
		return "ExamTrnEntity [id=" + id + ", technology="
				+ ", user=" + user + ", totalMarks=" + totalMarks
				+ ", totalQuestions=" + totalQuestions + "]";
	}
	
	
	
	
	
}
