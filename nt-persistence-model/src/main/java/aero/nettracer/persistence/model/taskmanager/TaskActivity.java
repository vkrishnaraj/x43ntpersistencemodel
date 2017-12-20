package aero.nettracer.persistence.model.taskmanager;

import aero.nettracer.persistence.model.Agent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;

@Entity
@Table(name="taskactivity")
public class TaskActivity {

	private GeneralTask task;
	private long taskactivity_id;
	private Timestamp completetime;
	private long duration;
	private Agent agent;
	private String resolution;

	@ManyToOne
	@JoinColumn(name = "task_id",nullable = false)
	public GeneralTask getTask() {
		return task;
	}

	public void setTask(GeneralTask task) {
		this.task = task;
	}

	@Id
	@GeneratedValue
	@Column(name = "taskactivity_id")
	public long getTaskactivity_id() {
		return taskactivity_id;
	}

	public void setTaskactivity_id(long taskactivity_id) {
		this.taskactivity_id = taskactivity_id;
	}

	@Column(name = "completetime")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getCompletetime() {
		return completetime;
	}

	public void setCompletetime(Timestamp completetime) {
		this.completetime = completetime;
	}

	@Column(name = "duration")
	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	@ManyToOne
	@JoinColumn(name = "agent_id", nullable = false)
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	@Column(name = "resolution")
	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

}
