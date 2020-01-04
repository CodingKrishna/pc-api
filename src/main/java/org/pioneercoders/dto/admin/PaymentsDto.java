package org.pioneercoders.dto.admin;

import java.util.Date;

import org.pioneercoders.dto.user.UserDto;

public class PaymentsDto {

	private Long id;
	private Date createOn;
	private UserDto user;
	private Float paidAmount;
	private String receivedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public Float getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(Float paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getReceivedBy() {
		return receivedBy;
	}

	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}

	@Override
	public String toString() {
		return "PaymentsDto [id=" + id + ", CreateOn=" + createOn + ", user="
				+ user + ", paidAmount=" + paidAmount + ", receivedBy="
				+ receivedBy + "]";
	}

}
