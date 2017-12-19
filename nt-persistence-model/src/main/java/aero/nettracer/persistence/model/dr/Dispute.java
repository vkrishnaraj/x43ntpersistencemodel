package aero.nettracer.persistence.model.dr;

import aero.nettracer.persistence.model.Agent;
import aero.nettracer.persistence.model.Incident;
import aero.nettracer.persistence.model.Lock;
import aero.nettracer.persistence.model.Station;
import aero.nettracer.persistence.model.Status;
import aero.nettracer.persistence.model.taskmanager.DisputeResolutionTask;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.sql.Timestamp;

@Entity
@Table(name="dispute")
public class Dispute {

	private long id;
	private int beforeDisputeLossCode = 0;
	private Timestamp created_timestamp;
	private int determinedLossCode;
	private String disputeExplanation;
	private String resolutionRemarks;
	private int suggestedLossCode;
	private String typeOfChange = "";
	private Station beforeDisputeFaultStation;
	private Station determinedFaultStation;
	private Agent disputeAgent;
	private Incident incident;
	private Agent resolutionAgent;
	private Status status;
	private Station suggestedFaultStation;
	private Timestamp resolution_timestamp;
	private Lock lock;
	private DisputeResolutionTask disputeResolutionTask;
	
	@Id
	@GeneratedValue
	@Column(name = "dispute_res_id")
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "beforedisputelosscode")
	public int getBeforeDisputeLossCode() {
		return beforeDisputeLossCode;
	}

	public void setBeforeDisputeLossCode(int beforeDisputeLossCode) {
		this.beforeDisputeLossCode = beforeDisputeLossCode;
	}

	@Column(name = "created_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getCreated_timestamp() {
		return created_timestamp;
	}

	public void setCreated_timestamp(Timestamp created_timestamp) {
		this.created_timestamp = created_timestamp;
	}

	@Column(name = "determinedlosscode")
	public int getDeterminedLossCode() {
		return determinedLossCode;
	}

	public void setDeterminedLossCode(int determinedLossCode) {
		this.determinedLossCode = determinedLossCode;
	}

	@Column(name = "disputeexplanation")
	public String getDisputeExplanation() {
		return disputeExplanation;
	}

	public void setDisputeExplanation(String disputeExplanation) {
		this.disputeExplanation = disputeExplanation;
	}

	@Column(name = "resolutionremarks")
	public String getResolutionRemarks() {
		return resolutionRemarks;
	}

	public void setResolutionRemarks(String resolutionRemarks) {
		this.resolutionRemarks = resolutionRemarks;
	}

	@Column(name = "suggestedlosscode")
	public int getSuggestedLossCode() {
		return suggestedLossCode;
	}

	public void setSuggestedLossCode(int suggestedLossCode) {
		this.suggestedLossCode = suggestedLossCode;
	}

	@Column(name = "typeofchange")
	public String getTypeOfChange() {
		return typeOfChange;
	}

	public void setTypeOfChange(String typeOfChange) {
		this.typeOfChange = typeOfChange;
	}

	@ManyToOne
	@JoinColumn(name = "before_dispute_fault_station_id", nullable = false)
	public Station getBeforeDisputeFaultStation() {
		return beforeDisputeFaultStation;
	}

	public void setBeforeDisputeFaultStation(Station beforeDisputeFaultStation) {
		this.beforeDisputeFaultStation = beforeDisputeFaultStation;
	}

	@ManyToOne
	@JoinColumn(name = "determined_station_id", nullable = false)
	public Station getDeterminedFaultStation() {
		return determinedFaultStation;
	}

	public void setDeterminedFaultStation(Station determinedFaultStation) {
		this.determinedFaultStation = determinedFaultStation;
	}

	@ManyToOne
	@JoinColumn(name = "dispute_agent_id", nullable = false)
	public Agent getDisputeAgent() {
		return disputeAgent;
	}

	public void setDisputeAgent(Agent disputeAgent) {
		this.disputeAgent = disputeAgent;
	}

	@OneToOne
	@JoinColumn(name = "incident_id", nullable = false)
	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	@ManyToOne
	@JoinColumn(name = "resolution_agent_id", nullable = false)
	public Agent getResolutionAgent() {
		return resolutionAgent;
	}

	public void setResolutionAgent(Agent resolutionAgent) {
		this.resolutionAgent = resolutionAgent;
	}

	@ManyToOne
	@JoinColumn(name = "status_id", nullable = false)
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}

	@ManyToOne
	@JoinColumn(name = "suggested_station_id", nullable = false)
	public Station getSuggestedFaultStation() {
		return suggestedFaultStation;
	}

	public void setSuggestedFaultStation(Station suggestedFaultStation) {
		this.suggestedFaultStation = suggestedFaultStation;
	}

	@Column(name = "resolution_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getResolution_timestamp() {
		return resolution_timestamp;
	}
	
	public void setResolution_timestamp(Timestamp resolution_timestamp) {
		this.resolution_timestamp = resolution_timestamp;
	}
	
	@Transient
	public Lock getLock() {
		return lock;
	}
	
	public void setLock(Lock lock) {
		this.lock = lock;
	}
	
	@OneToOne(mappedBy = "dispute", cascade = CascadeType.REMOVE)
	public DisputeResolutionTask getDisputeResolutionTask() {
		return disputeResolutionTask;
	}
	
	public void setDisputeResolutionTask(DisputeResolutionTask disputeResolutionTask) {
		this.disputeResolutionTask = disputeResolutionTask;
	}

	@Transient
	public String getReadOnlyDisputeExplanation() {
		if(disputeExplanation!=null) {
			return disputeExplanation.replaceAll("\r\n", "<br>");
		} else {
			return "";
		}

	}

	@Transient
	public String getReadOnlyResolutionRemarks() {
		if(resolutionRemarks!=null){
			return resolutionRemarks.replaceAll("\r\n", "<br>");
		} else {
			return "";
		}
	}

}
