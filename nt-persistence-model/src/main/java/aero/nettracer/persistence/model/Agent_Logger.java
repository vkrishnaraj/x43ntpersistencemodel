package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.Date;
import java.util.TimeZone;

import aero.nettracer.commons.utils.GenericDateUtils;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "agent_logger")
public class Agent_Logger implements Serializable {

	private int ID;
	private int agent_ID;
	private String companycode_ID;
	private Date log_in_time;
	private Date log_off_time;

	private String _DATEFORMAT; // current login agent's date format
	private String _TIMEFORMAT; // current login agent's time format
	private TimeZone _TIMEZONE;

	private String username;

	private boolean expired = false;

	public int getAgent_ID() {
		return agent_ID;
	}

	public void setAgent_ID(int agent_ID) {
		this.agent_ID = agent_ID;
	}

	public String getCompanycode_ID() {
		return companycode_ID;
	}

	public void setCompanycode_ID(String companycode_ID) {
		this.companycode_ID = companycode_ID;
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

	@Transient
	public String getDisplayLoggedOn() {
		return GenericDateUtils.formatDate(this.getLog_in_time(), _DATEFORMAT + " " + _TIMEFORMAT, null,
				_TIMEZONE);
	}

	@Transient
	public String getDisplayLoggedOff() {

		if (this.getLog_off_time() == null) return "";

		return GenericDateUtils.formatDate(this.getLog_off_time(), _DATEFORMAT + " " + _TIMEFORMAT, null,
				_TIMEZONE);
	}

	@Id
	@GeneratedValue
	public int getID() {
		return ID;
	}

	public void setID(int id) {
		ID = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getLog_in_time() {
		return log_in_time;
	}

	public void setLog_in_time(Date log_in_time) {
		this.log_in_time = log_in_time;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getLog_off_time() {
		return log_off_time;
	}

	public void setLog_off_time(Date log_off_time) {
		this.log_off_time = log_off_time;
	}

	@Transient
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}
}