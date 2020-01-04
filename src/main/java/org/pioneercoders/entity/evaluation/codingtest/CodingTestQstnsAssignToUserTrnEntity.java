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
@Table(name="coding_test_qtn_assign_to_user_trn_bl")
public class CodingTestQstnsAssignToUserTrnEntity {
	
	private Long id;
	private CodingTestQstnEntity question;
	private UserEntity user;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="QUESTION_ID")
	public CodingTestQstnEntity getQuestion() {
		return question;
	}
	public void setQuestion(CodingTestQstnEntity question) {
		this.question = question;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="USER_ID")
	public UserEntity getUser() {
		return user;
	}
	
	public void setUser(UserEntity user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "CodingTestQstnsTrnEntity [id=" + id + ", question=" + question
				+ ", user=" + user + "]";
	}
	
	
	
	
}
