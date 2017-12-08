package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.TimeZone;

import aero.nettracer.commons.utils.GenericDateUtils;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "message_copies")
public class MessageCopy implements Serializable {
	private int message_copy_id;
	private Message parent_message;
	private Station receiving_station;
	private String body;
	private String subject;
	private Status status;
	private Agent agent;


	@ManyToOne
	@JoinColumn(name = "status_id")
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	private String _DATEFORMAT;
	private String _TIMEFORMAT;
	private TimeZone _TIMEZONE;

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

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Id
	@GeneratedValue
	public int getMessage_copy_id() {
		return message_copy_id;
	}

	public void setMessage_copy_id(int message_copy_id) {
		this.message_copy_id = message_copy_id;
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
	@JoinColumn(name = "agent_ID")
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Transient
	public String getDisp_send_date() {
		if (parent_message != null) return GenericDateUtils.formatDate(parent_message.getSend_date(),
				_DATEFORMAT + " " + _TIMEFORMAT, null, _TIMEZONE);

		return null;
	}
}