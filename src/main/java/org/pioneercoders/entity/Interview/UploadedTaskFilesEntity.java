package org.pioneercoders.entity.Interview;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.pioneercoders.entity.evaluation.taskstest.TaskEntity;
import org.pioneercoders.entity.user.UserEntity;
@Entity
@Table(name="uploaded_task_files_tbl")
public class UploadedTaskFilesEntity {

	private Long id;
	private String fileName;
	private UserEntity user;
	private InterviewsEntity test;
	private TaskEntity task;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="FILE_NAME")
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
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
	@JoinColumn(name="INTERVIEWS_ID")
	public InterviewsEntity getTest() {
		return test;
	}
	public void setTest(InterviewsEntity test) {
		this.test = test;
	}
	
	@ManyToOne
	@JoinColumn(name="TASK_ID")
	public TaskEntity getTask() {
		return task;
	}
	public void setTask(TaskEntity task) {
		this.task = task;
	}
	@Override
	public String toString() {
		return "UploadedTestFileEntity [id=" + id + ", fileName=" + fileName
				+ ", user=" + user + ", test=" + test + ", task=" + task + "]";
	}
	
	
}
