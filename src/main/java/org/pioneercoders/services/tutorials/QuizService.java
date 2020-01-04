package org.pioneercoders.services.tutorials;

import java.util.List;

import org.pioneercoders.dto.tutorials.QuizDto;
import org.pioneercoders.exceptions.ServiceException;

public interface QuizService {
	
	public QuizDto createQuiz(QuizDto quizDto) throws ServiceException;
	
	public List<QuizDto> getQuizListByUserId(Long userId)throws ServiceException;
}












