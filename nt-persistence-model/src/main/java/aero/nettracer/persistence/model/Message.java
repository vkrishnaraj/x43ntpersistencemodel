package aero.nettracer.persistence.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.Set;

@Entity
@Table(name = "message")
public class Message {

	private int id;
	private Station send_station;
	private String file_ref_number;
	private Agent agent;
	private int file_type;
	private String message;
	private Timestamp send_date;
	private String subject;
	private Set<Recipient> recipients;

	@Id
	@GeneratedValue
	@Column(name = "message_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "station_id")
	public Station getSend_station() {
		return send_station;
	}

	public void setSend_station(Station send_station) {
		this.send_station = send_station;
	}

	@Column(name = "file_ref_number")
	public String getFile_ref_number() {
		return file_ref_number;
	}

	public void setFile_ref_number(String file_ref_number) {
		this.file_ref_number = file_ref_number;
	}

	@ManyToOne
	@JoinColumn(name = "agent_id")
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	@Column(name = "file_type")
	public int getFile_type() {
		return file_type;
	}

	public void setFile_type(int file_type) {
		this.file_type = file_type;
	}

	@Column(name = "message")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "send_date")
	public Timestamp getSend_date() {
		return send_date;
	}

	public void setSend_date(Timestamp send_date) {
		this.send_date = send_date;
	}

	@Column(name = "subject")
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@OneToMany(mappedBy = "message", cascade = CascadeType.ALL)
	@OrderBy(value = "recipient_id")
	public Set<Recipient> getRecipients() {
		return recipients;
	}

	public void setRecipients(Set<Recipient> recipients) {
		this.recipients = recipients;
	}

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

	@Transient
	public String getMessageTo() {
		StringBuffer toRet = new StringBuffer("");
		if (recipients != null && recipients.size() > 0) {
			for (Iterator i = recipients.iterator(); i.hasNext();) {
				Recipient rcpt = (Recipient) i.next();

				if (toRet.length() > 0) toRet.append(", ");
				toRet.append(rcpt.getStation().getCompany().getId() + " "
						+ rcpt.getStation().getStationcode());
			}
		}

		return toRet.toString();
	}


}