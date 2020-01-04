package org.pioneercoders.dto.student;

import java.util.Date;

import org.pioneercoders.dto.course.CourseDto;
import org.pioneercoders.dto.user.UserDto;

public class PurchasedCourseDto {
	
	private Long id;
	private Date purchasedOn;
	private CourseDto courseId;
	private UserDto user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CourseDto getCourseId() {
		return courseId;
	}
	public void setCourseId(CourseDto courseId) {
		this.courseId = courseId;
	}
	public Date getPurchasedOn() {
		return purchasedOn;
	}
	public void setPurchasedOn(Date purchasedOn) {
		this.purchasedOn = purchasedOn;
	}
	
	public UserDto getUser() {
		return user;
	}
	
	public void setUser(UserDto user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "PurchasedCourseDto [id=" + id + ", purchasedOn=" + purchasedOn
				+ ", courseId=" + courseId + ", user=" + user + "]";
	}
	
}
