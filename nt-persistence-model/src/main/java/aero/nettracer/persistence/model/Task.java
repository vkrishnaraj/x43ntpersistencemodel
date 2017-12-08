package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.Date;
import java.util.TimeZone;

import aero.nettracer.commons.utils.GenericDateUtils;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "tasks")
public class Task implements Serializable {

	private int task_id = 0;
	private String file_ref_number;
	private String description;
	private Date due_date_time;
	private Date reminder_date_time;
	private Priority priority;
	private Agent assigningAgent;
	private Station station;
	private int file_type;
	private Status status;
	private String remarks;
	private String _DATEFORMAT; // current login agent's date format
	private String _TIMEFORMAT; // current login agent's time format
	private TimeZone _TIMEZONE;

	private Agent assignedTo;

	public static final int ALL_TASKS = -1;
	public static final int ACTIVE_TASKS = -2;

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

	public void set_DATEFORMAT(String _dateformat) {
		_DATEFORMAT = _dateformat;
	}

	public void set_TIMEFORMAT(String _timeformat) {
		_TIMEFORMAT = _timeformat;
	}

	public void set_TIMEZONE(TimeZone _timezone) {
		_TIMEZONE = _timezone;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@ManyToOne
	@JoinColumn(name = "task_status_id")
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@ManyToOne
	@JoinColumn(name = "assigningAgent")
	public Agent getAssigningAgent() {
		return assigningAgent;
	}

	public void setAssigningAgent(Agent assigningAgent) {
		this.assigningAgent = assigningAgent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFile_ref_number() {
		return file_ref_number;
	}

	public void setFile_ref_number(String file_ref_number) {
		this.file_ref_number = file_ref_number;
	}

	@Id
	@GeneratedValue
	public int getTask_id() {
		return task_id;
	}

	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}

	@ManyToOne
	@JoinColumn(name = "priority_id")
	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public int getFile_type() {
		return file_type;
	}

	public void setFile_type(int file_type) {
		this.file_type = file_type;
	}

	@ManyToOne
	@JoinColumn(name = "station_id")
	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDue_date_time() {
		return due_date_time;
	}

	public void setDue_date_time(Date due_date_time) {
		this.due_date_time = due_date_time;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getReminder_date_time() {
		return reminder_date_time;
	}

	public void setReminder_date_time(Date reminder_date_time) {
		this.reminder_date_time = reminder_date_time;
	}

	@Transient
	public String getDispreminderdate() {
		return GenericDateUtils.formatDate(this.getReminder_date_time(), _DATEFORMAT, null, _TIMEZONE);
	}

	@Transient
	public String getDispremindertime() {
		return GenericDateUtils.formatDate(this.getReminder_date_time(), _TIMEFORMAT, null, _TIMEZONE);
	}

	@Transient
	public String getDispduedate() {
		return GenericDateUtils.formatDate(this.getDue_date_time(), _DATEFORMAT, null, _TIMEZONE);
	}

	@Transient
	public String getDispduetime() {
		return GenericDateUtils.formatDate(this.getDue_date_time(), _TIMEFORMAT, null, _TIMEZONE);
	}
}