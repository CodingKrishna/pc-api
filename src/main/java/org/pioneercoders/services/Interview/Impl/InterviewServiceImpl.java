package org.pioneercoders.services.Interview.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.pioneercoders.dao.Interview.InterviewDao;
import org.pioneercoders.dao.evaluation.codingtest.CodingTestQstnDao;
import org.pioneercoders.dao.evaluation.objectivetest.ObjectiveQstnAnswersDao;
import org.pioneercoders.dao.evaluation.objectivetest.ObjectiveQstnDao;
import org.pioneercoders.dao.evaluation.objectivetest.ObjectiveQstnUserAnsDao;
import org.pioneercoders.dao.evaluation.tasktest.TaskDao;
import org.pioneercoders.dao.user.UserDao;
import org.pioneercoders.dto.Interview.InterviewAssignToUsersDto;
import org.pioneercoders.dto.Interview.InterviewGroupsCandidatesDto;
import org.pioneercoders.dto.Interview.InterviewGroupsDto;
import org.pioneercoders.dto.Interview.InterviewResultsDto;
import org.pioneercoders.dto.Interview.InterviewRoundQuesAssoDto;
import org.pioneercoders.dto.Interview.InterviewRoundsDto;
import org.pioneercoders.dto.Interview.InterviewShortlistedCandidatesDto;
import org.pioneercoders.dto.Interview.InterviewTechnologiesDto;
import org.pioneercoders.dto.Interview.InterviewTypesDto;
import org.pioneercoders.dto.Interview.InterviewsDto;
import org.pioneercoders.dto.Interview.JobInterviewDto;
import org.pioneercoders.dto.Interview.RoundsDto;
import org.pioneercoders.dto.Interview.SelectedGroupsForInterviewDto;
import org.pioneercoders.dto.Interview.TechnologiesInRoundDto;
import org.pioneercoders.dto.common.TechnologiesDto;
import org.pioneercoders.dto.evaluation.codingtest.CodingTestQstnDto;
import org.pioneercoders.dto.evaluation.objectivetest.ObjectiveQstnDto;
import org.pioneercoders.dto.evaluation.objectivetest.ObjectiveTestTotalResultDto;
import org.pioneercoders.dto.evaluation.taskstest.TaskDto;
import org.pioneercoders.dto.student.InstituteDto;
import org.pioneercoders.dto.student.UniversityDto;
import org.pioneercoders.dto.user.UserDto;
import org.pioneercoders.entity.Interview.InterviewAssignToUsersEntity;
import org.pioneercoders.entity.Interview.InterviewGroupsCandidatesEntity;
import org.pioneercoders.entity.Interview.InterviewGroupsEntity;
import org.pioneercoders.entity.Interview.InterviewResultsEntity;
import org.pioneercoders.entity.Interview.InterviewRoundQuesAssoEntity;
import org.pioneercoders.entity.Interview.InterviewRoundsEntity;
import org.pioneercoders.entity.Interview.InterviewShortlistedCandidatesEntity;
import org.pioneercoders.entity.Interview.InterviewTechnologiesEntity;
import org.pioneercoders.entity.Interview.InterviewTypesEntity;
import org.pioneercoders.entity.Interview.InterviewsEntity;
import org.pioneercoders.entity.Interview.JobInterviewEntity;
import org.pioneercoders.entity.Interview.RoundsEntity;
import org.pioneercoders.entity.Interview.SelectedGroupsForInterviewEntity;
import org.pioneercoders.entity.evaluation.codingtest.CodingTestQstnEntity;
import org.pioneercoders.entity.evaluation.objectivetest.ObjectQstnEntity;
import org.pioneercoders.entity.evaluation.objectivetest.ObjectiveQstnAnswersEntity;
import org.pioneercoders.entity.evaluation.objectivetest.ObjectiveQstnUserAnsEntity;
import org.pioneercoders.entity.evaluation.objectivetest.ObjectiveTestTotalResultEntity;
import org.pioneercoders.entity.evaluation.taskstest.TaskEntity;
import org.pioneercoders.entity.student.InstituteEntity;
import org.pioneercoders.entity.student.UniversityEntity;
import org.pioneercoders.entity.user.UserEntity;
import org.pioneercoders.exceptions.DBException;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.Interview.InterviewService;
import org.pioneercoders.utils.CollectionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class InterviewServiceImpl implements InterviewService{
	
	private static final Logger log = LoggerFactory.getLogger(InterviewServiceImpl.class);
	
	@Autowired
	InterviewDao testDao;
	
	@Autowired
	ObjectiveQstnDao objectiveQstnDao;
	
	@Autowired
	ObjectiveQstnAnswersDao objQstnAnswerDao;
	
	@Autowired
	ObjectiveQstnUserAnsDao objQstnUserAnsDao;
	
//	@Autowired
//	UserDao userDao;
	
	@Autowired
	TaskDao taskDao;
	
	@Autowired
	CodingTestQstnDao codingQstnDao;
	
	InterviewResultsEntity testresultstrn = new InterviewResultsEntity();
	
	@Override
	public InterviewsDto createTest(InterviewsDto testDto) throws ServiceException {
		try{
			InterviewsEntity testEntity = DozerBeanMapperSingletonWrapper.getInstance().map(testDto, InterviewsEntity.class);
			testEntity = testDao.createTest(testEntity);
			
			List<InterviewRoundsDto> testRounds = new ArrayList<InterviewRoundsDto>();
			for(RoundsDto roundsdto :  testDto.getTestRounds()){
				InterviewRoundsDto testrounddto = new InterviewRoundsDto();
				testrounddto.setTestRounds(roundsdto);
				testRounds.add(testrounddto);
			}
			
			//DozerBeanMapperSingletonWrapper.getInstance().map(testDao.createTest(testEntity), TestDto.class);
			List<InterviewRoundsEntity> listOfRounds = CollectionMapper.getMappingList(testRounds.iterator(), InterviewRoundsEntity.class);
			
			testDao.saveTestRounds(testEntity, listOfRounds);
			// store this listOfRounds 
			
			List<InterviewTechnologiesDto> testTechnlogies = new ArrayList<InterviewTechnologiesDto>();
			for(TechnologiesDto techdto :  testDto.getTestTechnologies()){
				InterviewTechnologiesDto  testTechnologiesDto = new InterviewTechnologiesDto();
				testTechnologiesDto.setTechnologies(techdto);
				testTechnlogies.add(testTechnologiesDto);
			}
			
			List<InterviewTechnologiesEntity> listOfTechnologies = CollectionMapper.getMappingList(testTechnlogies.iterator(), InterviewTechnologiesEntity.class);
			
			// store this listOfTechnologies
			testDao.saveTestTechnologies(testEntity,listOfTechnologies);
			testDto = DozerBeanMapperSingletonWrapper.getInstance().map(testEntity, InterviewsDto.class);
			testDto.setTestRoundsList(testRounds);
			testDto.setTestTechnologiesList(testTechnlogies);
		}
		catch(DBException e){
			throw new ServiceException(e.getMessage(),e);
		}
		return testDto;
	}

	@Override
	public List<InterviewsDto> getTestList(Long userId) throws ServiceException {
		List<InterviewsDto> dtolist = null;
		try{
			List<InterviewsEntity> entitylist = testDao.gettestlist(userId);
			dtolist = CollectionMapper.getMappingList(entitylist.iterator(), InterviewsDto.class);
			for(int i=0;i<dtolist.size();i++){
				Long testId = dtolist.get(i).getId();
				List<InterviewRoundsEntity> testRoundsEntityList= testDao.getRoundsByTestId(testId);
				List<InterviewRoundsDto> testRoundsdtolist = CollectionMapper.getMappingList(testRoundsEntityList.iterator(), InterviewRoundsDto.class);
				dtolist.get(i).setTestRoundsList(testRoundsdtolist);
				List<InterviewTechnologiesEntity> testTechnologiesEntityList = testDao.getTechnologiesByTestId(testId);
				List<InterviewTechnologiesDto> testTehnologiesDtoList = CollectionMapper.getMappingList(testTechnologiesEntityList.iterator(), InterviewTechnologiesDto.class);
				dtolist.get(i).setTestTechnologiesList(testTehnologiesDtoList);
			}
		}
		catch(DBException e){
			throw new ServiceException();
		}
		return dtolist;
	}

	@Override
	public List<RoundsDto> getRounds() throws ServiceException {
		List<RoundsDto> roundsDto = null;
		try{
			List<RoundsEntity> entitylist = testDao.getRounds();
			roundsDto = CollectionMapper.getMappingList(entitylist.iterator(), RoundsDto.class);
		}
		catch(DBException e){
			throw new ServiceException();
		}
		return roundsDto;
	}
	@Override
	public Long saveQuestions(InterviewRoundQuesAssoDto testRoundQuesAssoDto) throws ServiceException {
		try{
			Long count = testDao.saveQuestions(testRoundQuesAssoDto);
			return count;
		}
		catch(DBException e){
			throw new ServiceException(e.getMessage(),e);
		}
	}
	
	
	@Override
	public List<ObjectiveQstnDto> getQuestionsByTechAndRounds(TechnologiesInRoundDto technologiesInRoundDto) throws ServiceException {
		List<ObjectiveQstnDto> objectivequestionsdto = null;
		ArrayList<ObjectiveQstnDto> list = new ArrayList<ObjectiveQstnDto>();
		try{
			for(int i=0;i<technologiesInRoundDto.getTechnologies().size();i++){
				String techName = technologiesInRoundDto.getTechnologies().get(i).getName();
				List<ObjectQstnEntity> objectiveentity = objectiveQstnDao.getQuestionsByGroup(techName);
				objectivequestionsdto = CollectionMapper.getMappingList(objectiveentity.iterator(), ObjectiveQstnDto.class);
				list.addAll(objectivequestionsdto);
			}
		}
		catch(DBException e){
			throw new ServiceException(e.getMessage(),e);
		}
		return list;
	}
	
	@Override
	public List<ObjectiveQstnDto> getQuestionsForUsers(Long testId) throws ServiceException {
		List<ObjectQstnEntity> questionentitylist = new ArrayList<ObjectQstnEntity>();
		List<ObjectiveQstnDto> questionlistdto = new ArrayList<ObjectiveQstnDto>();
		try{
			List<InterviewRoundQuesAssoEntity> testQuestionsEntity = testDao.getQuestionsForUsers(testId);
			for(int i=0;i<testQuestionsEntity.size();i++){
				if(testQuestionsEntity.get(i).getObjectQuestions()!=null){
					Long QuestionId = testQuestionsEntity.get(i).getObjectQuestions().getId();
					ObjectQstnEntity question = objectiveQstnDao.getQuestionsById(QuestionId);
					questionentitylist.add(question);
				}
			}
				questionlistdto = CollectionMapper.getMappingList(questionentitylist.iterator(), ObjectiveQstnDto.class);
				for(int i=0;i<questionlistdto.size();i++){
					boolean isSelected = true;
					questionlistdto.get(i).setSelected(isSelected);
				}
		}
		catch(DBException e){
			throw new ServiceException();
		}
		return questionlistdto;
	}
	
	
	@Override
	public List<TaskDto> getTasksForUsers(Long testId) throws ServiceException {
		List<TaskEntity> tasksEntitylist = new ArrayList<TaskEntity>();
		List<TaskDto> tasksDtoList = new ArrayList<TaskDto>();
		try{
			List<InterviewRoundQuesAssoEntity> testQuestionsEntity = testDao.getQuestionsForUsers(testId);
			for(int i=0;i<testQuestionsEntity.size();i++){
				if(testQuestionsEntity.get(i).getTaskQuestions()!=null){
					TaskEntity question = taskDao.getTaskListById(testQuestionsEntity.get(i).getTaskQuestions().getId());
					tasksEntitylist.add(question);
				}
			}
			tasksDtoList = CollectionMapper.getMappingList(tasksEntitylist.iterator(), TaskDto.class);
		}
		catch(DBException e){
			throw new ServiceException();
		}
		return tasksDtoList;
	}

	@Override
	public List<CodingTestQstnDto> getCodingQstnsForUsers(Long testId)
			throws ServiceException {
		List<CodingTestQstnEntity> codingQstnsEntitylist = new ArrayList<CodingTestQstnEntity>();
		List<CodingTestQstnDto> codingQstnsDtoList = new ArrayList<CodingTestQstnDto>();
		try{
			List<InterviewRoundQuesAssoEntity> testQuestionsEntity = testDao.getQuestionsForUsers(testId);
			for(int i=0;i<testQuestionsEntity.size();i++){
				if(testQuestionsEntity.get(i).getCodingTestQuestions()!=null){
					CodingTestQstnEntity question = codingQstnDao.getCodingQstnById(testQuestionsEntity.get(i).getCodingTestQuestions().getId());
					codingQstnsEntitylist.add(question);
				}
			}
			codingQstnsDtoList = CollectionMapper.getMappingList(codingQstnsEntitylist.iterator(), CodingTestQstnDto.class);
		}
		catch(DBException e){
			throw new ServiceException();
		}
		return codingQstnsDtoList;
	}
	
	
	@Override
	public List<InterviewsDto> getAllTests(Long userId) throws ServiceException {
		List<InterviewsDto> dtolist = null;
		try{
			List<InterviewsEntity> entitylist = testDao.getAllTests(userId);
			dtolist = CollectionMapper.getMappingList(entitylist.iterator(), InterviewsDto.class);
			for(int i=0;i<dtolist.size();i++){
				Long testId = dtolist.get(i).getId();
				List<InterviewRoundsEntity> testRoundsEntityList= testDao.getRoundsByTestId(testId);
				List<InterviewRoundsDto> testRoundsdtolist = CollectionMapper.getMappingList(testRoundsEntityList.iterator(), InterviewRoundsDto.class);
				dtolist.get(i).setTestRoundsList(testRoundsdtolist);
				List<InterviewTechnologiesEntity> testTechnologiesEntityList = testDao.getTechnologiesByTestId(testId);
				List<InterviewTechnologiesDto> testTehnologiesDtoList = CollectionMapper.getMappingList(testTechnologiesEntityList.iterator(), InterviewTechnologiesDto.class);
				dtolist.get(i).setTestTechnologiesList(testTehnologiesDtoList);
			}
		}
		catch(DBException e){
			throw new ServiceException();
		}
		return dtolist;
	}
	
	@Override
	public List<ObjectiveTestTotalResultDto> getUserTestResults(Long testId) throws ServiceException {
		List<ObjectiveTestTotalResultDto> resultsDto = null;
		try{
			List<ObjectiveTestTotalResultEntity> entitylist = testDao.getUserTestResults(testId);
			resultsDto = CollectionMapper.getMappingList(entitylist.iterator(), ObjectiveTestTotalResultDto.class);
		}
		catch(DBException e){
			throw new ServiceException();
		}
		return resultsDto;
	}
	
	@Override
	public Long submitExam(InterviewResultsDto testresultsDto) throws ServiceException {
		UserEntity userEntity =null;
		Long count=0l;
		try{
		List<ObjectiveQstnAnswersEntity> answersList = objQstnAnswerDao.getAllAnswers();
		
		//userDao.setExamCompleted(testresultsDto.getUser().getId());
		
		List<ObjectiveQstnDto> questions = testresultsDto.getQuestsList();
		UserDto userdto = testresultsDto.getUser();
		userEntity = DozerBeanMapperSingletonWrapper.getInstance().map(userdto, UserEntity.class);
		InterviewsDto testDto = testresultsDto.getTest();
		InterviewsEntity testentity = DozerBeanMapperSingletonWrapper.getInstance().map(testDto, InterviewsEntity.class);
		RoundsDto rounddto = testresultsDto.getRounds();
		RoundsEntity roundentity = DozerBeanMapperSingletonWrapper.getInstance().map(rounddto, RoundsEntity.class);
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
		testresultstrn.setTotalMarks(count);
		testresultstrn.setUser(userEntity);
		testresultstrn.setTest(testentity);
		testresultstrn.setTotalQuestions(testresultsDto.getTotalQuestions());
		testresultstrn.setRounds(roundentity);
		testDao.submitExam(testresultstrn);
		}
		catch(DBException e){
			throw new ServiceException();
	}
		return count;
	}
	
	@Override
	public List<InterviewResultsDto> getTestResultsForUser(Long userId) throws ServiceException {
		List<InterviewResultsDto> resultsDto = null;
		try{
			List<InterviewResultsEntity> resultsEntityList = testDao.getTestResultsForUser(userId);
			resultsDto = CollectionMapper.getMappingList(resultsEntityList.iterator(), InterviewResultsDto.class);
		}
		catch(DBException e){
			throw new ServiceException();
		}
		return resultsDto;
	}
	
	@Override
	public List<InterviewResultsDto> getTestResultsForHr(Long testId) throws ServiceException {
		List<InterviewResultsDto> resultsDto = new ArrayList<InterviewResultsDto>(); 
		//InterviewResultsDto interviewDto = null;
		try{
			List<InterviewResultsEntity> resultsEntityList = testDao.getTestResultsForHr(testId);
			/*for(int i=0;i<resultsEntityList.size();i++){
				if(resultsEntityList.get(i).getTotalQuestions() != 0){
			interviewDto = DozerBeanMapperSingletonWrapper.getInstance().map(resultsEntityList.get(i), InterviewResultsDto.class);
			resultsDto.add(interviewDto);
				}
			}*/
			
			resultsDto = CollectionMapper.getMappingList(resultsEntityList.iterator(), InterviewResultsDto.class);
		}
		catch(DBException e){
			throw new ServiceException();
		}
		return resultsDto;
	}
	
	@Override
	public JobInterviewDto saveJobInterview(JobInterviewDto jobInterviewDto) throws ServiceException {
		try{
			JobInterviewEntity entity = DozerBeanMapperSingletonWrapper.getInstance().map(jobInterviewDto, JobInterviewEntity.class);
			jobInterviewDto = DozerBeanMapperSingletonWrapper.getInstance().map(testDao.saveJobInterview(entity), JobInterviewDto.class);
		}
		catch(DBException e){
			throw new ServiceException(e.getMessage(),e);
		}
		return jobInterviewDto;
	}
	
	@Override
	public InterviewShortlistedCandidatesDto saveInterviewShortlistedCandidates
								(InterviewShortlistedCandidatesDto interviewShortlistedCandidatesDto) throws ServiceException {
		try{
			InterviewShortlistedCandidatesEntity entity = DozerBeanMapperSingletonWrapper.getInstance().map(interviewShortlistedCandidatesDto, InterviewShortlistedCandidatesEntity.class);
			interviewShortlistedCandidatesDto = DozerBeanMapperSingletonWrapper.getInstance().map(testDao.saveInterviewShortlistedCandidates(entity), InterviewShortlistedCandidatesDto.class);
		}
		catch(DBException e){
			throw new ServiceException(e.getMessage(),e);
		}
		return interviewShortlistedCandidatesDto;
	}
	
	@Override
	public JobInterviewDto getJobInterviewByTestId(Long testId) throws ServiceException {
		JobInterviewDto jobInterviewDto = null;
		try{
			JobInterviewEntity entity = testDao.getJobInterviewByTestId(testId);
			jobInterviewDto = DozerBeanMapperSingletonWrapper.getInstance().map(entity, JobInterviewDto.class);
		}
		catch(DBException e){
			throw new ServiceException();
		}
		return jobInterviewDto;
	}
	
	@Override
	public InterviewGroupsDto saveInterviewGroups
								(InterviewGroupsDto interviewGroupsDto) throws ServiceException {
		try{
			InterviewGroupsEntity entity = DozerBeanMapperSingletonWrapper.getInstance().map(interviewGroupsDto, InterviewGroupsEntity.class);
			interviewGroupsDto = DozerBeanMapperSingletonWrapper.getInstance().map(testDao.saveInterviewGroups(entity), InterviewGroupsDto.class);
		}
		catch(DBException e){
			throw new ServiceException(e.getMessage(),e);
		}
		return interviewGroupsDto;
	}
	
	@Override
	public List<InterviewGroupsCandidatesDto> saveInterviewGroupsCandidates
								(List<InterviewGroupsCandidatesDto> dtolist) throws ServiceException {
		try{
			testDao.saveInterviewGroupsCandidates(dtolist);
		}
		catch(DBException e){
			throw new ServiceException(e.getMessage(),e);
		}
		return dtolist;
	}
	
	@Override
	public List<InterviewGroupsDto> getAllInterviewGroups(Long userId) throws ServiceException {
		List<InterviewGroupsDto>  interviewgroupdtolist = null;
		try{
			List<InterviewGroupsEntity> entitylist = testDao.getAllInterviewGroups(userId);
			interviewgroupdtolist = CollectionMapper.getMappingList(entitylist.iterator(), InterviewGroupsDto.class);
		}
		catch(DBException e){
			throw new ServiceException();
		}
		return interviewgroupdtolist;
	}
	
	@Override
	public List<InterviewGroupsCandidatesDto> getInterviewCandidatesByGroupId(Long groupId) throws ServiceException {
		List<InterviewGroupsCandidatesDto>  interviewgroupcandidatesdtolist = null;
		try{
			List<InterviewGroupsCandidatesEntity> entitylist = testDao.getInterviewCandidatesByGroupId(groupId);
			interviewgroupcandidatesdtolist = CollectionMapper.getMappingList(entitylist.iterator(), InterviewGroupsCandidatesDto.class);
		}
		catch(DBException e){
			throw new ServiceException();
		}
		return interviewgroupcandidatesdtolist;
	}
	
	@Override
	public int restrictUsersOnlineTest(Long testId,Long userId,Long roundId) throws ServiceException {
		int result = 0;
		try{
			result = testDao.restrictUsersOnlineTest(testId, userId, roundId);
		}
		catch(DBException e){
			throw new ServiceException();
		}
		return result;
	}
	
	@Override
	public int restrictUsersOnlineTestByDates(Date fromDate,Date toDate,Long testId) throws ServiceException {
		int result = 0;
		try{
			result = testDao.restrictUsersOnlineTestByDates(fromDate, toDate, testId);
		}
		catch(DBException e){
			throw new ServiceException();
		}
		return result;
	}
	
	@Override
	public List<InterviewTypesDto> getInterviewTypesList() throws ServiceException {
		List<InterviewTypesDto>  interviewgroupdtolist = null;
		try{
			List<InterviewTypesEntity> entitylist = testDao.getInterviewTypesList();
			interviewgroupdtolist = CollectionMapper.getMappingList(entitylist.iterator(), InterviewTypesDto.class);
		}
		catch(DBException e){
			throw new ServiceException();
		}
		return interviewgroupdtolist;
	}
	
	@Override
	public List<InterviewsDto> getPrivateTestList(Long userId) throws ServiceException {
		List<InterviewsDto> dtolist = null;
		try{
			List<InterviewsEntity> entitylist = testDao.getprivatetestlist(userId);
			dtolist = CollectionMapper.getMappingList(entitylist.iterator(), InterviewsDto.class);
			for(int i=0;i<dtolist.size();i++){
				Long testId = dtolist.get(i).getId();
				List<InterviewRoundsEntity> testRoundsEntityList= testDao.getRoundsByTestId(testId);
				List<InterviewRoundsDto> testRoundsdtolist = CollectionMapper.getMappingList(testRoundsEntityList.iterator(), InterviewRoundsDto.class);
				dtolist.get(i).setTestRoundsList(testRoundsdtolist);
				List<InterviewTechnologiesEntity> testTechnologiesEntityList = testDao.getTechnologiesByTestId(testId);
				List<InterviewTechnologiesDto> testTehnologiesDtoList = CollectionMapper.getMappingList(testTechnologiesEntityList.iterator(), InterviewTechnologiesDto.class);
				dtolist.get(i).setTestTechnologiesList(testTehnologiesDtoList);
			}
		}
		catch(DBException e){
			throw new ServiceException();
		}
		return dtolist;
	}
	
	public void saveSelectedGroupsForInterview(SelectedGroupsForInterviewDto selectedGroupsForInterviewDto) throws ServiceException {
		//List<SelectedGroupsForInterviewDto>  selectedInterviewGroupList = null;
		try{
			testDao.saveSelectedGroupsForInterview(selectedGroupsForInterviewDto);
		}
		catch(DBException e){
			throw new ServiceException();
		}
		return;
	}
	
	@Override
	public List<SelectedGroupsForInterviewDto> getSelectedGroupsForInterviewByTestId(Long interviewId) throws ServiceException {
		List<SelectedGroupsForInterviewDto>  dtolist = new ArrayList<SelectedGroupsForInterviewDto>();;
	
		try{
			List<SelectedGroupsForInterviewEntity> entitylist = testDao.getSelectedGroupsForInterviewByTestId(interviewId);
			for(int i=0;i<entitylist.size();i++){
				SelectedGroupsForInterviewDto  dto = new SelectedGroupsForInterviewDto();
				SelectedGroupsForInterviewEntity entity = entitylist.get(i);
				dto.setId(entity.getId());
				InterviewsDto interviewsDto = DozerBeanMapperSingletonWrapper.getInstance().map(entity.getInterview(), InterviewsDto.class);
				dto.setInterview(interviewsDto);
				InterviewGroupsDto interviewgroup = DozerBeanMapperSingletonWrapper.getInstance().map(entity.getInterviewGroups(), InterviewGroupsDto.class);
				dto.setSingleInterviewGroup(interviewgroup);
				dtolist.add(dto);
			}
			for(int i=0;i<dtolist.size();i++){
				boolean isSelected = true;
				dtolist.get(i).setSelected(isSelected);
			}
		}
		catch(DBException e){
			throw new ServiceException();
		}
		return dtolist;
	}
	
	
	@Override
	public List<InterviewAssignToUsersDto> getInterviewAssignToUsersByUserId(Long userId) throws ServiceException {
		List<InterviewAssignToUsersDto>  dtolist = null;
		try{
			List<InterviewAssignToUsersEntity> entitylist = testDao.getInterviewAssignToUsersByUserId(userId);
			dtolist = CollectionMapper.getMappingList(entitylist.iterator(), InterviewAssignToUsersDto.class);
			for(int i=0;i<dtolist.size();i++){
				Long testId = dtolist.get(i).getTest().getId();
				List<InterviewRoundsEntity> testRoundsEntityList= testDao.getRoundsByTestId(testId);
				List<InterviewRoundsDto> testRoundsdtolist = CollectionMapper.getMappingList(testRoundsEntityList.iterator(), InterviewRoundsDto.class);
				dtolist.get(i).getTest().setTestRoundsList(testRoundsdtolist);
				List<InterviewTechnologiesEntity> testTechnologiesEntityList = testDao.getTechnologiesByTestId(testId);
				List<InterviewTechnologiesDto> testTehnologiesDtoList = CollectionMapper.getMappingList(testTechnologiesEntityList.iterator(), InterviewTechnologiesDto.class);
				dtolist.get(i).getTest().setTestTechnologiesList(testTehnologiesDtoList);
			}
		}
		catch(DBException e){
			throw new ServiceException();
		}
		return dtolist;
	}

	@Override
	public InstituteDto savePoCollegeDetails(InstituteDto pocollegedto) throws ServiceException {
		InstituteDto pocollegeDto = null;
		try{
			InstituteEntity poentity = DozerBeanMapperSingletonWrapper.getInstance().map(pocollegedto, InstituteEntity.class);
			poentity = testDao.savePoCollegeDetails(poentity);
			pocollegeDto = DozerBeanMapperSingletonWrapper.getInstance().map(poentity, InstituteDto.class);
			if(pocollegeDto.getUniversity().getId() != null){
				Long uniId = pocollegeDto.getUniversity().getId();
				UniversityEntity universityentity = null;//userDao.getuniversitydetailsbyid(uniId);
				UniversityDto universityDto = DozerBeanMapperSingletonWrapper.getInstance().map(universityentity, UniversityDto.class);
				pocollegeDto.setUniversity(universityDto);
			}
		}
		catch(DBException e){
			throw new ServiceException();
		}
		return pocollegeDto;
	}
	
	public InstituteDto getPoCollegedetailsById(Long poId) throws ServiceException {
		InstituteDto pocollegeDto = null;
		String collegeName = null;
		try{
			InstituteEntity poentity = testDao.getPoCollegeDetailsById(poId,collegeName);
			if(poentity != null){
				
				pocollegeDto = DozerBeanMapperSingletonWrapper.getInstance().map(poentity, InstituteDto.class);
			}
			if(pocollegeDto.getUniversity().getId() != null){
				Long uniId = pocollegeDto.getUniversity().getId();
				UniversityEntity universityentity = null;//userDao.getuniversitydetailsbyid(uniId);
				UniversityDto universityDto = DozerBeanMapperSingletonWrapper.getInstance().map(universityentity, UniversityDto.class);
				pocollegeDto.setUniversity(universityDto);
			}
		}
		catch(DBException e){
			throw new ServiceException();
		}
		return pocollegeDto;
	}

	
	

}
