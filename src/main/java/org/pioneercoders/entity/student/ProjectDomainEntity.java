package org.pioneercoders.entity.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="project_domain_mst_tbl")
public class ProjectDomainEntity {
	private Long id;
	private String projectDomainName;
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="PROJECT_DOMAIN_NAME")
	public String getProjectDomainName() {
		return projectDomainName;
	}
	public void setProjectDomainName(String projectDomainName) {
		this.projectDomainName = projectDomainName;
	}
	
	
}
