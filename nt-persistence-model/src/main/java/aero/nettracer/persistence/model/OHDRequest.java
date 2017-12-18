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
@Table(name = "ohd_request")
public class OHDRequest {

	private int id;
	private Agent requestingAgent;
	private Station requestForStation;
	private Incident incident;
	private OHD ohd;
	private Timestamp requestTime;
	private int match_id;
	private Status status;
	private int forward_id;
	private int denied;
	private String denialReason;
	private Timestamp denialDate;
	private String reason;
	private String incident_ID;

	@Id
	@GeneratedValue
	@Column(name = "ohd_request_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "requesting_agent_id")
	public Agent getRequestingAgent() {
		return requestingAgent;
	}

	public void setRequestingAgent(Agent requestingAgent) {
		this.requestingAgent = requestingAgent;
	}

	@ManyToOne
	@JoinColumn(name = "forward_to_station_id")
	public Station getRequestForStation() {
		return requestForStation;
	}

	public void setRequestForStation(Station requestForStation) {
		this.requestForStation = requestForStation;
	}

	@ManyToOne
	@JoinColumn(name = "incident_id")
	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	@ManyToOne
	@JoinColumn(name = "ohd_ID")
	public OHD getOhd() {
		return ohd;
	}

	public void setOhd(OHD ohd) {
		this.ohd = ohd;
	}

	@Column(name = "requesttime")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Timestamp requestTime) {
		this.requestTime = requestTime;
	}

	@Column(name = "match_id")
	public int getMatch_id() {
		return match_id;
	}

	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}

	@ManyToOne
	@JoinColumn(name = "status_id")
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Column(name = "forward_id")
	public int getForward_id() {
		return forward_id;
	}

	public void setForward_id(int forward_id) {
		this.forward_id = forward_id;
	}

	@Column(name = "denied")
	public int getDenied() {
		return denied;
	}

	public void setDenied(int denied) {
		this.denied = denied;
	}

	@Column(name = "denialreason")
	public String getDenialReason() {
		return denialReason;
	}

	public void setDenialReason(String denialReason) {
		this.denialReason = denialReason;
	}

	@Column(name = "denialdate")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getDenialDate() {
		return denialDate;
	}

	public void setDenialDate(Timestamp denialDate) {
		this.denialDate = denialDate;
	}

	@Column(name = "reason")
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Transient
	public String getIncident_ID() {
		return incident_ID;
	}

	public void setIncident_ID(String incident_ID) {
		this.incident_ID = incident_ID;
	}

	@Transient
	public String getRequestingCompany() {
		return requestForStation.getCompany().getId();
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
	public boolean isMatched() {
		return match_id > 0;
	}

	public void setMatched(boolean matched) {
		// Cannot set a boolean to match_id, do nothing (this method is so that
		// dozer does not throw an exception
	}

}