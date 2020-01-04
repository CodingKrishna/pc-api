package org.pioneercoders.dto.evaluation.taskstest;

import org.pioneercoders.dto.user.UserDto;

public class UserSubmittedTaskDto {

	private Long id;
	private String fileName;
	private UserDto user;
	
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
	@Override
	public String toString() {
		return "InternTaskFileNamesDto [id=" + id + ", fileName=" + fileName
				+ ", user=" + user + "]";
	}
	
}
