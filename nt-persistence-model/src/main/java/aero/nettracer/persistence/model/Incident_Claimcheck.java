package aero.nettracer.persistence.model;

import aero.nettracer.commons.utils.CommonsUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "incident_claimcheck")
public class Incident_Claimcheck {

	private int id;
	private Incident incident;
	private String claimchecknum="";
	private String OHD_ID="";
	private String claimchecknum_leading;
	private String claimchecknum_ticketingcode;
	private String claimchecknum_carriercode;
	private String claimchecknum_bagnumber;
	private String tempOHD_ID="";

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "incident_id")
	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	@Column(name = "claimchecknum")
	public String getClaimchecknum() {
		return claimchecknum;
	}

	public void setClaimchecknum(String claimchecknum) {
		if (claimchecknum != null)
			claimchecknum = CommonsUtils.removeSpaces(claimchecknum);
		this.claimchecknum = claimchecknum;
	}

	@Column(name = "ohd_id")
	public String getOHD_ID() {
		return OHD_ID;
	}

	public void setOHD_ID(String ohd_id) {
		OHD_ID = ohd_id;
	}

	@Column(name = "claimchecknum_leading")
	public String getClaimchecknum_leading() {
		return claimchecknum_leading;
	}

	public void setClaimchecknum_leading(String claimchecknum_leading) {
		this.claimchecknum_leading = claimchecknum_leading;
	}

	@Column(name = "claimchecknum_ticketingcode")
	public String getClaimchecknum_ticketingcode() {
		return claimchecknum_ticketingcode;
	}

	public void setClaimchecknum_ticketingcode(String claimchecknum_ticketingcode) {
		this.claimchecknum_ticketingcode = claimchecknum_ticketingcode;
	}

	@Column(name = "claimchecknum_carriercode")
	public String getClaimchecknum_carriercode() {
		return claimchecknum_carriercode;
	}

	public void setClaimchecknum_carriercode(String claimchecknum_carriercode) {
		this.claimchecknum_carriercode = claimchecknum_carriercode;
	}

	@Column(name = "claimchecknum_bagnumber")
	public String getClaimchecknum_bagnumber() {
		return claimchecknum_bagnumber;
	}

	public void setClaimchecknum_bagnumber(String claimchecknum_bagnumber) {
		this.claimchecknum_bagnumber = claimchecknum_bagnumber;
	}

	@Transient
	public String getTempOHD_ID() {
		return tempOHD_ID;
	}

	public void setTempOHD_ID(String tempOHD_ID) {
		this.tempOHD_ID = tempOHD_ID;
	}

}