package org.pioneercoders.dto.common;

public class LanguagesDto {

	private Long id;
	private String languageName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLanguageName() {
		return languageName;
	}
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	@Override
	public String toString() {
		return "LanguagesDto [id=" + id + ", languageName=" + languageName
				+ "]";
	}
	
}
