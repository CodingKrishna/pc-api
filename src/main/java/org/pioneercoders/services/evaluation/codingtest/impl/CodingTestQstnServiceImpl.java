package org.pioneercoders.services.evaluation.codingtest.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.pioneercoders.dao.evaluation.codingtest.CodingTestQstnDao;
import org.pioneercoders.dao.evaluation.codingtest.CodingTestQstnsTrnDao;
import org.pioneercoders.dto.evaluation.codingtest.CodingTestQstnDto;
import org.pioneercoders.dto.evaluation.codingtest.CodingTestQstnsAssignToUserTrnDto;
import org.pioneercoders.dto.evaluation.codingtest.CodingTestResultDto;
import org.pioneercoders.dto.user.UserDto;
import org.pioneercoders.entity.evaluation.codingtest.CodingTestQstnEntity;
import org.pioneercoders.entity.evaluation.codingtest.CodingTestQstnsAssignToUserTrnEntity;
import org.pioneercoders.entity.evaluation.codingtest.CodingTestResultEntity;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.evaluation.codingtest.CodingTestQstnService;
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
public class CodingTestQstnServiceImpl implements CodingTestQstnService{
	
	Logger log = LoggerFactory.getLogger(CodingTestQstnServiceImpl.class);
	
	@Autowired
	CodingTestQstnDao codingTestQstnDao;
	
	@Autowired
	CodingTestQstnsTrnDao codingTestQstnsTrnDao;
	
	@Override
	public List<CodingTestQstnDto> getAllQuestions() throws ServiceException {
		List<CodingTestQstnDto> qstnsList =null;
		try {
			List<CodingTestQstnEntity> entityList = codingTestQstnDao.getAllQuestions();
			qstnsList = CollectionMapper.getMappingList(entityList.iterator(), CodingTestQstnDto.class);
			return qstnsList;
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getAllQuestions Method");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public CodingTestQstnDto saveQuestion(CodingTestQstnDto codingTestQstnDto) throws ServiceException {
		CodingTestQstnDto finalDto = null;
		try {
			CodingTestQstnEntity entity = DozerBeanMapperSingletonWrapper.getInstance().map(codingTestQstnDto, CodingTestQstnEntity.class);
			 finalDto = DozerBeanMapperSingletonWrapper.getInstance().map(codingTestQstnDao.saveQuestion(entity), CodingTestQstnDto.class);
			
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing saveQuestion Method");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
		return finalDto;
	}

	@Override
	public List<CodingTestQstnsAssignToUserTrnDto> getAllQuestionsByUserId(Long userId) throws ServiceException {
		List<CodingTestQstnsAssignToUserTrnDto> qstnsList =null;
		try {
			List<CodingTestQstnsAssignToUserTrnEntity> entityList =codingTestQstnsTrnDao.getAllQuestionsByUserId(userId);
			qstnsList = CollectionMapper.getMappingList(entityList.iterator(), CodingTestQstnsAssignToUserTrnDto.class);
			List<CodingTestQstnsAssignToUserTrnDto> finalQuestionsDtoList = new ArrayList();
			for(CodingTestQstnsAssignToUserTrnDto que: qstnsList){
				CodingTestQstnDto queObje = que.getQuestion();
   				String finalString = que.getQuestion().getSampleCode();
   				if(finalString!=null){
   						finalString = Constants.updateContent(finalString, true);
   						queObje.setSampleCode(finalString);
						que.setQuestion(queObje);
   				}
			
			finalQuestionsDtoList.add(que);
		}
			return qstnsList;
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getAllQuestionsByUserId Method having"+userId);
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public int assingQuestionsToUser(Long userId, List<String> questIdsList) throws ServiceException {

		try {
			
			for(int i=0;i<questIdsList.size();i++){
				
				CodingTestQstnsAssignToUserTrnDto questionTrnDto = new CodingTestQstnsAssignToUserTrnDto();
				CodingTestQstnDto quesitonDto = new CodingTestQstnDto();
				quesitonDto.setId(Long.parseLong(questIdsList.get(i)));
				questionTrnDto.setQuestion(quesitonDto);
				
				UserDto user = new UserDto();
				user.setId(userId);
				questionTrnDto.setUser(user);
				
				CodingTestQstnsAssignToUserTrnEntity entity = DozerBeanMapperSingletonWrapper.getInstance().map(questionTrnDto, CodingTestQstnsAssignToUserTrnEntity.class);
				codingTestQstnsTrnDao.addQuestions(entity);
			}
			return 1;
		
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing saveQuestion Method");
					log.error(e.getMessage());
				}
				throw new ServiceException(e.getMessage(), e);
		}
	
	}

	@Override
	public CodingTestResultDto saveCodingTestResult(CodingTestResultDto codingTestResultDto) throws ServiceException {
		CodingTestResultDto finalDto = null;
		try {
			CodingTestResultEntity entity = DozerBeanMapperSingletonWrapper.getInstance().map(codingTestResultDto, CodingTestResultEntity.class);
			 finalDto = DozerBeanMapperSingletonWrapper.getInstance().map(codingTestQstnDao.saveCodingTestResult(entity), CodingTestResultDto.class);
			
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing saveCodingTestResult Method");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
		return finalDto;
	}
}
