package org.pioneercoders.dao.evaluation.codingtest;

import java.util.List;

import org.pioneercoders.entity.evaluation.codingtest.CodingTestQstnsAssignToUserTrnEntity;
import org.pioneercoders.exceptions.DBException;

public interface CodingTestQstnsTrnDao {
	
	public List<CodingTestQstnsAssignToUserTrnEntity> getAllQuestionsByUserId(Long userId) throws DBException;
	
	public CodingTestQstnsAssignToUserTrnEntity addQuestions(CodingTestQstnsAssignToUserTrnEntity entity) throws DBException;
}
