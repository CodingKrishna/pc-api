package org.pioneercoders.dto.student;


public class CityDto {
	private Long id;
	private String cityName;
	private StateDto state;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public StateDto getState() {
		return state;
	}
	public void setState(StateDto state) {
		this.state = state;
	}
	
	

}
