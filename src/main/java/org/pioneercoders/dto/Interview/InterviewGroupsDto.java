package org.pioneercoders.dto.Interview;

public class InterviewGroupsDto {
	
	private Long id;
	private String groupName;
	private String groupDesc;
	private Long hrId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupDesc() {
		return groupDesc;
	}
	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}
	public Long getHrId() {
		return hrId;
	}
	public void setHrId(Long hrId) {
		this.hrId = hrId;
	}
	

}
