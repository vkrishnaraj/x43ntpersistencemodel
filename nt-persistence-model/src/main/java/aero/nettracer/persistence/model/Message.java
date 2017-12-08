package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TimeZone;

import aero.nettracer.commons.utils.GenericDateUtils;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "message")
public class Message implements Serializable {
	private int message_id;
	private Station send_station;
	private Set<Recipient> recipients;
	private String message;
	private Date send_date;
	private String subject;
	private String file_ref_number;
	private int file_type;
	private String _DATEFORMAT;
	private String _TIMEFORMAT;
	private TimeZone _TIMEZONE;
	private Agent agent;

	@Transient
	public String getCreatedBy() {
		if (agent != null) return agent.getUsername();
		else return "";
	}

	@Transient
	public String getStationString() {
		if (send_station != null) return send_station.getStationcode();
		else return "";
	}

	@ManyToOne
	@JoinColumn(name = "agent_id")
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public String getFile_ref_number() {
		return file_ref_number;
	}

	public void setFile_ref_number(String file_ref_number) {
		this.file_ref_number = file_ref_number;
	}

	public int getFile_type() {
		return file_type;
	}

	public void setFile_type(int file_type) {
		this.file_type = file_type;
	}

	@Transient
	public String getDisp_send_date() {
		return GenericDateUtils.formatDate(this.getSend_date(), _DATEFORMAT + " " + _TIMEFORMAT, null,
				_TIMEZONE);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Id
	@GeneratedValue
	public int getMessage_id() {
		return message_id;
	}

	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}

	@OneToMany(mappedBy = "message", fetch = FetchType.EAGER)
	@OrderBy(clause = "recipient_id")
	@Cascade(CascadeType.ALL)
	public Set<Recipient> getRecipients() {
		return recipients;
	}

	@Transient
	public String getMessageTo() {

		StringBuffer toRet = new StringBuffer("");

		if (recipients != null && recipients.size() > 0) {
			for (Iterator i = recipients.iterator(); i.hasNext();) {
				Recipient rcpt = (Recipient) i.next();

				if (toRet.length() > 0) toRet.append(", ");
				toRet.append(rcpt.getStation().getCompany().getCompanyCode_ID() + " "
						+ rcpt.getStation().getStationcode());
			}
		}

		return toRet.toString();
	}

	public void setRecipients(Set<Recipient> recipients) {
		this.recipients = recipients;
	}

	public Date getSend_date() {
		return send_date;
	}

	public void setSend_date(Date send_date) {
		this.send_date = send_date;
	}

	@ManyToOne
	@JoinColumn(name = "station_id")
	public Station getSend_station() {
		return send_station;
	}

	public void setSend_station(Station send_station) {
		this.send_station = send_station;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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

}