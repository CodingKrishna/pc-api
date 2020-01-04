package org.pioneercoders.dto.admin;

import java.util.Date;

public class ExpendatureDto {

	private Long id;
	private String productName;
	private String description;
	private Double price;
	private Date createOn;
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
	public String getBillPath() {
		return billPath;
	}
	public void setBillPath(String billPath) {
		this.billPath = billPath;
	}
	public Date getCreateOn() {
		return createOn;
	}
	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}
	@Override
	public String toString() {
		return "ExpendatureDto [id=" + id + ", productName=" + productName
				+ ", description=" + description + ", price=" + price
				+ ", purchasedOn=" + createOn + ", billPath=" + billPath
				+ "]";
	}
	
	
}
