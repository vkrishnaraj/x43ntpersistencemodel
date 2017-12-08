package aero.nettracer.persistence.model.dr;

import java.util.Date;
import java.util.TimeZone;

import aero.nettracer.commons.constant.GenericConstants;
import aero.nettracer.commons.utils.GenericDateUtils;
import aero.nettracer.persistence.model.Agent;
import aero.nettracer.persistence.model.Incident;
import aero.nettracer.persistence.model.Lock;
import aero.nettracer.persistence.model.Station;
import aero.nettracer.persistence.model.Status;
import aero.nettracer.persistence.model.taskmanager.DisputeResolutionTask;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name="dispute")
public class Dispute {

	private long dispute_res_id;
	private Status status;
	private Date created_timestamp;
	private Date resolution_timestamp;

	private Incident incident;
	
	private Agent disputeAgent;
	private Station suggestedFaultStation;
	private int suggestedLossCode = 0;
	private String disputeExplanation;
	
	private Agent resolutionAgent;
	private Station determinedFaultStation;
	private int determinedLossCode = 0;
	private String resolutionRemarks;
	
	private Station beforeDisputeFaultStation;
	private int beforeDisputeLossCode = 0;
	
	private String typeOfChange = "";
	
	private Lock lock;
	
	private String _DATEFORMAT; // current login agent's date format
	private String _TIMEFORMAT; // current login agent's time format
	private TimeZone _TIMEZONE;
	
	private DisputeResolutionTask disputeResolutionTask;
	
	@Id
	@GeneratedValue
	public long getDispute_res_id() {
		return dispute_res_id;
	}
	
	public void setDispute_res_id(long dispute_res_id) {
		this.dispute_res_id = dispute_res_id;
	}
	
	@ManyToOne
	@JoinColumn(name = "status_ID", nullable = false)
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreated_timestamp() {
		return created_timestamp;
	}
	
	public void setCreated_timestamp(Date created_timestamp) {
		this.created_timestamp = created_timestamp;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getResolution_timestamp() {
		return resolution_timestamp;
	}
	
	public void setResolution_timestamp(Date resolution_timestamp) {
		this.resolution_timestamp = resolution_timestamp;
	}
	
	@Transient
	public Lock getLock() {
		return lock;
	}
	
	public void setLock(Lock lock) {
		this.lock = lock;
	}
	
	@OneToOne(targetEntity = Incident.class)
	@JoinColumn(name = "Incident_ID", nullable = false)
	public Incident getIncident() {
		return incident;
	}
	
	public void setIncident(Incident incident) {
		this.incident = incident;
	}
	
	@ManyToOne
	@JoinColumn(name = "suggested_station_ID", nullable = false)
	public Station getSuggestedFaultStation() {
		return suggestedFaultStation;
	}
	
	public void setSuggestedFaultStation(Station suggestedFaultStation) {
		this.suggestedFaultStation = suggestedFaultStation;
	}
	
	public int getSuggestedLossCode() {
		return suggestedLossCode;
	}
	
	public void setSuggestedLossCode(int suggestedLossCode) {
		this.suggestedLossCode = suggestedLossCode;
	}
	
	@ManyToOne
	@JoinColumn(name = "determined_station_ID", nullable = false)
	public Station getDeterminedFaultStation() {
		return determinedFaultStation;
	}
	
	public void setDeterminedFaultStation(Station determinedFaultStation) {
		this.determinedFaultStation = determinedFaultStation;
	}
	
	public int getDeterminedLossCode() {
		return determinedLossCode;
	}
	
	public void setDeterminedLossCode(int determinedLossCode) {
		this.determinedLossCode = determinedLossCode;
	}
	
	@ManyToOne
	@JoinColumn(name = "dispute_agent_ID", nullable = false)
	public Agent getDisputeAgent() {
		return disputeAgent;
	}
	
	public void setDisputeAgent(Agent disputeAgent) {
		this.disputeAgent = disputeAgent;
	}
	
	public String getDisputeExplanation() {
		return disputeExplanation;
	}
	
	public void setDisputeExplanation(String disputeExplanation) {
		this.disputeExplanation = disputeExplanation;
	}
	
	@Transient
	public String getReadOnlyDisputeExplanation() {
		if(disputeExplanation!=null) {
			return disputeExplanation.replaceAll("\r\n", "<br>");
		} else {
			return "";
		}
		
	}

	@ManyToOne
	@JoinColumn(name = "resolution_agent_ID", nullable = false)
	public Agent getResolutionAgent() {
		return resolutionAgent;
	}
	
	public void setResolutionAgent(Agent resolutionAgent) {
		this.resolutionAgent = resolutionAgent;
	}
	
	public String getResolutionRemarks() {
		return resolutionRemarks;
	}
	
	public void setResolutionRemarks(String resolutionRemarks) {
		this.resolutionRemarks = resolutionRemarks;
	}

	@Transient
	public String getReadOnlyResolutionRemarks() {
		if(resolutionRemarks!=null){
			return resolutionRemarks.replaceAll("\r\n", "<br>");
		} else {
			return "";
		} 
	}
	
	@ManyToOne
	@JoinColumn(name = "before_dispute_fault_station_ID", nullable = false)
	public Station getBeforeDisputeFaultStation() {
		return beforeDisputeFaultStation;
	}
	
	public void setBeforeDisputeFaultStation(Station beforeDisputeFaultStation) {
		this.beforeDisputeFaultStation = beforeDisputeFaultStation;
	}
	
	public int getBeforeDisputeLossCode() {
		return beforeDisputeLossCode;
	}
	
	public void setBeforeDisputeLossCode(int beforeDisputeLossCode) {
		this.beforeDisputeLossCode = beforeDisputeLossCode;
	}
	
	public String getTypeOfChange() {
		return typeOfChange;
	}
	
	public void setTypeOfChange(String typeOfChange) {
		this.typeOfChange = typeOfChange;
	}
	
	@Transient
	public String getDispTimestampCreated() {
		Date completedate = GenericDateUtils.convertToDate(getCreated_timestamp().toString() + " " + getCreated_timestamp().toString(), GenericConstants.DB_DATETIMEFORMAT,
				null);
		return GenericDateUtils.formatDate(completedate, _DATEFORMAT + " " + _TIMEFORMAT, null, _TIMEZONE);
	}
	
	@Transient
	public String getDispTimestampResolved() {
		if(getResolution_timestamp() == null){
			return "";
		}
		Date completedate = GenericDateUtils.convertToDate(getResolution_timestamp().toString() + " " + getResolution_timestamp().toString(), GenericConstants.DB_DATETIMEFORMAT,
				null);
		return GenericDateUtils.formatDate(completedate, _DATEFORMAT + " " + _TIMEFORMAT, null, _TIMEZONE);
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
	
	@OneToOne(mappedBy = "dispute", cascade = CascadeType.REMOVE, fetch=FetchType.LAZY)
	public DisputeResolutionTask getDisputeResolutionTask() {
		return disputeResolutionTask;
	}
	
	public void setDisputeResolutionTask(DisputeResolutionTask disputeResolutionTask) {
		this.disputeResolutionTask = disputeResolutionTask;
	}
}
