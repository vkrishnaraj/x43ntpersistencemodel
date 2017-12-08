package aero.nettracer.persistence.model;

import java.io.Serializable;

import aero.nettracer.commons.utils.CommonsUtils;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Incident_Claimcheck")
public class Incident_Claimcheck implements Serializable {

	private static final long serialVersionUID = -7863821205236377195L;
	private int claimcheck_ID;
	private String claimchecknum="";
	private String claimchecknum_leading;
	private String claimchecknum_ticketingcode;
	private String claimchecknum_carriercode;
	private String claimchecknum_bagnumber;
	private String OHD_ID="";
	private String tempOHD_ID="";
	private Incident incident;
	

	@Id
	@GeneratedValue
	public int getClaimcheck_ID() {
		return claimcheck_ID;
	}

	public void setClaimcheck_ID(int claimcheck_ID) {
		this.claimcheck_ID = claimcheck_ID;
	}

	@ManyToOne
	@JoinColumn(name = "incident_ID")
	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	public String getClaimchecknum() {
		return claimchecknum;
	}

	public void setClaimchecknum(String claimchecknum) {
		if (claimchecknum != null)
			claimchecknum = CommonsUtils.removeSpaces(claimchecknum);
		this.claimchecknum = claimchecknum;
	}
	
	public String getClaimchecknum_leading() {
		return claimchecknum_leading;
	}

	public void setClaimchecknum_leading(String claimchecknum_leading) {
		this.claimchecknum_leading = claimchecknum_leading;
	}

	public String getClaimchecknum_ticketingcode() {
		return claimchecknum_ticketingcode;
	}

	public void setClaimchecknum_ticketingcode(String claimchecknum_ticketingcode) {
		this.claimchecknum_ticketingcode = claimchecknum_ticketingcode;
	}

	public String getClaimchecknum_carriercode() {
		return claimchecknum_carriercode;
	}

	public void setClaimchecknum_carriercode(String claimchecknum_carriercode) {
		this.claimchecknum_carriercode = claimchecknum_carriercode;
	}

	public String getClaimchecknum_bagnumber() {
		return claimchecknum_bagnumber;
	}

	public void setClaimchecknum_bagnumber(String claimchecknum_bagnumber) {
		this.claimchecknum_bagnumber = claimchecknum_bagnumber;
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

	public void setTempOHD_ID(String tempOHD_ID) {
		this.tempOHD_ID = tempOHD_ID;
	}

}