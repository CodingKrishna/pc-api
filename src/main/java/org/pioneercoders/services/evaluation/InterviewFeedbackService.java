package org.pioneercoders.services.evaluation;

import java.util.List;

import org.pioneercoders.dto.evaluation.InterviewFeedbackDto;
import org.pioneercoders.dto.evaluation.UserInterviewStatusDto;
import org.pioneercoders.dto.user.UserDto;
import org.pioneercoders.exceptions.ServiceException;

public interface InterviewFeedbackService {
	
	public List<InterviewFeedbackDto> getInterviewFeedbackList() throws ServiceException;
	
	public UserInterviewStatusDto insertOrUpdateUserInterviewStatus(UserInterviewStatusDto studentDto) throws ServiceException;

	public UserInterviewStatusDto getUserInterviewStatusDetailsByUserId(Long userId)throws ServiceException;
	
	public List<UserDto> getUserInterviewStatusDetailsListByGoodOrExcellent() throws ServiceException;
	
}
