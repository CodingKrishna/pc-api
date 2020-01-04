package org.pioneercoders.dto.course;

import java.util.Date;

public class BatchTimingDto {
	
	private Long id;
	private Date startDate;
	private String timings;
	private String trainerName;
	private String description;
	private CourseDto course;
	private String imgPath;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getTimings() {
		return timings;
	}
	public void setTimings(String timings) {
		this.timings = timings;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public CourseDto getCourse() {
		return course;
	}
	public void setCourse(CourseDto course) {
		this.course = course;
	}
	
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	@Override
	public String toString() {
		return "BatchTimingDto [id=" + id + ", startDate=" + startDate
				+ ", timings=" + timings + ", trainerName=" + trainerName
				+ ", description=" + description + ", course=" + course + "]";
	}
	
	
}
