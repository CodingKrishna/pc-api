package org.pioneercoders.entity.course;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="course_mst_tbl")
public class CourseEntity {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	
	@Column(name="COURSE_NAME")
	private String courseName;
	
	@Column(name="SHORT_DESC", length = 1000)
	private String shortDesc;
	
	@Column(name="PRICE")
	private Float price;
	
	@Column(name="COURSE_START_DATE")
	private Date courseStartDate;
	
	@Column(name="SORT_INDEX")
	private Integer sortIndex;
	
	@Column(name="IMAGE_PATH")
	private String imgPath;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "DESC_PATH")
	private String descPath;
	
	@Column(name = "CATEGORY")
	private String category;
	
	@Column(name = "IS_FEATURED_COURSE")
	private Boolean isFeaturedCourse;
	
	@Column(name="COURSE_DURATION")
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescPath() {
		return descPath;
	}

	public void setDescPath(String descPath) {
		this.descPath = descPath;
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
		return "Course [id=" + id + ", courseName=" + courseName
				+ ", shortDesc=" + shortDesc + ", price=" + price
				+ ", courseStartDate=" + courseStartDate + ", sortIndex="
				+ sortIndex + ", imgPath=" + imgPath + ", status=" + status
				+ "]";
	}
	

}
