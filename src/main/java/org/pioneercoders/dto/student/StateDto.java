package org.pioneercoders.dto.student;

public class StateDto {
	
	private Long id;
	private String stateName;
	private CountryDto country;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public CountryDto getCountry() {
		return country;
	}
	public void setCountry(CountryDto country) {
		this.country = country;
	}
	
	
	

}
