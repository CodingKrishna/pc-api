package org.pioneercoders.entity.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.pioneercoders.entity.user.UserEntity;

@Entity
@Table(name="user_basic_skills_tbl")
public class UserBasicSkillsEntity {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	private UserEntity user;

	@Column(name = "COMMUNICATION_RATING")
	private Long commRating;
	
	@Column(name = "ANALYTICAL_RATING")
	private Long analyticalRating;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCommRating() {
		return commRating;
	}
	public void setCommRating(Long commRating) {
		this.commRating = commRating;
	}
	public Long getAnalyticalRating() {
		return analyticalRating;
	}
	public void setAnalyticalRating(Long analyticalRating) {
		this.analyticalRating = analyticalRating;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
}
