package org.pioneercoders.entity.evaluation.objectivetest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.pioneercoders.entity.user.UserEntity;

@Entity
@Table(name="object_test_user_ans_tbl")
public class ObjectiveQstnUserAnsEntity {
	private Long id;
	private String answer;
	private ObjectQstnEntity quesId;
	private Boolean isAnswered;
	private UserEntity user;
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="ANSWER")
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "QUESTION_ID")
	public ObjectQstnEntity getQuesId() {
		return quesId;
	}
	public void setQuesId(ObjectQstnEntity quesId) {
		this.quesId = quesId;
	}
	
	@Column(name="IS_ANSWERED")
	public Boolean getIsAnswered() {
		return isAnswered;
	}
	public void setIsAnswered(Boolean isAnswered) {
		this.isAnswered = isAnswered;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PERSIONAL_ID")
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "ObjectiveQstnUserAnsEntity [id=" + id + ", answer=" + answer
				+ ", quesId=" + quesId + ", isAnswered=" + isAnswered
				+ ", user=" + user + "]";
	}
}
