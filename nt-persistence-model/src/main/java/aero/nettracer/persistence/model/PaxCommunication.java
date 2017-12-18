package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;

@Entity
@Table(name = "pax_communication")
public class PaxCommunication {

	private int id;
	private Timestamp acknowledge_timestamp;
	private String comment;
	private Timestamp createdate;
	private PaxCommunicationStatus status = PaxCommunicationStatus.NEW;
	private Agent acknowledge_agent;
	private Agent agent;
	private Incident incident;

	public static enum PaxCommunicationStatus {
		ACKNOWLEDGED, NEW, READ, RESPONDED
	}

	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "acknowledge_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getAcknowledge_timestamp() {
		return acknowledge_timestamp;
	}

	public void setAcknowledge_timestamp(Timestamp acknowledge_timestamp) {
		this.acknowledge_timestamp = acknowledge_timestamp;
	}

	@Column(nullable = false, length = 1500, columnDefinition = "text")
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name = "createdate")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}


	@Enumerated(EnumType.STRING)
	@Column(nullable = false, name = "status", length = 12)
	public PaxCommunicationStatus getStatus() {
		return status;
	}

	public void setStatus(PaxCommunicationStatus status) {
		this.status = status;
	}

	@ManyToOne
	@JoinColumn(name = "acknowledge_agent_agent_id")
	public Agent getAcknowledge_agent() {
		return acknowledge_agent;
	}

	public void setAcknowledge_agent(Agent acknowledge_agent) {
		this.acknowledge_agent = acknowledge_agent;
	}

	@ManyToOne
	@JoinColumn(name = "agent_agent_id")
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	@ManyToOne
	@JoinColumn(name = "incident_incident_id", nullable = false)
	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

}
