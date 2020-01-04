package org.pioneercoders.entity.evaluation.taskstest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.pioneercoders.entity.user.UserEntity;

@Entity
@Table(name="user_submitted_tasks_tbl")
public class UserSubmittedTaskEntity {

	private Long id;
	private String fileName;
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

	@Column(name="FILENAME")
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "InternTaskFileNamesEntity [id=" + id + ", fileName=" + fileName
				+ ", user=" + user + "]";
	}
	
	
}
