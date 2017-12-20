package aero.nettracer.persistence.model.fraudservice.detection;

import java.io.Serializable;
import java.util.Date;

import aero.nettracer.commons.utils.GenericDateUtils;
import aero.nettracer.persistence.model.fraudservice.File;
import aero.nettracer.persistence.model.fraudservice.messaging.FsMessage;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

@Entity
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

	@Id
	@GeneratedValue
	private long id;
	private String requestedAgent;
	private String requestedAirline;
	@Temporal(TemporalType.TIMESTAMP)
	private Date requestedDate;
	private String responseAgent;
	private Date responseDate;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private RequestStatus status;

	@OneToOne(fetch = FetchType.EAGER)
	private File file;

	@ManyToOne(fetch = FetchType.EAGER)
	private MatchHistory matchHistory;

	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private FsMessage message;

	public File getFile() {
		return file;
	}

	public String getRequestedAirline() {
		return requestedAirline;
	}

	public void setRequestedAirline(String requestedAirline) {
		this.requestedAirline = requestedAirline;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public MatchHistory getMatchHistory() {
		return matchHistory;
	}

	public void setMatchHistory(MatchHistory matchHistory) {
		this.matchHistory = matchHistory;
	}

	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(RequestStatus status) {
		this.status = status;
	}

	public FsMessage getMessage() {
		return message;
	}

	public void setMessage(FsMessage message) {
		this.message = message;
	}

	public Date getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(Date requestedDate) {
		this.requestedDate = requestedDate;
	}

	public String getRequestedAgent() {
		return requestedAgent;
	}

	public void setRequestedAgent(String requestedAgent) {
		this.requestedAgent = requestedAgent;
	}

	public Date getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}

	public String getResponseAgent() {
		return responseAgent;
	}

	public void setResponseAgent(String responseAgent) {
		this.responseAgent = responseAgent;
	}

	@Transient
	public String getDisRequestedDate(String dateFormat) {
		return GenericDateUtils.formatDate(requestedDate, dateFormat, "", null);
	}

}
