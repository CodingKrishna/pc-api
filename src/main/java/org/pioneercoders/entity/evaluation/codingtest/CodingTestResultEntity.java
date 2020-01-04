package org.pioneercoders.entity.evaluation.codingtest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.pioneercoders.entity.user.UserEntity;

@Entity
@Table(name="codingtest_results_mst_tbl")
public class CodingTestResultEntity {

	private Long id;
	private CodingTestQstnEntity codingTestQstn;
	private Long points;
	private UserEntity user;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "QUESTION_ID")
	public CodingTestQstnEntity getCodingTestQstn() {
		return codingTestQstn;
	}
	public void setCodingTestQstn(CodingTestQstnEntity codingTestQstn) {
		this.codingTestQstn = codingTestQstn;
	}
	
	@Column(name="POINTS")
	public Long getPoints() {
		return points;
	}
	public void setPoints(Long points) {
		this.points = points;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "CodingTestResultEntity [id=" + id + ", codingTestQstn="
				+ codingTestQstn + ", points=" + points + ", user=" + user
				+ "]";
	}
	
	
}
