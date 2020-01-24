package org.pioneercoders.services.user.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.pioneercoders.dao.common.PlacementsDao;
import org.pioneercoders.dao.common.RoleDao;
import org.pioneercoders.dao.common.SubscriberDao;
import org.pioneercoders.dao.common.SupportDao;
import org.pioneercoders.dao.hr.PricingPlanesDao;
import org.pioneercoders.dao.hr.PricinnPlanTrnDao;
import org.pioneercoders.dao.hr.ShortListedProfilesDao;
import org.pioneercoders.dao.user.PurchasedCoursesDao;
import org.pioneercoders.dao.user.ReferralDao;
import org.pioneercoders.dao.user.TechSkillDao;
import org.pioneercoders.dao.user.UserDao;
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
import org.pioneercoders.dto.student.PurchasedCourseDto;
import org.pioneercoders.dto.student.ReferralDto;
import org.pioneercoders.dto.student.SkillsDto;
import org.pioneercoders.dto.student.SocialInfoDto;
import org.pioneercoders.dto.student.StateDto;
import org.pioneercoders.dto.student.TechSkillDto;
import org.pioneercoders.dto.student.UniversityDto;
import org.pioneercoders.dto.student.UserBasicSkillsDto;
import org.pioneercoders.dto.student.UserExperianceDto;
import org.pioneercoders.dto.student.UserLanguagesDto;
import org.pioneercoders.dto.user.UserBasicInfoDto;
import org.pioneercoders.dto.user.UserDto;
import org.pioneercoders.entity.common.PlacementsEntity;
import org.pioneercoders.entity.common.RoleEntity;
import org.pioneercoders.entity.common.SubscribeEntity;
import org.pioneercoders.entity.common.SupportEntity;
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
import org.pioneercoders.entity.student.PurchasedCourseEntity;
import org.pioneercoders.entity.student.ReferralEntity;
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
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.user.UserService;
import org.pioneercoders.utils.CollectionMapper;
import org.pioneercoders.utils.Constants;
import org.pioneercoders.utils.FileReadUtil;
import org.pioneercoders.utils.MailContentUtil;
import org.pioneercoders.utils.MailThread;
import org.pioneercoders.utils.SMSThread;
import org.pioneercoders.utils.UserRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import sun.misc.BASE64Decoder;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Resource(name = "msgProps")
	private Map<String, String> msgProps;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	RoleDao roleDao;
	
	@Autowired
	ReferralDao referralDao;
	
	@Autowired
	SupportDao supportDao;
	
	@Autowired
	PlacementsDao placementsDao;
	
	@Autowired
	SubscriberDao subscriberDao;
	
	@Autowired
	PricingPlanesDao pricingPlanesDao; 
	
	@Autowired
	ShortListedProfilesDao shortListedProfileDao;
	
	@Autowired 
	PricinnPlanTrnDao pricingPlansTrnDao;
	
	@Autowired
	TechSkillDao techSkillDao;
