package aero.nettracer.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "message_copies")
public class MessageCopy {

	private int id;
	private Message parent_message;
	private Station receiving_station;
	private Status status;
	private String subject;
	private Agent agent;
	private String body;

	@Id
	@GeneratedValue
	@Column(name = "message_copy_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "message_id")
	public Message getParent_message() {
		return parent_message;
	}

	public void setParent_message(Message parent_message) {
		this.parent_message = parent_message;
	}

	@ManyToOne
	@JoinColumn(name = "station_id")
	public Station getReceiving_station() {
		return receiving_station;
	}

	public void setReceiving_station(Station receiving_station) {
		this.receiving_station = receiving_station;
	}

	@ManyToOne
	@JoinColumn(name = "status_id")
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Column(name = "subject")
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@ManyToOne
	@JoinColumn(name = "agent_id")
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	@Column(name = "body")
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}