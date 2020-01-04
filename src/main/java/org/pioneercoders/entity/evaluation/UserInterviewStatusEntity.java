package org.pioneercoders.entity.evaluation;

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
@Table(name="user_interview_status_tbl")
public class UserInterviewStatusEntity {
	private Long id;
	private Long attitude;
	private Long logical;
	private String ftfExtraComments;
	private Long teleCommunication;
	private Long teleProgramming;
	private  String teleExtraComments;
	private Long sysProgramsGiven;
	private Long sysProgramsExecuted;
	private Long sysRating;
	private Long tasksGiven;
	private Long tasksCompleted;
	private Long taskRating;
	private UserEntity user;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="ATTITUDE")
	public Long getAttitude() {
		return attitude;
	}
	public void setAttitude(Long attitude) {
		this.attitude = attitude;
	}
	
	@Column(name="LOGICAL")
	public Long getLogical() {
		return logical;
	}
	public void setLogical(Long logical) {
		this.logical = logical;
	}
	
	@Column(name="FTF_EXTRA_COMMENTS")
	public String getFtfExtraComments() {
		return ftfExtraComments;
	}
	public void setFtfExtraComments(String ftfExtraComments) {
		this.ftfExtraComments = ftfExtraComments;
	}
	
	@Column(name="TELE_COMMUNICATION")
	public Long getTeleCommunication() {
		return teleCommunication;
	}
	public void setTeleCommunication(Long teleCommunication) {
		this.teleCommunication = teleCommunication;
	}
	
	@Column(name="TELE_PROGRAMMING")
	public Long getTeleProgramming() {
		return teleProgramming;
	}
	public void setTeleProgramming(Long teleProgramming) {
		this.teleProgramming = teleProgramming;
	}
	
	@Column(name="TELE_EXTRA_COMMENTS")
	public String getTeleExtraComments() {
		return teleExtraComments;
	}
	public void setTeleExtraComments(String teleExtraComments) {
		this.teleExtraComments = teleExtraComments;
	}
	
	@Column(name="SYS_PROGRAMS_GIVEN")
	public Long getSysProgramsGiven() {
		return sysProgramsGiven;
	}
	public void setSysProgramsGiven(Long sysProgramsGiven) {
		this.sysProgramsGiven = sysProgramsGiven;
	}
	
	@Column(name="SYS_PROGRAMS_EXECUTED")
	public Long getSysProgramsExecuted() {
		return sysProgramsExecuted;
	}
	
	@Column(name="SYS_RATING")
	public void setSysProgramsExecuted(Long sysProgramsExecuted) {
		this.sysProgramsExecuted = sysProgramsExecuted;
	}
	public Long getSysRating() {
		return sysRating;
	}
	public void setSysRating(Long sysRating) {
		this.sysRating = sysRating;
	}
	
	@Column(name="TASKS_GIVEN")
	public Long getTasksGiven() {
		return tasksGiven;
	}
	public void setTasksGiven(Long tasksGiven) {
		this.tasksGiven = tasksGiven;
	}
	
	@Column(name="TASKS_COMPLETED")
	public Long getTasksCompleted() {
		return tasksCompleted;
	}
	public void setTasksCompleted(Long tasksCompleted) {
		this.tasksCompleted = tasksCompleted;
	}
	@Column(name="TASK_RATING")
	public Long getTaskRating() {
		return taskRating;
	}
	public void setTaskRating(Long taskRating) {
		this.taskRating = taskRating;
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
		return "StudentInterviewStatusEntity [id=" + id + ", attitude="
				+ attitude + ", logical=" + logical + ", ftfExtraComments="
				+ ftfExtraComments + ", teleCommunication=" + teleCommunication
				+ ", teleProgramming=" + teleProgramming
				+ ", teleExtraComments=" + teleExtraComments
				+ ", sysProgramsGiven=" + sysProgramsGiven
				+ ", sysProgramsExecuted=" + sysProgramsExecuted
				+ ", sysRating=" + sysRating + ", tasksGiven=" + tasksGiven
				+ ", tasksCompleted=" + tasksCompleted + ", taskRating="
				+ taskRating + ", user=" + user + "]";
	}
	
	
}