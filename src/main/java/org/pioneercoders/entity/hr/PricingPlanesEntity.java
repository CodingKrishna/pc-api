package org.pioneercoders.entity.hr;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="pricing_planes_tbl")
public class PricingPlanesEntity {
	
	private Long id;
	private String planType;
	private Float planPrice;
	private String availableProfiles;
	private Long planValidity;
	private String staffLogin;
	private Boolean techSupport;
	private String planAvailability;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="PLAN_TYPE")
	public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	
	@Column(name="PLAN_PRICE")
	public Float getPlanPrice() {
		return planPrice;
	}
	public void setPlanPrice(Float planPrice) {
		this.planPrice = planPrice;
	}
	
	@Column(name="AVAILABLE_PROFILES")
	public String getAvailableProfiles() {
		return availableProfiles;
	}
	public void setAvailableProfiles(String availableProfiles) {
		this.availableProfiles = availableProfiles;
	}
	
	@Column(name="PLAN_VALIDITY")
	public Long getPlanValidity() {
		return planValidity;
	}
	public void setPlanValidity(Long planValidity) {
		this.planValidity = planValidity;
	}
	
	@Column(name="STAFF_LOGIN")
	public String getStaffLogin() {
		return staffLogin;
	}
	public void setStaffLogin(String staffLogin) {
		this.staffLogin = staffLogin;
	}
	
	@Column(name="TECH_SUPPORT")
	public Boolean getTechSupport() {
		return techSupport;
	}
	public void setTechSupport(Boolean techSupport) {
		this.techSupport = techSupport;
	}
	
	@Column(name="PLAN_AVAILABILITY")
	public String getPlanAvailability() {
		return planAvailability;
	}
	public void setPlanAvailability(String planAvailability) {
		this.planAvailability = planAvailability;
	}
	@Override
	public String toString() {
		return "PricingPlanesEntity [id=" + id + ", planType=" + planType
				+ ", purchasedDate=" + ", planPrice="
				+ planPrice + ", availableProfiles=" + availableProfiles
				+ ", planValidity=" + planValidity + ", staffLogin="
				+ staffLogin + ", techSupport=" + techSupport
				+ ", planAvailability=" + planAvailability + "]";
	}
	
}
