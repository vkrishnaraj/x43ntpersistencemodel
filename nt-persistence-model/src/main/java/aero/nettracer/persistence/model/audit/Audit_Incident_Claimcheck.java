package aero.nettracer.persistence.model.audit;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "audit_Incident_Claimcheck")
public class Audit_Incident_Claimcheck implements Serializable {
	private int audit_claimcheck_id;
	private int Claimcheck_ID;
	private String claimchecknum;
	private String OHD_ID;
	
	private Audit_Incident audit_incident;

	@Id
	@GeneratedValue
	public int getAudit_claimcheck_id() {
		return audit_claimcheck_id;
	}

	public void setAudit_claimcheck_id(int audit_claimcheck_id) {
		this.audit_claimcheck_id = audit_claimcheck_id;
	}

	@ManyToOne
	@JoinColumn(name = "audit_incident_id")
	public Audit_Incident getAudit_incident() {
		return audit_incident;
	}

	public void setAudit_incident(Audit_Incident audit_incident) {
		this.audit_incident = audit_incident;
	}
	
	public int getClaimcheck_ID() {
		return Claimcheck_ID;
	}

	public void setClaimcheck_ID(int claimcheck_ID) {
		Claimcheck_ID = claimcheck_ID;
	}

	public String getClaimchecknum() {
		return claimchecknum;
	}

	public void setClaimchecknum(String claimchecknum) {
		this.claimchecknum = claimchecknum;
	}

	public String getOHD_ID() {
		return OHD_ID;
	}

	public void setOHD_ID(String ohd_id) {
		OHD_ID = ohd_id;
	}
}