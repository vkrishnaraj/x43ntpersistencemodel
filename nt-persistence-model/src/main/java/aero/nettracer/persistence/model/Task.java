package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.sql.Timestamp;

@Entity
@Table(name = "tasks")
public class Task {

	private int id;
	private String file_ref_number;
	private String description;
	private Timestamp reminder_date_time;
	private Timestamp due_date_time;
	private Priority priority;
	private Agent assigningAgent;
	private Status status;
	private String remarks;
	private Station station;
	private int file_type;
	private Agent assignedTo;

	public static final int ALL_TASKS = -1;
	public static final int ACTIVE_TASKS = -2;

	@Id
	@GeneratedValue
	@Column(name = "task_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "file_ref_number")
	public String getFile_ref_number() {
		return file_ref_number;
	}

	public void setFile_ref_number(String file_ref_number) {
		this.file_ref_number = file_ref_number;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "reminder_date_time")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getReminder_date_time() {
		return reminder_date_time;
	}

	public void setReminder_date_time(Timestamp reminder_date_time) {
		this.reminder_date_time = reminder_date_time;
	}

	@Column(name = "due_date_time")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getDue_date_time() {
		return due_date_time;
	}

	public void setDue_date_time(Timestamp due_date_time) {
		this.due_date_time = due_date_time;
	}

	@ManyToOne
	@JoinColumn(name = "priority_id")
	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	@ManyToOne
	@JoinColumn(name = "assigningagent")
	public Agent getAssigningAgent() {
		return assigningAgent;
	}

	public void setAssigningAgent(Agent assigningAgent) {
		this.assigningAgent = assigningAgent;
	}

	@ManyToOne
	@JoinColumn(name = "task_status_id")
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Column(name = "remarks")
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@ManyToOne
	@JoinColumn(name = "station_id")
	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	@Column(name = "file_type")
	public int getFile_type() {
		return file_type;
	}

	public void setFile_type(int file_type) {
		this.file_type = file_type;
	}

	@ManyToOne
	@JoinColumn(name = "assigned_agent_ID")
	public Agent getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Agent assignedTo) {
		this.assignedTo = assignedTo;
	}

	@Transient
	public String getCreatedBy() {
		if (assigningAgent != null) return assigningAgent.getUsername();
		else return "";
	}

	@Transient
	public String getStationString() {
		if (station != null) return station.getStationcode();
		else return "";
	}

}