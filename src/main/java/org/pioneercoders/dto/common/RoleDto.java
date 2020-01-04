package org.pioneercoders.dto.common;

public class RoleDto {
	
	private Long id;
	private String roleName;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	@Override
	public String toString() {
		return "RoleDto [id=" + id + ", roleName=" + roleName + "]";
	}
	
	

}
