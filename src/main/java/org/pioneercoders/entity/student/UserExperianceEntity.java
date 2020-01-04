package org.pioneercoders.entity.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.pioneercoders.entity.user.UserEntity;

@Entity
@Table(name="user_experiance_tbl")
public class UserExperianceEntity {
	
	 private Long id;
	 private int yearsOfExperiance;
	 private int monthsOfExperiace;
	 private String expectedSalaryInLakhs;
	 private String expectedSalaryInThousands;
	 private String curentSalaryInLakhs;
	 private String curentSalaryInThousands;
	 private UserEntity user;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}

	@Column(name="YEARS_OF_EXPERIANCE")
	public int getYearsOfExperiance() {
		return yearsOfExperiance;
	}
	public void setYearsOfExperiance(int yearsOfExperiance) {
		this.yearsOfExperiance = yearsOfExperiance;
	}
	
	@Column(name="YEARS_OF_MONTHS")
	public int getMonthsOfExperiace() {
		return monthsOfExperiace;
	}
	public void setMonthsOfExperiace(int monthsOfExperiace) {
		this.monthsOfExperiace = monthsOfExperiace;
	}
	@Column(name="EXPECTED_SALARY_IN_LAKHS")
	public String getExpectedSalaryInLakhs() {
		return expectedSalaryInLakhs;
	}
	public void setExpectedSalaryInLakhs(String expectedSalaryInLakhs) {
		this.expectedSalaryInLakhs = expectedSalaryInLakhs;
	}
	@Column(name="EXPECTED_SALARY_IN_THOUSANDS")
	public String getExpectedSalaryInThousands() {
		return expectedSalaryInThousands;
	}
	public void setExpectedSalaryInThousands(String expectedSalaryInThousands) {
		this.expectedSalaryInThousands = expectedSalaryInThousands;
	}
	@Column(name="CURRENT_SALARY_IN_LAKHS")
	public String getCurentSalaryInLakhs() {
		return curentSalaryInLakhs;
	}
	public void setCurentSalaryInLakhs(String curentSalaryInLakhs) {
		this.curentSalaryInLakhs = curentSalaryInLakhs;
	}
	@Column(name="CURRENT_SALARY_IN_THOUSANDS")
	public String getCurentSalaryInThousands() {
		return curentSalaryInThousands;
	}
	public void setCurentSalaryInThousands(String curentSalaryInThousands) {
		this.curentSalaryInThousands = curentSalaryInThousands;
	}
	@Override
	public String toString() {
		return "ExpectationsEntity [id=" + id + ", expectedSalaryInLakhs="
				+ expectedSalaryInLakhs + ", curentSalaryInLakhs=" + curentSalaryInLakhs + ", user="
				+ user + "]";
	}

}
