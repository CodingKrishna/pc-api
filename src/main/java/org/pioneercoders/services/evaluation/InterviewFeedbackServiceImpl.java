package org.pioneercoders.services.evaluation;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.pioneercoders.dao.evaluation.InterviewFeedbackDao;
import org.pioneercoders.dao.user.UserDao;
import org.pioneercoders.dto.evaluation.InterviewFeedbackDto;
import org.pioneercoders.dto.evaluation.UserInterviewStatusDto;
import org.pioneercoders.dto.user.UserDto;
import org.pioneercoders.entity.evaluation.InterviewFeedbackEntity;
import org.pioneercoders.entity.evaluation.UserInterviewStatusEntity;
import org.pioneercoders.entity.user.UserEntity;
import org.pioneercoders.exceptions.DBException;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.utils.CollectionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional(propagation=Propagation.REQUIRED)
public class InterviewFeedbackServiceImpl implements InterviewFeedbackService{
	
	@Autowired
	InterviewFeedbackDao interviewFeedbackDao;
	
	@Autowired
	UserDao userDao;
	
	Logger logger = LoggerFactory.getLogger(InterviewFeedbackServiceImpl.class);

	@Override
	public List<InterviewFeedbackDto> getInterviewFeedbackList()throws ServiceException {
		List<InterviewFeedbackEntity> li;
		List<InterviewFeedbackDto> entityList = null;
		try {
			li = interviewFeedbackDao.getInterviewFeedbackList();
			entityList = CollectionMapper.getMappingList(li.iterator(), InterviewFeedbackDto.class);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return entityList;
	}

	@Override
	public UserInterviewStatusDto insertOrUpdateUserInterviewStatus(UserInterviewStatusDto studentDto) throws ServiceException {
		UserInterviewStatusDto finalDto=null;
		try {
			UserInterviewStatusEntity entity = DozerBeanMapperSingletonWrapper.getInstance().map(studentDto, UserInterviewStatusEntity.class);
			finalDto = DozerBeanMapperSingletonWrapper.getInstance().map(interviewFeedbackDao.insertOrUpadateStudentFeedBack(entity),UserInterviewStatusDto.class);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finalDto;
	}

	@Override
	public UserInterviewStatusDto getUserInterviewStatusDetailsByUserId(Long userId) throws ServiceException {
		// TODO Auto-generated method stub
		try{
			UserInterviewStatusEntity entity = interviewFeedbackDao.getInterviewFeedBackDetailsByUserId(userId);
			UserInterviewStatusDto finalDto=DozerBeanMapperSingletonWrapper.getInstance().map(entity, UserInterviewStatusDto.class);
			return finalDto;
			}catch(DBException e){
				throw new ServiceException(e.getMessage(),e);
			}
	}

	@Override
	public List<UserDto> getUserInterviewStatusDetailsListByGoodOrExcellent()throws ServiceException {
		List<UserEntity> li = new ArrayList();
		List<UserDto> entityList = null;
		try {
			List<UserInterviewStatusEntity> feedBackList = interviewFeedbackDao.getInterviewFeedBacksListByGoodOrExcellent();
			for(int i=0;i<feedBackList.size();i++){
				UserEntity user = userDao.getUserDetailsById(feedBackList.get(i).getUser().getId());
				li.add(user);
			}
			entityList = CollectionMapper.getMappingList(li.iterator(), UserDto.class);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return entityList;
	}


}
