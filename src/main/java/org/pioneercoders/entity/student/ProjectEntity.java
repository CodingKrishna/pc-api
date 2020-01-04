package org.pioneercoders.entity.student;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.pioneercoders.dto.student.ProjectDomainDto;
import org.pioneercoders.entity.user.UserEntity;

@Entity
@Table(name="user_projects_tbl")
public class ProjectEntity {
	
	private Long id;
	private String projectTitle;
	private String desc;
	private Date startDate;
	private Date endDate;
	private String responsibilities;
	private ProjectDomainEntity projectdomain;
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
	
	@Column(name="TITLE")
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	@Column(name="PROJECT_DESC")
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Column(name="START_DATE")
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@Column(name="END_START")
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Column(name="RESPONSIBILITIES")
	public String getResponsibilities() {
		return responsibilities;
	}
	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	@ManyToOne
	@JoinColumn(name="PROJECT_DOMAIN_ID")
	public ProjectDomainEntity getProjectdomain() {
		return projectdomain;
	}
	public void setProjectdomain(ProjectDomainEntity projectdomain) {
		this.projectdomain = projectdomain;
	}
	@Override
	public String toString() {
		return "ProjectEntity [id=" + id + ", projectTitle=" + projectTitle
				+ ", desc=" + desc + ", startDate=" + startDate + ", endDate="
				+ endDate + ", responsibilities=" + responsibilities
				+ ", user=" + user + "]";
	}
	
}
