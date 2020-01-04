package org.pioneercoders.services.common;

import java.util.List;

import org.pioneercoders.dto.common.InstructorDto;
import org.pioneercoders.exceptions.ServiceException;

public interface InstructorService {
	
	public InstructorDto createInstructorInfo(InstructorDto InstructorDto) throws ServiceException;
	
	public List<InstructorDto> getInstructorInfoList()throws ServiceException;

}