/*	
	@Autowired
	ExamReDao examDao;
	
	@Autowired
	AnswerDao answerDao;
	
	@Autowired
	QuestionsDao questionDao;*/
	
	@Autowired(required = true)
	PurchasedCoursesDao purchasedCourseDao;
	
	@Autowired
	MailContentUtil mailContentUtil;
	
	@Override
	public UserDto createUser(UserDto userDto, String activateBaseUrl)throws ServiceException {
		UserDto finalUserDto=null;
		try {
			if(userDao.getUserDetailsByEmailOrMobile(userDto.getEmailId(), userDto.getMobileNo())==null){
				//userDto.setStatus(Constants.STATUS_PENDING);
				userDto.setStatus(Constants.STATUS_ACTIVE);
				userDto.setCreatedOn(Constants.CREATED_ON());
				userDto.setIsVisible(true);
				UserEntity userEntity = DozerBeanMapperSingletonWrapper.getInstance().map(userDto, UserEntity.class);
				finalUserDto = DozerBeanMapperSingletonWrapper.getInstance().map(userDao.createUser(userEntity),UserDto.class);
				finalUserDto.setPassword(null);
				// send SMS and Email on successful creation of user in DB.
				if(finalUserDto.getId()!=0){
					//sendSMSandEmail(activateBaseUrl, finalUserDto);
					if(finalUserDto.getRole().getId() == UserRoles.INTERVIEW.getValue()){
						userDao.updateUserInInterviewCandidates(finalUserDto);
					}
				}
			}
			
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finalUserDto;
	}

	private void sendSMSandEmail(String activateBaseUrl, UserDto finalUserDto) {
		StringBuffer message = new StringBuffer(new FileReadUtil().getProperty("MESSAGE_REGISTRATION"));
		String whatsupMobileNo = new FileReadUtil().getProperty("MESSAGE_POINEER_CODERS_WHATS_UP_MOBILE");
		String acronym = "@POINEER_CODERS_MOBILE@";
		if(message.indexOf(acronym)>-1){
			message = message.replace(message.indexOf(acronym), message.indexOf(acronym) + acronym.length(), whatsupMobileNo);
		}
		
		SMSThread smsThread = new SMSThread(message.toString(), finalUserDto.getMobileNo());
		Thread smsth = new Thread(smsThread);
		smsth.start();
		
		String mailContent = mailContentUtil.sendMailForRegistration(activateBaseUrl, finalUserDto);
		MailThread mailThread = new MailThread(finalUserDto.getEmailId(), msgProps.get("email.registration.subject"), mailContent);
		Thread t = new Thread(mailThread);
		t.start();
	}

	/**
	 * this method is used to get the user details by passing email id and password.
	 * @param email id 
	 * @param encripted password.
	 */
	public UserDto getUserDetails(String emailId,String password) throws ServiceException {
		UserDto userDto=null;
		try {
			UserEntity userEntity=userDao.getUserDetails(emailId, password);
			if(userEntity!=null){
				userDto = DozerBeanMapperSingletonWrapper.getInstance().map(userEntity,UserDto.class);
				if(userDto.getRole().getId() == UserRoles.INTERVIEW.getValue()){
					userDao.updateUserInInterviewCandidates(userDto);
				}
				userDto.setPassword(null);
			}
		}catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return userDto;
	}

	@Override
	public List<UserDto> getUsersList(String status) throws ServiceException {
		try {
			List<UserEntity> list = userDao.getUserList(status);
			List<UserDto> userList = CollectionMapper.getMappingList(list.iterator(), UserDto.class);
			for(UserDto user : userList) {
				user.setPassword(null);
			}
			return userList;
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing userList data ");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public UserDto getUserDtoById(Long id) throws ServiceException {
		try{
			UserEntity entity = userDao.getUserDetailsById(id);
			UserDto userDto=DozerBeanMapperSingletonWrapper.getInstance().map(entity, UserDto.class);
			userDto.setPassword(null);
			return userDto;
			}catch(DBException e){
				throw new ServiceException(e.getMessage(),e);
			}
	}

	@Override
	public UserDto updateStatus(UserDto userDto) throws ServiceException {
		UserDto finalDto = null;
		try{
			UserEntity entity = userDao.getUserDetailsById(userDto.getId());
			if(userDto.getStatus().equals("activate")){
				entity.setStatus(Constants.STATUS_ACTIVE);
			}else if(userDto.getStatus().equals("deactivate")){
				entity.setStatus(Constants.STATUS_DEACTIVE);
			}
			finalDto=DozerBeanMapperSingletonWrapper.getInstance().map(userDao.updateUser(entity), UserDto.class);
			finalDto.setPassword(null);
			
		}catch(DBException e){
			throw new ServiceException(e.getMessage(),e);
		}
		
		return finalDto;
	}
	
	@Override
	public UserDto updateUser(UserDto userDto)throws ServiceException {
		UserDto finalUserDto=null;
		try {
			UserEntity userEntity = userDao.getUserDetailsById(userDto.getId());
			//userEntity.setAddress(userDto.getAddress());
			finalUserDto = DozerBeanMapperSingletonWrapper.getInstance().map(userDao.updateUser(userEntity),UserDto.class);
			finalUserDto.setPassword(null);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finalUserDto;
	}
	
	@Override
	public UserDto getUserDetailsByEmailOrMobile(String emailId,String mobileNo)
			throws ServiceException {
		UserDto finalUserDto=null;
		try {
			finalUserDto = DozerBeanMapperSingletonWrapper.getInstance().map(userDao.getUserDetailsByEmailOrMobile(emailId, mobileNo),UserDto.class);
			finalUserDto.setPassword(null);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finalUserDto;
	}
	
	@Override
	public void activateUserStatusById(Long id,Long roleId) throws ServiceException {
		try {
			userDao.activateUserStatusById(id,roleId);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		
	}
	
	@Override
	public UserDto updateUserVisibilityById(Boolean isVisible, Long userId) throws ServiceException {
		UserDto userDto = null;
		try {
			userDto = DozerBeanMapperSingletonWrapper.getInstance().map(userDao.updateUserIsVisibleById(isVisible, userId),UserDto.class);
			userDto.setPassword(null);
		} catch (DBException e) {
			e.printStackTrace();
		}
		return userDto;
	}
	
	@Override
	public int updateUserInterviewDetailsByUserId(Long userId,String interviewStatus,Boolean reShedule,Date interviewDate,String interviewTiming)
			throws ServiceException {
		int row = 0;
		try {
			row = userDao.updateUserInterviewDetailsByUserId(userId,interviewStatus,reShedule, interviewDate,interviewTiming);
		} catch (DBException e) {
			e.printStackTrace();
		}
		return row;
	}
	
	@Override
	public UserDto updateUserByBasicInfo(UserDto userDto) throws ServiceException {
		try {
			UserEntity entity = DozerBeanMapperSingletonWrapper.getInstance().map(userDto, UserEntity.class);
			userDto = DozerBeanMapperSingletonWrapper.getInstance().map(userDao.updateUserByBasicInfo(entity),UserDto.class);
			userDto.setPassword(null);
		} catch (DBException e) {
			e.printStackTrace();
		}
		return userDto;
	}	

	//Education Info Operations
	@Override
	public CompleteProfileDto createEducationInfo(List<EducationDto> educationsList) throws ServiceException {
		CompleteProfileDto profileDto = new CompleteProfileDto();
		List<EducationDto> educationListData = new ArrayList<EducationDto>();
		try {
			List<EducationEntity> entitylist = CollectionMapper.getMappingList(educationsList.iterator(), EducationEntity.class);
			entitylist = userDao.saveOrUpdateEducation(entitylist);
			educationListData = CollectionMapper.getMappingList(entitylist.iterator(), EducationDto.class);
			for(int i=0;i<educationListData.size();i++){
				InstituteEntity instituteentity = userDao.getinstitutedetailsbyid(educationListData.get(i).getInstitute().getId());
				InstituteDto instituteDto = DozerBeanMapperSingletonWrapper.getInstance().map(instituteentity, InstituteDto.class);
				educationListData.get(i).setInstitute(instituteDto);
				UniversityEntity universityentity = userDao.getuniversitydetailsbyid(educationListData.get(i).getUniversity().getId());
				UniversityDto universityDto = DozerBeanMapperSingletonWrapper.getInstance().map(universityentity, UniversityDto.class);
				educationListData.get(i).setUniversity(universityDto);
			}
			profileDto.setEducation(educationListData);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return profileDto;
	}

	@Override
	public EducationDto updateEducationInfo(EducationDto educationDto) throws ServiceException {
		EducationDto finalDto=null;
		try {
			EducationEntity entity = DozerBeanMapperSingletonWrapper.getInstance().map(educationDto, EducationEntity.class);
			finalDto = DozerBeanMapperSingletonWrapper.getInstance().map(userDao.updateEducation(entity),EducationDto.class);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finalDto;
	}
	
	@Override
	public List<InstituteDto> getInstituteList() throws ServiceException {
		List<InstituteDto> listDto=null;
		try {
			List<InstituteEntity> entitylist = userDao.getInstituteList();
			listDto = CollectionMapper.getMappingList(entitylist.iterator(), InstituteDto.class);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return listDto;
	}
	
	@Override
	public List<UniversityDto> getUniversityList() throws ServiceException {
		List<UniversityDto> listDto=null;
		try {
			List<UniversityEntity> listentity = userDao.getUniversityList();
			listDto = CollectionMapper.getMappingList(listentity.iterator(),UniversityDto.class );
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return listDto;
	}
	
	@Override
	public int deleteEducationInfoByUserIdAndType(Long userId, String eduType) throws ServiceException {
		int result;
		try {
			result = userDao.deleteEducationByUserIdAndType(userId, eduType);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return result;
	}
	
	//AddressInfo Operations
	@Override
	public AddressDto createAddressInfo(AddressDto addressDto)throws ServiceException {
		AddressDto finalDto=null;
		try {
			AddressEntity entity = DozerBeanMapperSingletonWrapper.getInstance().map(addressDto, AddressEntity.class);
			
			finalDto = DozerBeanMapperSingletonWrapper.getInstance().map(userDao.createAddress(entity),AddressDto.class);
			
			CityEntity cityentity = userDao.getcityInfoById(finalDto.getCity().getId());
			CityDto cityDto = DozerBeanMapperSingletonWrapper.getInstance().map(cityentity, CityDto.class);
			finalDto.setCity(cityDto);
			StateEntity stateentity = userDao.getstateInfoById(finalDto.getState().getId());
			StateDto statedto = DozerBeanMapperSingletonWrapper.getInstance().map(stateentity, StateDto.class);
			finalDto.setState(statedto);
			CountryEntity countryentity = userDao.getcountryInfoById(finalDto.getCountry().getId());
			CountryDto countrydto = DozerBeanMapperSingletonWrapper.getInstance().map(countryentity, CountryDto.class);
			finalDto.setCountry(countrydto);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finalDto;
	}

	@Override
	public AddressDto updateAddressInfo(AddressDto addressDto) throws ServiceException {
		AddressDto finalDto=null;
		try {
			AddressEntity entity = DozerBeanMapperSingletonWrapper.getInstance().map(addressDto, AddressEntity.class);
			finalDto = DozerBeanMapperSingletonWrapper.getInstance().map(userDao.updateAddress(entity),AddressDto.class);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finalDto;
	}
	
	public List<CityDto> getCityList() throws ServiceException{
		List<CityDto> listDto;
		try{
			List<CityEntity> cityentity = userDao.getCityList();
			listDto = CollectionMapper.getMappingList(cityentity.iterator(), CityDto.class);
		}
		catch(DBException e){
			throw new ServiceException(e.getMessage(),e);
		}
		return listDto;
	}
	
	public List<StateDto> getStateList() throws ServiceException{
		List<StateDto> listDto;
		try{
			List<StateEntity> stateentity = userDao.getStateList();
			listDto = CollectionMapper.getMappingList(stateentity.iterator(), StateDto.class);
		}
		catch(DBException e){
			throw new ServiceException(e.getMessage(),e);
		}
		return listDto;
	}
	
	public List<CountryDto> getCountryList() throws ServiceException{
		List<CountryDto> listDto;
		try{
			List<CountryEntity> countryentity = userDao.getCountryList();
			listDto = CollectionMapper.getMappingList(countryentity.iterator(), CountryDto.class);
		}
		catch(DBException e){
			throw new ServiceException(e.getMessage(),e);
		}
		return listDto;
	}

	//	ProjectInfo Operations
	@Override
	public CompleteProfileDto createProjectInfo(List<ProjectDto> projectsList) throws ServiceException {
		CompleteProfileDto profileDto = new CompleteProfileDto();
		List<ProjectDto> projectListData = new ArrayList<ProjectDto>();
		try {
			List<ProjectEntity> entitylist = CollectionMapper.getMappingList(projectsList.iterator(), ProjectEntity.class);
			entitylist = userDao.saveOrUpdateProject(entitylist);
			projectListData = CollectionMapper.getMappingList(entitylist.iterator(), ProjectDto.class);
			profileDto.setProject(projectListData);
			
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return profileDto;
	}
	
	@Override
	public int deleteProjectByUserIdAndProjectName(Long userId, String projectName) throws ServiceException {
		int result;
		try {
			result = userDao.deleteProjectByUserIdAndType(userId, projectName);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return result;
	}

	@Override
	public ProjectDto updateProjectInfo(ProjectDto projectDto) throws ServiceException {
		ProjectDto finalDto=null;
		try {
			ProjectEntity entity = DozerBeanMapperSingletonWrapper.getInstance().map(projectDto, ProjectEntity.class);
			finalDto = DozerBeanMapperSingletonWrapper.getInstance().map(userDao.updateProject(entity),ProjectDto.class);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finalDto;
	}
	
	public List<ProjectDomainDto> getProjectDomainList() throws ServiceException{
		List<ProjectDomainDto> listdto = null;
		try{
			List<ProjectDomainEntity> entitylist = userDao.getProjectDomainList();
			 listdto = CollectionMapper.getMappingList(entitylist.iterator(), ProjectDomainDto.class);
		}catch(DBException e){
			throw new ServiceException(e.getMessage(),e);
		}
		return listdto;
	}
	
	@Override
	public List<TechnologiesDto> getAllTechnologiesList() throws ServiceException {
		try {
			List<TechnologiesEntity> list = techSkillDao.getAllTechnologies();
			List<TechnologiesDto> technologiesList = CollectionMapper.getMappingList(list.iterator(), TechnologiesDto.class);
			return technologiesList;
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getAllTechnologiesList data ");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
	}
	
	@Override
	public CompleteProfileDto createTechSkillRecord(SkillsDto skills)throws ServiceException {
		CompleteProfileDto profileDto = new CompleteProfileDto();
		SkillsDto finalSkills = new SkillsDto();
		List<TechSkillDto> techSKillListData = new ArrayList<TechSkillDto>();
		TechSkillDto finalDto = null;
		try {
			List<TechSkillEntity> listData = techSkillDao.getTechSkillRecordsByUserId(skills.getTechskills().get(0).getUser().getId());
			
			if(listData!=null){
				techSkillDao.deleteTechSkillByUserId(skills.getTechskills().get(0).getUser().getId());
			}
			UserBasicSkillsEntity userBasicSkillEntity = userDao.getUserBasicSkillsByUserId(skills.getTechskills().get(0).getUser().getId());
			
			if(userBasicSkillEntity!=null){
				userBasicSkillEntity.setAnalyticalRating(skills.getBasicSkills().getAnalyticalRating());
				userBasicSkillEntity.setCommRating(skills.getBasicSkills().getCommRating());
				
				UserBasicSkillsDto finalBasicSkills = DozerBeanMapperSingletonWrapper.getInstance().map(userDao.updateBasicSkills(userBasicSkillEntity),UserBasicSkillsDto.class);
				finalSkills.setBasicSkills(finalBasicSkills);
			}else{
				UserBasicSkillsEntity entity = DozerBeanMapperSingletonWrapper.getInstance().map(skills.getBasicSkills(),UserBasicSkillsEntity.class);
				UserBasicSkillsDto finalBasicSkills = DozerBeanMapperSingletonWrapper.getInstance().map(userDao.createBasicSkills(entity),UserBasicSkillsDto.class);
				finalSkills.setBasicSkills(finalBasicSkills);
			}
			for(int i=0;i<skills.getTechskills().size();i++){
				TechSkillEntity entity = new TechSkillEntity();
				TechnologiesEntity techEntity = new TechnologiesEntity();
				techEntity.setId(skills.getTechskills().get(i).getTechnology().getId());
				entity.setTechnology(techEntity);
				UserEntity user = new UserEntity();
				user.setId(skills.getTechskills().get(i).getUser().getId());
				entity.setUser(user);
				//TechSkillEntity entity = DozerBeanMapperSingletonWrapper.getInstance().map(skills.getBasicSkills(),TechSkillEntity.class);
				
				finalDto = DozerBeanMapperSingletonWrapper.getInstance().map(techSkillDao.createTechSkillRecord(entity),TechSkillDto.class);
				techSKillListData.add(finalDto);
			}
			
			finalSkills.setTechskills(techSKillListData);
			
			profileDto.setSkill(finalSkills);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		} 
		return profileDto;
	}

	@Override
	public TechSkillDto updateTechSkillRecord(TechSkillDto techSkillDto) throws ServiceException {
		TechSkillDto finalDto=null;
		try {
			TechSkillEntity entity = DozerBeanMapperSingletonWrapper.getInstance().map(techSkillDto, TechSkillEntity.class);
			finalDto = DozerBeanMapperSingletonWrapper.getInstance().map(techSkillDao.updateTechSkillRecord(entity),TechSkillDto.class);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finalDto;
	}

	@Override
	public List<TechSkillDto> getTechSkillRecordsByUserId(Long userId)
			throws ServiceException {
		try {
			List<TechSkillEntity> list = techSkillDao.getTechSkillRecordsByUserId(userId);
			List<TechSkillDto> techListData = CollectionMapper.getMappingList(list.iterator(), TechSkillDto.class);
			return techListData;
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getTechSkillRecordsByUserId data ");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
	}
	
	@Override
	public CompleteProfileDto getCompleteProfile(Long userId) throws ServiceException {
		CompleteProfileDto completeProfileDto=new CompleteProfileDto();
		UserEntity user= null;
		List<EducationEntity> educationList= null;
		List<ProjectEntity> projectList = null;
		List<TechSkillEntity> techSkillsList = null;
		SocialInfoEntity socialInfoEntity = null;
		List<EmployersInfoEntity> employersInfoList = null;
		UserBasicInfoEntity userBasicInfoEntity = null;
		UserExperianceEntity userExperianceInfoEntity = null;
		AddressEntity addressEntity = null;
		UserBasicSkillsEntity userBasicSkillsEntity = null;
		SkillsDto skills = new SkillsDto();
		List<UserLanguagesDto> languagesListData = null;
		List<UserLanguagesEntity> languagesEntityList = null;
		try {
			if((user= userDao.getUserDetailsById(userId))!=null){
				UserDto userdata =DozerBeanMapperSingletonWrapper.getInstance().map(user, UserDto.class);
				completeProfileDto.setUser(userdata);
				}
			if( (educationList = userDao.getEducationById(userId))!=null){
				List<EducationDto> finalEducationList = CollectionMapper.getMappingList(educationList.iterator(), EducationDto.class);
			    completeProfileDto.setEducation(finalEducationList);
			}
			if((projectList = userDao.getProjectById(userId))!=null){
				List<ProjectDto> finalProjectList = CollectionMapper.getMappingList(projectList.iterator(), ProjectDto.class);
			    completeProfileDto.setProject(finalProjectList);
			}
			if((techSkillsList = techSkillDao.getTechSkillRecordsByUserId(userId))!=null){
				List<TechSkillDto> finalSkillsList = CollectionMapper.getMappingList(techSkillsList.iterator(), TechSkillDto.class);
			    skills.setTechskills(finalSkillsList);
			}
			if((socialInfoEntity = userDao.getSocialInfoByUserId(userId))!=null){
				SocialInfoDto socialInfo =DozerBeanMapperSingletonWrapper.getInstance().map(socialInfoEntity, SocialInfoDto.class);	
				completeProfileDto.setSocial(socialInfo);
				}
			if((employersInfoList = userDao.getEmployersInfoByUserId(userId))!=null){
				List<EmployersInfoDto> finalEmpInfoList = CollectionMapper.getMappingList(employersInfoList.iterator(), EmployersInfoDto.class);
				completeProfileDto.setEmployersInfo(finalEmpInfoList);
				}
			if((userBasicInfoEntity = userDao.getUserBasicInfoById(userId))!=null){
				UserBasicInfoDto basicInfo =DozerBeanMapperSingletonWrapper.getInstance().map(userBasicInfoEntity, UserBasicInfoDto.class);	
				completeProfileDto.setUserBasicInfo(basicInfo);
				}
			if((userExperianceInfoEntity = userDao.getUserExperianceInfoById(userId))!=null){
				UserExperianceDto finalUserExperianceInfo =DozerBeanMapperSingletonWrapper.getInstance().map(userExperianceInfoEntity, UserExperianceDto.class);	
				completeProfileDto.setUserExperianceInfo(finalUserExperianceInfo);
				}
			if((addressEntity = userDao.getAddressInfoById(userId))!=null){
				AddressDto addressInfo =DozerBeanMapperSingletonWrapper.getInstance().map(addressEntity, AddressDto.class);	
				completeProfileDto.setAddress(addressInfo);
				}
			if((userBasicSkillsEntity = userDao.getUserBasicSkillsByUserId(userId))!=null){
				UserBasicSkillsDto basicSkills=DozerBeanMapperSingletonWrapper.getInstance().map(userBasicSkillsEntity, UserBasicSkillsDto.class);	
				skills.setBasicSkills(basicSkills);
			}if((languagesEntityList = userDao.getLanguagesByUserId(userId))!=null){
				languagesListData = CollectionMapper.getMappingList(languagesEntityList.iterator(), UserLanguagesDto.class);
				completeProfileDto.setLanguages(languagesListData);
			}
			completeProfileDto.setSkill(skills);
		}catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return completeProfileDto;
	}

	@Override
	public List<RoleDto> getAllRoles() throws ServiceException {
		try {
			List<RoleEntity> list = roleDao.getAllRoles();
			return CollectionMapper.getMappingList(list.iterator(), RoleDto.class);
		} catch(DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public int updateStatusAndRoleForUsers(List<Integer> userIds, Integer selectedRole, String statusString) throws ServiceException{
		int result;
		try {
			result= userDao.updateStatusAndRoleForUsers(convertIds(userIds), selectedRole.longValue(), statusString);
		} catch(DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return result;
	}
	
	private List<Long> convertIds(List<Integer> integerIds) {
		List<Long> longIds = new ArrayList<Long>();
		for(int i=0; i<integerIds.size(); i++) {
			longIds.add(integerIds.get(i).longValue());
		}
		return longIds;
	}

	@Override
	public ReferralDto createReferral(ReferralDto referralDto) throws ServiceException {
		ReferralDto finalDto=null;
		try {
			ReferralEntity entity = DozerBeanMapperSingletonWrapper.getInstance().map(referralDto, ReferralEntity.class);
			finalDto = DozerBeanMapperSingletonWrapper.getInstance().map(referralDao.createReferral(entity),ReferralDto.class);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finalDto;
	}

	@Override
	public SupportDto createSupport(SupportDto supportDto) throws ServiceException {
		SupportDto finalDto=null;
		try {
			SupportEntity entity = DozerBeanMapperSingletonWrapper.getInstance().map(supportDto, SupportEntity.class);
			finalDto = DozerBeanMapperSingletonWrapper.getInstance().map(supportDao.createSupportRecord(entity),SupportDto.class);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finalDto;
	}

	@Override
	public List<PlacementsDto> getPlacementsList() throws ServiceException {
		try {
			List<PlacementsEntity> list = placementsDao.getPlacementsList();
			return CollectionMapper.getMappingList(list.iterator(), PlacementsDto.class);
		} catch(DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<SupportDto> getAllSupportsList() throws ServiceException {
		List<SupportEntity> list;
		try {
			list = supportDao.getAllSupports();
			List<SupportDto> supportsList = CollectionMapper.getMappingList(list.iterator(), SupportDto.class);
			return supportsList;
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getAllSupportsList method");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public int addReferralData(List<ReferralDto> referralDto) throws ServiceException {
		int row; 
		try {
			List<ReferralEntity> referralList = CollectionMapper.getMappingList(referralDto.iterator(), ReferralEntity.class);
			row= referralDao.addReferralRecords(referralList);
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing Batch data ");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
		return row;
	}

	@Override
	public SubscribeDto createSubscriberInfo(SubscribeDto SubscribeDto)
			throws ServiceException {
		SubscribeDto finalDto=null;
		try {
			SubscribeEntity entity = DozerBeanMapperSingletonWrapper.getInstance().map(SubscribeDto, SubscribeEntity.class);
			finalDto = DozerBeanMapperSingletonWrapper.getInstance().map(subscriberDao.createSubscribeRecord(entity),SubscribeDto.class);
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing Subscribe record Save");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
		return finalDto;
	}

	@Override
	public List<ReferralDto> getReferralsByUserId(Long userId) throws ServiceException {
		if (log.isDebugEnabled()) {
			log.debug("Entered into getAllReferralsByUserId -->: userId["+userId+"]");
		}
		List<ReferralEntity> list;
		try {
			list = referralDao.getReferralsByUserId(userId);
			List<ReferralDto> referralsList = CollectionMapper.getMappingList(list.iterator(), ReferralDto.class);
			return referralsList;
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getAllReferralsByUserId method");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<CompleteProfileDto> getUsersListByVisibility() throws ServiceException {
		List<UserEntity> list;
		List<CompleteProfileDto> arrayList = new ArrayList<CompleteProfileDto>();

		try {
			list = userDao.getUserListByUserVisibility();
			List<UserDto> usersList = CollectionMapper.getMappingList(list.iterator(), UserDto.class);
			for(int i=0;i<usersList.size();i++){
				CompleteProfileDto completeProfileDto = getCompleteProfile(usersList.get(i).getId());
				arrayList.add(completeProfileDto);
			}
			return arrayList;
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getUsersListByVisibility method");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public SocialInfoDto createSocialInfo(SocialInfoDto socialInfoDto) throws ServiceException {
		SocialInfoDto finalDto=null;
		try {
			SocialInfoEntity entity = DozerBeanMapperSingletonWrapper.getInstance().map(socialInfoDto, SocialInfoEntity.class);
			finalDto = DozerBeanMapperSingletonWrapper.getInstance().map(userDao.createSocialInfo(entity),SocialInfoDto.class);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finalDto;
	}

	@Override
	public SocialInfoDto updateSocialInfo(SocialInfoDto socialInfoDto) throws ServiceException {
		SocialInfoDto finalDto=null;
		try {
			SocialInfoEntity entity = DozerBeanMapperSingletonWrapper.getInstance().map(socialInfoDto, SocialInfoEntity.class);
			finalDto = DozerBeanMapperSingletonWrapper.getInstance().map(userDao.updateSocialInfo(entity),SocialInfoDto.class);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finalDto;
	}

	@Override
	public CompleteProfileDto createEmployersInfo(List<EmployersInfoDto> employersInfoList) throws ServiceException {
		CompleteProfileDto profileDto = new CompleteProfileDto();
		List<EmployersInfoDto> employersListData = new ArrayList<EmployersInfoDto>();
		try {
			List<EmployersInfoEntity> entitylist = CollectionMapper.getMappingList(employersInfoList.iterator(),EmployersInfoEntity.class);
			entitylist = userDao.saveOrUpdateEmployersInfo(entitylist);
			employersListData = CollectionMapper.getMappingList(entitylist.iterator(), EmployersInfoDto.class);
			profileDto.setEmployersInfo(employersListData);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return profileDto;
	}

	@Override
	public int deleteEmployerInfoByUserIdAndType(Long userId, String empType) throws ServiceException {
		int result;
		try {
			result = userDao.deleteEmployerInfoByUserIdAndEmployerType(userId, empType);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return result;
	}
	
	@Override
	public EmployersInfoDto updateEmployersInfo(EmployersInfoDto employersInfoDto) throws ServiceException {
		EmployersInfoDto finalDto=null;
		try {
			EmployersInfoEntity entity = DozerBeanMapperSingletonWrapper.getInstance().map(employersInfoDto, EmployersInfoEntity.class);
			finalDto = DozerBeanMapperSingletonWrapper.getInstance().map(userDao.updateEmployersInfo(entity),EmployersInfoDto.class);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finalDto;
		
	}

	@Override
	public List<UserDto> getUsersListData(ArrayList<Integer> userIds) throws ServiceException {
		UserDto finalDto = null;
		List<UserDto> al = new ArrayList<UserDto>();
		for(int i=0; i<userIds.size();i++){
			UserEntity entity=null;
			try {
				entity = userDao.getUserDetailsById(Long.parseLong(userIds.get(i).toString()));
				finalDto = DozerBeanMapperSingletonWrapper.getInstance().map(entity,UserDto.class);
				finalDto.setPassword(null);
				al.add(finalDto);
			} catch (DBException e) {
				throw new ServiceException(e.getMessage(), e);
			}
			
		}
		return al;
	}

	@Override
	public CompleteProfileDto createUserBasicInfo(ProfileWithLanguageDto profileWithLanguageDto) throws ServiceException {
		CompleteProfileDto profileDto = new CompleteProfileDto();
		List<TechSkillDto> technologiesListData = new ArrayList<TechSkillDto>();
		SkillsDto skills = new SkillsDto();
		try {
			List<UserLanguagesEntity> listData = userDao.getLanguagesByUserId(profileWithLanguageDto.getUserBasicProfile().getUser().getId());
			
			if(listData.size()>0){
				userDao.deleteLanguagesByUserId(profileWithLanguageDto.getUserBasicProfile().getUser().getId());
			}
			List<UserLanguagesEntity> changedListData = new ArrayList<UserLanguagesEntity>();
			
			for(int i=0;i<profileWithLanguageDto.getUserBasicProfile().getLanguages().size();i++){
					UserLanguagesEntity entity = new UserLanguagesEntity();
					LanguageEntity langEntity = new LanguageEntity();
					langEntity.setId(profileWithLanguageDto.getUserBasicProfile().getLanguages().get(i).getLanguage().getId());
					entity.setLanguage(langEntity);
					UserEntity user = new UserEntity();
					user.setId(profileWithLanguageDto.getUserBasicProfile().getLanguages().get(i).getUser().getId());
					entity.setUser(user);
					changedListData.add(entity);
					//UserLanguagesDto finalDto = DozerBeanMapperSingletonWrapper.getInstance().map(userDao.createUserLanguagesRecord(entity),UserLanguagesDto.class);
			}
			userDao.createUserLanguagesRecord(changedListData);
			
			List<UserLanguagesEntity> userLanguagesListData = userDao.getLanguagesByUserId(profileWithLanguageDto.getUserBasicProfile().getUser().getId());
			System.out.println(userLanguagesListData);
			List<UserLanguagesDto> userLanguagesList = CollectionMapper.getMappingList(userLanguagesListData.iterator(), UserLanguagesDto.class);
			
			UserBasicInfoEntity basicInfoEntity = userDao.getUserBasicInfoById(profileWithLanguageDto.getUserBasicProfile().getUser().getId());
			if(basicInfoEntity!=null){
				basicInfoEntity.setDob(profileWithLanguageDto.getUserBasicProfile().getDob());
				basicInfoEntity.setProfileSummary(profileWithLanguageDto.getUserBasicProfile().getProfileSummary());
				basicInfoEntity.setResumePath(profileWithLanguageDto.getUserBasicProfile().getResumePath());
				basicInfoEntity.setSelfIntroVideoPath(profileWithLanguageDto.getUserBasicProfile().getSelfIntroVideoPath());
			    UserBasicInfoDto finalBasicInfoDto = DozerBeanMapperSingletonWrapper.getInstance().map(userDao.updateUserBasicInfo(basicInfoEntity),UserBasicInfoDto.class);
				profileDto.setUserBasicInfo(finalBasicInfoDto);
			}
			else{
				UserBasicInfoEntity userBasicInfoEntity = DozerBeanMapperSingletonWrapper.getInstance().map(profileWithLanguageDto.getUserBasicProfile(),UserBasicInfoEntity.class);
				UserBasicInfoDto finalBasicInfoDto = DozerBeanMapperSingletonWrapper.getInstance().map(userDao.createBasicInfo(userBasicInfoEntity),UserBasicInfoDto.class);
				profileDto.setUserBasicInfo(finalBasicInfoDto);
			}
			List<TechSkillEntity> techskillsData = techSkillDao.getTechSkillRecordsByUserId(profileWithLanguageDto.getTechskills().get(0).getUser().getId());
			
			if(techskillsData!=null){
				techSkillDao.deleteTechSkillByUserId(profileWithLanguageDto.getTechskills().get(0).getUser().getId());
			}
			for(int i=0;i<profileWithLanguageDto.getTechskills().size();i++){
				TechSkillEntity entity = new TechSkillEntity();
				TechnologiesEntity technologyEntity = new TechnologiesEntity();
				technologyEntity.setId(profileWithLanguageDto.getTechskills().get(i).getTechnology().getId());
				entity.setTechnology(technologyEntity);
				UserEntity user = new UserEntity();
				user.setId(profileWithLanguageDto.getUserBasicProfile().getUser().getId());
				entity.setUser(user);
				TechSkillDto finalDto = DozerBeanMapperSingletonWrapper.getInstance().map(techSkillDao.createTechSkillRecord(entity),TechSkillDto.class);
				technologiesListData.add(finalDto);
			}

			for(int i =0;i<userLanguagesList.size();i++){
				LanguageEntity lentity= userDao.getLanguagesbylanguageid(userLanguagesList.get(i).getLanguage().getId());
				LanguagesDto ldto = DozerBeanMapperSingletonWrapper.getInstance().map(lentity, LanguagesDto.class);
				userLanguagesList.get(i).setLanguage(ldto);
			}
			profileDto.setLanguages(userLanguagesList);
			for(int t=0;t<technologiesListData.size();t++){
				TechnologiesEntity tentity = userDao.gettechnologiesbytechid(technologiesListData.get(t).getTechnology().getId());
			TechnologiesDto tdto = DozerBeanMapperSingletonWrapper.getInstance().map(tentity, TechnologiesDto.class);
			technologiesListData.get(t).setTechnology(tdto);
			}
			skills.setTechskills(technologiesListData);
			
			profileDto.setSkill(skills);
			
		}catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return profileDto;
	}
		

	@Override
	public UserBasicInfoDto updateUserBasicInfo(UserBasicInfoDto basicInfoDto) throws ServiceException {
		UserBasicInfoDto finalDto=null;
		try {
			UserBasicInfoEntity entity = DozerBeanMapperSingletonWrapper.getInstance().map(basicInfoDto, UserBasicInfoEntity.class);
			finalDto = DozerBeanMapperSingletonWrapper.getInstance().map(userDao.updateUserBasicInfo(entity),UserBasicInfoDto.class);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finalDto;
	}

	@Override
	public int updateMobileNoByUserId(Long userId, String mobileNo) throws ServiceException {
		int row = 0;
		try {
			row = userDao.updateUserMobileNoByUserId(userId, mobileNo);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return row;
	}

	@Override
	public UserExperianceDto createUserExperianceInfo(UserExperianceDto userExperianceDto) throws ServiceException {
		UserExperianceDto finalDto=null;
		try {
			UserExperianceEntity entity = DozerBeanMapperSingletonWrapper.getInstance().map(userExperianceDto, UserExperianceEntity.class);
			finalDto = DozerBeanMapperSingletonWrapper.getInstance().map(userDao.createUserExperianceInfo(entity),UserExperianceDto.class);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finalDto;
	}
	
	@Override
	public UserExperianceDto getUsersBySalaryRange(String curentSalary) throws ServiceException {
		UserExperianceDto usersDto=null;
		try {
			usersDto = DozerBeanMapperSingletonWrapper.getInstance().map(userDao.getUsersBySalaryRange(curentSalary),UserExperianceDto.class);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return usersDto;
	}
	
	@Override
	public EducationDto getUsersByQualification(String qualification) throws ServiceException {
		EducationDto usersDto=null;
		/*try {
			usersDto = DozerBeanMapperSingletonWrapper.getInstance().map(userDao.getUsersByQualification(qualification),EducationDto.class);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}*/
		return usersDto;
	}
	
	@Override
	public EducationDto getUsersBypercentage(Float percentage) throws ServiceException {
		EducationDto usersDto=null;
		/*try {
			usersDto = DozerBeanMapperSingletonWrapper.getInstance().map(userDao.getUsersByPercentage(percentage),EducationDto.class);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}*/
		return usersDto;
	}

	@Override
	public UserExperianceDto updateUserExperianceInfo(
			UserExperianceDto userExperianceDto) throws ServiceException {
		UserExperianceDto finalDto=null;
		try {
			UserExperianceEntity entity = DozerBeanMapperSingletonWrapper.getInstance().map(userExperianceDto, UserExperianceEntity.class);
			finalDto = DozerBeanMapperSingletonWrapper.getInstance().map(userDao.updateUserExperianceInfo(entity),UserExperianceDto.class);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finalDto;
	}

	@Override
	public List<CompleteProfileDto> getUsersListByRole() throws ServiceException {
		try {
			List<CompleteProfileDto> completeProfile= new ArrayList<CompleteProfileDto>();
			List<UserEntity> list = userDao.getUserListByRole();
			List<UserDto> userList = CollectionMapper.getMappingList(list.iterator(), UserDto.class);
			for(int i=0;i<userList.size();i++){
				List<PurchasedCourseEntity> courseList = purchasedCourseDao.getPurchasedCoursesByUserId(userList.get(i).getId());
				List<PurchasedCourseDto> finalPurCourseList = CollectionMapper.getMappingList(courseList.iterator(), PurchasedCourseDto.class);
				CompleteProfileDto finalProfileDto = new CompleteProfileDto();
				finalProfileDto.setUser(userList.get(i));
				finalProfileDto.setPurchaseCourseDto(finalPurCourseList);
				completeProfile.add(finalProfileDto);
			}
			return completeProfile;
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing quizList data ");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public int updateUserPasswordByEmailId(String emailId, String password) throws ServiceException {
		int row = 0;
		try {
			byte[] finalData2 = new BASE64Decoder().decodeBuffer(emailId);
			row = userDao.updatePasswordByEmailId(new String(finalData2), password);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}catch (Exception e1) {
			throw new ServiceException(e1.getMessage(), e1);
		}
		return row;
	}

	@Override
	public TechSkillDto getTechSkillRecordsByUserIdAndTechId(Long userId,Long techId) throws ServiceException {
		try{
			TechSkillEntity entity = techSkillDao.getTechSkillRecordByUserIdAndTechId(userId, techId);
			TechSkillDto finalDto=DozerBeanMapperSingletonWrapper.getInstance().map(entity, TechSkillDto.class);
			return finalDto;
			}catch(DBException e){
				throw new ServiceException(e.getMessage(),e);
			}
	}

	@Override
	public UserBasicSkillsDto createBasicSkillRecord(UserBasicSkillsDto basicSkillsDto) throws ServiceException {
		UserBasicSkillsDto finalDto=null;
		try {
			UserBasicSkillsEntity entity = DozerBeanMapperSingletonWrapper.getInstance().map(basicSkillsDto, UserBasicSkillsEntity.class);
			finalDto = DozerBeanMapperSingletonWrapper.getInstance().map(userDao.createBasicSkills(entity),UserBasicSkillsDto.class);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finalDto;
	}

	@Override
	public UserBasicSkillsDto updateBasicSkillRecord(UserBasicSkillsDto basicSkillsDto) throws ServiceException {
		UserBasicSkillsDto finalDto=null;
		try {
			UserBasicSkillsEntity entity = DozerBeanMapperSingletonWrapper.getInstance().map(basicSkillsDto, UserBasicSkillsEntity.class);
			finalDto = DozerBeanMapperSingletonWrapper.getInstance().map(userDao.updateBasicSkills(entity),UserBasicSkillsDto.class);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finalDto;
	}

	@Override
	public UserBasicSkillsDto getUserBasicSkillsByUserId(Long userId)throws ServiceException {
		try{
			UserBasicSkillsEntity entity = userDao.getUserBasicSkillsByUserId(userId);
			UserBasicSkillsDto finalDto=DozerBeanMapperSingletonWrapper.getInstance().map(entity, UserBasicSkillsDto.class);
			return finalDto;
		} catch(DBException e){
				throw new ServiceException(e.getMessage(),e);
			}
	}

	@Override
	public List<LanguagesDto> getAllLanguagesList() throws ServiceException {
		try {
			List<LanguageEntity> list = userDao.getAllLanguages();
			List<LanguagesDto> technologiesList = CollectionMapper.getMappingList(list.iterator(), LanguagesDto.class);
			return technologiesList;
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getAllLanguagesList data ");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
	}
	
	public List<UserSearchResultsDto> getuserslistbysearchpreference(UserSearchDto userSearchDto) throws ServiceException {
		/*ArrayList<UserSearchResultsEntity> newusersearchentity = new ArrayList<UserSearchResultsEntity>();*/
		/*Integer z = 0;
		long x = z.longValue();*/
		
		try {
		/*	newusersearchentity.get(0).setId(x);*/
				List<UserSearchResultsEntity> usersearchentity = userDao.getusersearch(userSearchDto);
			/*	for(int k=0;k<usersearchentity.size();k++){
					for(int m=0;m<newusersearchentity.size();m++){
						if(newusersearchentity.get(m).getId() != usersearchentity.get(k).getId()){
							newusersearchentity.add(newusersearchentity.get(m));
						}
					}
					
				}*/
				List<UserSearchResultsDto> usersearchresultdtolist = CollectionMapper.getMappingList(usersearchentity.iterator(), UserSearchResultsDto.class);
				for(int i=0;i<usersearchresultdtolist.size();i++){
					if(usersearchresultdtolist.get(i).getCityID() != null){
						CityEntity cityEntity = userDao.getcityInfoById(usersearchresultdtolist.get(i).getCityID());
						CityDto citydto = DozerBeanMapperSingletonWrapper.getInstance().map(cityEntity, CityDto.class);
						usersearchresultdtolist.get(i).setCity(citydto);
					}
					/*if(usersearchresultdtolist.get(i).getTechSkillId() != null){
						TechnologiesEntity techentity = userDao.gettechnologiesbytechid(usersearchresultdtolist.get(i).getTechSkillId());
						TechnologiesDto techdto = DozerBeanMapperSingletonWrapper.getInstance().map(techentity, TechnologiesDto.class);
						usersearchresultdtolist.get(i).setTechskill(techdto);
					}*/
				}
				return usersearchresultdtolist;
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing UserSearchDto data ");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
	}
	
	
}
