package org.pioneercoders.entity.course;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="batch_timing_trn_tbl")
public class BatchTimingsEntity {
	
	private Long id;
	private Date startDate;
	private String timings;
	private String trainerName;
	private String description;
	private CourseEntity course;
	private String imgPath;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "BATCH_START_DATE")
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@Column(name = "TIMINGS")
	public String getTimings() {
		return timings;
	}
	public void setTimings(String timings) {
		this.timings = timings;
	}
	
	@Column(name = "TRAINER_NAME")
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COURSE_ID")
	public CourseEntity getCourse() {
		return course;
	}
	public void setCourse(CourseEntity course) {
		this.course = course;
	}
	
	@Column(name = "IMGPATH")
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	@Override
	public String toString() {
		return "BatchTimingsEntity [id=" + id + ", startDate=" + startDate
				+ ", timings=" + timings + ", trainerName=" + trainerName
				+ ", description=" + description + ", course=" + course + "]";
	}
	
	

}
