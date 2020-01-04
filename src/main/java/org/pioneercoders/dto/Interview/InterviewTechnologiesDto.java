package org.pioneercoders.dto.Interview;

import org.pioneercoders.dto.common.TechnologiesDto;

public class InterviewTechnologiesDto {
	
	private Long id;
	private InterviewsDto test;
	private TechnologiesDto technologies;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public InterviewsDto getTest() {
		return test;
	}
	public void setTest(InterviewsDto test) {
		this.test = test;
	}
	public TechnologiesDto getTechnologies() {
		return technologies;
	}
	public void setTechnologies(TechnologiesDto technologies) {
		this.technologies = technologies;
	}
	
	
	

}
