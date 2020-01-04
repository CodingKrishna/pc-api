
package org.pioneercoders.dao.user.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.dao.Interview.InterviewDao;
import org.pioneercoders.dao.user.UserDao;
import org.pioneercoders.dto.hr.UserSearchDto;
import org.pioneercoders.dto.user.UserDto;
import org.pioneercoders.entity.Interview.InterviewAssignToUsersEntity;
import org.pioneercoders.entity.Interview.InterviewGroupsCandidatesEntity;
import org.pioneercoders.entity.Interview.SelectedGroupsForInterviewEntity;
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
import org.pioneercoders.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	InterviewDao inteviewDao;
	
	private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);
	
	
	public List<ProjectEntity> saveOrUpdateProject(List<ProjectEntity> profileEntitylist) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			for(ProjectEntity project :profileEntitylist){
				session.saveOrUpdate(project);
			}
			session.flush();
		} catch(Exception e){
			throw new DBException(e.getMessage(),e);
			
		}
		return profileEntitylist;
	}
	
	/* (non-Javadoc)
	 * @see org.pioneercoders.dao.user.UserDao#saveOrUpdateEducation(java.util.List)
	 */
	public List<EducationEntity> saveOrUpdateEducation(List<EducationEntity> educationEntityList) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			for(EducationEntity education :educationEntityList){
				session.saveOrUpdate(education);
			}
			session.flush();
		} catch(Exception e){
			throw new DBException(e.getMessage(),e);
			
		}
		return educationEntityList;
	}
	
	@Override
	public InstituteEntity getinstitutedetailsbyid(Long Id) throws DBException{
		if(log.isDebugEnabled()) {
			log.debug("getInstituteDetailsbyid id["+Id+"]");
		}
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "from InstituteEntity where Id=:Id";
			Query query= session.createQuery(hql);
			query.setParameter("Id", Id);
			return (InstituteEntity) query.uniqueResult();
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while retrieve getInstituteDetails ");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		} 
	}
	
	@Override
	public UniversityEntity getuniversitydetailsbyid(Long Id) throws DBException{
		if(log.isDebugEnabled()) {
			log.debug("getUniversityDetailsbyid id["+Id+"]");
		}
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "from UniversityEntity where Id=:Id";
			Query query= session.createQuery(hql);
			query.setParameter("Id", Id);
			return (UniversityEntity) query.uniqueResult();
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing getuniversitydetailsbyid");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
	}
	
	
	public List<EmployersInfoEntity> saveOrUpdateEmployersInfo(List<EmployersInfoEntity> employersInfoEntityList) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			for(EmployersInfoEntity employersInfo :employersInfoEntityList){
				session.saveOrUpdate(employersInfo);
			}
			session.flush();
		} catch(Exception e){
			throw new DBException(e.getMessage(),e);
		}
		return employersInfoEntityList;
}


	//userdaoimpl
	@Override
	public UserEntity createUser(UserEntity userEntity) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			userEntity.setId((Long)session.save(userEntity));
		} catch(Exception e){
			if(log.isErrorEnabled()) {
				 log.error("Exception Occred while creating user  Record ["+userEntity.getEmailId()+"] ["+userEntity.getUserName()+"]");
				 log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
		if(log.isDebugEnabled()) {
			log.debug("User Record inserted with id ["+userEntity.getId()+"] ["+userEntity.getEmailId()+"] ["+userEntity.getUserName()+"]");
		}
		return userEntity;

	}

	/**
	 * this method is details by passing email id and password.
	 * @param email id 
	 * @param password
	 */
	@Override
	public UserEntity getUserDetails(String emailId, String password) throws DBException{
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "from UserEntity where emailId=:emailId and password=:password and status='"+Constants.STATUS_ACTIVE+"'";
			Query query= session.createQuery(hql);
			query.setParameter("emailId", emailId);
			query.setParameter("password", password);
			return (UserEntity) query.uniqueResult();
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while loggin with UserDetails emailId["+emailId+"]");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
	}
	
	@Override
	public UserEntity getUserDetailsByEmailOrMobile(String emailId, String mobile) throws DBException{
		if(log.isDebugEnabled()) {
			log.debug("getUserDetailsByEmailOrMobile  emailId:["+emailId+"] mobile["+mobile+"]");
		}
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "from UserEntity where emailId=:emailId or mobileNo=:mobile";
			Query query= session.createQuery(hql);
			query.setParameter("emailId", emailId);
			query.setParameter("mobile", mobile);
			return (UserEntity) query.uniqueResult();
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing UserDetails");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
	}

	@Override
	public UserEntity getUserDetailsById(Long id) throws DBException {
		if(log.isDebugEnabled()) {
			log.debug("getUserDetailsById id :["+id+"]");
		}
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query= session.createQuery("from UserEntity where id=:id");
			query.setParameter("id", id);
			return (UserEntity) query.uniqueResult();
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing UserDetailsById for the user id: ["+id+"]");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		} 
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> getUserList(String status) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql=null;
			if(status.equals("all")){
				hql = "from UserEntity u";
			} else if(status.equals("ACTIVE")){
				hql = "from UserEntity u where u.status='"+Constants.STATUS_ACTIVE+"'";
			} else if(status.equals("PENDING")){
				hql = "from UserEntity u where u.status='"+Constants.STATUS_PENDING+"'";
			}
			Query query = session.createQuery(hql);
			return query.list();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing UserList Method");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}


	@Override
	public UserEntity updateUser(UserEntity entity) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(entity);
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while updating user  Record ["+entity.getEmailId()+"] ["+entity.getUserName()+"]");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
		if(log.isDebugEnabled()){
			log.debug("User Record is updated with id ["+entity.getId()+"] ["+entity.getEmailId()+"] ["+entity.getUserName()+"]");
		}
		return entity;
	}
	
	@Override
	public void activateUserStatusById(Long id,Long roleId) throws DBException {
		if(log.isDebugEnabled()){
			log.debug("activateUserStatusById id ["+id+"] roleId["+roleId+"]");
		}
		try {
			if(roleId==null){
				roleId=1l;
			}
			Session session = sessionFactory.getCurrentSession();
			Query query= session.createQuery("update UserEntity set status='"+Constants.STATUS_ACTIVE+"',role.id="+roleId+"  where id="+id);
			query.executeUpdate();
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing ActivationUser by id");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
	}
	
	@Override
	public int updateUserInterviewDetailsByUserId(Long userId,String interviewStatus,Boolean reShedule, Date interviewDate,String interviewTiming) throws DBException {
		int row=0;
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("update UserEntity set reShedule =:reShedule, interviewDate =:interviewDate, interviewTiming=:interviewTiming, interviewStatus=:interviewStatus where id=:id");
			query.setParameter("reShedule", reShedule);
			query.setParameter("interviewDate", interviewDate);
			query.setParameter("interviewTiming", interviewTiming);
			query.setParameter("id", userId);
			query.setParameter("interviewStatus", interviewStatus);
			row = query.executeUpdate();
			
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing Update UserDetails by userId["+userId+"]");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
		return row;
	}
	
	@Override
	public UserEntity updateUserIsVisibleById(Boolean isVisible,Long userId) throws DBException {
		int id=0;
		UserEntity userEntity = null;
		if(log.isDebugEnabled()) {
			log.debug("UpdateUserVisibility by user id["+userId+"] and isVisible["+isVisible+"]");
		}
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("update UserEntity set isVisible="+isVisible+" where id="+userId);
			id = query.executeUpdate();
			if(id!=0){
				Query query1 = session.createQuery("from UserEntity where id="+userId);
				userEntity = (UserEntity) query1.uniqueResult();
			}
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing UpdateUserVisibility by userId userId["+userId+"] isVisible["+isVisible+"]");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		} 
		return userEntity;
	}

	@Override
	public UserEntity updateUserByBasicInfo(UserEntity userEntity) throws DBException {
		if(log.isDebugEnabled()) {
			log.debug("updateUserByBasicInfo for the user id"+userEntity.getId());
		}
		Query query =null;//, selfIntroVideoPath =:selfIntroVideoPath 
		int row =0;
		try {
			Session session = sessionFactory.getCurrentSession();
			query = session.createQuery("update UserEntity set profileSummary=:profileSummary, resumePath=:resumePath, dob=:dob, exp=:exp where id=:id");
			//query.setParameter("profileSummary", userEntity.getProfileSummary());
			//query.setParameter("selfIntroVideoPath", userEntity.getSelfIntroVideoPath());
			//query.setParameter("resumePath", userEntity.getResumePath());
			//query.setParameter("dob", userEntity.getDob());
			//query.setParameter("exp", userEntity.getExp());
			//query.setParameter("id", userEntity.getId());
			row = query.executeUpdate();
			if(row>0){
				UserEntity finalUserEntity= getUserDetailsById(userEntity.getId());
				return finalUserEntity;
			}

		} catch(Exception e) {
			if(log.isErrorEnabled()){
				//log.error("Exception Occred while executing Update UserDetails by ProfileSummery"+userEntity.getProfileSummary()+", selfIntroVedioPath "+ userEntity.getSelfIntroVideoPath());
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		} 
		return userEntity;
	}


	
//	education details 
	@Override
	public EducationEntity createEducation(EducationEntity entity) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			entity.setId((Long)session.save(entity));
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while creating Education  Record ");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
		if(log.isDebugEnabled()) {
			log.debug("Education Record inserted with id ["+entity.getId()+"]");
		}
		return entity;
	}

	@Override
	public EducationEntity updateEducation(EducationEntity entity) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(entity);
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while updating user  Record ");
				log.error(e.getMessage());
			}
		}  
		if(log.isDebugEnabled()) {
			log.debug("User Record is updated with id ["+entity.getId()+"]");
		}
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EducationEntity> getEducationById(Long userId) throws DBException {
		if(log.isDebugEnabled()){
			log.debug("getEducationById userId["+userId+"]");
		}
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query= session.createQuery("from EducationEntity where user.id=:userId");
			query.setParameter("userId", userId);
			return query.list();
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing EducationListId");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<InstituteEntity> getInstituteList() throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query= session.createQuery("from InstituteEntity");
			return query.list();
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing InstituteEntity");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UniversityEntity> getUniversityList() throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query= session.createQuery("from UniversityEntity");
			return query.list();
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing UniversityEntity");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
	}

	@Override
	public EducationEntity getEducationInfoByUserIdAndType(Long userId,String educationType) throws DBException {
		if(log.isDebugEnabled()){
			log.debug("getEducationInfoByUserIdAndType userId["+userId+"] educationType["+educationType+"]");
		}
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query= session.createQuery("from EducationEntity where educationType=:educationType and user.id=:userId");
			query.setParameter("userId", userId);
			query.setParameter("educationType",educationType);
			return (EducationEntity) query.uniqueResult();
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing EducationInfoByUserId and EducationType");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
	}
	
	@Override
	public int deleteEducationByUserIdAndType(Long userId, String educationType) throws DBException {
		if(log.isDebugEnabled()){
			log.debug("deleteEducationByUserIdAndType userId["+userId+"] educationType["+educationType+"]");
		}
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query= session.createQuery("delete from EducationEntity where educationType=:educationType and user.id=:userId");
			query.setParameter("userId", userId);
			query.setParameter("educationType",educationType);
			return query.executeUpdate();
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occred while Deleting Education By userId and EducationType");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
	}
	
	//address related Methods
	@Override
	public AddressEntity createAddress(AddressEntity entity) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			if(entity.getId()!=null){
				session.update(entity);
			}else{
				entity.setId((Long)session.save(entity));
			}
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while creating Address  Record ");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
		if(log.isDebugEnabled()) {
			log.debug("Education Record inserted with id ["+entity.getId()+"]");
		}
		return entity;
	}


	@Override
	public AddressEntity updateAddress(AddressEntity entity) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(entity);
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while updating address  Record ");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}  
		if(log.isDebugEnabled()) {
			log.debug("Address Record is updated with id ["+entity.getId()+"]");
		}
		return entity;
	}

	
	@Override
	public AddressEntity getAddressInfoById(Long userId) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query= session.createQuery("from AddressEntity where user.id=:userId");
			query.setParameter("userId", userId);
			return (AddressEntity) query.uniqueResult();
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing AddressInfoById");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
				
		}
	}
	
	@Override
	public CityEntity getcityInfoById(Long Id) throws DBException {
		if(log.isDebugEnabled()){
			log.debug("getcityInfoById city id["+Id+"]");
		}
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query= session.createQuery("from CityEntity where id=:Id");
			query.setParameter("Id", Id);
			return (CityEntity) query.uniqueResult();
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing cityInfoById");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CityEntity> getCityList() throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query= session.createQuery("from CityEntity");
			return query.list();
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing CityEntity");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<StateEntity> getStateList() throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query= session.createQuery("from StateEntity");
			return query.list();
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing StateEntity");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
	}
	
	@Override
	public StateEntity getstateInfoById(Long Id) throws DBException {
		if(log.isDebugEnabled()){
			log.debug("getstateInfoById id["+Id+"]");
		}
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query= session.createQuery("from StateEntity where id=:Id");
			query.setParameter("Id", Id);
			return (StateEntity) query.uniqueResult();
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing stateInfoById");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CountryEntity> getCountryList() throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query= session.createQuery("from CountryEntity");
			return query.list();
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing CountryEntity");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
	}
	
	@Override
	public CountryEntity getcountryInfoById(Long Id) throws DBException {
		if(log.isDebugEnabled()){
			log.debug("getcountryInfoById id["+Id+"]");
		}
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query= session.createQuery("from CountryEntity where id=:Id");
			query.setParameter("Id", Id);
			return (CountryEntity) query.uniqueResult();
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing countryInfoById");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
	}
	
    // project related Methods
	@Override
	public ProjectEntity createProject(ProjectEntity entity) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			entity.setId((Long)session.save(entity));
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while creating Project Record ");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
			
		} if(log.isDebugEnabled()) {
			log.debug("Project Record inserted with id ["+entity.getId()+"]");
		}
		return entity;
	}
	
	
	@Override
	public ProjectEntity updateProject(ProjectEntity entity) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(entity);
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while updating Project  Record ");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
			
		} if(log.isDebugEnabled()) {
			log.debug("Project Record is updated with id ["+entity.getId()+"]");
		}
		return entity;
	}
	
	@Override
	public int deleteProjectByUserIdAndType(Long userId, String projectName)
			throws DBException {
		if(log.isDebugEnabled()){
			log.debug("deleteProjectByUserIdAndType userId["+userId+"] projectName["+projectName+"]");
		}
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query= session.createQuery("delete from ProjectEntity where projectTitle=:projectTitle and user.id=:userId");
			query.setParameter("userId", userId);
			query.setParameter("projectTitle",projectName);
			return query.executeUpdate();
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occred while Deleting Project By userId and EducationType");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProjectEntity> getProjectById(Long userId) throws DBException {
		if(log.isDebugEnabled()){
			log.debug("getProjectById userId["+userId+"]");
		}
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query= session.createQuery("from ProjectEntity where user.id=:userId");
			query.setParameter("userId", userId);
			return query.list();
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing ProjectListId");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<ProjectDomainEntity> getProjectDomainList()throws DBException{
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query= session.createQuery("from ProjectDomainEntity");
			return query.list();
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing ProjectDomainEntity");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
	}
	
	@Override
	public ProjectEntity getProjectInfoByUserIdAndProjectName(Long userId, String projectName) throws DBException {
		if(log.isDebugEnabled()){
			log.debug("getProjectInfoByUserIdAndProjectName userId["+userId+"] projectName["+projectName+"]");
		}
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query= session.createQuery("from ProjectEntity where projectTitle=:projectTitle and user.id=:userId");
			query.setParameter("userId", userId);
			query.setParameter("projectTitle",projectName);
			return (ProjectEntity) query.uniqueResult();
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing getProjectInfoByUserIdAndProjectName methode");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
	}

	// Quiz related Methods
	
	@Override
	public int updateStatusAndRoleForUsers(List<Long> userIds, Long selectedRoleId, String statusString) throws DBException {
		if(log.isDebugEnabled()){
			log.debug("updateStatusAndRoleForUsers userIds["+userIds+"] selectedRoleId["+selectedRoleId+"] statusString["+statusString+"]");
		}
		int updatedCount =0;
		try {
			Session session = sessionFactory.getCurrentSession();
			String queryString = "update UserEntity set status = :newStatus";
			if(selectedRoleId != 0) {
				queryString += ", role.id = :roleId";
			}
			queryString += " where id in (:userIds)";
			Query query = session.createQuery(queryString);
			query.setParameter("newStatus", statusString);
			if(selectedRoleId !=0){
			
				query.setParameter("roleId", selectedRoleId.longValue());
			
			}
			query.setParameterList("userIds", userIds);
			
			updatedCount = query.executeUpdate();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing QuizList Method");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
		
		return updatedCount;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> getUserListByUserVisibility() throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from UserEntity where isVisible is true and (ratingValue ='Good' or ratingValue='Excellent')");
			System.out.println(query.list());
			return query.list();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing UserListByIsVisibility Method");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}


	@Override
	public SocialInfoEntity createSocialInfo(SocialInfoEntity entity) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			entity.setId((Long)session.save(entity));
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while creating SocialInfo Record ["+entity.getSkypeId()+"]");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
			
		} 
		
		if(log.isDebugEnabled()) {
			log.debug("SocialInfo Record inserted with id ["+entity.getId()+"] ["+entity.getSkypeId()+"]");
		}
		return entity;
	}


	@Override
	public SocialInfoEntity updateSocialInfo(SocialInfoEntity entity) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(entity);
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while updating SocialInfo  Record ");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}  
		if(log.isDebugEnabled()) {
			log.debug("SocialInfo Record is updated with id ["+entity.getId()+"]");
		}
		return entity;
	}


	@Override
	public SocialInfoEntity getSocialInfoByUserId(Long userId) throws DBException {
		if(log.isDebugEnabled()){
			log.debug("getSocialInfoByUserId userId["+userId+"]");
		}
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query= session.createQuery("from SocialInfoEntity where user.id=:userId");
			query.setParameter("userId", userId);
			return (SocialInfoEntity) query.uniqueResult();
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing SocialInfoByUserId Method");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
	}

	@Override
	public Boolean setExamCompleted(Long userId) throws DBException {
		if (log.isDebugEnabled()) {
			log.debug("setExamCompleted for userId" + userId);
		}
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session
					.createQuery("update  UserEntity set examCompleted=true  where id = "
							+ userId);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception Occred while updating UserEntity Id"
						+ userId);
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}

	@Override
	public UserBasicInfoEntity createBasicInfo(UserBasicInfoEntity entity)
			throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			entity.setId((Long)session.save(entity));
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while creating UserBasicInfo Record ");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
			
		} 
		if(log.isDebugEnabled()) {
			log.debug("UserBasicInfo Record inserted with id ["+entity.getId()+"]");
		}
		return entity;
	}

	@Override
	public UserBasicInfoEntity updateUserBasicInfo(UserBasicInfoEntity entity)
			throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(entity);
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while updating BasicInfo  Record ");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
			
		} 
		if(log.isDebugEnabled()) {
			log.debug("BasicInfo Record is updated with id ["+entity.getId()+"]");
		}
		return entity;
	}


	@Override
	public UserBasicInfoEntity getUserBasicInfoById(Long userId) throws DBException {
		if(log.isDebugEnabled()){
			log.debug("getUserBasicInfoById for userId["+userId+"]");
		}
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query= session.createQuery("from UserBasicInfoEntity where user.id=:userId");
			query.setParameter("userId", userId);
			return (UserBasicInfoEntity) query.uniqueResult();
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing getUserBasicInfoById");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
	}


	@Override
	public int updateUserMobileNoByUserId(Long userId,String mobileNo) throws DBException {
		int row=0;
		if(log.isDebugEnabled()) {
			log.debug("UpdateUserMobileNo By UserId["+userId+"] mobileNo["+mobileNo+"]");
		}
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("update UserEntity set mobileNo =:mobileNo where id=:id");
			query.setParameter("mobileNo", mobileNo);
			query.setParameter("id", userId);
			row = query.executeUpdate();
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing Update UserMobileNo by userid ["+userId+"] mobile no["+mobileNo+"]");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		} 
		return row;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> getUsersListByExamCompleted() throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from UserEntity u where u.examCompleted is true");
			return query.list();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing UserList Method");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}

	@Override
	public UserExperianceEntity createUserExperianceInfo(UserExperianceEntity entity) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			entity.setId((Long)session.save(entity));
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while creating createUserExperianceInfo Record ");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
			
		} 
		if(log.isDebugEnabled()) {
			log.debug("UserExperianceInfo Record inserted with id ["+entity.getId()+"]");
		}
		return entity;
	}


	@Override
	public UserExperianceEntity updateUserExperianceInfo(UserExperianceEntity entity) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(entity);
		}catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while updating UserExperianceInfo  Record ");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
			
		} 
		if(log.isDebugEnabled()) {
			log.debug("UserExperianceInfo Record is updated with id ["+entity.getId()+"]");
		}
		return entity;
	}


	@Override
	public UserExperianceEntity getUserExperianceInfoById(Long userId)throws DBException {
		if(log.isDebugEnabled()){
			log.debug("getUserExperianceInfoById user Id["+userId+"]");
		}
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query= session.createQuery("from UserExperianceEntity where user.id=:userId");
			query.setParameter("userId", userId);
			return (UserExperianceEntity) query.uniqueResult();
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing getTotalExperianceById");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserExperianceEntity> getUsersBySalaryRange(String curentSalary) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from ExpectationsEntity where curentSalary = "+curentSalary );
			return query.list();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing ExpectationsEntity Method");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EducationEntity> getUsersByQualification(String qualification) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from EducationEntity where educationType = "+qualification );
			return query.list();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing EducationEntity Method");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EducationEntity> getUsersByPercentage(Float percentage) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from EducationEntity where percentage = "+percentage );
			return query.list();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing EducationEntity Method");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> getUserListByRole() throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from UserEntity u where u.role.id=4");
			return query.list();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing UserList Method");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}

	@Override
	public int updatePasswordByEmailId(String emailId, String password) throws DBException {
		if(log.isDebugEnabled()) {
			log.debug("updatePasswordByEmailId emailId["+emailId+"]");
		}
		int row=0;
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("update UserEntity set password =:password where emailId=:emailId");
			query.setParameter("password", password);
			query.setParameter("emailId", emailId);
			row = query.executeUpdate();
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing Update UserPassword by EmailId");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		} 
		return row;
	}


	@Override
	public int deleteSkillsetTrnRecord(Long id) throws DBException {
		if(log.isDebugEnabled()){
			log.debug("delete SkillsetTrn Record By Id ["+id+"]");
		}
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query= session.createQuery("delete from SkillsetTrnEntity where id=:id");
			query.setParameter("id",id);
			return query.executeUpdate();
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occred while Deleting SKillTrnRecord By Id"+id);
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
	}


	@Override
	public UserBasicSkillsEntity createBasicSkills(UserBasicSkillsEntity entity)
			throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			Long id = (Long) session.save(entity);
			entity.setId(id);
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occred while creating UserBasicSkill Records ["+entity.getAnalyticalRating()+"]");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
		if(log.isDebugEnabled()){
			log.debug("Refferal Record is inserted with id ["+entity.getCommRating()+"] ["+entity.getAnalyticalRating()+"]");
		}
		return entity;
	}

	@Override
	public UserBasicSkillsEntity updateBasicSkills(UserBasicSkillsEntity entity)throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(entity);
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while updating UserBasicSkill  Record ");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
			
		} 
		if(log.isDebugEnabled()) {
			log.debug("UserBasicSkill Record is updated with id ["+entity.getId()+"]");
		}
		return entity;
	}


	@Override
	public UserBasicSkillsEntity getUserBasicSkillsByUserId(Long userId)throws DBException {
		if(log.isDebugEnabled()){
			log.debug("getUserBasicSkillsByUserId userid["+userId+"]");
		}
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query= session.createQuery("from UserBasicSkillsEntity where user.id=:userId");
			query.setParameter("userId", userId);
			return (UserBasicSkillsEntity) query.uniqueResult();
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing getUserBasicSkillsByUserId");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
	}


	@Override
	public EmployersInfoEntity createEmployersInfo(
			EmployersInfoEntity entity) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			entity.setId((Long)session.save(entity));
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while creating EmployerInfoEntity Record ["+entity.getEmployer()+"]");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
			
		} 
		if(log.isDebugEnabled()) {
			log.debug("WorkExperianceInfo Record inserted with id ["+entity.getId()+"] ["+entity.getEmployer()+"]");
		}
		return entity;
	}


	@Override
	public EmployersInfoEntity updateEmployersInfo(EmployersInfoEntity entity) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(entity);
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while updating Employers Info Record ");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
			
		}  
		if(log.isDebugEnabled()) {
			log.debug("WorkExperiace Info Record is updated with id ["+entity.getId()+"]");
		}
		return entity;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<EmployersInfoEntity> getEmployersInfoByUserId(Long userId)
			throws DBException {
		if(log.isDebugEnabled()){
			log.debug("WorkExperianceInfoByUserId userId["+userId+"]");
		}
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query= session.createQuery("from EmployersInfoEntity where user.id=:userId");
			query.setParameter("userId", userId);
			return query.list();
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing EmployersInfoEntity Method");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
	}

	@Override
	public EmployersInfoEntity getEmployersInfoByUserIdAndType(Long userId, String employerStatus) throws DBException {
		if(log.isDebugEnabled()){
			log.debug("getWorkExpByUserIdAndType userId["+userId+"] employerStatus["+employerStatus+"]");
		}
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query= session.createQuery("from EmployersInfoEntity where employerStatus=:employerStatus and user.id=:userId");
			query.setParameter("userId", userId);
			query.setParameter("employerStatus",employerStatus);
			return (EmployersInfoEntity) query.uniqueResult();
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing getWorkExp By UserId And Type");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
	}
	
	@Override
	public int deleteEmployerInfoByUserIdAndEmployerType(Long userId, String empType) throws DBException {
		if(log.isDebugEnabled()){
			log.debug("delete WorkExp Record By UserId userId["+userId+"] empType["+empType+"]");
		}
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query= session.createQuery("delete from EmployersInfoEntity where employerStatus=:employerStatus and user.id=:userId");
			query.setParameter("userId", userId);
			query.setParameter("employerStatus",empType);
			return query.executeUpdate();
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occred while Deleting WorkExp By userId and empType");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<LanguageEntity> getAllLanguages() throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			String queryString = "from LanguageEntity";
			Query query = session.createQuery(queryString);
			return query.list();
		}catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getAllLanguagesList Metthode ");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}


	@Override
	public void createUserLanguagesRecord(List<UserLanguagesEntity> userLanguagesList) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			for(int i=0;i<userLanguagesList.size();i++){
				
				session.save(userLanguagesList.get(i));
				/*if( i % 10 == 0 ) // Same as the JDBC batch size
				{ 
					
				}*/
			}
			session.flush();
		}catch(Exception e){
			throw new DBException(e.getMessage(),e);
		}
	}

	@Override
	public UserLanguagesEntity updateUserLanguagesRecord(UserLanguagesEntity userLanguagesEntity) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(userLanguagesEntity);
		}catch(Exception e){
			
			if(log.isErrorEnabled()){
				log.error("Exception Occred while creating Langualg Trn  Records ["+userLanguagesEntity.getUser().getId()+"]");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
		return userLanguagesEntity;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<UserLanguagesEntity> getLanguagesByUserId(Long userId)throws DBException {
		if(log.isDebugEnabled()){
			log.debug("getLanguagesByUserId userId["+userId+"]");
		}
		try {
			Session session = sessionFactory.getCurrentSession();
			String queryString = "from UserLanguagesEntity where user.id="+userId;
			Query query = session.createQuery(queryString);
			return query.list();
		}catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getLanguagesByUserId method having id"+userId);
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}
	
	public LanguageEntity getLanguagesbylanguageid(Long languageid)throws DBException {
		if(log.isDebugEnabled()){
			log.debug("getLanguagesbylanguageid languageid["+languageid+"]");
		}
		try {
			Session session = sessionFactory.getCurrentSession();
			String queryString = "from LanguageEntity where id="+languageid;
			Query query = session.createQuery(queryString);
			return (LanguageEntity)query.uniqueResult();
		}catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getLanguagesByUserId method having id"+languageid);
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}
	
	public TechnologiesEntity gettechnologiesbytechid(Long techid)throws DBException {
		if(log.isDebugEnabled()){
			log.debug("gettechnologiesbytechid techid["+techid+"]");
		}
		try {
			Session session = sessionFactory.getCurrentSession();
			String queryString = "from TechnologiesEntity where id="+techid;
			Query query = session.createQuery(queryString);
			return (TechnologiesEntity)query.uniqueResult();
		}catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getLanguagesByUserId method having id"+techid);
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}


	@Override
	public int deleteLanguagesByUserId(Long userId) throws DBException {
		Query query;
		int result=0;
		try {
			Session session = sessionFactory.getCurrentSession();
			query= session.createQuery("delete from UserLanguagesEntity where user.id=:userId");
			query.setParameter("userId", userId);
			result = query.executeUpdate();
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occred while Deleting Languages By having id"+userId);
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
				
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int updateUserInInterviewCandidates(UserDto userDto) throws DBException {
		Query query = null;
		List<InterviewGroupsCandidatesEntity> interviewGroupsCandidatesEntityList = null;
		int result=0;
		UserEntity userentity = DozerBeanMapperSingletonWrapper.getInstance().map(userDto, UserEntity.class);
		try {
			List<InterviewGroupsCandidatesEntity> interviewlist = new ArrayList<InterviewGroupsCandidatesEntity>();
			Session session = sessionFactory.getCurrentSession();
			query= session.createQuery("from InterviewGroupsCandidatesEntity where candidateEmail =:candidateEmail");
			query.setParameter("candidateEmail", userDto.getEmailId());
			interviewlist = query.list();
			
			if(interviewlist.size() >= 1){
				Long userId = userDto.getId();
				for(int i=0;i<interviewlist.size();i++){
					query = session.createQuery("update InterviewGroupsCandidatesEntity set userId =:userId where id=:id");
					query.setParameter("userId", userDto.getId());
					query.setParameter("id", interviewlist.get(i).getId());
					query.executeUpdate(); 
				}
				query= session.createQuery("from InterviewGroupsCandidatesEntity where userId="+userId);
				interviewGroupsCandidatesEntityList = query.list();
				for(int m=0;m<interviewGroupsCandidatesEntityList.size();m++){
					Long groupId = interviewGroupsCandidatesEntityList.get(m).getGroupId();
					List<SelectedGroupsForInterviewEntity> testList = inteviewDao.getSelectedGroupsForInterviewByGroupId(groupId);
					for(int k=0;k<testList.size();k++){
						int results = 0;
						InterviewAssignToUsersEntity assigntouser = new InterviewAssignToUsersEntity();
						assigntouser.setTest(testList.get(k).getInterview());
						assigntouser.setUser(userentity);
						results = inteviewDao.getInterviewAssignToUsersByUserIdandTestId(assigntouser.getUser().getId(),assigntouser.getTest().getId());
						if(results == 0){
						session.save(assigntouser);
						}
					}
				}
				
			}
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occred while updating UserInInterviewCandidate By having id"+userDto.getUserName());
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
				
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AddressEntity> getaddressInfoBycityId(Long cityId) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query= session.createQuery("from AddressEntity where city.id=:Id");
			query.setParameter("Id", cityId);
			return query.list();
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing cityInfoById");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TechSkillEntity> gettechInfoBytechId(Long techId) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query= session.createQuery("from TechSkillEntity where technology.id=:Id");
			query.setParameter("Id", techId);
			return query.list();
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing gettechInfoBytechId");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserExperianceEntity> getuserexperienceInfoByexpId(int exp) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query= session.createQuery("from UserExperianceEntity where yearsOfExperiance=:exp");
			query.setParameter("exp", exp);
			return query.list();
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing getuserexperienceInfoByexpId");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserSearchResultsEntity> getusersearch(UserSearchDto userSearchDto) throws DBException {
		Query query;
		ArrayList<UserSearchResultsEntity> emptyuserlist = new ArrayList<UserSearchResultsEntity>();
		try {
			Session session = sessionFactory.getCurrentSession();
			if(userSearchDto.getAddress().getCity().getId() !=0 && userSearchDto.getTech().size() == 0){
				ArrayList<UserSearchResultsEntity> userlist = new ArrayList<UserSearchResultsEntity>();
				ArrayList<UserSearchResultsEntity> userlist2 = new ArrayList<UserSearchResultsEntity>();
				ArrayList<UserSearchResultsEntity> finaluserlist = new ArrayList<UserSearchResultsEntity>();
				query= session.createQuery("from UserSearchResultsEntity where cityID=:cityID and roleId=6");
				query.setParameter("cityID", userSearchDto.getAddress().getCity().getId());
				query.list();
				if(query.list().size() != 0){
					userlist.addAll(query.list());
				}
				if(userSearchDto.getExpmax() != 0){
					query= session.createQuery("from UserSearchResultsEntity where roleId=6 and yearsOfExperience between "+userSearchDto.getExpmin() +" and "+ userSearchDto.getExpmax());
					if(query.list().size() != 0){
						userlist2.addAll(query.list());
					}else{
						return emptyuserlist;
					}
				}
				if(userlist2.size() !=0){
					if(userlist.size() > userlist2.size()){
						for(int k=0;k<userlist2.size();k++){
							for(int m=0;m<userlist.size();m++){
								if(userlist2.get(k).getId() == userlist.get(m).getId()){
									finaluserlist.add(userlist.get(m));
								}
							}
						}
						return finaluserlist;
					}else{
						for(int k=0;k<userlist.size();k++){
							for(int m=0;m<userlist2.size();m++){
								if(userlist.get(k).getId() == userlist2.get(m).getId()){
									finaluserlist.add(userlist2.get(m));
								}
							}
						}
						return finaluserlist;
					}

				}else{
					return userlist;
				}
			}
			else if(userSearchDto.getAddress().getCity().getId() == 0 && userSearchDto.getTech().size() != 0){
				ArrayList<TechSkillEntity> userlist = new ArrayList<TechSkillEntity>();
				ArrayList<UserSearchResultsEntity> userlist2 = new ArrayList<UserSearchResultsEntity>();
				ArrayList<UserSearchResultsEntity> finaluserlist = new ArrayList<UserSearchResultsEntity>();
				for(int i=0;i<userSearchDto.getTech().size();i++){
					query= session.createQuery("from TechSkillEntity where technology.id=:techID and user.role.id=6");
					query.setParameter("techID", userSearchDto.getTech().get(i).getId());
					if(query.list().size() != 0){
						userlist.addAll(query.list());
					}
				
				}
				if(userSearchDto.getExpmax() != 0){
					query= session.createQuery("from UserSearchResultsEntity where roleId=6 and  yearsOfExperience between "+userSearchDto.getExpmin() +" and "+ userSearchDto.getExpmax());
					query.setParameter("min", userSearchDto.getExpmin());
					query.setParameter("max", userSearchDto.getExpmax());
					if(query.list().size() != 0){
						userlist2.addAll(query.list());
					}else{
						return emptyuserlist;
					}
					
				}
				if(userlist2.size() !=0){
					if(userlist.size() > userlist2.size()){
						for(int k=0;k<userlist2.size();k++){
							for(int m=0;m<userlist.size();m++){
								if(userlist2.get(k).getId() == userlist.get(m).getUser().getId()){
									finaluserlist.add(userlist2.get(k));
								}
							}
						}
						return finaluserlist;
					}else{
						for(int k=0;k<userlist.size();k++){
							for(int m=0;m<userlist2.size();m++){
								if(userlist.get(k).getUser().getId() == userlist2.get(m).getId()){
									finaluserlist.add(userlist2.get(m));
								}
							}
						}
						return finaluserlist;
					}	
				}
				else{
					for(int k=0;k<userlist.size();k++){
						UserSearchResultsEntity usersearch = new UserSearchResultsEntity();
						UserEntity user = new UserEntity();
						AddressEntity address = new AddressEntity();
						Long id = userlist.get(k).getUser().getId();
						query= session.createQuery("from userEntity where id= "+id);
						user = (UserEntity)query.uniqueResult();
						query= session.createQuery("from AddressEntity where user.id= "+id);
						address = (AddressEntity)query.uniqueResult();
						usersearch.setAddress(address.getAddress());
						usersearch.setMobileId(user.getMobileNo());
						usersearch.setUserName(user.getUserName());
						usersearch.setEmailID(user.getEmailId());
						finaluserlist.add(usersearch);
					}
					return finaluserlist;
				}
				
			}
			else if(userSearchDto.getAddress().getCity().getId() != 0 && userSearchDto.getTech().size() != 0){
				ArrayList<UserSearchResultsEntity> userlist = new ArrayList<UserSearchResultsEntity>();
				ArrayList<UserSearchResultsEntity> userlist2 = new ArrayList<UserSearchResultsEntity>();
				ArrayList<UserSearchResultsEntity> userlistchecking = new ArrayList<UserSearchResultsEntity>();
				ArrayList<TechSkillEntity> userlist3 = new ArrayList<TechSkillEntity>();
				ArrayList<UserSearchResultsEntity> finaluserlist = new ArrayList<UserSearchResultsEntity>();
				query= session.createQuery("from UserSearchResultsEntity where cityID=:cityID and roleId=6");
				query.setParameter("cityID", userSearchDto.getAddress().getCity().getId());
				query.list();
				if(query.list().size() != 0){
					userlist.addAll(query.list());
				}
				else{
					return emptyuserlist;
				}
				for(int i=0;i<userSearchDto.getTech().size();i++){
					query= session.createQuery("from TechSkillEntity where technology.id=:techID and user.role.id=6");
					query.setParameter("techID", userSearchDto.getTech().get(i).getId());
					if(query.list().size() != 0){
						userlist3.addAll(query.list());
					}else{
						return emptyuserlist;
					}
				
				}
				//--------------------------------------------------------
				if(userlist3.size() !=0){
					if(userlist.size() > userlist3.size()){
						for(int k=0;k<userlist3.size();k++){
							for(int m=0;m<userlist.size();m++){
								if(userlist3.get(k).getUser().getId() == userlist.get(m).getId()){
									userlistchecking.add(userlist.get(m));
								}
							}
						}
						
					}else{
						for(int k=0;k<userlist.size();k++){
							for(int m=0;m<userlist3.size();m++){
								if(userlist.get(k).getId() == userlist3.get(m).getUser().getId()){
									userlistchecking.add(userlist.get(k));
								}
							}
						}
						
					}
				}else{
					userlistchecking.addAll(userlist);
				}
				
				
				
				
				//------------------------------------------------------------
				if(userSearchDto.getExpmax() != 0){
					query= session.createQuery("from UserSearchResultsEntity where roleId=6 and yearsOfExperience between "+userSearchDto.getExpmin() +" and "+ userSearchDto.getExpmax());
					if(query.list().size() != 0){
						userlist2.addAll(query.list());
					}
					else{
						return emptyuserlist;
					}
					
				}
				if(userlist2.size() !=0){
					if(userlistchecking.size() > userlist2.size()){
						for(int k=0;k<userlist2.size();k++){
							for(int m=0;m<userlistchecking.size();m++){
								if(userlist2.get(k).getId() == userlistchecking.get(m).getId()){
									finaluserlist.add(userlistchecking.get(m));
								}
							}
						}
						return finaluserlist;
					}else{
						for(int k=0;k<userlistchecking.size();k++){
							for(int m=0;m<userlist2.size();m++){
								if(userlistchecking.get(k).getId() == userlist2.get(m).getId()){
									finaluserlist.add(userlist2.get(m));
								}
							}
						}
						return finaluserlist;
					}
				}else{
					return userlistchecking;
				}
				
			}
			else if(userSearchDto.getAddress().getCity().getId() == 0 && userSearchDto.getTech().size() == 0){
				ArrayList<UserSearchResultsEntity> userlist2 = new ArrayList<UserSearchResultsEntity>();
				if(userSearchDto.getExpmax() != 0){
					query= session.createQuery("from UserSearchResultsEntity where roleId=6 and yearsOfExperience between "+userSearchDto.getExpmin() +" and "+ userSearchDto.getExpmax());
					if(query.list().size() != 0){
						userlist2.addAll(query.list());
					}
					return userlist2;
				}else{
					return userlist2;
				}
				
			}
			else{
					return emptyuserlist;
				}
				
			
		}catch(Exception e){
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing getuserexperienceInfoByexpId");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
				
		}

	}
		
}
