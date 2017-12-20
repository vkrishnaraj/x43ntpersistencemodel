package aero.nettracer.persistence.model.taskmanager;

import aero.nettracer.persistence.model.communications.IncidentActivity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("INCACTIVITYTASK")
public class IncidentActivityTask extends GeneralTask {

	private boolean active;
	private IncidentActivity incidentActivity;
	private TaskType taskType;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "incidentActivityId", nullable = false)
	public IncidentActivity getIncidentActivity() {
		return incidentActivity;
	}
	
	public void setIncidentActivity(IncidentActivity incidentActivity) {
		this.incidentActivity = incidentActivity;
	}

	@Column(name = "active")
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@ManyToOne
	@JoinColumn(name="task_type_id")
	public TaskType getTaskType() {
		return taskType;
	}

	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}

}
