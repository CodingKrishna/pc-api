package org.pioneercoders.services.evaluation.objectivetest;

import org.pioneercoders.dto.evaluation.objectivetest.ExamDto;
import org.pioneercoders.dto.evaluation.objectivetest.ObjectiveQstnDto;
import org.pioneercoders.exceptions.ServiceException;

public interface ObjectiveQstnService {

	public ObjectiveQstnDto insertQuestions(ObjectiveQstnDto objectiveQstnDto) throws ServiceException;

	public ExamDto getExamQuestionsForPerson(Long userId) throws ServiceException;

}
