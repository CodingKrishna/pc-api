package org.pioneercoders.entity.Interview;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="rounds_mst_tbl")
public class RoundsEntity {
	
	private Long id;
	private String patternName;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="PATTERN_NAME")
	public String getPatternName() {
		return patternName;
	}
	public void setPatternName(String patternName) {
		this.patternName = patternName;
	}
	
	
	
}
