package org.pioneercoders.services.evaluation.objectivetest.Impl;

import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.pioneercoders.dao.evaluation.objectivetest.ObjectiveQstnAnswersDao;
import org.pioneercoders.dao.evaluation.objectivetest.ObjectiveQstnUserAnsDao;
import org.pioneercoders.dao.evaluation.objectivetest.ObjectiveTestTotalResultDao;
import org.pioneercoders.dao.user.UserDao;
import org.pioneercoders.dto.evaluation.objectivetest.ExamDto;
import org.pioneercoders.dto.evaluation.objectivetest.ExamResTransDto;
import org.pioneercoders.dto.evaluation.objectivetest.ObjectiveQstnDto;
import org.pioneercoders.dto.evaluation.objectivetest.ObjectiveQstnUserAnsDto;
import org.pioneercoders.dto.evaluation.objectivetest.ObjectiveTestTotalResultDto;
import org.pioneercoders.dto.user.UserDto;
import org.pioneercoders.entity.evaluation.objectivetest.ObjectQstnEntity;
import org.pioneercoders.entity.evaluation.objectivetest.ObjectiveQstnAnswersEntity;
import org.pioneercoders.entity.evaluation.objectivetest.ObjectiveQstnUserAnsEntity;
import org.pioneercoders.entity.evaluation.objectivetest.ObjectiveTestTotalResultEntity;
import org.pioneercoders.entity.user.UserEntity;
import org.pioneercoders.exceptions.DBException;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.evaluation.objectivetest.ExamService;
import org.pioneercoders.utils.CollectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional(propagation=Propagation.REQUIRED)
public class ExamServiceImpl implements ExamService{

	
	@Autowired
	ObjectiveQstnUserAnsDao objQstnUserAnsDao;
	
	@Autowired
	ObjectiveTestTotalResultDao objQstTestTotalResultsDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ObjectiveQstnAnswersDao objQstnAnswerDao;
	
	
	ObjectiveTestTotalResultEntity examTrn = new ObjectiveTestTotalResultEntity();
	
