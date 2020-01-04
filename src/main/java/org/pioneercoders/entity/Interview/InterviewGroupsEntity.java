package org.pioneercoders.entity.Interview;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Interview_Groups_mst_tbl")
public class InterviewGroupsEntity {
	
	private Long id;
	private String groupName;
	private String groupDesc;
	private Long hrId;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="GROUP_NAME")
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	@Column(name="GROUP_DESC")
	public String getGroupDesc() {
		return groupDesc;
	}
	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}
	@Column(name="HR_ID")
	public Long getHrId() {
		return hrId;
	}
	public void setHrId(Long hrId) {
		this.hrId = hrId;
	}
	
	
}
