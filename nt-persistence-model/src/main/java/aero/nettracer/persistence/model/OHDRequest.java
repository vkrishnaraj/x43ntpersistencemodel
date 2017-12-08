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
@Table(name = "ohd_request")
public class OHDRequest implements Serializable {
	private int ohd_request_id;
	private Agent requestingAgent;
	private Station requestForStation;
	private String incident_ID;
	private OHD ohd;
	private Date requestTime;
	private String reason;
	private int match_id;
	private Status status;
	private int forward_id;
	private String denialReason;
	private int denied;
	private Date denialDate;
	private Incident incident;
	private String _DATEFORMAT;
	private String _TIMEFORMAT;
	private TimeZone _TIMEZONE;

	@Transient
	public String getRequestingCompany() {
		return requestForStation.getCompany().getCompanyCode_ID();
	}

	@Transient
	public String getRequestingStation() {
		return requestForStation.getStationcode();
	}

	@Transient
	public String getRequestee() {
		return requestingAgent.getUsername();
	}

	@Transient
	public String getTimeRequested() {
		return GenericDateUtils.formatDate(this.getRequestTime(), _DATEFORMAT + " "
				+ _TIMEFORMAT, null, _TIMEZONE);
	}

	@Transient
	public String getTimeDenied() {
		if (denialDate != null)
			return GenericDateUtils.formatDate(this.getDenialDate(), _DATEFORMAT + " "
					+ _TIMEFORMAT, null, _TIMEZONE);
		else
			return "";
	}

	@Transient
	public String get_DATEFORMAT() {
		return _DATEFORMAT;
	}

	public void set_DATEFORMAT(String _dateformat) {
		_DATEFORMAT = _dateformat;
	}

	@Transient
	public String get_TIMEFORMAT() {
		return _TIMEFORMAT;
	}

	public void set_TIMEFORMAT(String _timeformat) {
		_TIMEFORMAT = _timeformat;
	}

	@Transient
	public TimeZone get_TIMEZONE() {
		return _TIMEZONE;
	}

	public void set_TIMEZONE(TimeZone _timezone) {
		_TIMEZONE = _timezone;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDenialDate() {
		return denialDate;
	}

	public void setDenialDate(Date denialDate) {
		this.denialDate = denialDate;
	}

	public String getDenialReason() {
		return denialReason;
	}

	public void setDenialReason(String denialReason) {
		this.denialReason = denialReason;
	}

	public int getDenied() {
		return denied;
	}

	public void setDenied(int denied) {
		this.denied = denied;
	}

	@ManyToOne
	@JoinColumn(name = "status_id")
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Id
	@GeneratedValue
	public int getOhd_request_id() {
		return ohd_request_id;
	}

	public void setOhd_request_id(int ohd_request_id) {
		this.ohd_request_id = ohd_request_id;
	}

	@Transient
	public String getIncident_ID() {
		return incident_ID;
	}

	public void setIncident_ID(String incident_ID) {
		this.incident_ID = incident_ID;
	}

	@ManyToOne
	@JoinColumn(name = "ohd_ID")
	public OHD getOhd() {
		return ohd;
	}

	public void setOhd(OHD ohd) {
		this.ohd = ohd;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@ManyToOne
	@JoinColumn(name = "forward_to_station_ID")
	public Station getRequestForStation() {
		return requestForStation;
	}

	public void setRequestForStation(Station requestForStation) {
		this.requestForStation = requestForStation;
	}

	@ManyToOne
	@JoinColumn(name = "requesting_agent_id")
	public Agent getRequestingAgent() {
		return requestingAgent;
	}

	public void setRequestingAgent(Agent requestingAgent) {
		this.requestingAgent = requestingAgent;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	public int getMatch_id() {
		return match_id;
	}

	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}

	public int getForward_id() {
		return forward_id;
	}

	public void setForward_id(int forward_id) {
		this.forward_id = forward_id;
	}

	@Transient
	public boolean isMatched() {
		return match_id > 0;
	}

	public void setMatched(boolean matched) {
		// Cannot set a boolean to match_id, do nothing (this method is so that
		// dozer does not throw an exception
	}

	@ManyToOne
	@JoinColumn(name = "incident_ID")
	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}
}