package org.pioneercoders.dao.evaluation.objectivetest;

import java.util.List;

import org.pioneercoders.entity.evaluation.objectivetest.ObjectiveQstnAnswersEntity;
import org.pioneercoders.exceptions.DBException;

public interface ObjectiveQstnAnswersDao{

	public List<ObjectiveQstnAnswersEntity> getAllAnswers() throws DBException;
	
	public ObjectiveQstnAnswersEntity insertAnswers(ObjectiveQstnAnswersEntity objectiveQstnAnswersEntity) throws DBException ;
}
