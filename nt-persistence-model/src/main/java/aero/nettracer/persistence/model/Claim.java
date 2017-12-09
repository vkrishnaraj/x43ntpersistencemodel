package aero.nettracer.persistence.model;

import aero.nettracer.persistence.model.fraudservice.FsClaim;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Proxy;


@Entity
@DiscriminatorValue("NTCLAIM")
public class Claim extends FsClaim {


	
	/*public Claim(){
		super();
	}
	
	public Claim(long id) {
		super(id);
	}

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ntIncident_Incident_ID")
	private Incident ntIncident;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Claimprorate_ID")
	private ClaimProrate claimprorate;

	@ManyToOne
	@JoinColumn(name = "Status_ID")
	private Status status;

	@ManyToOne(targetEntity = Signature.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "signature_id")
	private Signature signature;

	@ManyToOne(targetEntity = Claim_Questionnaire.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "questionnaire_id")
	private Claim_Questionnaire questionnaire;
	
	public Incident getNtIncident() {
		return ntIncident;
	}
	
	public void setNtIncident(Incident ntIncident) {
		super.setNtIncidentId(ntIncident.getIncident_ID());
		this.ntIncident = ntIncident;
	}
	
	public ClaimProrate getClaimprorate() {
		return claimprorate;
	}

	public void setClaimprorate(ClaimProrate claimprorate) {
		if (claimprorate != null) {
			super.setClaimProrateId(claimprorate.getClaimprorate_ID());
		}
		this.claimprorate = claimprorate;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		super.setStatusId(status.getStatus_ID());
		this.status = status;
	}

	public Signature getSignature() {
		return signature;
	}

	public void setSignature(Signature signature) {
		this.signature = signature;
	}

	public Claim_Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Claim_Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}
	
	@Transient
	public int getStatusId() {
		return status.getStatus_ID();
	}
	
	public void setStatusId(int statusId) {
		super.setStatusId(statusId);
		status.setStatus_ID(statusId);
	}
	
	public void setFraudStatusId(int statusId) {
		super.setFraudStatusId(statusId);
	}
	
	public int getFraudStatusId() {
		return super.getFraudStatusId();
	} */
}
