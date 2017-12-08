package aero.nettracer.persistence.model.audit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;

import aero.nettracer.commons.constant.GenericConstants;
import aero.nettracer.commons.utils.CommonsConstants;
import aero.nettracer.commons.utils.GenericDateUtils;
import aero.nettracer.persistence.model.Agent;
import aero.nettracer.persistence.model.Incident;
import aero.nettracer.persistence.model.Status;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Audit_Claim")
public class Audit_Claim implements Serializable {
	private int audit_claim_id;
	private long Claim_ID;
	private double claimamount;
	private String claimcurrency_ID;
	private String ssn;
	private String driverslicense;
	private String dlstate;
	private String commonnum;
	private String countryofissue;
	private Status status;
	private Incident incident;
	private String _DATEFORMAT; // current login agent's date format
	private String _TIMEFORMAT; // current login agent's time format
	private TimeZone _TIMEZONE;
	private Agent modify_agent;
	private Date modify_time;
	private String modify_reason;
	private Set<Audit_ExpensePayout> expenses;
	private Audit_ClaimProrate audit_claimprorate;

	@ManyToOne
	@JoinColumn(name = "modify_agent_id")
	public Agent getModify_agent() {
		return modify_agent;
	}

	public void setModify_agent(Agent modify_agent) {
		this.modify_agent = modify_agent;
	}

	public String getModify_reason() {
		return modify_reason;
	}

	public void setModify_reason(String modify_reason) {
		this.modify_reason = modify_reason;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getModify_time() {
		return modify_time;
	}

	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}

	@Transient
	public String getDispmodify_time() {
		Date completedate = GenericDateUtils.convertToDate(getModify_time().toString(),
				GenericConstants.DB_DATETIMEFORMAT, null);
		return GenericDateUtils.formatDate(completedate, _DATEFORMAT + " " + _TIMEFORMAT, null, _TIMEZONE);
	}

	@OneToMany(mappedBy = "audit_claim", fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@OrderBy(clause = "createdate")
	public Set<Audit_ExpensePayout> getExpenses() {
		return expenses;
	}

	public void setExpenses(Set<Audit_ExpensePayout> expenses) {
		this.expenses = expenses;
	}

	@Transient
	public ArrayList<Audit_ExpensePayout> getExpense_list() {
		return new ArrayList((expenses != null ? expenses : new HashSet()));
	}

	@ManyToOne
	@JoinColumn(name = "audit_claimprorate_id")
	@Cascade(CascadeType.ALL)
	public Audit_ClaimProrate getAudit_claimprorate() {
		return audit_claimprorate;
	}

	public void setAudit_claimprorate(Audit_ClaimProrate audit_claimprorate) {
		this.audit_claimprorate = audit_claimprorate;
	}

	@Id
	@GeneratedValue
	public int getAudit_claim_id() {
		return audit_claim_id;
	}

	public void setAudit_claim_id(int audit_claim_id) {
		this.audit_claim_id = audit_claim_id;
	}

	@ManyToOne
	@JoinColumn(name = "status_ID")
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public double getClaimamount() {
		return claimamount;
	}

	public void setClaimamount(double claimamount) {
		this.claimamount = claimamount;
	}

	@Transient
	public String getDisclaimamount() {
		return CommonsConstants.DECIMALFORMAT.format(getClaimamount());
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getDlstate() {
		return dlstate;
	}

	public void setDlstate(String dlstate) {
		this.dlstate = dlstate;
	}

	public String getDriverslicense() {
		return driverslicense;
	}

	public void setDriverslicense(String driverslicense) {
		this.driverslicense = driverslicense;
	}

	public String getCommonnum() {
		return commonnum;
	}

	public void setCommonnum(String commonnum) {
		this.commonnum = commonnum;
	}

	public String getCountryofissue() {
		return countryofissue;
	}

	public void setCountryofissue(String countryofissue) {
		this.countryofissue = countryofissue;
	}
	
	public long getClaim_ID() {
		return Claim_ID;
	}

	public void setClaim_ID(long claim_ID) {
		Claim_ID = claim_ID;
	}

	@Column(name = "currency_ID")
	public String getClaimcurrency_ID() {
		return claimcurrency_ID;
	}

	public void setClaimcurrency_ID(String claimcurrency_ID) {
		this.claimcurrency_ID = claimcurrency_ID;
	}

	@ManyToOne
	@JoinColumn(name = "incident_ID")
	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
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
}