package org.pioneercoders.services.Interview;

import java.util.Date;
import java.util.List;

import org.pioneercoders.dto.Interview.InterviewAssignToUsersDto;
import org.pioneercoders.dto.Interview.InterviewGroupsCandidatesDto;
import org.pioneercoders.dto.Interview.InterviewGroupsDto;
import org.pioneercoders.dto.Interview.InterviewResultsDto;
import org.pioneercoders.dto.Interview.InterviewRoundQuesAssoDto;
import org.pioneercoders.dto.Interview.InterviewShortlistedCandidatesDto;
import org.pioneercoders.dto.Interview.InterviewTypesDto;
import org.pioneercoders.dto.Interview.InterviewsDto;
import org.pioneercoders.dto.Interview.JobInterviewDto;
import org.pioneercoders.dto.Interview.RoundsDto;
import org.pioneercoders.dto.Interview.SelectedGroupsForInterviewDto;
import org.pioneercoders.dto.Interview.TechnologiesInRoundDto;
import org.pioneercoders.dto.evaluation.codingtest.CodingTestQstnDto;
import org.pioneercoders.dto.evaluation.objectivetest.ObjectiveQstnDto;
import org.pioneercoders.dto.evaluation.objectivetest.ObjectiveTestTotalResultDto;
import org.pioneercoders.dto.evaluation.taskstest.TaskDto;
import org.pioneercoders.dto.student.InstituteDto;
import org.pioneercoders.exceptions.ServiceException;

public interface InterviewService {
	
	public InterviewsDto createTest(InterviewsDto testDto) throws ServiceException;
	
	public List<InterviewsDto> getTestList(Long userId) throws ServiceException;
	
	public List<RoundsDto> getRounds() throws ServiceException;
	
	public List<ObjectiveQstnDto> getQuestionsByTechAndRounds(TechnologiesInRoundDto technologiesInRoundDto) throws ServiceException;
	
	public Long saveQuestions(InterviewRoundQuesAssoDto testRoundQuesAssoDto) throws ServiceException;
	
	public List<ObjectiveQstnDto> getQuestionsForUsers(Long testId) throws ServiceException;
	
	public List<TaskDto> getTasksForUsers(Long testId) throws ServiceException;
	
	public List<CodingTestQstnDto> getCodingQstnsForUsers(Long testId) throws ServiceException;
	
	public List<InterviewsDto> getAllTests(Long userId) throws ServiceException;
	
	public List<ObjectiveTestTotalResultDto> getUserTestResults(Long testId) throws ServiceException ;
	
	public Long submitExam(InterviewResultsDto testresultsDto) throws ServiceException ;
	
	public List<InterviewResultsDto> getTestResultsForUser(Long userId) throws ServiceException;
	
	public List<InterviewResultsDto> getTestResultsForHr(Long testId) throws ServiceException;
	
	public JobInterviewDto saveJobInterview(JobInterviewDto jobInterviewDto) throws ServiceException;
	
	public InterviewShortlistedCandidatesDto saveInterviewShortlistedCandidates
								(InterviewShortlistedCandidatesDto interviewShortlistedCandidatesDto) throws ServiceException ;
	
	public JobInterviewDto getJobInterviewByTestId(Long testId) throws ServiceException;
	
	public InterviewGroupsDto saveInterviewGroups(InterviewGroupsDto interviewGroupsDto) throws ServiceException;
	
	public List<InterviewGroupsCandidatesDto> saveInterviewGroupsCandidates(List<InterviewGroupsCandidatesDto> dtolist) throws ServiceException;
	
	public List<InterviewGroupsDto> getAllInterviewGroups(Long userId) throws ServiceException ;
	
	public List<InterviewGroupsCandidatesDto> getInterviewCandidatesByGroupId(Long groupId) throws ServiceException;
	
	public int restrictUsersOnlineTest(Long testId,Long userId,Long roundId) throws ServiceException;
	
	public int restrictUsersOnlineTestByDates(Date fromDate,Date toDate,Long testId) throws ServiceException ;
	
	public List<InterviewTypesDto> getInterviewTypesList() throws ServiceException;
	
	public List<InterviewsDto> getPrivateTestList(Long userId) throws ServiceException;
	
	public void saveSelectedGroupsForInterview(SelectedGroupsForInterviewDto selectedGroupsForInterviewDto) throws ServiceException;
	
	public List<SelectedGroupsForInterviewDto> getSelectedGroupsForInterviewByTestId(Long interviewId) throws ServiceException;
	
	public List<InterviewAssignToUsersDto> getInterviewAssignToUsersByUserId(Long userId) throws ServiceException;
	
	public InstituteDto savePoCollegeDetails(InstituteDto pocollegedto) throws ServiceException ;
	
	public InstituteDto getPoCollegedetailsById(Long poId) throws ServiceException;
	
}
/*	
	
	
	public List<TestPatternDto> getPatterns() throws ServiceException;
	
	public List<TestQuestionDto> assignQuestions(List<TestQuestionDto> testDtolist) throws ServiceException;
	
	public List<TestQuestionDto> getTestQuestionsByTestId(Long testId) throws ServiceException;
	
	public TestAssignToUsersDto assignTestToUser(TestAssignToUsersDto testAssignToUsersDto) throws ServiceException;
	
	public TestAssignToUsersDto getTestAssignToUsersByUserId(Long userId) throws ServiceException;
	
	public TestResultsDto saveTestResults(TestResultsDto testResultsDto) throws ServiceException;
	
	public TestResultsDto getTestResultsByUserId(Long userId) throws ServiceException;
	
}
*/