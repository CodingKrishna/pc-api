package org.pioneercoders.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.pioneercoders.dto.hr.ShortListedProfileDto;
import org.pioneercoders.dto.user.UserDto;
import org.pioneercoders.entity.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;

import sun.misc.BASE64Encoder;

public class MailContentUtil {
	
	@Autowired
	AppConfig appConfig;
	
	public String  sendMailForRegistration(String activateBaseUrl, UserDto userdto){
		String fileName= appConfig.getRegistrationEmailTemplate();
		StringBuffer contents = new StringBuffer();
		String url =null;
		
		if(userdto.getId()!=null){
			String encodedId = new BASE64Encoder().encodeBuffer(userdto.getId().toString().getBytes());
			if(userdto.getRole()!=null){
				url = "<a href=\"" + activateBaseUrl + "?id="+encodedId+"&roleId="+userdto.getRole().getId()+"\">"+"click</a>";
			}
			else{
				url = "<a href=\"" + activateBaseUrl + "?id="+encodedId+"&roleId"+"\">"+"click</a>";
			}
		}
		try {
			// use buffering, reading one line at a time
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			try {
				String line = null;
				while ((line = reader.readLine()) != null) {
					contents.append(line);
					contents.append(System.getProperty("line.separator"));
				}
				String acronym = "@ACTIVATION_LINK@";
				if(contents.indexOf(acronym)>-1){
					contents = contents.replace(contents.indexOf(acronym), contents.indexOf(acronym) + acronym.length(), url);
				}
			} finally {
				reader.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return contents.toString();
	}
	
	public String sendMailForInterviewCall(String interviewDate,UserEntity userEntity){
		String fileName= appConfig.getInterviewEmailTemplate();
		StringBuffer contents = new StringBuffer();
		
		try {
			// use buffering, reading one line at a time
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			try {
				String line = null;
				while ((line = reader.readLine()) != null) {
					contents.append(line);
					contents.append(System.getProperty("line.separator"));
				}
				String acronymName = "@NAMEOFPERSION@";
				String acronymInterviewDate = "@INTERVIEWDATE@";
				contents = contents.replace(contents.indexOf(acronymName), contents.indexOf(acronymName) + acronymName.length(), userEntity.getUserName());
				contents = contents.replace(contents.indexOf(acronymInterviewDate), contents.indexOf(acronymInterviewDate) + acronymInterviewDate.length(), interviewDate);
			} finally {
				reader.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		
		return contents.toString();
	}
	
	public String sendMailToUser(String filePath){
		String fileName= appConfig.getAppTemplates();
		StringBuffer contents = new StringBuffer();
		
		try {
			// use buffering, reading one line at a time
			System.out.println("file Path ==="+fileName.concat(filePath).concat(".html"));
			BufferedReader reader = new BufferedReader(new FileReader(fileName.concat(filePath).concat(".html")));
			try {
				String line = null;
				while ((line = reader.readLine()) != null) {
					contents.append(line);
					contents.append(System.getProperty("line.separator"));
				}
			
			} finally {
				reader.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		
		return contents.toString();
	}

	public String sendMailToProfileUser(ShortListedProfileDto profileDto){
		String fileName= appConfig.getHrportalEmailTemplate();
		StringBuffer contents = new StringBuffer();
		
		try {
			// use buffering, reading one line at a time
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			try {
				String line = null;
				while ((line = reader.readLine()) != null) {
					contents.append(line);
					contents.append(System.getProperty("line.separator"));
				}
				String acronym1 = "@PERSION_NAME@";
				String acronym2 = "@MESSAGE_DATA@";
				if(contents.indexOf(acronym1)>-1){
					contents = contents.replace(contents.indexOf(acronym1), contents.indexOf(acronym1) + acronym1.length(), profileDto.getName());
				}if(contents.indexOf(acronym2)>-1){
					contents = contents.replace(contents.indexOf(acronym2), contents.indexOf(acronym2) + acronym2.length(), profileDto.getMessage());
				}
			} finally {
				reader.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return contents.toString();
	}
	
	public String sendMailForForgetPassword(String emailId,String url){
		String fileName= appConfig.getForgetPasswordEmailTemplate();
		StringBuffer contents = new StringBuffer();
		String finalUrl;
		try {
			// use buffering, reading one line at a time
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String encodedBytes = new BASE64Encoder().encodeBuffer(emailId.getBytes());
			finalUrl = "<a href=\"" + url + "?emailId="+encodedBytes+"\">"+"click</a>";
			try {
				String line = null;
				while ((line = reader.readLine()) != null) {
					contents.append(line);
					contents.append(System.getProperty("line.separator"));
				}
				
				String acronym = "@FORGETPASSWORD_LINK@";
				if(contents.indexOf(acronym)>-1){
					contents = contents.replace(contents.indexOf(acronym), contents.indexOf(acronym) + acronym.length(), finalUrl);
				}
			} finally {
				reader.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return contents.toString();
	}
	
	public String sendMailToUserFromHr(){
		String fileName= appConfig.getHrEmailTemplate();
		StringBuffer contents = new StringBuffer();
		
		try {
			// use buffering, reading one line at a time
			
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			try {
				String line = null;
				while ((line = reader.readLine()) != null) {
					contents.append(line);
					contents.append(System.getProperty("line.separator"));
				}
			
			} finally {
				reader.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		
		return contents.toString();
	}

}
