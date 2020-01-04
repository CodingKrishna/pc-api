package org.pioneercoders.services.evaluation.codingtest;

import java.util.List;

import org.pioneercoders.dto.evaluation.codingtest.CodingTestQstnDto;
import org.pioneercoders.dto.evaluation.codingtest.CodingTestQstnsAssignToUserTrnDto;
import org.pioneercoders.dto.evaluation.codingtest.CodingTestResultDto;
import org.pioneercoders.exceptions.ServiceException;

public interface CodingTestQstnService {
	
	public List<CodingTestQstnDto> getAllQuestions() throws ServiceException;

	public CodingTestQstnDto saveQuestion(CodingTestQstnDto codingTestQstnDto) throws ServiceException;

	public List<CodingTestQstnsAssignToUserTrnDto> getAllQuestionsByUserId(Long userId) throws ServiceException;
	
	public int assingQuestionsToUser(Long userId,List<String> questionIds) throws ServiceException;
	
	public CodingTestResultDto saveCodingTestResult(CodingTestResultDto codingTestResultDto) throws ServiceException;
	
}
