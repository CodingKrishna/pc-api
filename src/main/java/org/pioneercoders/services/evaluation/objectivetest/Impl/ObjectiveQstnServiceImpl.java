package org.pioneercoders.services.evaluation.objectivetest.Impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.pioneercoders.dao.evaluation.objectivetest.ObjectiveQstnAnswersDao;
import org.pioneercoders.dao.evaluation.objectivetest.ObjectiveQstnDao;
import org.pioneercoders.dao.user.TechSkillDao;
import org.pioneercoders.dao.user.UserDao;
import org.pioneercoders.dto.evaluation.objectivetest.ExamDto;
import org.pioneercoders.dto.evaluation.objectivetest.ObjectiveQstnDto;
import org.pioneercoders.entity.evaluation.objectivetest.ObjectQstnEntity;
import org.pioneercoders.entity.evaluation.objectivetest.ObjectiveQstnAnswersEntity;
import org.pioneercoders.entity.student.TechSkillEntity;
import org.pioneercoders.exceptions.DBException;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.evaluation.objectivetest.ObjectiveQstnService;
import org.pioneercoders.utils.CollectionMapper;
import org.pioneercoders.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class ObjectiveQstnServiceImpl implements ObjectiveQstnService{

	@Autowired
	ObjectiveQstnDao objQstnDao;
	
	@Autowired
	ObjectiveQstnAnswersDao objQstnAnswerDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	TechSkillDao techDao;
	
	public ObjectiveQstnDto insertQuestions(ObjectiveQstnDto objectiveQstnDto)throws ServiceException {
		// TODO Auto-generated method stub
		try{
			String number = null;
			String data = null;
			ObjectiveQstnAnswersEntity answerEntity = new ObjectiveQstnAnswersEntity();
			answerEntity.setAnswer(objectiveQstnDto.getAns());
			String result = objQstnDao.getFinalQuestionId(objectiveQstnDto.getQuesGroup());
			if(objectiveQstnDto.getQuesGroup().equals("CSS")){
				number = result.substring(objectiveQstnDto.getQuesGroup().length(),result.length());
			}else if(objectiveQstnDto.getQuesGroup().equals("JAVA")){
				number = result.substring(objectiveQstnDto.getQuesGroup().length(),result.length());
			}else if(objectiveQstnDto.getQuesGroup().equals("HTML")){
				number = result.substring(objectiveQstnDto.getQuesGroup().length(),result.length());
			}
			int id  = Integer.valueOf(number);
			id++;
			objectiveQstnDto.setQuestionId(objectiveQstnDto.getQuesGroup()+id);
			if(objectiveQstnDto.getCode()!=null){
				objectiveQstnDto.setQuesType("code");
				if(objectiveQstnDto.getQuesGroup().equals("JAVA")){
					objectiveQstnDto.setQuestionDesc(objectiveQstnDto.getQuestionDesc()+"@CODE_START@@JAVA@"+objectiveQstnDto.getCode()+"@CODE_END@");
				}else if(objectiveQstnDto.getQuesGroup().equals("HTML")){
					objectiveQstnDto.setQuestionDesc(objectiveQstnDto.getQuestionDesc()+"@CODE_START@@HTML@"+objectiveQstnDto.getCode()+"@CODE_END@");
				}else if(objectiveQstnDto.getQuesGroup().equals("CSS")){
					objectiveQstnDto.setQuestionDesc(objectiveQstnDto.getQuestionDesc()+"@CODE_START@@CSS@"+objectiveQstnDto.getCode()+"@CODE_END@");
				}
				
			}else{
				objectiveQstnDto.setQuesType("choice");
			}
			ObjectQstnEntity questionsEntity= DozerBeanMapperSingletonWrapper.getInstance().map(objectiveQstnDto, ObjectQstnEntity.class);
			for(int i =0;i<objectiveQstnDto.getOptions().length;i++){
				if(i<1){
					questionsEntity.setOptions(objectiveQstnDto.getOptions()[i]);
				}else{
					questionsEntity.setOptions(questionsEntity.getOptions().concat("@@"+objectiveQstnDto.getOptions()[i]));
				}
			}
			questionsEntity.setAns("");
			ObjectiveQstnDto finalQueDto = DozerBeanMapperSingletonWrapper.getInstance().map(objQstnDao.insertQuestions(questionsEntity), ObjectiveQstnDto.class);
			answerEntity.setQuestionId(finalQueDto.getId());
			objQstnAnswerDao.insertAnswers(answerEntity);
			return finalQueDto;
			}catch(DBException e){
				throw new ServiceException(e.getMessage(),e);
			}
	}

	public List<ObjectiveQstnDto> getQuestionsByQesGroup(String questionGroup)
			throws ServiceException {
		// TODO Auto-generated method stub
		
		try{
			List<ObjectQstnEntity> entityList = objQstnDao.getQuestionsByGroup(questionGroup);
			List<ObjectiveQstnDto> dtoList = CollectionMapper.getMappingList(entityList.iterator(), ObjectiveQstnDto.class);
			return dtoList;
			}catch(DBException e){
				throw new ServiceException(e.getMessage(),e);
			}
	}

	public ExamDto getExamQuestionsForPerson(Long userId) throws ServiceException {
		try {
			// Fetching Questions from DB
			List<TechSkillEntity> techSkillsEntity = techDao.getTechSkillRecordsByUserId(userId);
			List<ObjectQstnEntity> finalQuestionsList=  new ArrayList();
			for(int i=0;i<techSkillsEntity.size();i++){
				List<ObjectQstnEntity> techBaseqestionList = objQstnDao.getQuestionsByGroup(techSkillsEntity.get(i).getTechnology().getName());
				Collections.shuffle(techBaseqestionList);
				techBaseqestionList = techBaseqestionList.subList(0, 5);
				finalQuestionsList.addAll(techBaseqestionList);
			}


			
			// Converting to dto Structure
			List<ObjectiveQstnDto> qestionDtoList = CollectionMapper.getMappingList(finalQuestionsList.iterator(), ObjectiveQstnDto.class);
			List<ObjectiveQstnDto> finalQuestionsDtoList = new ArrayList<ObjectiveQstnDto>();
			for(ObjectiveQstnDto que: qestionDtoList){
   				String finalString = que.getQuestionDesc();
   				finalString  = Constants.updateContent(finalString, false);
   				que.setQuestionDesc(finalString);
   				finalQuestionsDtoList.add(que);
			}
				
			
			//
			ExamDto examDto = new ExamDto();
			examDto.setQuestsList(finalQuestionsDtoList);
			
			return examDto;
		}catch(DBException e){
			throw new ServiceException(e.getMessage(),e);
		}
	}
}
