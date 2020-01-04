package org.pioneercoders.entity.admin;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.pioneercoders.entity.user.UserEntity;
@Entity
@Table(name="courses_payments_trn_tbl")
public class PaymentsEntity {
	private Long id;
	private Date createOn;
	private UserEntity user;
	private Float paidAmount;
	private String receivedBy;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	@Column(name="CREATED_ON")
	public Date getCreateOn() {
		return createOn;
	}
	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	public UserEntity getUser() {
		return user;
	}
	
	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	@Column(name="PAID_AMOUNT")
	public Float getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(Float paidAmount) {
		this.paidAmount = paidAmount;
	}
	
	@Column(name="RECEIVED_BY")
	public String getReceivedBy() {
		return receivedBy;
	}

	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}
	
	@Override
	public String toString() {
		return "PaymentsEntity [id=" + id + ", CreateOn=" + createOn
				+ ", user=" + user + ", paidAmount=" + paidAmount
				+ ", receivedBy=" + receivedBy + "]";
	}
}
