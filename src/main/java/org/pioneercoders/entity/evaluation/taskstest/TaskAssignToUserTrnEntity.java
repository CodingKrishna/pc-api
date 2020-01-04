package org.pioneercoders.entity.evaluation.taskstest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.pioneercoders.entity.user.UserEntity;

@Entity
@Table(name="task_assign_to_user_trn_tbl")
public class TaskAssignToUserTrnEntity {

	private Long id;
	private TaskEntity task;
	private UserEntity user;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="TASK_ID")
	public TaskEntity getTask() {
		return task;
	}
	public void setTask(TaskEntity task) {
		this.task = task;
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
		return "InternTaskTrnEntity [id=" + id + ", internTask=" + task
				+ ", user=" + user + "]";
	}
	
}
