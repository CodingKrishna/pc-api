package org.pioneercoders.dto.Interview;

import java.util.List;

import org.pioneercoders.dto.common.TechnologiesDto;

public class TechnologiesInRoundDto {
	
	private List<TechnologiesDto> technologies;
	private List<RoundsDto> round;
	

	public List<TechnologiesDto> getTechnologies() {
		return technologies;
	}
	public void setTechnologies(List<TechnologiesDto> technologies) {
		this.technologies = technologies;
	}
	public List<RoundsDto> getRound() {
		return round;
	}
	public void setRound(List<RoundsDto> round) {
		this.round = round;
	}

}
