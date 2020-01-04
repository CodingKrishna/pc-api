package org.pioneercoders.services.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.pioneercoders.dto.common.LanguagesDto;
import org.pioneercoders.dto.common.PlacementsDto;
import org.pioneercoders.dto.common.RoleDto;
import org.pioneercoders.dto.common.SubscribeDto;
import org.pioneercoders.dto.common.SupportDto;
import org.pioneercoders.dto.common.TechnologiesDto;
import org.pioneercoders.dto.hr.UserSearchDto;
import org.pioneercoders.dto.hr.UserSearchResultsDto;
import org.pioneercoders.dto.student.AddressDto;
import org.pioneercoders.dto.student.CityDto;
import org.pioneercoders.dto.student.CompleteProfileDto;
import org.pioneercoders.dto.student.CountryDto;
import org.pioneercoders.dto.student.EducationDto;
import org.pioneercoders.dto.student.EmployersInfoDto;
import org.pioneercoders.dto.student.InstituteDto;
import org.pioneercoders.dto.student.ProfileWithLanguageDto;
import org.pioneercoders.dto.student.ProjectDomainDto;
import org.pioneercoders.dto.student.ProjectDto;
import org.pioneercoders.dto.student.ReferralDto;
import org.pioneercoders.dto.student.SkillsDto;
import org.pioneercoders.dto.student.SocialInfoDto;
import org.pioneercoders.dto.student.StateDto;
import org.pioneercoders.dto.student.TechSkillDto;
import org.pioneercoders.dto.student.UniversityDto;
import org.pioneercoders.dto.student.UserBasicSkillsDto;
import org.pioneercoders.dto.student.UserExperianceDto;
import org.pioneercoders.dto.user.UserBasicInfoDto;
import org.pioneercoders.dto.user.UserDto;
import org.pioneercoders.exceptions.ServiceException;

public interface UserService {
	
	public UserDto createUser(UserDto userDto, String activateBaseUrl) throws ServiceException;
	
	public UserDto getUserDetails(String emailId,String password) throws ServiceException;
	
	public List<UserDto> getUsersList(String status)throws ServiceException;
	
	public UserDto getUserDtoById(Long id)throws ServiceException;

	public UserDto updateStatus(UserDto userDto)throws ServiceException;

	public UserDto updateUser(UserDto userDto)throws ServiceException;
	
	public UserDto getUserDetailsByEmailOrMobile(String emailId,String mobileNo) throws ServiceException;
	
	public void activateUserStatusById(Long id,Long roleId) throws ServiceException;
	
	public UserDto updateUserVisibilityById(Boolean isVisible,Long userId) throws ServiceException;
	
	public UserDto updateUserByBasicInfo(UserDto userDto) throws ServiceException;
	
	public int updateUserInterviewDetailsByUserId(Long userId,String interviewStatus,Boolean reShedule,Date interviewDate,String interviewTiming) throws ServiceException;
	
	public int updateMobileNoByUserId(Long userId,String mobileNo) throws ServiceException;
	
	public CompleteProfileDto createEducationInfo(List<EducationDto> educationsList) throws ServiceException;
	
	public EducationDto updateEducationInfo(EducationDto educationDto)throws ServiceException;
	
	public int deleteEducationInfoByUserIdAndType(Long userId,String eduType)throws ServiceException;
	
	public  List<InstituteDto> getInstituteList() throws ServiceException;
	
	public List<UniversityDto> getUniversityList() throws ServiceException;
	
	public AddressDto createAddressInfo(AddressDto addressDto) throws ServiceException;
	
	public AddressDto updateAddressInfo(AddressDto addressDto)throws ServiceException;
	
	public CompleteProfileDto createProjectInfo(List<ProjectDto> projectsList) throws ServiceException;
	
	public int deleteProjectByUserIdAndProjectName(Long userId,String projectName)throws ServiceException;
	
	public ProjectDto updateProjectInfo(ProjectDto projectDto)throws ServiceException;
	
	public List<ProjectDomainDto> getProjectDomainList() throws ServiceException;
	
	public List<TechnologiesDto> getAllTechnologiesList() throws ServiceException;
	
