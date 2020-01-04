package org.pioneercoders.dao.evaluation;

import java.util.List;

import org.pioneercoders.entity.evaluation.InterviewFeedbackEntity;
import org.pioneercoders.entity.evaluation.UserInterviewStatusEntity;
import org.pioneercoders.exceptions.DBException;

public interface InterviewFeedbackDao {
	
	public List<InterviewFeedbackEntity> getInterviewFeedbackList() throws DBException;
	
	public UserInterviewStatusEntity insertOrUpadateStudentFeedBack(UserInterviewStatusEntity entity) throws DBException;

	public UserInterviewStatusEntity getInterviewFeedBackDetailsByUserId(Long userId) throws DBException;
	
	public List<UserInterviewStatusEntity> getInterviewFeedBacksListByGoodOrExcellent() throws DBException;
	
}
