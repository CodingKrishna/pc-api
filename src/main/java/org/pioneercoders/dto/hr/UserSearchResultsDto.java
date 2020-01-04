package org.pioneercoders.dto.hr;

import org.pioneercoders.dto.common.TechnologiesDto;
import org.pioneercoders.dto.student.CityDto;

public class UserSearchResultsDto {
	private Long id;
	private int yearsOfExperience;
	private String EmailID;
	private String MobileId;
	private String userName;
	private Long roleId;
	private Long cityID;
	private String address;
	private CityDto city;
	private TechnologiesDto techskill;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	public String getEmailID() {
		return EmailID;
	}
	public void setEmailID(String emailID) {
		EmailID = emailID;
	}
	public String getMobileId() {
		return MobileId;
	}
	public void setMobileId(String mobileId) {
		MobileId = mobileId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getCityID() {
		return cityID;
	}
	public void setCityID(Long cityID) {
		this.cityID = cityID;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public CityDto getCity() {
		return city;
	}
	public void setCity(CityDto city) {
		this.city = city;
	}
	public TechnologiesDto getTechskill() {
		return techskill;
	}
	public void setTechskill(TechnologiesDto techskill) {
		this.techskill = techskill;
	}
	
}
