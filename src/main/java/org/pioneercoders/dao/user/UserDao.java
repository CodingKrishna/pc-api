package org.pioneercoders.dao.user;

import java.util.Date;
import java.util.List;

import org.pioneercoders.dto.hr.UserSearchDto;
import org.pioneercoders.dto.user.UserDto;
import org.pioneercoders.entity.common.TechnologiesEntity;
import org.pioneercoders.entity.hr.UserSearchResultsEntity;
import org.pioneercoders.entity.student.AddressEntity;
import org.pioneercoders.entity.student.CityEntity;
import org.pioneercoders.entity.student.CountryEntity;
import org.pioneercoders.entity.student.EducationEntity;
import org.pioneercoders.entity.student.EmployersInfoEntity;
import org.pioneercoders.entity.student.InstituteEntity;
import org.pioneercoders.entity.student.LanguageEntity;
import org.pioneercoders.entity.student.ProjectDomainEntity;
import org.pioneercoders.entity.student.ProjectEntity;
import org.pioneercoders.entity.student.SocialInfoEntity;
import org.pioneercoders.entity.student.StateEntity;
import org.pioneercoders.entity.student.TechSkillEntity;
import org.pioneercoders.entity.student.UniversityEntity;
import org.pioneercoders.entity.student.UserBasicSkillsEntity;
import org.pioneercoders.entity.student.UserExperianceEntity;
import org.pioneercoders.entity.student.UserLanguagesEntity;
import org.pioneercoders.entity.user.UserBasicInfoEntity;
import org.pioneercoders.entity.user.UserEntity;
import org.pioneercoders.exceptions.DBException;

public interface UserDao {
	
	public List<ProjectEntity> saveOrUpdateProject(List<ProjectEntity> profileEntitylist) throws DBException;
	
	public List<EducationEntity> saveOrUpdateEducation(List<EducationEntity> educationEntityList) throws DBException;
	
	public List<EmployersInfoEntity> saveOrUpdateEmployersInfo(List<EmployersInfoEntity> employersInfoEntityList) throws DBException;
	//userdao
	public UserEntity createUser(UserEntity userEntity) throws DBException;
	
	public UniversityEntity getuniversitydetailsbyid(Long Id) throws DBException;

	public InstituteEntity getinstitutedetailsbyid(Long Id) throws DBException;
	
	public UserEntity getUserDetails(String emailId, String password) throws DBException;

	public UserEntity getUserDetailsById(Long id) throws DBException;

	public UserEntity getUserDetailsByEmailOrMobile(String emailId,String mobile) throws DBException;
	
	public int updateUserMobileNoByUserId(Long userId,String mobileNo) throws DBException;

	public List<UserEntity> getUserList(String status) throws DBException;

	public UserEntity updateUser(UserEntity entity) throws DBException;
	
	public void activateUserStatusById(Long id,Long roleId) throws DBException;
	
	public UserEntity updateUserIsVisibleById(Boolean isVisible,Long userId) throws DBException;
	
	public int updateUserInterviewDetailsByUserId(Long id,String interviewStatus,Boolean reShedule, Date interviewDate,String interviewTiming)throws DBException;
	
	public List<UserEntity> getUserListByUserVisibility() throws DBException;
	
	public UserEntity updateUserByBasicInfo(UserEntity userEntity) throws DBException;
	
	public List<UserEntity> getUsersListByExamCompleted() throws DBException;
	
	// Education related methods

	public EducationEntity createEducation(EducationEntity entity) throws DBException;
	
	public EducationEntity getEducationInfoByUserIdAndType(Long userId,String eduType) throws DBException;

	public EducationEntity updateEducation(EducationEntity entity) throws DBException;
	
	public int deleteEducationByUserIdAndType(Long userId,String eduType) throws DBException;

	public List<EducationEntity> getEducationById(Long userId) throws DBException;
	
	public List<InstituteEntity> getInstituteList() throws DBException;
	
	public List<UniversityEntity> getUniversityList() throws DBException;
	
	// Address related methods

	public AddressEntity createAddress(AddressEntity entity) throws DBException;

	public AddressEntity updateAddress(AddressEntity entity) throws DBException;
	

	public AddressEntity getAddressInfoById(Long userId) throws DBException;

	// Project related Methods

	public ProjectEntity createProject(ProjectEntity entity) throws DBException;

	public ProjectEntity updateProject(ProjectEntity entity) throws DBException;

	public List<ProjectEntity> getProjectById(Long userId) throws DBException;
	
	public ProjectEntity getProjectInfoByUserIdAndProjectName(Long userId,String projectName) throws DBException;
	
