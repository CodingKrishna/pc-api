package org.pioneercoders.dao.evaluation.objectivetest;

import java.util.List;

import org.pioneercoders.entity.evaluation.objectivetest.ObjectQstnEntity;
import org.pioneercoders.exceptions.DBException;

public interface ObjectiveQstnDao {
	
public ObjectQstnEntity insertQuestions(ObjectQstnEntity objectQstnEntity) throws DBException ;
	
public List<ObjectQstnEntity> getQuestionsByGroup(String questionGroup) throws DBException ;

public String getFinalQuestionId(String questionGroup) throws DBException ;

public ObjectQstnEntity getQuestionsById(Long id) throws DBException;
}
