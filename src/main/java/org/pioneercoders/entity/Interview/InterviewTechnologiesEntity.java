package org.pioneercoders.entity.Interview;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.pioneercoders.entity.common.TechnologiesEntity;

@Entity
@Table(name="interview_technology_tbl")
public class InterviewTechnologiesEntity {
	
	private Long id;
	private InterviewsEntity test;
	private TechnologiesEntity technologies;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name="INTERVIEWS_ID")
	public InterviewsEntity getTest() {
		return test;
	}
	public void setTest(InterviewsEntity test) {
		this.test = test;
	}
	@ManyToOne
	@JoinColumn(name="TECHNOLOGIES_ID")
	public TechnologiesEntity getTechnologies() {
		return technologies;
	}
	public void setTechnologies(TechnologiesEntity technologies) {
		this.technologies = technologies;
	}
	
	
	
}
