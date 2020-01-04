package org.pioneercoders.entity.student;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.pioneercoders.entity.course.CourseEntity;
import org.pioneercoders.entity.user.UserEntity;

@Entity
@Table(name="purchased_courses_trn_tbl")
public class PurchasedCourseEntity {
	
	private Long id;
	private CourseEntity courseId;
	private Date purchasedOn;
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
	@JoinColumn(name="COURSE_ID")
	public CourseEntity getCourseId() {
		return courseId;
	}
	public void setCourseId(CourseEntity courseId) {
		this.courseId = courseId;
	}
	public void setPurchasedOn(Date purchasedOn) {
		this.purchasedOn = purchasedOn;
	}
	
	@Column(name="PURCHASED_DATE")	
	public Date getPurchasedOn() {
		return purchasedOn;
	}
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "PurchasedCourseEntity [id=" + id + ", courseId=" + courseId
				+ ", purchasedOn=" + purchasedOn + ", user=" + user + "]";
	}

	
}