	public List<ProjectDomainEntity> getProjectDomainList()throws DBException;
	
	public int deleteProjectByUserIdAndType(Long userId,String ProjectName) throws DBException;
	
	public List<CityEntity> getCityList() throws DBException;
	
	public CityEntity getcityInfoById(Long Id) throws DBException;
	
	public List<StateEntity> getStateList() throws DBException;
	
	public StateEntity getstateInfoById(Long Id) throws DBException;
	
	public List<CountryEntity> getCountryList() throws DBException;
	
	public CountryEntity getcountryInfoById(Long Id) throws DBException ;

	//Evaluation related Methods
	
	
	public int updateStatusAndRoleForUsers(List<Long> userIds, Long selectedRoleId, String statustring)  throws DBException;
	
	//Social Info Medthods
	
	public SocialInfoEntity createSocialInfo(SocialInfoEntity entity) throws DBException;

	public SocialInfoEntity updateSocialInfo(SocialInfoEntity entity) throws DBException;

	public SocialInfoEntity getSocialInfoByUserId(Long userId) throws DBException;
	
	//WorkExperiance Info Methods
	
	public EmployersInfoEntity createEmployersInfo(EmployersInfoEntity entity) throws DBException;

	public EmployersInfoEntity updateEmployersInfo(EmployersInfoEntity entity) throws DBException;

	public List<EmployersInfoEntity> getEmployersInfoByUserId(Long userId) throws DBException;
	
	public Boolean setExamCompleted(Long userId) throws DBException ;
	
	public EmployersInfoEntity getEmployersInfoByUserIdAndType(Long userId,String employerStatus) throws DBException;
	
	public int deleteEmployerInfoByUserIdAndEmployerType(Long userId,String empType) throws DBException;
	
	// Basic Info related Methods

	public UserBasicInfoEntity createBasicInfo(UserBasicInfoEntity entity) throws DBException;
	
	public UserBasicInfoEntity updateUserBasicInfo(UserBasicInfoEntity entity) throws DBException;
	
	public UserBasicInfoEntity getUserBasicInfoById(Long userId) throws DBException;
	
	//User Basic Skills related Methods
	
	public UserBasicSkillsEntity createBasicSkills(UserBasicSkillsEntity entity) throws DBException;
	
	public UserBasicSkillsEntity updateBasicSkills(UserBasicSkillsEntity entity) throws DBException;
	
	public UserBasicSkillsEntity getUserBasicSkillsByUserId(Long userId) throws DBException;
	

	
	
	
	//Total workExp Methods
	
	public UserExperianceEntity createUserExperianceInfo(UserExperianceEntity entity) throws DBException;

	public UserExperianceEntity updateUserExperianceInfo(UserExperianceEntity entity) throws DBException;

	public UserExperianceEntity getUserExperianceInfoById(Long userId) throws DBException;
	
	public List<UserEntity> getUserListByRole() throws DBException;
	
	public int updatePasswordByEmailId(String emailId,String password) throws DBException;
	

	public List<UserExperianceEntity> getUsersBySalaryRange(String curentSalary) throws DBException ;

	public int deleteSkillsetTrnRecord(Long id) throws DBException;
	
	
	//languages related Methods 
	
	public List<LanguageEntity> getAllLanguages()throws DBException;
	
	public void createUserLanguagesRecord(List<UserLanguagesEntity> userLanguagesList)throws DBException;
	
	public UserLanguagesEntity updateUserLanguagesRecord(UserLanguagesEntity userLanguagesEntity)throws DBException;
	
	public List<UserLanguagesEntity> getLanguagesByUserId(Long userId) throws DBException;
	
	public int deleteLanguagesByUserId(Long userId) throws DBException;
	
	public List<EducationEntity> getUsersByPercentage(Float percentage) throws DBException;
	
	public List<EducationEntity> getUsersByQualification(String qualification) throws DBException;
	
	public int updateUserInInterviewCandidates(UserDto userDto) throws DBException;
	
	public LanguageEntity getLanguagesbylanguageid(Long languageid)throws DBException;
	
	public TechnologiesEntity gettechnologiesbytechid(Long techid)throws DBException;
	
	public List<AddressEntity> getaddressInfoBycityId(Long cityId) throws DBException;
	
	public List<TechSkillEntity> gettechInfoBytechId(Long techId) throws DBException ;
	
	public List<UserExperianceEntity> getuserexperienceInfoByexpId(int exp) throws DBException;
	
	public List<UserSearchResultsEntity> getusersearch(UserSearchDto userSearchDto) throws DBException;
	
}