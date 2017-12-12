package aero.nettracer.persistence.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "billing")
public class Billing {

	private int id;
	private String companyCode;
	private Station station;
	private Incident incident;
	private Timestamp create_date_time;
	private Timestamp status_change_time;
	private Agent agent;

	@Id
	@GeneratedValue
	@Column(name = "billing_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "companycode", nullable = false)
	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	@ManyToOne
	@JoinColumn(name = "station_id", nullable = false)
	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	@ManyToOne
	@JoinColumn(name = "report_num", nullable = false)
	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	@Column(name = "create_date_time", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getCreate_date_time() {
		return create_date_time;
	}

	public void setCreate_date_time(Timestamp create_date_time) {
		this.create_date_time = create_date_time;
	}

	@Column(name = "status_change_time")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getStatus_change_time() {
		return status_change_time;
	}

	public void setStatus_change_time(Timestamp status_change_time) {
		this.status_change_time = status_change_time;
	}

	@ManyToOne
	@JoinColumn(name = "agent_id")
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}
}