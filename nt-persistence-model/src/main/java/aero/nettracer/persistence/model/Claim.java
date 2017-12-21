package aero.nettracer.persistence.model;

import aero.nettracer.persistence.model.fraudservice.FsClaim;
import aero.nettracer.persistence.model.fraudservice.FsIncident;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;


@Entity
@DiscriminatorValue("NTCLAIM")
public class Claim extends FsClaim {

    public Claim(){
        super();
    }

    public Claim(long id) {
        super(id);
    }

    private Incident ntIncident;
    private ClaimProrate claimprorate;
    private Status status;
    private Signature signature;
    private Claim_Questionnaire questionnaire;


	@ManyToOne
	@JoinColumn(name = "ntincident_incident_id")
	public Incident getNtIncident() {
		return ntIncident;
	}
	
	public void setNtIncident(Incident ntIncident) {
		super.setNtIncidentId(ntIncident.getId());
		this.ntIncident = ntIncident;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "claimprorate_id")
	public ClaimProrate getClaimprorate() {
		return claimprorate;
	}

	public void setClaimprorate(ClaimProrate claimprorate) {
		if (claimprorate != null) {
			super.setClaimProrateId(claimprorate.getId());
		}
		this.claimprorate = claimprorate;
	}

	@ManyToOne
	@JoinColumn(name = "Status_ID")
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		super.setStatusId(status.getId());
		this.status = status;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "signature_id")
	public Signature getSignature() {
		return signature;
	}

	public void setSignature(Signature signature) {
		this.signature = signature;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "questionnaire_id")
	public Claim_Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Claim_Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}
	
	@Transient
	public int getStatusId() {
		return status.getId();
	}
	
	public void setStatusId(int statusId) {
		super.setStatusId(statusId);
		status.setId(statusId);
	}
	
	public int getFraudStatusId() {
		return super.getFraudStatusId();
	}

	public void setFraudStatusId(int statusId) {
		super.setFraudStatusId(statusId);
	}

	@Transient
	public String getAirlineIncidentId() {
		FsIncident incident = getIncident();
		return incident == null ? "" : incident.getAirlineIncidentId();
	}
}
