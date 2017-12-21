package aero.nettracer.persistence.model.taskmanager;

import aero.nettracer.persistence.model.Agent;
import aero.nettracer.persistence.model.Incident;
import aero.nettracer.persistence.model.Status;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "view_tasks_not_in_work")
public class VTaskNotInWork {

	private long task_id;
	private TaskType taskType;
	private Date opened_timestamp;
	private Agent agent;
	private Status status;
	private Incident incident;
	private String lastname;
	private String firstname;
	private boolean acaa;

	@Id
	public long getTask_id() {
		return task_id;
	}
	
	public void setTask_id(long task_id) {
		this.task_id = task_id;
	}

	@ManyToOne
	@JoinColumn(name="task_type_id")
	public TaskType getTaskType() {
		return taskType;
	}

	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}

	@Temporal(value = TemporalType.TIMESTAMP)
	public Date getOpened_timestamp() {
		return opened_timestamp;
	}

	public void setOpened_timestamp(Date opened_timestamp) {
		this.opened_timestamp = opened_timestamp;
	}

	@ManyToOne
	@JoinColumn(name = "agent_ID")
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	@ManyToOne
	@JoinColumn(name = "status_ID")
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@ManyToOne
	@JoinColumn(name = "Incident_ID", nullable = false)
	@Fetch(FetchMode.SELECT)
	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	@Column(name = "lastname")
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "firstname")
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public boolean getAcaa() {
		return acaa;
	}

	public void setAcaa(boolean acaa) {
		this.acaa = acaa;
	}

}