	public Long insertExam(ExamDto examDto) throws ServiceException {
		UserDto userDto=examDto.getUser();
		Long result=0l;
		examTrn.setTotalQuestions(examDto.getTotalQuestions());
		UserEntity userEntity = DozerBeanMapperSingletonWrapper.getInstance().map(userDto ,UserEntity.class);
		try {
			result = saveExamQuestions(examDto.getQuestsList(), userEntity);
			
			userDao.setExamCompleted(userDto.getId());
			
			
		} catch (DBException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Long saveExamQuestions(List<ObjectiveQstnDto> questions, UserEntity userEntity) throws DBException {
		List<ObjectiveQstnAnswersEntity> answersList = objQstnAnswerDao.getAllAnswers();
		Long count=0l;

		for(ObjectiveQstnDto questionDto : questions) {
			ObjectiveQstnUserAnsEntity examReEntity = new ObjectiveQstnUserAnsEntity();
			ObjectQstnEntity questionsEntity = DozerBeanMapperSingletonWrapper.getInstance().map(questionDto, ObjectQstnEntity.class);
			examReEntity.setAnswer(questionDto.getAns());
			examReEntity.setIsAnswered(questionDto.getAns() == null || questionDto.getAns().equals("") ? false : true);
			examReEntity.setQuesId(questionsEntity);
			examReEntity.setUser(userEntity);
			examReEntity = objQstnUserAnsDao.insertObjQstnUserAnsRecord(examReEntity);
			for(int i=0;i<answersList.size();i++){
				if(answersList.get(i).getQuestionId()==examReEntity.getQuesId().getId()){
					if(answersList.get(i).getAnswer().equals(examReEntity.getAnswer())){
						count++;
					}
				}
			}
		}
		objQstnUserAnsDao.flushSession();
		examTrn.setTotalMarks(count);
		examTrn.setUser(userEntity);
		objQstTestTotalResultsDao.insertObjTestTotalResult(examTrn);
		return count;
	}

	@Override
	public ExamResTransDto getExamTransInfo(Long personlInfoId) throws ServiceException {
		ExamResTransDto response = null;

		try {	
			response = new ExamResTransDto();
			List<ObjectiveQstnUserAnsEntity> examEntities = objQstnUserAnsDao.getObjQstnUserAnsRecordByPersonalInfoId(personlInfoId);
			List<ObjectiveQstnUserAnsDto> examReDtos = CollectionMapper.getMappingList(examEntities.iterator(), ObjectiveQstnUserAnsDto.class);
			
			response.setExamList(examReDtos);
			
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		return response;
	}

	@Override
	public List<ObjectiveTestTotalResultDto> getAllExamResults() throws ServiceException {
		List<ObjectiveTestTotalResultDto> examTrnDtos = null;
		try {	
			List<ObjectiveTestTotalResultEntity> examTrnEntities = objQstTestTotalResultsDao.getAllObjTestData();
			examTrnDtos = CollectionMapper.getMappingList(examTrnEntities.iterator(), ObjectiveTestTotalResultDto.class);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		return examTrnDtos;
	}

	@Override
	public List<ObjectiveTestTotalResultDto> getAllExamResultsByProfileId(Long id) throws ServiceException {
		List<ObjectiveTestTotalResultDto> examTrnDtos = null;
		try {	
			List<ObjectiveTestTotalResultEntity> examTrnEntities = objQstTestTotalResultsDao.getAllObjTestInfoByProfileId(id);
			examTrnDtos = CollectionMapper.getMappingList(examTrnEntities.iterator(), ObjectiveTestTotalResultDto.class);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		return examTrnDtos;
	}

	/*@Override
	public List<TechologiesDto> getAllTechnologies() throws ServiceException {
		List<TechologiesDto> finalTechnologyList = null;
		try {	
			List<TechnologiesEntity> technologyList = technologyDao.getAllTechnologies();
			finalTechnologyList = CollectionMapper.getMappingList(technologyList.iterator(), TechologiesDto.class);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		return finalTechnologyList;
	}

	@Override
	public List<TechnologyTrnDto> getTechnlogiesListByUserId(Long userId) throws ServiceException {
		List<TechnologyTrnDto> technologyTrnDtos = null;
		try {	
			List<TechnologyTrnEntity> technologyTrnEntities = technologyDao.getTechnologiesListByUserId(userId);
			technologyTrnDtos = CollectionMapper.getMappingList(technologyTrnEntities.iterator(), TechnologyTrnDto.class);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		return technologyTrnDtos;
	}

	@Override
	public int assingTechnologiesToUsers(Long userId,List<String> technologiesList) throws ServiceException {
		try {
			
			for(int i=0;i<technologiesList.size();i++) {
				TechnologyTrnEntity entity = new TechnologyTrnEntity();
				
				TechnologiesEntity technology = new TechnologiesEntity();
				technology.setId(Long.parseLong(technologiesList.get(i)));
				entity.setTechnology(technology);
				
				UserEntity user = new UserEntity();
				user.setId(userId);
				entity.setUser(user);
				technologyDao.createTechnologyTrnRecord(entity);
			}
			
	    } catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}*/
	
}
	/*public List<ExamResTransDto> getAllExamReData() throws ServiceException {
		try {
			List<ExamReEntity> examsResultsEntityList = examReDao.getAllReData();
			List<ExamReDto> examsResultsDtoList = CollectionMapper.getMappingList(examsResultsEntityList.iterator(), ExamReDto.class);
			//List<ExamResTransDto> response = new ArrayList<ExamResTransDto>();
			
			List<ExamResTransDto> list = new ArrayList<ExamResTransDto>();
			for(int i=0;i<dtoList.size();i++){
				if(!list.contains(dtoList.get(i).getPersonalDto())){
					list.set(i,dtoList.get(i));
				}
			}
			return transformExamResultsList(examsResultsDtoList, actualAnswersList);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
	
	private List<ExamResTransDto> transformExamResultsList(List<ExamReDto> examsResultsDtoList, List<AnswersEntity> actualAnswersList) {

		List<ExamResTransDto> transformedList = new ArrayList<ExamResTransDto>();
		List<PersonalDto> personalDtosList = new ArrayList<PersonalDto>();
		for(int i=0;i<examsResultsDtoList.size();i++) {
			if(!personalDtosList.contains(examsResultsDtoList.get(i).getPersonalDto())) {
				personalDtosList.set(i, examsResultsDtoList.get(i).getPersonalDto());
			}
		}
		return transformedList;
	}*/
