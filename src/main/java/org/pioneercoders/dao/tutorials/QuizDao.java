package org.pioneercoders.dao.tutorials;

import java.util.List;

import org.pioneercoders.entity.tutorials.QuizEntity;
import org.pioneercoders.exceptions.DBException;

public interface QuizDao {

	public QuizEntity createQuiz(QuizEntity quizEntity) throws DBException;

	public List<QuizEntity> getQuizDetailsByUserId(Long userId) throws DBException;
}
