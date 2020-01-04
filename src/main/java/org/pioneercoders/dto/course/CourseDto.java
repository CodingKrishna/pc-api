package org.pioneercoders.dto.course;

import java.util.Date;

public class CourseDto {

	private Long id;
	private String courseName;
	private String shortDesc;
	private Float price;
	private Date courseStartDate;
	private Integer sortIndex;
	private String imgPath;
	private String descPath;
	private String descTemplate;
	private String category;
	private Boolean isFeaturedCourse;
	private String courseDuration;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Date getCourseStartDate() {
		return courseStartDate;
	}

	public void setCourseStartDate(Date courseStartDate) {
		this.courseStartDate = courseStartDate;
	}

	public Integer getSortIndex() {
		return sortIndex;
	}

	public void setSortIndex(Integer sortIndex) {
		this.sortIndex = sortIndex;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getDescPath() {
		return descPath;
	}

	public void setDescPath(String descPath) {
		this.descPath = descPath;
	}
	

	public String getDescTemplate() {
		return descTemplate;
	}

	public void setDescTemplate(String descTemplate) {
		this.descTemplate = descTemplate;
	}
	
	

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	
	public Boolean getIsFeaturedCourse() {
		return isFeaturedCourse;
	}

	public void setIsFeaturedCourse(Boolean isFeaturedCourse) {
		this.isFeaturedCourse = isFeaturedCourse;
	}
	
	public String getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}

	@Override
	public String toString() {
		return "CourseDto [id=" + id + ", courseName=" + courseName
				+ ", shortDesc=" + shortDesc + ", price=" + price
				+ ", courseStartDate=" + courseStartDate + ", sortIndex="
				+ sortIndex + ", imgPath=" + imgPath + ", descPath=" + descPath
				+ "]";
	}



}