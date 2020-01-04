package org.pioneercoders.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:app.properties")
public class AppConfig {

	@Value("${ROOT_DIRECTORY}")
	private String tutorialContentRootDir;
	
	@Value("${TUTORIALS_DIRECTORY}")
	private String tutorialDirectory;
	
	@Value("${LECTURER_HOME_DIRECTORY}")
	private String lecturerHomeDirectory;
	
	@Value("${PROJECTS_DIRECTORY}")
	private String projectsDirectory;
	
	@Value("${DOCUMENTS_DIRECTORY}")
	private String documentsDirectory;
	
	@Value("${CAMPUS_UPLOADED_ROOT}")
	private String campusUploadedRoot;
	
	@Value("${CASE_STUDIES_DIRECTORY}")
	private String caseStudiesDirectory;
	
	@Value("${EXPENDATURE_BILLS}")
	private String expendatureBills;
	
	@Value("${COURSES_DIRECTORY}")
	private String coursesDirectory;
	
	@Value("${INTERN_TASKS_DIRECTORY}")
	private String internTasksDirectory;
	
	@Value("${PROFILE_INFO}")
	private String profileInfo;
	
	@Value("${INTERN_TASK_DOWNLOAD}")
	private String internTaskDownload;
	
	@Value("${REGISTRATION_EMAIL_TEMPLATE}")
	private String registrationEmailTemplate;
	
	@Value("${INTERVIEW_EMAIL_TEMPLATE}")
	private String interviewEmailTemplate;
	
	@Value("${APP_TEMPLATES}")
	private String appTemplates;
	
	@Value("${HRPORTAL_EMAIL_TEMPLATE}")
	private String hrportalEmailTemplate;
	
	@Value("${FORGETPASSWORD_EMAIL_TEMPLATE}")
	private String forgetPasswordEmailTemplate;
	
	@Value("${HR_EMAIL_TEMPLATE}")
	private String hrEmailTemplate;
	
    @Bean
    public MailContentUtil mailContentUtil() {
        return new MailContentUtil();
	}
	
	public String getTutorialContentRootDir() {
		return tutorialContentRootDir;
	}

	public void setTutorialContentRootDir(String tutorialContentRootDir) {
		this.tutorialContentRootDir = tutorialContentRootDir;
	}

	public String getTutorialDirectory() {
		return tutorialDirectory;
	}

	public void setTutorialDirectory(String tutorialDirectory) {
		this.tutorialDirectory = tutorialDirectory;
	}

	public String getLecturerHomeDirectory() {
		return lecturerHomeDirectory;
	}

	public void setLecturerHomeDirectory(String lecturerHomeDirectory) {
		this.lecturerHomeDirectory = lecturerHomeDirectory;
	}

	
	public String getProjectsDirectory() {
		return projectsDirectory;
	}

	public void setProjectsDirectory(String projectsDirectory) {
		this.projectsDirectory = projectsDirectory;
	}

	public String getDocumentsDirectory() {
		return documentsDirectory;
	}

	public void setDocumentsDirectory(String documentsDirectory) {
		this.documentsDirectory = documentsDirectory;
	}

	public String getCampusUploadedRoot() {
		return campusUploadedRoot;
	}

	public void setCampusUploadedRoot(String campusUploadedRoot) {
		this.campusUploadedRoot = campusUploadedRoot;
	}

	public String getCaseStudiesDirectory() {
		return caseStudiesDirectory;
	}

	public void setCaseStudiesDirectory(String caseStudiesDirectory) {
		this.caseStudiesDirectory = caseStudiesDirectory;
	}

	public String getExpendatureBills() {
		return expendatureBills;
	}

	public void setExpendatureBills(String expendatureBills) {
		this.expendatureBills = expendatureBills;
	}

	public String getCoursesDirectory() {
		return coursesDirectory;
	}

	public void setCoursesDirectory(String coursesDirectory) {
		this.coursesDirectory = coursesDirectory;
	}

	public String getInternTasksDirectory() {
		return internTasksDirectory;
	}

	public void setInternTasksDirectory(String internTasksDirectory) {
		this.internTasksDirectory = internTasksDirectory;
	}

	public String getProfileInfo() {
		return profileInfo;
	}

	public void setProfileInfo(String profileInfo) {
		this.profileInfo = profileInfo;
	}

	public String getInternTaskDownload() {
		return internTaskDownload;
	}

	public void setInternTaskDownload(String internTaskDownload) {
		this.internTaskDownload = internTaskDownload;
	}

	public String getRegistrationEmailTemplate() {
		return registrationEmailTemplate;
	}

	public void setRegistrationEmailTemplate(String registrationEmailTemplate) {
		this.registrationEmailTemplate = registrationEmailTemplate;
	}

	public String getInterviewEmailTemplate() {
		return interviewEmailTemplate;
	}

	public void setInterviewEmailTemplate(String interviewEmailTemplate) {
		this.interviewEmailTemplate = interviewEmailTemplate;
	}

	public String getAppTemplates() {
		return appTemplates;
	}

	public void setAppTemplates(String appTemplates) {
		this.appTemplates = appTemplates;
	}

	public String getHrportalEmailTemplate() {
		return hrportalEmailTemplate;
	}

	public void setHrportalEmailTemplate(String hrportalEmailTemplate) {
		this.hrportalEmailTemplate = hrportalEmailTemplate;
	}

	public String getForgetPasswordEmailTemplate() {
		return forgetPasswordEmailTemplate;
	}

	public void setForgetPasswordEmailTemplate(String forgetPasswordEmailTemplate) {
		this.forgetPasswordEmailTemplate = forgetPasswordEmailTemplate;
	}

	public String getHrEmailTemplate() {
		return hrEmailTemplate;
	}

	public void setHrEmailTemplate(String hrEmailTemplate) {
		this.hrEmailTemplate = hrEmailTemplate;
	}

	//To resolve ${} in @Value
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
}
