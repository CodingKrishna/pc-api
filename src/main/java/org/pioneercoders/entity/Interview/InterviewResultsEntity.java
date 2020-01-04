package org.pioneercoders.entity.Interview;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.pioneercoders.entity.evaluation.codingtest.CodingTestQstnEntity;
import org.pioneercoders.entity.user.UserEntity;

@Entity
@Table(name="interview_results_tbl")
public class InterviewResultsEntity {
	
	private Long id;
	private InterviewsEntity test;
	private UserEntity user;
	private RoundsEntity rounds;
	private Long totalQuestions;
	private Long totalMarks;
	private CodingTestQstnEntity codingTestQstn;
	private Integer points;
	
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name="INTERVIEWS_ID")
	public InterviewsEntity getTest() {
		return test;
	}
	public void setTest(InterviewsEntity test) {
		this.test = test;
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
	@JoinColumn(name="ROUND_ID")
	public RoundsEntity getRounds() {
		return rounds;
	}
	public void setRounds(RoundsEntity rounds) {
		this.rounds = rounds;
	}
	
	
	@Column(name="TOTAL_QUESTIONS")
	public Long getTotalQuestions() {
		return totalQuestions;
	}
	public void setTotalQuestions(Long totalQuestions) {
		this.totalQuestions = totalQuestions;
	}
	@Column(name="TOTAL_MARKS")
	public Long getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(Long totalMarks) {
		this.totalMarks = totalMarks;
	}
	@ManyToOne
	@JoinColumn(name="CODING_TEST_ID")
	public CodingTestQstnEntity getCodingTestQstn() {
		return codingTestQstn;
	}
	public void setCodingTestQstn(CodingTestQstnEntity codingTestQstn) {
		this.codingTestQstn = codingTestQstn;
	}
	@Column(name="POINTS")
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	
}
