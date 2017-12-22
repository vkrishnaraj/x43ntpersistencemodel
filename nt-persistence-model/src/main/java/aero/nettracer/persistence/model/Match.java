package aero.nettracer.persistence.model;

import aero.nettracer.commons.utils.CommonsUtils;
import org.apache.commons.collections4.CollectionUtils;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "match_history")
public class Match {

	private int id;
	private int match_type; // 0 = passive, 1 = active
	private Incident mbr;
	private OHD ohd;
	private int bagnumber;
	private String claimchecknum;
	private double match_percent;
	private Date match_made_on;
	private Status status;
	private int category;
	private Set<Match_Detail> details;
	private String dispdate;

	@Id
	@GeneratedValue
	@Column(name = "match_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "match_type")
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

	@Column(name = "bagnumber")
	public int getBagnumber() {
		return bagnumber;
	}

	public void setBagnumber(int bagnumber) {
		this.bagnumber = bagnumber;
	}

	@Column(name = "claimchecknum")
	public String getClaimchecknum() {
		return claimchecknum;
	}

	public void setClaimchecknum(String claimchecknum) {
		this.claimchecknum = claimchecknum;
	}

	@Column(name = "match_percent")
	public double getMatch_percent() {
		return match_percent;
	}

	public void setMatch_percent(double match_percent) {
		this.match_percent = match_percent;
	}

	@Column(name = "match_made_on")
	public Date getMatch_made_on() {
		return match_made_on;
	}

	public void setMatch_made_on(Date match_made_on) {
		this.match_made_on = match_made_on;
	}

	@ManyToOne
	@JoinColumn(name = "status_ID")
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	@OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
	@OrderBy(value = "item")
	public Set<Match_Detail> getDetails() {
		return details;
	}

	public void setDetails(Set<Match_Detail> details) {
		this.details = details;
	}

	@Transient
	public String getDispdate() {
		return dispdate;
	}

	public void setDispdate(String dispdate) {
		this.dispdate = dispdate;
	}

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
		return mbr.getId();
	}

	@Transient
	public String getOhdNumber() {
		return ohd.getId();
	}

	@Transient
	public List getDisplayDetails() {
		if (CollectionUtils.isEmpty(details)) return null;
		return new ArrayList(details);
	}

	@Transient
	public String getDisppercent() {
		return CommonsUtils.format(getMatch_percent(), "%");
	}

}