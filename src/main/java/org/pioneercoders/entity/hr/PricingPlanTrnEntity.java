package org.pioneercoders.entity.hr;

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
@Table(name="pricing_plan_trn_tbl")
public class PricingPlanTrnEntity {
	

	private Long id;
	private Date purchasedDate;
	private UserEntity user;
	private PricingPlanesEntity plan;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="PURCHASE_DATE")
	public Date getPurchasedDate() {
		return purchasedDate;
	}
	public void setPurchasedDate(Date purchasedDate) {
		this.purchasedDate = purchasedDate;
	}
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	@ManyToOne
	@JoinColumn(name="PLAN_ID")
	public PricingPlanesEntity getPlan() {
		return plan;
	}
	public void setPlan(PricingPlanesEntity plan) {
		this.plan = plan;
	}
	
	
	
	@Override
	public String toString() {
		return "PricingPlanTrnEntity [id=" + id + ", purchasedDate="
				+ purchasedDate + ", user=" + user + ", plan=" + plan + "]";
	}

}
