package org.pioneercoders.entity.Interview;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.pioneercoders.entity.evaluation.codingtest.CodingTestQstnEntity;
import org.pioneercoders.entity.evaluation.objectivetest.ObjectQstnEntity;
import org.pioneercoders.entity.evaluation.taskstest.TaskEntity;

@Entity
@Table(name="interviews_round_question_tbl")
public class InterviewRoundQuesAssoEntity {
	
	private Long id;
	private InterviewsEntity test;
	private RoundsEntity rounds;
	private ObjectQstnEntity objectQuestions;
	private TaskEntity taskQuestions;
	private CodingTestQstnEntity codingTestQuestions;
	
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name="INTERVIEWS_ID")
	public InterviewsEntity getTest() {
		return test;
	}
	public void setTest(InterviewsEntity test) {
		this.test = test;
	}
	@ManyToOne
	@JoinColumn(name="ROUND_ID")
	public RoundsEntity getRounds() {
		return rounds;
	}
	public void setRounds(RoundsEntity rounds) {
		this.rounds = rounds;
	}
	@ManyToOne
	@JoinColumn(name="OBJECTIVE_QUESTION_ID")
	public ObjectQstnEntity getObjectQuestions() {
		return objectQuestions;
	}
	public void setObjectQuestions(ObjectQstnEntity objectQuestions) {
		this.objectQuestions = objectQuestions;
	}
	@ManyToOne
	@JoinColumn(name="TASK_QUESTION_ID")
	public TaskEntity getTaskQuestions() {
		return taskQuestions;
	}
	public void setTaskQuestions(TaskEntity taskQuestions) {
		this.taskQuestions = taskQuestions;
	}
	@ManyToOne
	@JoinColumn(name="CODING_QUESTION_ID")
	public CodingTestQstnEntity getCodingTestQuestions() {
		return codingTestQuestions;
	}
	public void setCodingTestQuestions(CodingTestQstnEntity codingTestQuestions) {
		this.codingTestQuestions = codingTestQuestions;
	}
	@Override
	public String toString() {
		return "TestRoundQuesAssoEntity [id=" + id + ", test=" + test
				+ ", rounds=" + rounds + ", objectQuestions=" + objectQuestions
				+ ", taskQuestions=" + taskQuestions + ", codingTestQuestions="
				+ codingTestQuestions + "]";
	}
	
}