	public CompleteProfileDto createTechSkillRecord(SkillsDto skills)throws ServiceException;
	
	public TechSkillDto updateTechSkillRecord(TechSkillDto techSkillDto)throws ServiceException;
	
	public List<TechSkillDto> getTechSkillRecordsByUserId(Long userId) throws ServiceException;
	
	public TechSkillDto getTechSkillRecordsByUserIdAndTechId(Long userId,Long techId) throws ServiceException;
	
	public CompleteProfileDto getCompleteProfile(Long userId)throws ServiceException;
	
	public List<RoleDto> getAllRoles() throws ServiceException;
	
	public int updateStatusAndRoleForUsers(List<Integer> userIds, Integer selectedRole, String statusString) throws ServiceException;
	
	public ReferralDto createReferral(ReferralDto referralDto) throws ServiceException;
	
	public int addReferralData(List<ReferralDto> referralDto) throws ServiceException;
	
	public List<ReferralDto> getReferralsByUserId(Long userId)throws ServiceException;
	
	public SupportDto createSupport(SupportDto supportDto) throws ServiceException;

	public List<SupportDto> getAllSupportsList()throws ServiceException;
	
	public List<PlacementsDto> getPlacementsList() throws ServiceException;
	
	public SubscribeDto createSubscriberInfo(SubscribeDto SubscribeDto) throws ServiceException;
	
	public SocialInfoDto createSocialInfo(SocialInfoDto socialInfoDto) throws ServiceException;
	
	public SocialInfoDto updateSocialInfo(SocialInfoDto socialInfoDto)throws ServiceException;
	
	public CompleteProfileDto createEmployersInfo(List<EmployersInfoDto> employersInfoList) throws ServiceException;
	
	public int deleteEmployerInfoByUserIdAndType(Long userId,String empType)throws ServiceException;
	
	public EmployersInfoDto updateEmployersInfo(EmployersInfoDto employersInfo)throws ServiceException;
	
	public List<UserDto> getUsersListData(ArrayList<Integer> userIds) throws ServiceException;
	
	
	
	public CompleteProfileDto createUserBasicInfo(ProfileWithLanguageDto profileWithLanguagesDto) throws ServiceException;
	
	public UserBasicInfoDto updateUserBasicInfo(UserBasicInfoDto basicInfoDto)throws ServiceException;
	

	public List<CompleteProfileDto> getUsersListByVisibility()throws ServiceException;
	
	//public Map<String,Object> getUserQuitzData()throws ServiceException;
	
	public UserExperianceDto createUserExperianceInfo(UserExperianceDto userExperianceDto) throws ServiceException;
	
	public UserExperianceDto updateUserExperianceInfo(UserExperianceDto userExperianceDto)throws ServiceException;
	
	public List<CompleteProfileDto> getUsersListByRole()throws ServiceException;
	
	public int updateUserPasswordByEmailId(String emailId,String password) throws ServiceException;
	

	public UserExperianceDto getUsersBySalaryRange(String curentSalary) throws ServiceException;
	
	public EducationDto getUsersByQualification(String qualification) throws ServiceException;
	
	public EducationDto getUsersBypercentage(Float percentage) throws ServiceException;
	
	

	//public List<SkillsetTrnDto> getSkillSetTrnRecordBySkillId(Long skillId)throws ServiceException;
	
	//public Double getTotalExpeAmountByDate(String startDate,String endDate) throws ServiceException;
	
	public List<CityDto> getCityList() throws ServiceException;
	
	public List<StateDto> getStateList() throws ServiceException;
	
	public List<CountryDto> getCountryList() throws ServiceException;
	
	public UserBasicSkillsDto createBasicSkillRecord(UserBasicSkillsDto basicSkillsDto)throws ServiceException;
	
	public UserBasicSkillsDto updateBasicSkillRecord(UserBasicSkillsDto basicSkillsDto)throws ServiceException;
	
	public UserBasicSkillsDto getUserBasicSkillsByUserId(Long userId)throws ServiceException;
	
	public List<LanguagesDto> getAllLanguagesList() throws ServiceException;
	
	public  List<UserSearchResultsDto> getuserslistbysearchpreference(UserSearchDto userSearchDto) throws ServiceException;
	
}












