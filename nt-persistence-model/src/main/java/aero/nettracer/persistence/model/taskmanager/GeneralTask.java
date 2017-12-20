package aero.nettracer.persistence.model.taskmanager;

import aero.nettracer.persistence.model.Agent;
import aero.nettracer.persistence.model.Lock;
import aero.nettracer.persistence.model.Status;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="task")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="task_type", discriminatorType = DiscriminatorType.STRING, length=16)
public abstract class GeneralTask {

	private long id;
	private Timestamp opened_timestamp;
	private Timestamp closed_timestamp;
	private Status status;
	private Timestamp generic_timestamp;
	private String locale;
	private Agent assigned_agent;
	private List<TaskActivity> activities;
	private Lock lock;

	@Id
	@GeneratedValue
	@Column(name = "task_id")
	public long getId() {
		return id;
	}

	public void setId(long taskId) {
		id = taskId;
	}

	@Column(name = "opened_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getOpened_timestamp() {
		return opened_timestamp;
	}

	public void setOpened_timestamp(Timestamp openedTimestamp) {
		opened_timestamp = openedTimestamp;
	}

	@Column(name = "closed_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getClosed_timestamp() {
		return closed_timestamp;
	}

	public void setClosed_timestamp(Timestamp closedTimestamp) {
		closed_timestamp = closedTimestamp;
	}

	@ManyToOne
	@JoinColumn(name = "status_id", nullable = false)
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Column(name = "generic_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getGeneric_timestamp() {
		return generic_timestamp;
	}

	public void setGeneric_timestamp(Timestamp generic_timestamp) {
		this.generic_timestamp = generic_timestamp;
	}

	@ManyToOne
	@JoinColumn(name = "agent_id")
	public Agent getAssigned_agent() {
		return assigned_agent;
	}

	public void setAssigned_agent(Agent assignedAgent) {
		assigned_agent = assignedAgent;
	}

	@OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
	public List<TaskActivity> getActivities() {
		return activities;
	}

	public void setActivities(List<TaskActivity> activities) {
		this.activities = activities;
	}
	
	@Transient
	public Lock getLock() {
		return lock;
	}

	public void setLock(Lock lock) {
		this.lock = lock;
	}
	
	@Transient
	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

}
