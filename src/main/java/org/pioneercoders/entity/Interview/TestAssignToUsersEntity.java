package org.pioneercoders.entity.Interview;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.pioneercoders.entity.user.UserEntity;

@Entity
@Table(name="interviews_assign_to_users_tbl")
public class TestAssignToUsersEntity {
	
	private Long id;
	private InterviewsEntity test;
	private UserEntity user;
	
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
	
	

}
