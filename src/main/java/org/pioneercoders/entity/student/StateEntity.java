package org.pioneercoders.entity.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="state_mst_tbl")
public class StateEntity {
	
	private Long id;
	private String stateName;
	private CountryEntity country;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="STATE_NAME")
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	@ManyToOne
	@JoinColumn(name="COUNTRY_ID")
	public CountryEntity getCountry() {
		return country;
	}
	public void setCountry(CountryEntity country) {
		this.country = country;
	}
	
	
	
	

}
