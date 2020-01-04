package org.pioneercoders.dao.Interview;

import java.util.Date;
import java.util.List;

import org.pioneercoders.dto.Interview.InterviewGroupsCandidatesDto;
import org.pioneercoders.dto.Interview.InterviewRoundQuesAssoDto;
import org.pioneercoders.dto.Interview.SelectedGroupsForInterviewDto;
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
import org.pioneercoders.entity.evaluation.objectivetest.ObjectiveTestTotalResultEntity;
import org.pioneercoders.entity.student.InstituteEntity;
import org.pioneercoders.exceptions.DBException;

public interface InterviewDao {
	
	public InterviewsEntity createTest(InterviewsEntity testEntity) throws DBException;
	
	public List<InterviewsEntity> gettestlist(Long userId) throws DBException;
	
	public List<RoundsEntity> getRounds() throws DBException;
	
	public List<InterviewRoundsEntity> saveTestRounds(InterviewsEntity testEntity,  List<InterviewRoundsEntity> listOfTestRounds) throws DBException;
	
	public List<InterviewTechnologiesEntity> saveTestTechnologies(InterviewsEntity testEntity , List<InterviewTechnologiesEntity> listOftestTechnologies) throws DBException;
	
	public List<InterviewRoundsEntity> getRoundsByTestId(Long TestId) throws DBException;
	
	public List<InterviewTechnologiesEntity> getTechnologiesByTestId(Long TestId) throws DBException;
	
	public Long saveQuestions(InterviewRoundQuesAssoDto testRoundQuesAssoDto)throws DBException;
	
	public List<InterviewRoundQuesAssoEntity> getQuestionsForUsers(Long testId) throws DBException;
	
	public List<InterviewsEntity> getAllTests(Long userId) throws DBException;
	
	public List<ObjectiveTestTotalResultEntity> getUserTestResults(Long testId) throws DBException;
	
	public InterviewResultsEntity submitExam(InterviewResultsEntity testResultsEntity) throws DBException;
	
	public List<InterviewResultsEntity> getTestResultsForUser(Long userId) throws DBException;
	
	public List<InterviewResultsEntity> getTestResultsForHr(Long testId) throws DBException;
	
	public JobInterviewEntity saveJobInterview(JobInterviewEntity jobInterviewEntity) throws DBException;
	
	public InterviewShortlistedCandidatesEntity saveInterviewShortlistedCandidates
								(InterviewShortlistedCandidatesEntity interviewShortlistedCandidatesEntity) throws DBException;
	
	public JobInterviewEntity getJobInterviewByTestId(Long testId) throws DBException;
	
	
	public InterviewGroupsEntity saveInterviewGroups(InterviewGroupsEntity interviewGroupsEntity) throws DBException;
	
	public  void saveInterviewGroupsCandidates(List<InterviewGroupsCandidatesDto> dtolists) throws DBException;
	
	public List<InterviewGroupsEntity> getAllInterviewGroups(Long userId) throws DBException;
	
	public List<InterviewGroupsCandidatesEntity> getInterviewCandidatesByGroupId(Long groupId) throws DBException;
	
	public int restrictUsersOnlineTest(Long testId,Long userId,Long roundId) throws DBException;
	
	public int restrictUsersOnlineTestByDates(Date fromDate,Date toDate,Long testId) throws DBException;
	
	public List<InterviewTypesEntity> getInterviewTypesList() throws DBException;
	
	public List<InterviewsEntity> getprivatetestlist(Long userId) throws DBException;
	
	public void saveSelectedGroupsForInterview(SelectedGroupsForInterviewDto selectedGroupsForInterviewDto) throws DBException;

	public List<SelectedGroupsForInterviewEntity> getSelectedGroupsForInterviewByTestId(Long interviewId) throws DBException;
	
	public List<SelectedGroupsForInterviewEntity> getSelectedGroupsForInterviewByGroupId(Long interviewGroupId) throws DBException;
	
	public List<InterviewAssignToUsersEntity> getInterviewAssignToUsersByUserId(Long userId) throws DBException;
	
	public int getInterviewAssignToUsersByUserIdandTestId(Long userId,Long testId) throws DBException;
	
	public InstituteEntity savePoCollegeDetails(InstituteEntity poCollegeEntity) throws DBException;
	
	public InstituteEntity getPoCollegeDetailsById(Long poId,String collegeName) throws DBException;
	
}

	/*

	public TestQuestionEntity assignQuestions(TestQuestionEntity testQuestionEntity) throws DBException;
	
	public TestAssignToUsersEntity assignTestToUser(TestAssignToUsersEntity testAssignToUsersEntity) throws DBException;
	
	public TestAssignToUsersEntity getTestAssignToUsersByUserId(Long userId) throws DBException;
	
	public TestResultsEntity saveTestResults(TestResultsEntity testResultsEntity) throws DBException;
	
	public TestResultsEntity getTestResultsByUserId(Long userId) throws DBException;
	
	public List<TestQuestionEntity> getTestQuestionsByTestId(Long TestId) throws DBException;
}
*/