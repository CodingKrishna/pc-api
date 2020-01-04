package org.pioneercoders.dto.hr;

import java.util.Date;

import org.pioneercoders.dto.user.UserDto;

public class PricingPlansTrnDto {
	
	private Long id;
	private Date purchasedDate;
	private UserDto user;
	private PricingPlansDto plan;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getPurchasedDate() {
		return purchasedDate;
	}
	public void setPurchasedDate(Date purchasedDate) {
		this.purchasedDate = purchasedDate;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public PricingPlansDto getPlan() {
		return plan;
	}
	public void setPlan(PricingPlansDto plan) {
		this.plan = plan;
	}
	@Override
	public String toString() {
		return "PricingPlansTrnDto [id=" + id + ", purchasedDate="
				+ purchasedDate + ", user=" + user + ", plan=" + plan + "]";
	}
	
	

}
