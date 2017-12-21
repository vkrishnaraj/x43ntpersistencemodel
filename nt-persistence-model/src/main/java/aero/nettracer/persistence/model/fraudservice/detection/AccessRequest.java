package aero.nettracer.persistence.model.fraudservice.detection;

import aero.nettracer.commons.utils.GenericDateUtils;
import aero.nettracer.persistence.model.fraudservice.File;
import aero.nettracer.persistence.model.fraudservice.messaging.FsMessage;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.sql.Timestamp;

@Entity
@Table(name = "accessrequest")
public class AccessRequest {

	public enum RequestStatus {
		Created(0), Approved(1), Denied(2);

		private int requestStatusIndex;

		private RequestStatus(int requestStatusIndex) { this.requestStatusIndex = requestStatusIndex; }

		public static RequestStatus getRequestStatus(int requestStatusIndex) {
			for (RequestStatus r : RequestStatus.values()) {
				if (r.requestStatusIndex == requestStatusIndex) {
					return r;
				}
			}
			throw new IllegalArgumentException("RequestStatus not found.");
		}
	}

	private long id;
	private String requestedAgent;
	private String requestedAirline;
	private Timestamp requestedDate;
	private String responseAgent;
	private Timestamp responseDate;
	private RequestStatus status;
	private File file;
	//private MatchHistory matchHistory;
	private FsMessage message;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "requestedagent")
	public String getRequestedAgent() {
		return requestedAgent;
	}

	public void setRequestedAgent(String requestedAgent) {
		this.requestedAgent = requestedAgent;
	}

	@Column(name = "requestedairline")
	public String getRequestedAirline() {
		return requestedAirline;
	}

	public void setRequestedAirline(String requestedAirline) {
		this.requestedAirline = requestedAirline;
	}

	@Column(name = "requesteddate")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(Timestamp requestedDate) {
		this.requestedDate = requestedDate;
	}

	@Column(name = "responseagent")
	public String getResponseAgent() {
		return responseAgent;
	}

	public void setResponseAgent(String responseAgent) {
		this.responseAgent = responseAgent;
	}

	@Column(name = "responsedate")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(Timestamp responseDate) {
		this.responseDate = responseDate;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(RequestStatus status) {
		this.status = status;
	}

	@OneToOne
	@JoinColumn(name = "file_id")
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	/*@ManyToOne
	@JoinColumn(name = "matchhistory_id")
	public MatchHistory getMatchHistory() {
		return matchHistory;
	}

	public void setMatchHistory(MatchHistory matchHistory) {
		this.matchHistory = matchHistory;
	}*/

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "message_id")
	public FsMessage getMessage() {
		return message;
	}

	public void setMessage(FsMessage message) {
		this.message = message;
	}

	@Transient
	public String getDisRequestedDate(String dateFormat) {
		return GenericDateUtils.formatDate(requestedDate, dateFormat, "", null);
	}

}
