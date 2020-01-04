package org.pioneercoders.dto.common;

import java.util.List;

public class MessageDto {

	private List<String> mobileNo;
	private String message;
	private List<String> emailIds;
	private String filePath;

	public List<String> getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(List<String> mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getEmailIds() {
		return emailIds;
	}
	public void setEmailIds(List<String> emailIds) {
		this.emailIds = emailIds;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
