package org.pioneercoders.entity.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role_mst_tbl")
public class RoleEntity {
	
	private Long id;
	private String roleName;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "ROLE_NAME")
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	@Override
	public String toString() {
		return "RoleEntity [id=" + id + ", roleName=" + roleName + "]";
	}
	
	
	
	

}
