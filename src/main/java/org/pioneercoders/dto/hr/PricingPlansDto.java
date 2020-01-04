package org.pioneercoders.dto.hr;


public class PricingPlansDto {

	private Long id;
	private String planType;
	private Float planPrice;
	private String availableProfiles;
	private Long planValidity;
	private String staffLogin;
	private Boolean techSupport;
	private String planAvailability;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	public Float getPlanPrice() {
		return planPrice;
	}
	public void setPlanPrice(Float planPrice) {
		this.planPrice = planPrice;
	}
	public String getAvailableProfiles() {
		return availableProfiles;
	}
	public void setAvailableProfiles(String availableProfiles) {
		this.availableProfiles = availableProfiles;
	}
	public Long getPlanValidity() {
		return planValidity;
	}
	public void setPlanValidity(Long planValidity) {
		this.planValidity = planValidity;
	}
	public String getStaffLogin() {
		return staffLogin;
	}
	public void setStaffLogin(String staffLogin) {
		this.staffLogin = staffLogin;
	}
	public Boolean getTechSupport() {
		return techSupport;
	}
	public void setTechSupport(Boolean techSupport) {
		this.techSupport = techSupport;
	}
	public String getPlanAvailability() {
		return planAvailability;
	}
	public void setPlanAvailability(String planAvailability) {
		this.planAvailability = planAvailability;
	}
	@Override
	public String toString() {
		return "PricingPlansDto [id=" + id + ", planType=" + planType
				+ ", purchasedDate=" + ", planPrice="
				+ planPrice + ", availableProfiles=" + availableProfiles
				+ ", planValidity=" + planValidity + ", staffLogin="
				+ staffLogin + ", techSupport=" + techSupport
				+ ", planAvailability=" + planAvailability + "]";
	}
}
