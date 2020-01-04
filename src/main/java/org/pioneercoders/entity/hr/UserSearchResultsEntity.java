package org.pioneercoders.entity.hr;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_search_view")
public class UserSearchResultsEntity {
	private Long id;
	private int yearsOfExperience;
	private String EmailID;
	private String MobileId;
	private String userName;
	private Long roleId;
	private Long cityID;
	private String address;
	
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="YEARS_OF_EXPERIANCE")
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	@Column(name="EMAILID")
	public String getEmailID() {
		return EmailID;
	}
	public void setEmailID(String emailID) {
		EmailID = emailID;
	}
	@Column(name="MOBILENO")
	public String getMobileId() {
		return MobileId;
	}
	public void setMobileId(String mobileId) {
		MobileId = mobileId;
	}
	@Column(name="USERNAME")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name="ROLE_ID")
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	@Column(name="CITY_ID")
	public Long getCityID() {
		return cityID;
	}
	public void setCityID(Long cityID) {
		this.cityID = cityID;
	}
	@Column(name="ADDRESS")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
