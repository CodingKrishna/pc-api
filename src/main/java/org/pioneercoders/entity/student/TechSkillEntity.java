package org.pioneercoders.entity.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.pioneercoders.entity.common.TechnologiesEntity;
import org.pioneercoders.entity.user.UserEntity;

@Entity
@Table(name="user_tech_skills_trn_tbl")
public class TechSkillEntity {
	
	private Long id;
    private TechnologiesEntity technology;
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
	@JoinColumn(name="TECH_SKILL_ID")
	public TechnologiesEntity getTechnology() {
		return technology;
	}

	public void setTechnology(TechnologiesEntity technology) {
		this.technology = technology;
	}

	@ManyToOne
	@JoinColumn(name="USER_ID")
	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "SkillsetTrnEntity [id=" + id + ", technology=" + technology
				+ ", user=" + user + "]";
	}

}
