package org.pioneercoders.entity.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.pioneercoders.dto.student.CountryDto;
import org.pioneercoders.dto.student.StateDto;
import org.pioneercoders.entity.user.UserEntity;

@Entity
@Table(name="user_addresses_tbl")
public class AddressEntity {

	private Long id;
	private String address;
	private CityEntity city;
	private StateEntity state;
	private CountryEntity country;
	private String pincode;
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
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	@Column(name="ADDRESS")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name="PINCODE")
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	@ManyToOne
	@JoinColumn(name="CITY_ID")
	public CityEntity getCity() {
		return city;
	}
	public void setCity(CityEntity city) {
		this.city = city;
	}
	@ManyToOne
	@JoinColumn(name="STATE_ID")
	public StateEntity getState() {
		return state;
	}
	public void setState(StateEntity state) {
		this.state = state;
	}
	@ManyToOne
	@JoinColumn(name="COUNTRY_ID")
	public CountryEntity getCountry() {
		return country;
	}
	public void setCountry(CountryEntity country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "AddressEntity [id=" + id + ", address=" + address + ", city="
				+ city + ", pincode=" + pincode
				 + ", user=" + user + "]";
	}
	
}
