package org.pioneercoders.services.evaluation.objectivetest;

import java.util.List;

import org.pioneercoders.dto.evaluation.objectivetest.ExamDto;
import org.pioneercoders.dto.evaluation.objectivetest.ExamResTransDto;
import org.pioneercoders.dto.evaluation.objectivetest.ObjectiveTestTotalResultDto;
import org.pioneercoders.exceptions.ServiceException;

public interface ExamService {
	
	public Long insertExam(ExamDto examDto)  throws ServiceException ;

	public ExamResTransDto getExamTransInfo(Long personlInfoId) throws ServiceException;
	
	public List<ObjectiveTestTotalResultDto> getAllExamResults()  throws ServiceException ;
	
	public List<ObjectiveTestTotalResultDto> getAllExamResultsByProfileId(Long id)  throws ServiceException ;
	
	/*public List<TechologiesDto> getAllTechnologies()  throws ServiceException ;
	
	public int assingTechnologiesToUsers(Long userId,List<String> technologiesList) throws ServiceException;
	
	public List<TechnologyTrnDto> getTechnlogiesListByUserId(Long userId)  throws ServiceException ;*/
	
	// public List<ExamResTransDto> getAllExamReData()  throws ServiceException ;
	
}
