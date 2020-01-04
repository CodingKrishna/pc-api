package org.pioneercoders.entity.admin;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="expendature_mst_tbl")
public class ExpendatureEntity {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="PRICE")
	private Double price;
	
	@Column(name="PURCHASED_ON")
	private Date createOn;
	
	@Column(name="BILL_PATH")
	private String billPath;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Date getCreateOn() {
		return createOn;
	}
	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}
	public String getBillPath() {
		return billPath;
	}
	public void setBillPath(String billPath) {
		this.billPath = billPath;
	}
	@Override
	public String toString() {
		return "ExpendatureEntity [id=" + id + ", productName=" + productName
				+ ", description=" + description + ", price=" + price
				+ ", purchasedOn=" + createOn + ", billPath=" + billPath
				+ "]";
	}
	
	
}
