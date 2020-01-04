package org.pioneercoders.dto.student;

import org.pioneercoders.dto.user.UserDto;

public class UserExperianceDto {

	 private Long id;
	 private String expectedSalaryInLakhs;
	 private String expectedSalaryInThousands;
	 private String curentSalaryInLakhs;
	 private String curentSalaryInThousands;
	 private int yearsOfExperiance;
	 private int monthsOfExperiace;
	 private UserDto user;
	 
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
	public int getYearsOfExperiance() {
		return yearsOfExperiance;
	}
	public void setYearsOfExperiance(int yearsOfExperiance) {
		this.yearsOfExperiance = yearsOfExperiance;
	}
	public int getMonthsOfExperiace() {
		return monthsOfExperiace;
	}
	public void setMonthsOfExperiace(int monthsOfExperiace) {
		this.monthsOfExperiace = monthsOfExperiace;
	}
	public String getExpectedSalaryInLakhs() {
		return expectedSalaryInLakhs;
	}
	public void setExpectedSalaryInLakhs(String expectedSalaryInLakhs) {
		this.expectedSalaryInLakhs = expectedSalaryInLakhs;
	}
	public String getExpectedSalaryInThousands() {
		return expectedSalaryInThousands;
	}
	public void setExpectedSalaryInThousands(String expectedSalaryInThousands) {
		this.expectedSalaryInThousands = expectedSalaryInThousands;
	}
	public String getCurentSalaryInLakhs() {
		return curentSalaryInLakhs;
	}
	public void setCurentSalaryInLakhs(String curentSalaryInLakhs) {
		this.curentSalaryInLakhs = curentSalaryInLakhs;
	}
	public String getCurentSalaryInThousands() {
		return curentSalaryInThousands;
	}
	public void setCurentSalaryInThousands(String curentSalaryInThousands) {
		this.curentSalaryInThousands = curentSalaryInThousands;
	}
	@Override
	public String toString() {
		return "TotalWorkExpDto [id=" + id + ", expectedSalaryInLakhs="
				+ expectedSalaryInLakhs + ", curentSalaryInLakhs=" + curentSalaryInLakhs + ", user="
				+ user + "]";
	}
}
