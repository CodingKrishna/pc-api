package org.pioneercoders.entity.evaluation.taskstest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="task_mst_tbl")
public class TaskEntity {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="QUESTION")
	private String question;
	
	@Column(name="QUESTION_DES")
	private String queDescription;
	
	@Column(name="IMAGE_PATH")
	private String imagePath;
	
	@Column(name="TECHNOLOGY")
	private String technology;
	
	@Column(name="OBJECTIVE")
	private String objective;
	
	@Column(name="REFFERENCE_LINK")
	private String refferenceLink;
	
	@Column(name="SHORT_NAME")
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
		return "InternTaskEntity [id=" + id + ", question=" + question
				+ ", queDescription=" + queDescription + ", imagePath="
				+ imagePath + "]";
	}
	
}
