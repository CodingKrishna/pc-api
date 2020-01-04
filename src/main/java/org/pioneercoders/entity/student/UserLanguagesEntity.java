package org.pioneercoders.entity.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.pioneercoders.entity.user.UserEntity;

@Entity
@Table(name="user_languages_trn_tbl")
public class UserLanguagesEntity {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="LANGUAGE_ID")
	private LanguageEntity language;
	
	@OneToOne
	@JoinColumn(name="USER_ID")
	private UserEntity user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LanguageEntity getLanguage() {
		return language;
	}
	public void setLanguage(LanguageEntity language) {
		this.language = language;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "UserLanguagesEntity [id=" + id + ", language=" + language
				+ ", user=" + user + "]";
	}
	
}
