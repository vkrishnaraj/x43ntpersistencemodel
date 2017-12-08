package aero.nettracer.persistence.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Incident_Claimcheck")
public class TraceIncident_Claimcheck implements Serializable {

	private int Claimcheck_ID;
	private String claimchecknum="";
	private String OHD_ID="";
	private String tempOHD_ID="";
	private TraceIncident incident;

	@Id
	@GeneratedValue
	public int getClaimcheck_ID() {
		return Claimcheck_ID;
	}

	public void setClaimcheck_ID(int claimcheck_ID) {
		Claimcheck_ID = claimcheck_ID;
	}

	@ManyToOne
	@JoinColumn(name = "incident_ID")
	public TraceIncident getIncident() {
		return incident;
	}

	public void setIncident(TraceIncident incident) {
		this.incident = incident;
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

	@Transient
	public String getTempOHD_ID() {
		return tempOHD_ID;
	}

	@Transient
	public void setTempOHD_ID(String tempOHD_ID) {
		this.tempOHD_ID = tempOHD_ID;
	}
	
}