package org.pioneercoders.dto.hr;

import java.util.List;

import org.pioneercoders.dto.common.TechnologiesDto;
import org.pioneercoders.dto.student.AddressDto;

public class UserSearchDto {
	
	private AddressDto address;
	private List<TechnologiesDto> tech;
	private int expmin;
	private int expmax;
	
	public AddressDto getAddress() {
		return address;
	}
	public void setAddress(AddressDto address) {
		this.address = address;
	}
	public List<TechnologiesDto> getTech() {
		return tech;
	}
	public void setTech(List<TechnologiesDto> tech) {
		this.tech = tech;
	}
	public int getExpmin() {
		return expmin;
	}
	public void setExpmin(int expmin) {
		this.expmin = expmin;
	}
	public int getExpmax() {
		return expmax;
	}
	public void setExpmax(int expmax) {
		this.expmax = expmax;
	}
	
	

}
