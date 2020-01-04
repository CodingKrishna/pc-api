package org.pioneercoders.dto.student;

import org.pioneercoders.dto.common.LanguagesDto;
import org.pioneercoders.dto.user.UserDto;

public class UserLanguagesDto {

	private Long id;
	private LanguagesDto language;
	private UserDto user;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LanguagesDto getLanguage() {
		return language;
	}
	public void setLanguage(LanguagesDto language) {
		this.language = language;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "UserLanguagesDto [id=" + id + ", language=" + language
				+ ", user=" + user + "]";
	}
}
