package org.pioneercoders.dto.Interview;

import org.pioneercoders.dto.evaluation.taskstest.TaskDto;
import org.pioneercoders.dto.user.UserDto;

public class UploadedTaskFilesDto {
	
	private Long id;
	private String fileName;
	private UserDto user;
	private InterviewsDto test;
	private TaskDto task;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public InterviewsDto getTest() {
		return test;
	}
	public void setTest(InterviewsDto test) {
		this.test = test;
	}
	public TaskDto getTask() {
		return task;
	}
	public void setTask(TaskDto task) {
		this.task = task;
	}
	@Override
	public String toString() {
		return "UploadedTestFilesDto [id=" + id + ", fileName=" + fileName
				+ ", user=" + user + ", test=" + test + ", task=" + task + "]";
	}
	
}
