package org.pioneercoders.entity.evaluation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.pioneercoders.entity.user.UserEntity;
@Entity
@Table(name="user_known_apps_tbl")
public class UserKnownAppsEntity {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="USER_ID")
	private UserEntity user;
	
	@Column(name="APPLICATIONS", length = 5000)
	private String applications;
	
	@Column(name="MOBILE_APPS", length = 5000)
	private String mobileApps;
	
	@Column(name="GAMES", length = 5000)
	private String games;
	
	@Column(name="STRENGTHS", length = 1000)
	private String strengths;
	
	@Column(name="WEAKNESS", length = 1000)
	private String weakness;
	
	@Column(name="ACCOMLISHMENTS", length = 1000)
	private String accomplishments;
	
	@Column(name="CREATED_ON")
	private Date createdOn;
	
	@Column(name="STATUS")
	private String status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public String getApplications() {
		return applications;
	}
	public void setApplications(String applications) {
		this.applications = applications;
	}
	public String getMobileApps() {
		return mobileApps;
	}
	public void setMobileApps(String mobileApps) {
		this.mobileApps = mobileApps;
	}
	public String getGames() {
		return games;
	}
	public void setGames(String games) {
		this.games = games;
	}
	public String getStrengths() {
		return strengths;
	}
	public void setStrengths(String strengths) {
		this.strengths = strengths;
	}
	public String getWeakness() {
		return weakness;
	}
	public void setWeakness(String weakness) {
		this.weakness = weakness;
	}
	public String getAccomplishments() {
		return accomplishments;
	}
	public void setAccomplishments(String accomplishments) {
		this.accomplishments = accomplishments;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "UserKnownAppsEntity [id=" + id + ", user=" + user
				+ ", applications=" + applications + ", mobileApps="
				+ mobileApps + ", games=" + games + ", strengths=" + strengths
				+ ", weakness=" + weakness + ", accomplishments="
				+ accomplishments + ", createdOn=" + createdOn + ", status="
				+ status + "]";
	}

	
	

}
