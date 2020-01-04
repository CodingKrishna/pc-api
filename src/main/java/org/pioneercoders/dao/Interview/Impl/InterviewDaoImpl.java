package org.pioneercoders.dao.Interview.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.dao.Interview.InterviewDao;
import org.pioneercoders.dao.user.UserDao;
import org.pioneercoders.dto.Interview.InterviewGroupsCandidatesDto;
import org.pioneercoders.dto.Interview.InterviewGroupsDto;
import org.pioneercoders.dto.Interview.InterviewRoundQuesAssoDto;
import org.pioneercoders.dto.Interview.InterviewsDto;
import org.pioneercoders.dto.Interview.RoundsDto;
import org.pioneercoders.dto.Interview.SelectedGroupsForInterviewDto;
import org.pioneercoders.dto.evaluation.codingtest.CodingTestQstnDto;
import org.pioneercoders.dto.evaluation.objectivetest.ObjectiveQstnDto;
import org.pioneercoders.dto.evaluation.taskstest.TaskDto;
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
import org.pioneercoders.entity.evaluation.objectivetest.ObjectiveTestTotalResultEntity;
import org.pioneercoders.entity.evaluation.taskstest.TaskEntity;
import org.pioneercoders.entity.student.InstituteEntity;
import org.pioneercoders.entity.user.UserEntity;
import org.pioneercoders.exceptions.DBException;
import org.pioneercoders.utils.DateParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InterviewDaoImpl implements InterviewDao{
	
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	UserDao userdao;
	
	private static final Logger log = LoggerFactory.getLogger(InterviewDaoImpl.class);
	
	public InterviewsEntity createTest(InterviewsEntity testEntity) throws DBException{
		try{
			Session session = sessionFactory.getCurrentSession();
			session.save(testEntity);
			session.flush();
		}
		catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occured while creating creatingTest ["+ testEntity.getId()+"] ["+ testEntity.getUser().getUserName()+"]");
			}
		}
		return testEntity;
	}
	
	@SuppressWarnings("unchecked")
	public List<InterviewsEntity> gettestlist(Long userId) throws DBException{
		Query query = null;
		List<InterviewsEntity> list = null;
		try{
			Integer interviewTypeId = 1;
			Long x = interviewTypeId.longValue();
			Session session = sessionFactory.getCurrentSession();
			query = session.createQuery("from InterviewsEntity where user.id =" +userId+" and interviewType.id = "+x+" ORDER BY id ASC");	
			list = query.list();
			if(list.size() == 0){
				query = session.createQuery("from InterviewsEntity where user.id =" +userId);	
				list = query.list();
			}
		}
		catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occured while getting TestList by userId");
			}
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<InterviewsEntity> getAllTests(Long userId) throws DBException{
		Query query = null;
		UserEntity userentity = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			
			userentity = userdao.getUserDetailsById(userId);
			Long roleId = userentity.getRole().getId();
			if(roleId == 6){
				query = session.createQuery("from InterviewsEntity where interviewType.id = 1");
			}
			else if(roleId == 2){
				query = session.createQuery("from InterviewsEntity where interviewType.id = 3");
			}
				
		}
		catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occured while getting alltests");
			}
		}
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<RoundsEntity> getRounds() throws DBException{
		Query query = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			query = session.createQuery("from RoundsEntity");	
			return query.list();
		}
		catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occured while getting roundslist");
			}
			throw new DBException(e.getMessage(),e);
		}
	}
	
	public  List<InterviewRoundsEntity> saveTestRounds(InterviewsEntity testEntity,  List<InterviewRoundsEntity> listOfTestRounds) throws DBException{
		try{
			Session session = sessionFactory.getCurrentSession();
			for(InterviewRoundsEntity testRoundsEntity : listOfTestRounds){
				testRoundsEntity.setTest(testEntity);
				session.save(testRoundsEntity);
			}
			session.flush();
		}
		catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occured while creating creatingTest ");
			}
		}
		return listOfTestRounds;
	}
	
	public List<InterviewTechnologiesEntity> saveTestTechnologies(InterviewsEntity testEntity , List<InterviewTechnologiesEntity> listOftestTechnologies) throws DBException{
		try{
			Session session = sessionFactory.getCurrentSession();
			for(InterviewTechnologiesEntity testTech : listOftestTechnologies){
				testTech.setTest(testEntity);
				session.save(testTech);
			}
			session.flush();
		}
		catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occured while creating creatingTest ");
			}
		}
		return listOftestTechnologies;
	}
	
	@SuppressWarnings("unchecked")
	public List<InterviewRoundsEntity> getRoundsByTestId(Long TestId) throws DBException{
		Query query = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			query = session.createQuery("from InterviewRoundsEntity where test.id =" + TestId);	
			return query.list();
		}
		catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occured while getting TechnologiesByTestId");
			}
			throw new DBException(e.getMessage(),e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<InterviewTechnologiesEntity> getTechnologiesByTestId(Long TestId) throws DBException{
		Query query = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			query = session.createQuery("from InterviewTechnologiesEntity where test.id =" + TestId);	
			return query.list();
		}
		catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occured while getting TechnologiesByTestId");
			}
			throw new DBException(e.getMessage(),e);
		}
	}
	
	public Long saveQuestions(InterviewRoundQuesAssoDto testRoundQuesAssoDto) throws DBException{
		int count = 0;
		Long value = 0L;
		try{
			Session session = sessionFactory.getCurrentSession();
			InterviewsDto testdto = testRoundQuesAssoDto.getTest();
			InterviewsEntity testentity = DozerBeanMapperSingletonWrapper.getInstance().map(testdto, InterviewsEntity.class);
			RoundsDto roundsdto = testRoundQuesAssoDto.getRounds();
			RoundsEntity roundsEntity = DozerBeanMapperSingletonWrapper.getInstance().map(roundsdto, RoundsEntity.class);
			if(testRoundQuesAssoDto.getObjectQuestions()!=null){
				for(int i=0;i<testRoundQuesAssoDto.getObjectQuestions().size();i++){
					ObjectiveQstnDto objectquestions= testRoundQuesAssoDto.getObjectQuestions().get(i);
					ObjectQstnEntity objentity = DozerBeanMapperSingletonWrapper.getInstance().map(objectquestions, ObjectQstnEntity.class);
					InterviewRoundQuesAssoEntity testRoundQuesAssoEntity = new InterviewRoundQuesAssoEntity();
					testRoundQuesAssoEntity.setObjectQuestions(objentity);
					testRoundQuesAssoEntity.setRounds(roundsEntity);
					testRoundQuesAssoEntity.setTest(testentity);
					session.save(testRoundQuesAssoEntity);
				}
				
			}if(testRoundQuesAssoDto.getTaskQuestions()!=null){
				for(int j=0;j<testRoundQuesAssoDto.getTaskQuestions().size();j++){
					TaskDto taskQuestions= testRoundQuesAssoDto.getTaskQuestions().get(j);
					TaskEntity taskEntity = DozerBeanMapperSingletonWrapper.getInstance().map(taskQuestions, TaskEntity.class);
					InterviewRoundQuesAssoEntity testRoundQuesAssoEntity = new InterviewRoundQuesAssoEntity();
					testRoundQuesAssoEntity.setTaskQuestions(taskEntity);
					testRoundQuesAssoEntity.setRounds(roundsEntity);
					testRoundQuesAssoEntity.setTest(testentity);
					session.save(testRoundQuesAssoEntity);
				}
			}if(testRoundQuesAssoDto.getCodingTestQuestions()!=null){
				for(int k=0;k<testRoundQuesAssoDto.getCodingTestQuestions().size();k++){
					CodingTestQstnDto codingTestQuestion= testRoundQuesAssoDto.getCodingTestQuestions().get(k);
					CodingTestQstnEntity codingTestQstEntity = DozerBeanMapperSingletonWrapper.getInstance().map(codingTestQuestion, CodingTestQstnEntity.class);
					InterviewRoundQuesAssoEntity testRoundQuesAssoEntity = new InterviewRoundQuesAssoEntity();
					testRoundQuesAssoEntity.setCodingTestQuestions(codingTestQstEntity);
					testRoundQuesAssoEntity.setRounds(roundsEntity);
					testRoundQuesAssoEntity.setTest(testentity);
					session.save(testRoundQuesAssoEntity);
				}
			}
			session.flush();
			count = 1;
			value = Long.valueOf(count);
		}
		catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occured while creating creatingquestions");
			}
		}
		return value;
	}
	
	@SuppressWarnings("unchecked")
	public List<InterviewRoundQuesAssoEntity> getQuestionsForUsers(Long testId) throws DBException{
		Query query = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			query = session.createQuery("from InterviewRoundQuesAssoEntity where test.id =" + testId);	
			return query.list();
		}
		catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occured while getting TestRoundQuesAssoEntity");
			}
			throw new DBException(e.getMessage(),e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<ObjectiveTestTotalResultEntity> getUserTestResults(Long testId) throws DBException{
		Query query = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			query = session.createQuery("from ObjectiveTestTotalResultEntity where test.id =" + testId);	
			return query.list();
		}
		catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occured while getting ObjectiveTestTotalResultEntity");
			}
			throw new DBException(e.getMessage(),e);
		}
	}
	
	public InterviewResultsEntity submitExam(InterviewResultsEntity testResultsEntity) throws DBException{
		try{
			Session session = sessionFactory.getCurrentSession();
			if(testResultsEntity.getTotalQuestions() != 0){
			session.save(testResultsEntity);
			}
			session.flush();
		}
		catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occured while creating creatingTest ["+ testResultsEntity.getId()+"]");
			}
		}
		return testResultsEntity;
	}
	
	@SuppressWarnings("unchecked")
	public List<InterviewResultsEntity> getTestResultsForUser(Long userId) throws DBException{
		Query query = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			query = session.createQuery("from InterviewResultsEntity where user.id =" + userId);	
			return query.list();
		}
		catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occured while getting TestResultsEntity");
			}
			throw new DBException(e.getMessage(),e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<InterviewResultsEntity> getTestResultsForHr(Long testId) throws DBException{
		Query query = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			query = session.createQuery("from InterviewResultsEntity where test.id =" + testId);	
			return query.list();
		}
		catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occured while getting TestResultsEntity");
			}
			throw new DBException(e.getMessage(),e);
		}
	}
	
	public JobInterviewEntity saveJobInterview(JobInterviewEntity jobInterviewEntity) throws DBException{
		try{
			Session session = sessionFactory.getCurrentSession();
			session.save(jobInterviewEntity);
			session.flush();
		}
		catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occured while creating creatingTest ["+ jobInterviewEntity.getId()+"] ["+ jobInterviewEntity.getJob().getJobTitle()+"]");
			}
		}
		return jobInterviewEntity;
	}
	
	public InterviewShortlistedCandidatesEntity saveInterviewShortlistedCandidates
								(InterviewShortlistedCandidatesEntity interviewShortlistedCandidatesEntity) throws DBException{
		try{
			Session session = sessionFactory.getCurrentSession();
			session.save(interviewShortlistedCandidatesEntity);
			session.flush();
		}
		catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occured while creating creatingTest ["+ interviewShortlistedCandidatesEntity.getId()+"]["+ interviewShortlistedCandidatesEntity.getUser().getUserName()+"] ["+ interviewShortlistedCandidatesEntity.getJobInterview().getJob().getJobTitle()+"]");
			}
		}
		return interviewShortlistedCandidatesEntity;
	}
	
	public JobInterviewEntity getJobInterviewByTestId(Long testId) throws DBException{
		Query query = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			query = session.createQuery("from JobInterviewEntity where test.id =" + testId);	
		}
		catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occured while getting JobInterviewEntity");
			}
		}
		return (JobInterviewEntity)query.uniqueResult();
	}
	
	public InterviewGroupsEntity saveInterviewGroups(InterviewGroupsEntity interviewGroupsEntity) throws DBException{
		try{
			Session session = sessionFactory.getCurrentSession();
			session.save(interviewGroupsEntity);
			session.flush();
		}
		catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occured while creating creatingTest ["+ interviewGroupsEntity.getId()+"] ["+ interviewGroupsEntity.getGroupName()+"]");
			}
		}
		return interviewGroupsEntity;
	}
	
	public void saveInterviewGroupsCandidates(List<InterviewGroupsCandidatesDto> dtolist) throws DBException{
		List<InterviewGroupsCandidatesEntity> list = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			for(int i=0;i<dtolist.size();i++){
				InterviewGroupsCandidatesEntity entity = 	DozerBeanMapperSingletonWrapper.getInstance().map(dtolist.get(i), InterviewGroupsCandidatesEntity.class);
				session.save(entity);
			}
			
			session.flush();
		}
		catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occured while creating creating InterviewGroupsCandidates");
			}
		}
		return;
	}
	
	public List<InterviewGroupsEntity> getAllInterviewGroups(Long userId) throws DBException{
		Query query = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			query = session.createQuery("from InterviewGroupsEntity where hrId ="+userId);	
			return query.list();
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occured while getting InterviewGroupsEntity");
			}
			throw new DBException(e.getMessage(),e);
		}
	}
	
	public List<InterviewGroupsCandidatesEntity> getInterviewCandidatesByGroupId(Long groupId) throws DBException{
		Query query = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			query = session.createQuery("from InterviewGroupsCandidatesEntity where groupId ="+groupId);	
		}
		catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occured while getting InterviewGroupsCandidatesEntity");
			}
		}
		return query.list();
	}
	
	public int restrictUsersOnlineTest(Long testId,Long userId,Long roundId) throws DBException{
		Query query = null;
		int result = 0;
		List<InterviewResultsEntity> resultlist = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			query = session.createQuery("from InterviewResultsEntity where test.id = "+testId+" and user.id = "+userId+" and rounds.id = "+roundId);	
			resultlist = query.list();
			result = resultlist.size();
		}
		catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occured while getting InterviewResultsEntity for restricting users from writing online test again");
			}
		}
		return result;
	}
	
	public int restrictUsersOnlineTestByDates(Date fromDate,Date toDate,Long testId) throws DBException{
		Query query = null;
		int result = 0;
		List<InterviewsEntity> resultlist = null;
		Date frdate = DateParser.removeTimeFromDate(fromDate);
		Date todate = DateParser.removeTimeFromDate(toDate);
		String fdate = DateParser.dateToString(fromDate);
		String tdate = DateParser.dateToString(toDate);
		try{
			//DATE(NOW())
			Session session = sessionFactory.getCurrentSession();
			query = session.createQuery("from InterviewsEntity where DATE(NOW()) between '"+fdate+"' and '"+tdate+"' and id="+testId);	
			resultlist = query.list();
			result = resultlist.size();
		}
		catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occured while getting InterviewsEntity by dates for restricting users from writing online test again");
			}
		}
		return result;
	}
	
	public List<InterviewTypesEntity> getInterviewTypesList() throws DBException{
		Query query = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			query = session.createQuery("from InterviewTypesEntity");	
		}
		catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occured while getting InterviewTypesEntity");
			}
		}
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<InterviewsEntity> getprivatetestlist(Long userId) throws DBException{
		Query query = null;
		List<InterviewsEntity> list = null;
		try{
			Integer interviewTypeId = 2;
			Long x = interviewTypeId.longValue();
			Session session = sessionFactory.getCurrentSession();
			query = session.createQuery("from InterviewsEntity where user.id =" +userId+" and interviewType.id = "+x+" ORDER BY id ASC");	
			list = query.list();
			/*if(list.size() == 0){
				query = session.createQuery("from InterviewsEntity where user.id =" +userId);	
				list = query.list();
			}*/
		}
		catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occured while getting PrivateTestList by userId");
			}
		}
		return list;
	}
	
	public void saveSelectedGroupsForInterview(SelectedGroupsForInterviewDto selectedGroupsForInterviewDto) throws DBException{
		Session session = sessionFactory.getCurrentSession();
		try{
			InterviewsDto interviewsDto = selectedGroupsForInterviewDto.getInterview();
			InterviewsEntity interviewsEntity = DozerBeanMapperSingletonWrapper.getInstance().map(interviewsDto, InterviewsEntity.class);
			for(int i =0;i<selectedGroupsForInterviewDto.getInterviewGroups().size();i++){
				InterviewGroupsDto interviewGroupDto = selectedGroupsForInterviewDto.getInterviewGroups().get(i);
				InterviewGroupsEntity interviewGroupEntity = DozerBeanMapperSingletonWrapper.getInstance().map(interviewGroupDto, InterviewGroupsEntity.class);
				SelectedGroupsForInterviewEntity selectedEntity = new SelectedGroupsForInterviewEntity();
				selectedEntity.setInterview(interviewsEntity);
				selectedEntity.setInterviewGroups(interviewGroupEntity);
				session.save(selectedEntity);
			}
			session.flush();
		}
		catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occured while creating SelectedGroupsForInterview");
			}
		}
		return;
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectedGroupsForInterviewEntity> getSelectedGroupsForInterviewByTestId(Long interviewId) throws DBException{
		Query query = null;
		try{

			Session session = sessionFactory.getCurrentSession();
			query = session.createQuery("from SelectedGroupsForInterviewEntity where interview.id =" +interviewId);	
			
		}
		catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occured while getting SelectedGroupsForInterviewEntity by interviewId");
			}
		}
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectedGroupsForInterviewEntity> getSelectedGroupsForInterviewByGroupId(Long interviewGroupId) throws DBException{
		Query query = null;
		try{

			Session session = sessionFactory.getCurrentSession();
			query = session.createQuery("from SelectedGroupsForInterviewEntity where interviewGroups.id =" +interviewGroupId);	
			
		}
		catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occured while getting SelectedGroupsForInterviewEntity by interviewgroupId");
			}
		}
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<InterviewAssignToUsersEntity> getInterviewAssignToUsersByUserId(Long userId) throws DBException{
		Query query = null;
		try{

			Session session = sessionFactory.getCurrentSession();
			query = session.createQuery("from InterviewAssignToUsersEntity where user.id =" +userId);	
			
		}
		catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occured while getting InterviewAssignToUsersEntity by userId");
			}
		}
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public int getInterviewAssignToUsersByUserIdandTestId(Long userId,Long testId) throws DBException{
		Query query = null;
		List<InterviewAssignToUsersEntity> assignlist = new ArrayList<InterviewAssignToUsersEntity>();
		int result = 0;
		try{

			Session session = sessionFactory.getCurrentSession();
			query = session.createQuery("from InterviewAssignToUsersEntity where user.id =" +userId+" and test.id="+testId);	
			assignlist = query.list();
			if(assignlist.size() == 1){
				result = 1;
			}
		}
		catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occured while getting InterviewAssignToUsersEntity by userId and testid");
			}
		}
		return result;
	}
	
	
	public InstituteEntity savePoCollegeDetails(InstituteEntity poCollegeEntity) throws DBException{
		try{
			Query query = null;
			Long poId = null;
			Session session = sessionFactory.getCurrentSession();
			InstituteEntity poentity = getPoCollegeDetailsById(poId,poCollegeEntity.getInstituteName());
			if(poentity == null || poentity.getId() == null){
				session.save(poCollegeEntity);
			}else{
				query= session.createQuery("update InstituteEntity set collegePhoneNo=:collegePhoneno,startDate=:startdate,description=:description,university.id=:university where instituteName=:instituteName");
				query.setParameter("collegePhoneno", poCollegeEntity.getCollegePhoneNo());
				query.setParameter("startdate",poCollegeEntity.getStartDate());
				query.setParameter("description",poCollegeEntity.getDescription());
				query.setParameter("instituteName",poCollegeEntity.getInstituteName());
				query.setParameter("university", poCollegeEntity.getUniversity().getId());
				query.executeUpdate();
			}
			session.flush();
		}
		catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occured while creating creatingTest ["+ poCollegeEntity.getId()+"]");
			}
		}
		return poCollegeEntity;
	}
	
	public InstituteEntity getPoCollegeDetailsById(Long poId,String collegeName) throws DBException{
		Query query = null;
		InstituteEntity instituteentity  = new InstituteEntity();
		try{
			Session session = sessionFactory.getCurrentSession();
			if(collegeName != null){
				query = session.createQuery("from InstituteEntity where instituteName= '" + collegeName+"'");	
			}else{
				query = session.createQuery("from InstituteEntity where poId.id= " + poId);		
			}
		}
		catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occured while getting InstituteEntity by poId");
			}
		}
		List<InstituteEntity>institutelist = query.list();
		if(query.list().size() != 0){
			return (InstituteEntity) institutelist.get(0);	
		}else{
			return instituteentity;
		}
	}
	
}