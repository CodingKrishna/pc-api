package org.pioneercoders.dto.evaluation;

import java.util.Date;

import org.pioneercoders.dto.user.UserDto;

public class UserKnownAppsDto {
	
	private Long id;
	private UserDto user;
	private String applications;
	private String mobileApps;
	private String games;
	private String strengths;
	private String weakness;
	private String accomplishments;
	private Date createdOn;
	private String status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
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
		return "EvaluationDto [id=" + id + ", userId=" + user
				+ ", applications=" + applications + ", mobileApps="
				+ mobileApps + ", games=" + games + ", strengths=" + strengths
				+ ", weakness=" + weakness + ", accomplishments="
				+ accomplishments + ", createdOn=" + createdOn + ", status="
				+ status + "]";
	}
	
	

}
