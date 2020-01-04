package org.pioneercoders.entity.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="technologies_mst_tbl")
/*@Cache(usage=CacheConcurrencyStrategy.READ_ONLY, region="skills")*/
public class TechnologiesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="TECHNOLOGY_NAME")
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "TechnologiesEntity [id=" + id + ", name=" + name + "]";
	}
		
}
