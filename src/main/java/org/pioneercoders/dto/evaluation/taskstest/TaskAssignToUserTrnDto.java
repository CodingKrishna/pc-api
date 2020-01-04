package org.pioneercoders.dto.evaluation.taskstest;

import org.pioneercoders.dto.user.UserDto;

public class TaskAssignToUserTrnDto{
	
	private Long id;
	private TaskDto task;
	private UserDto user;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TaskDto getTask() {
		return task;
	}
	public void setTask(TaskDto task) {
		this.task = task;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "TaskAssignToUserTrnEntity [id=" + id + ", task=" + task
				+ ", user=" + user + "]";
	}

}