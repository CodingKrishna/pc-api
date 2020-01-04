package org.pioneercoders.dto.evaluation.taskstest;

public class TaskDto {
	
	private Long id;
	private String question;
	private String queDescription;
	private String imagePath;
	private String technology;
	private String objective;
	private String refferenceLink;
	private String shortName;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getQueDescription() {
		return queDescription;
	}
	public void setQueDescription(String queDescription) {
		this.queDescription = queDescription;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	
	public String getObjective() {
		return objective;
	}
	public void setObjective(String objective) {
		this.objective = objective;
	}
	
	public String getRefferenceLink() {
		return refferenceLink;
	}
	public void setRefferenceLink(String refferenceLink) {
		this.refferenceLink = refferenceLink;
	}
	
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	@Override
	public String toString() {
		return "InternTaskDto [id=" + id + ", question=" + question
				+ ", queDescription=" + queDescription + ", imagePath="
				+ imagePath + "]";
	}

}
