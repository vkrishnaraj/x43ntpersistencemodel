package aero.nettracer.persistence.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "incident_checklist")
public class IncidentChecklist {

	private long id;
	private Incident incident;
	private ChecklistTask checklistTask;
	private ChecklistTaskOption checklistTaskOption;
	private Agent agent;
	private Date timestamp;

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(targetEntity = Incident.class)
	@JoinColumn(name = "incident_id", nullable = false)
	public Incident getIncident() {
		return incident;
	}
	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	@ManyToOne
	@JoinColumn(name = "task_id", nullable = false)
	public ChecklistTask getChecklistTask() {
		return checklistTask;
	}

	public void setChecklistTask(ChecklistTask checklistTask) {
		this.checklistTask = checklistTask;
	}

	@ManyToOne
	@JoinColumn(name = "option_id", nullable = false)
	public ChecklistTaskOption getChecklistTaskOption() {
		return checklistTaskOption;
	}
	public void setChecklistTaskOption(ChecklistTaskOption checklistTaskOption) {
		this.checklistTaskOption = checklistTaskOption;
	}

	@ManyToOne
	@JoinColumn(name = "agent_agent_id")
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public String toString() {
		String result;
		StringBuffer mySb = new StringBuffer();
		mySb.append("id=" + id);
		mySb.append("incident_id=" + incident.getId());
		mySb.append("checklistTask_id=" + checklistTask.getId());
		result = "" + mySb.toString();
		return result;
	}
}
