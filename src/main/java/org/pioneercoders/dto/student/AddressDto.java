package org.pioneercoders.dto.student;

import org.pioneercoders.dto.user.UserDto;

public class AddressDto {
	
	private Long id;
	private String address;
	private CityDto city;
	private StateDto state;
	private CountryDto country;
	private String pincode;
	private UserDto user;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public CityDto getCity() {
		return city;
	}
	public void setCity(CityDto city) {
		this.city = city;
	}
	public StateDto getState() {
		return state;
	}
	public void setState(StateDto state) {
		this.state = state;
	}
	public CountryDto getCountry() {
		return country;
	}
	public void setCountry(CountryDto country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "AddressDto [id=" + id + ", address=" + address + ", city="
				+ city + ", pincode=" + pincode 
				 + ", user=" + user + "]";
	}
	
}
