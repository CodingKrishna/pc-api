package org.pioneercoders.services.tutorials.impl;

import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.pioneercoders.dao.tutorials.QuizDao;
import org.pioneercoders.dto.tutorials.QuizDto;
import org.pioneercoders.entity.tutorials.QuizEntity;
import org.pioneercoders.exceptions.DBException;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.tutorials.QuizService;
import org.pioneercoders.utils.CollectionMapper;
import org.pioneercoders.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional(propagation=Propagation.REQUIRED)
public class QuizServiceImpl implements QuizService {

private static final Logger log = LoggerFactory.getLogger(QuizServiceImpl.class);
	
	@Autowired
	QuizDao quizDao;
	
	@Override
	public QuizDto createQuiz(QuizDto quizDto) throws ServiceException {
		QuizDto finalDto=null;
		try {
			quizDto.setStatus(Constants.STATUS_ACTIVE);
			quizDto.setCreatedOn(Constants.CREATED_ON());
			QuizEntity entity = DozerBeanMapperSingletonWrapper.getInstance().map(quizDto, QuizEntity.class);
			finalDto = DozerBeanMapperSingletonWrapper.getInstance().map(quizDao.createQuiz(entity),QuizDto.class);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finalDto;
	}

	@Override
	public List<QuizDto> getQuizListByUserId(Long userId) throws ServiceException {
		try {
			List<QuizEntity> list = quizDao.getQuizDetailsByUserId(userId);
			List<QuizDto> userList = CollectionMapper.getMappingList(list.iterator(), QuizDto.class);

			log.info("Returning quizList -->: ");
			return userList;
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing quizList data ");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
	}


}

