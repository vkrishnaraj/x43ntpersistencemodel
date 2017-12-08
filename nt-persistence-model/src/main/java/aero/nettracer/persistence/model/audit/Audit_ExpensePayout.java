package aero.nettracer.persistence.model.audit;

import java.io.Serializable;
import java.util.Date;
import java.util.TimeZone;

import aero.nettracer.commons.utils.CommonsConstants;
import aero.nettracer.commons.utils.GenericDateUtils;
import aero.nettracer.persistence.model.Agent;
import aero.nettracer.persistence.model.ExpenseType;
import aero.nettracer.persistence.model.Station;
import aero.nettracer.persistence.model.Status;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Audit_ExpensePayout")
public class Audit_ExpensePayout implements Serializable {
	private int audit_expensepayout_id;
	private int Expensepayout_ID;
	private Date createdate;
	private String paycode;
	private String draft;
	private Date draftreqdate;
	private Date draftpaiddate;
	private double checkamt;
	private double voucheramt;
	private int mileageamt;
	private double pcardamt;
	private double achamt;
	private double otheramt;
	private String currency_ID;
	private Station expenselocation;
	private ExpenseType expensetype;
	private String auditComments;
	private Status status;
	private double incidentalAmountAuth;
	private double incidentalAmountClaimed;
	private double creditCardRefund;
	private Date voucherExpirationDate;
	private Date approval_date;
	private Agent agent;
	private Station station;
	private String _DATEFORMAT; // current login agent's date format
	private String _TIMEFORMAT; // current login agent's time format
	private TimeZone _TIMEZONE;
	private Audit_Claim audit_claim;
	private String modify_reason;
	private Date modify_time;

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

	@ManyToOne
	@JoinColumn(name = "audit_claim_id")
	public Audit_Claim getAudit_claim() {
		return audit_claim;
	}

	public void setAudit_claim(Audit_Claim audit_claim) {
		this.audit_claim = audit_claim;
	}

	public int getExpensepayout_ID() {
		return Expensepayout_ID;
	}

	public void setExpensepayout_ID(int expensepayout_ID) {
		Expensepayout_ID = expensepayout_ID;
	}

	@ManyToOne
	@JoinColumn(name = "expenselocation_ID")
	public Station getExpenselocation() {
		return expenselocation;
	}

	public void setExpenselocation(Station expenselocation) {
		this.expenselocation = expenselocation;
	}

	@ManyToOne
	@JoinColumn(name = "agent_ID")
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	@ManyToOne
	@JoinColumn(name = "station_ID")
	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	@ManyToOne
	@JoinColumn(name = "expensetype_ID")
	public ExpenseType getExpensetype() {
		return expensetype;
	}

	public void setExpensetype(ExpenseType expensetype) {
		this.expensetype = expensetype;
	}

	public String getCurrency_ID() {
		return currency_ID;
	}

	public void setCurrency_ID(String currency_ID) {
		this.currency_ID = currency_ID;
	}

	@Temporal(TemporalType.DATE)
	public Date getCreatedate() {
		return createdate;
	}

	@Transient
	public String getDiscreatedate() {
		return GenericDateUtils.formatDate(getCreatedate(), get_DATEFORMAT(), null, get_TIMEZONE());
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getDraft() {
		return draft;
	}

	public void setDraft(String draft) {
		this.draft = draft;
	}

	public Date getDraftpaiddate() {
		return draftpaiddate;
	}

	public void setDraftpaiddate(Date draftpaiddate) {
		this.draftpaiddate = draftpaiddate;
	}

	@Transient
	public String getDisdraftpaiddate() {
		return GenericDateUtils.formatDate(getDraftpaiddate(), get_DATEFORMAT(), null, null);
	}

	public Date getDraftreqdate() {
		return draftreqdate;
	}

	public void setDraftreqdate(Date draftreqdate) {
		this.draftreqdate = draftreqdate;
	}

	@Transient
	public String getDisdraftreqdate() {
		return GenericDateUtils.formatDate(getDraftreqdate(), get_DATEFORMAT(), null, null);
	}

	@Id
	@GeneratedValue
	public int getAudit_expensepayout_id() {
		return audit_expensepayout_id;
	}

	public void setAudit_expensepayout_id(int audit_expensepayout_id) {
		this.audit_expensepayout_id = audit_expensepayout_id;
	}

	public String getPaycode() {
		return paycode;
	}

	public void setPaycode(String paycode) {
		this.paycode = paycode;
	}

	public double getCheckamt() {
		return checkamt;
	}

	public void setCheckamt(double checkamt) {
		this.checkamt = checkamt;
	}

	@Transient
	public String getDischeckamt() {
		return CommonsConstants.DECIMALFORMAT.format(getCheckamt());
	}

	public int getMileageamt() {
		return mileageamt;
	}

	public void setMileageamt(int mileageamt) {
		this.mileageamt = mileageamt;
	}

	public double getVoucheramt() {
		return voucheramt;
	}

	public void setVoucheramt(double voucheramt) {
		this.voucheramt = voucheramt;
	}

	@Transient
	public String getDisvoucheramt() {
		return CommonsConstants.DECIMALFORMAT.format(getVoucheramt());
	}

	public double getPcardamt() {
		return pcardamt;
	}

	public void setPcardamt(double pcardamt) {
		this.pcardamt = pcardamt;
	}

	@Transient
	public String getDispcardamt() {
		return CommonsConstants.DECIMALFORMAT.format(getPcardamt());
	}

	public double getAchamt() {
		return achamt;
	}

	public void setAchamt(double achamt) {
		this.achamt = achamt;
	}

	@Transient
	public String getDisachamt() {
		return CommonsConstants.DECIMALFORMAT.format(getAchamt());
	}

	public double getOtheramt() {
		return otheramt;
	}

	public void setOtheramt(double otheramt) {
		this.otheramt = otheramt;
	}

	@Transient
	public String getDisotheramt() {
		return CommonsConstants.DECIMALFORMAT.format(getOtheramt());
	}

	@Column(name = "comments")
	public String getAuditComments() {
		return auditComments;
	}

	@ManyToOne
	@JoinColumn(name = "status_ID")
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setAuditComments(String comments) {
		this.auditComments = comments;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getApproval_date() {
		return approval_date;
	}

	public void setApproval_date(Date approval_date) {
		this.approval_date = approval_date;
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

	@Column(name = "incidental_amount_auth")
	public double getIncidentalAmountAuth() {
		return incidentalAmountAuth;
	}

	public void setIncidentalAmountAuth(double incidentalAmount) {
		this.incidentalAmountAuth = incidentalAmount;
	}

	@Column(name = "voucher_exp")
	@Temporal(TemporalType.DATE)
	public Date getVoucherExpirationDate() {
		return voucherExpirationDate;
	}

	public void setVoucherExpirationDate(Date voucherExpirationDate) {
		this.voucherExpirationDate = voucherExpirationDate;
	}

	@Column(name = "incidental_amount_claim")
	public double getIncidentalAmountClaimed() {
		return incidentalAmountClaimed;
	}
	
	public void setIncidentalAmountClaimed(double incidentalAmountClaimed) {
		this.incidentalAmountClaimed = incidentalAmountClaimed;
	}

	@Column(name = "creditcard_refund")
	public double getCreditCardRefund() {
		return creditCardRefund;
	}
	
	public void setCreditCardRefund(double creditCardRefund) {
		this.creditCardRefund = creditCardRefund;
	}
	
	
}