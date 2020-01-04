package org.pioneercoders.dto.evaluation;

import org.pioneercoders.dto.user.UserDto;

public class UserInterviewStatusDto {
	
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
	private UserDto user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAttitude() {
		return attitude;
	}
	public void setAttitude(Long attitude) {
		this.attitude = attitude;
	}
	public Long getLogical() {
		return logical;
	}
	public void setLogical(Long logical) {
		this.logical = logical;
	}
	public String getFtfExtraComments() {
		return ftfExtraComments;
	}
	public void setFtfExtraComments(String ftfExtraComments) {
		this.ftfExtraComments = ftfExtraComments;
	}
	public Long getTeleProgramming() {
		return teleProgramming;
	}
	public void setTeleProgramming(Long teleProgramming) {
		this.teleProgramming = teleProgramming;
	}
	public String getTeleExtraComments() {
		return teleExtraComments;
	}
	public void setTeleExtraComments(String teleExtraComments) {
		this.teleExtraComments = teleExtraComments;
	}
	public Long getSysProgramsGiven() {
		return sysProgramsGiven;
	}
	public void setSysProgramsGiven(Long sysProgramsGiven) {
		this.sysProgramsGiven = sysProgramsGiven;
	}
	public Long getSysProgramsExecuted() {
		return sysProgramsExecuted;
	}
	public void setSysProgramsExecuted(Long sysProgramsExecuted) {
		this.sysProgramsExecuted = sysProgramsExecuted;
	}
	public Long getSysRating() {
		return sysRating;
	}
	public void setSysRating(Long sysRating) {
		this.sysRating = sysRating;
	}
	public Long getTasksGiven() {
		return tasksGiven;
	}
	public void setTasksGiven(Long tasksGiven) {
		this.tasksGiven = tasksGiven;
	}
	public Long getTasksCompleted() {
		return tasksCompleted;
	}
	public void setTasksCompleted(Long tasksCompleted) {
		this.tasksCompleted = tasksCompleted;
	}
	public Long getTaskRating() {
		return taskRating;
	}
	public void setTaskRating(Long taskRating) {
		this.taskRating = taskRating;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public Long getTeleCommunication() {
		return teleCommunication;
	}
	public void setTeleCommunication(Long teleCommunication) {
		this.teleCommunication = teleCommunication;
	}
	@Override
	public String toString() {
		return "StudentInterviewStatusDto [id=" + id + ", attitude=" + attitude
				+ ", logical=" + logical + ", ftfExtraComments="
				+ ftfExtraComments + ", teleCommunicatio=" + teleCommunication
				+ ", teleProgramming=" + teleProgramming
				+ ", teleExtraComments=" + teleExtraComments
				+ ", sysProgramsGiven=" + sysProgramsGiven
				+ ", sysProgramsExecuted=" + sysProgramsExecuted
				+ ", sysRating=" + sysRating + ", tasksGiven=" + tasksGiven
				+ ", tasksCompleted=" + tasksCompleted + ", taskRating="
				+ taskRating + ", user=" + user + "]";
	}
	
	
}
