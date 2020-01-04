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
@Table(name="city_mst_tbl")
public class CityEntity {
	private Long id;
	private String cityName;
	private StateEntity state;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="CITY_NAME")
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	@ManyToOne
	@JoinColumn(name="STATE_ID")
	public StateEntity getState() {
		return state;
	}
	public void setState(StateEntity state) {
		this.state = state;
	}
	
	
	
}
