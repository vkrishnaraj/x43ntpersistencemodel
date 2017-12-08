package aero.nettracer.persistence.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import aero.nettracer.commons.utils.CommonsUtils;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "match_history")
public class Match implements Serializable {

	private int match_id;
	private int match_type; // 0 = passive, 1 = active
	private Incident mbr;
	private OHD ohd;
	private int bagnumber;
	private String claimchecknum;
	private double match_percent;
	private Date match_made_on;
	private Status status;
	private Set<Match_Detail> details;
	private int category;
	private String dispdate;

	@Transient
	public String getReportPercentage() {
		return "" + match_percent;
	}

	@Transient
	public String getReportCategory() {
		return "" + category;
	}

	@Transient
	public String getReportNumber() {
		return mbr.getIncident_ID();
	}

	@Transient
	public String getOhdNumber() {
		return ohd.getOHD_ID();
	}

	@Transient
	public List getDisplayDetails() {
		if (details == null || details.size() < 1) return null;

		return new ArrayList(details);
	}

	//NTFIXEME
	/*@Transient
	public JRBeanCollectionDataSource getReportDetails() {
		if (details == null || details.size() < 1) return null;

		return new JRBeanCollectionDataSource(new ArrayList(details));
	}*/

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	@OneToMany(mappedBy = "match", fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	@OrderBy(clause = "item")
	public Set<Match_Detail> getDetails() {
		return details;
	}

	public void setDetails(Set<Match_Detail> details) {
		this.details = details;
	}

	@ManyToOne
	@JoinColumn(name = "status_ID")
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Id
	@GeneratedValue
	public int getMatch_id() {
		return match_id;
	}

	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}

	public Date getMatch_made_on() {
		return match_made_on;
	}

	public void setMatch_made_on(Date match_made_on) {
		this.match_made_on = match_made_on;
	}

	public double getMatch_percent() {
		return match_percent;
	}

	public void setMatch_percent(double match_percent) {
		this.match_percent = match_percent;
	}

	public int getMatch_type() {
		return match_type;
	}

	public void setMatch_type(int match_type) {
		this.match_type = match_type;
	}

	@ManyToOne
	@JoinColumn(name = "mbr_number")
	public Incident getMbr() {
		return mbr;
	}

	public void setMbr(Incident mbr) {
		this.mbr = mbr;
	}

	@ManyToOne
	@JoinColumn(name = "ohd_id")
	public OHD getOhd() {
		return ohd;
	}

	public void setOhd(OHD ohd) {
		this.ohd = ohd;
	}

	public int getBagnumber() {
		return bagnumber;
	}

	public void setBagnumber(int bagnumber) {
		this.bagnumber = bagnumber;
	}

	public String getClaimchecknum() {
		return claimchecknum;
	}

	public void setClaimchecknum(String claimchecknum) {
		this.claimchecknum = claimchecknum;
	}

	@Transient
	public String getDispdate() {
		return dispdate;
	}

	public void setDispdate(String dispdate) {
		this.dispdate = dispdate;
	}

	@Transient
	public String getDisppercent() {
		return CommonsUtils.format(getMatch_percent(), "%");
	}

}