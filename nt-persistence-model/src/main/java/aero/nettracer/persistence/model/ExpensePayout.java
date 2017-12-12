/*
 * Created on Jul 14, 2004
 *

 * Window - Preferences - Java - Code Style - Code Templates
 */
package aero.nettracer.persistence.model;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.OrderBy;

@Entity
@Table(name = "expensepayout")
public class ExpensePayout {

	private int id;
	private Timestamp createdate;
	private String paycode;
	private int mileageamt;
	private double voucheramt;
	private Currency currency;
	private String draft;
	private Date draftreqdate;
	private Date draftpaiddate;
	private double checkamt;
	private Station expenselocation;
	private ExpenseType expensetype;
	private Status status;
	private Agent agent;
	private Station station;
	private Timestamp approval_date;
	private double incidentalAmountAuth;
	private double incidentalAmountClaimed;
	private double creditCardRefund;
	private Date voucherExpirationDate;
	private Incident incident;
	private BDO bdo;
	private OHD ohd;
	private String distributemethod;
	private String paytype;
	private int printcount;
	private String ordernum;
	private String cancelreason;
	private int cancelcount;
	private String slvnum;
	private String seccode;
	private long issuanceItem;
	private Date maildate;
	private String firstname;
	private String middlename;
	private String lastname;
	private String address1;
	private String address2;
	private String city;
	private String state_ID;
	private String province;
	private String zip;
	private String homephone;
	private String workphone;
	private String mobile;
	private String email;
	private String countrycode_ID;
	private double pcardamt;
	private double achamt;
	private double otheramt;
	private double amount;
	private Set<Remark> remarks = new HashSet<Remark>();

	@Id
	@GeneratedValue
	@Column(name = "expensepayout_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "createdate")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	@Column(name = "paycode")
	public String getPaycode() {
		return paycode;
	}

	public void setPaycode(String paycode) {
		this.paycode = paycode;
	}

	@Column(name = "mileageamt")
	public int getMileageamt() {
		return mileageamt;
	}

	public void setMileageamt(int mileageamt) {
		this.mileageamt = mileageamt;
	}

	@Column(name = "voucheramt")
	public double getVoucheramt() {
		return voucheramt;
	}

	public void setVoucheramt(double voucheramt) {
		this.voucheramt = voucheramt;
	}

	@Column(name = "currency_id")
	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	@Column(name = "draft")
	public String getDraft() {
		return draft;
	}

	public void setDraft(String draft) {
		this.draft = draft;
	}

	@Column(name = "draftreqdate")
	public Date getDraftreqdate() {
		return draftreqdate;
	}

	public void setDraftreqdate(Date draftreqdate) {
		this.draftreqdate = draftreqdate;
	}

	@Column(name = "draftpaiddate")
	public Date getDraftpaiddate() {
		return draftpaiddate;
	}

	public void setDraftpaiddate(Date draftpaiddate) {
		this.draftpaiddate = draftpaiddate;
	}

	@Column(name = "checkamt")
	public double getCheckamt() {
		return checkamt;
	}

	public void setCheckamt(double checkamt) {
		this.checkamt = checkamt;
	}

	@ManyToOne
	@JoinColumn(name = "expenselocation_id")
	public Station getExpenselocation() {
		return expenselocation;
	}

	public void setExpenselocation(Station expenselocation) {
		this.expenselocation = expenselocation;
	}

	@ManyToOne
	@JoinColumn(name = "expensetype_id", nullable = false)
	public ExpenseType getExpensetype() {
		return expensetype;
	}

	public void setExpensetype(ExpenseType expensetype) {
		this.expensetype = expensetype;
	}

	@ManyToOne
	@JoinColumn(name = "status_id")
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@ManyToOne
	@JoinColumn(name = "agent_id", nullable = false)
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	@ManyToOne
	@JoinColumn(name = "station_id", nullable = false)
	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	@Column(name = "approval_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getApproval_date() {
		return approval_date;
	}

	public void setApproval_date(Timestamp approval_date) {
		this.approval_date = approval_date;
	}

	@Column(name = "incidental_amount_auth")
	public double getIncidentalAmountAuth() {
		return incidentalAmountAuth;
	}

	public void setIncidentalAmountAuth(double incidentalAmountAuth) {
		this.incidentalAmountAuth = incidentalAmountAuth;
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

	@Column(name = "voucher_exp")
	@Temporal(TemporalType.DATE)
	public Date getVoucherExpirationDate() {
		return voucherExpirationDate;
	}

	public void setVoucherExpirationDate(Date voucherExpirationDate) {
		this.voucherExpirationDate = voucherExpirationDate;
	}

	@ManyToOne
	@JoinColumn(name = "incident_ID")
	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	@ManyToOne
	@JoinColumn(name = "bdo_id")
	public BDO getBdo() {
		return bdo;
	}

	public void setBdo(BDO bdo) {
		this.bdo = bdo;
	}

	@ManyToOne
	@JoinColumn(name = "ohd_id")
	public OHD getOhd() {
		return ohd;
	}

	public void setOhd(OHD ohd) {
		this.ohd = ohd;
	}

	@Column(name = "distributemethod")
	public String getDistributemethod() {
		return distributemethod;
	}

	public void setDistributemethod(String distributemethod) {
		this.distributemethod = distributemethod;
	}

	@Column(name = "paytype")
	public String getPaytype() {
		return paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}

	@Column(name = "printcount")
	public int getPrintcount() {
		return printcount;
	}

	public void setPrintcount(int printcount) {
		this.printcount = printcount;
	}

	@Column(name = "ordernum")
	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}

	@Column(name = "cancelreason")
	public String getCancelreason() {
		return cancelreason;
	}

	public void setCancelreason(String cancelreason) {
		this.cancelreason = cancelreason;
	}

	@Column(name = "cancelcount")
	public int getCancelcount() {
		return cancelcount;
	}

	public void setCancelcount(int cancelcount) {
		this.cancelcount = cancelcount;
	}

	@Column(name = "slvnum")
	public String getSlvnum() {
		return slvnum;
	}

	public void setSlvnum(String slvnum) {
		this.slvnum = slvnum;
	}

	@Column(name = "seccode")
	public String getSeccode() {
		return seccode;
	}

	public void setSeccode(String seccode) {
		this.seccode = seccode;
	}

	@Column(name = "issuanceitem")
	public long getIssuanceItem() {
		return issuanceItem;
	}

	public void setIssuanceItem(long issuanceItem) {
		this.issuanceItem = issuanceItem;
	}

	@Column(name = "maildate")
	public Date getMaildate() {
		return maildate;
	}

	public void setMaildate(Date maildate) {
		this.maildate = maildate;
	}

	@Column(name = "firstname")
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "middlename")
	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	@Column(name = "lastname")
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "address1")
	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@Column(name = "address2")
	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@Column(name = "city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state_id")
	public String getState_ID() {
		return state_ID;
	}

	public void setState_ID(String state_ID) {
		this.state_ID = state_ID;
	}

	@Column(name = "province")
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "zip")
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Column(name = "homephone")
	public String getHomephone() {
		return homephone;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}

	@Column(name = "workphone")
	public String getWorkphone() {
		return workphone;
	}

	public void setWorkphone(String workphone) {
		this.workphone = workphone;
	}

	@Column(name = "mobile")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "countrycode_ID")
	public String getCountrycode_ID() {
		return countrycode_ID;
	}

	public void setCountrycode_ID(String countrycode_ID) {
		this.countrycode_ID = countrycode_ID;
	}

	@Column(name = "pcardamt")
	public double getPcardamt() {
		return pcardamt;
	}

	public void setPcardamt(double pcardamt) {
		this.pcardamt = pcardamt;
	}

	@Column(name = "achamt")
	public double getAchamt() {
		return achamt;
	}

	public void setAchamt(double achamt) {
		this.achamt = achamt;
	}

	@Column(name = "otheramt")
	public double getOtheramt() {
		return otheramt;
	}

	public void setOtheramt(double otheramt) {
		this.otheramt = otheramt;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "expensepayout_id", referencedColumnName="expensepayout_id")
	@OrderBy(clause = "createtime asc")
	public Set<Remark> getRemarks() {
		return remarks;
	}

	public void setRemarks(Set<Remark> remarks) {
		this.remarks = remarks;
	}

	//NTFIXME - Make this new db model dependent on commons before enabling the below code
	/*@Transient
	public double getAmount() {
		// FIXME: NT-7966: Case statement is only necessary while *amt properties remain employed in the POJO and table.
		double amount;
		switch (getPaytype() == null ? "" : getPaytype()) {
		case CommonsConstants.ENUM_MILE:
			amount = getMileageamt();
			break;
		case CommonsConstants.ENUM_VOUCHER:
			amount = getVoucheramt();
			break;
		case CommonsConstants.ENUM_CCREF:
			amount = getCreditCardRefund();
			break;
		case CommonsConstants.ENUM_PCARD:
			amount = getPcardamt();
			break;
		case CommonsConstants.ENUM_ACH:
			amount = getAchamt();
			break;
		case CommonsConstants.ENUM_OTHER:
			amount = getOtheramt();
			break;
		// ENUM_DRAFT, ENUM_PSO, ENUM_INVOICE, ENUM_INC, BDO expenses:
		default:
			amount = getCheckamt();
			break;
		}
		
		this.amount = amount;
		return this.amount;
	}
	
	@Transient
	public void setAmount(double amount) {
		this.amount = amount;
		// FIXME: NT-7966: Case statement is only necessary while *amt properties remain employed in the POJO and table.
		switch (getPaytype()) {
		case CommonsConstants.ENUM_DRAFT:
			setCheckamt(amount);
			break;
		case CommonsConstants.ENUM_PSO:
			setCheckamt(amount);
			break;
		case CommonsConstants.ENUM_INVOICE:
			setCheckamt(amount);
			break;
		case CommonsConstants.ENUM_MILE:
			setMileageamt((int)Math.round(amount));
			break;
		case CommonsConstants.ENUM_VOUCHER:
			setVoucheramt(amount);
			break;
		case CommonsConstants.ENUM_CCREF:
			setCreditCardRefund(amount);
			break;
		case CommonsConstants.ENUM_INC:
			setCheckamt(amount);
			break;
		case CommonsConstants.ENUM_PCARD:
			setPcardamt(amount);
			break;
		case CommonsConstants.ENUM_ACH:
			setAchamt(amount);
			break;
		case CommonsConstants.ENUM_OTHER:
			setOtheramt(amount);
			break;
		}
	}*/
	
	/*@Transient
	public String getDispamount() {
		if (getPaytype().equals("MILE")) {
			return String.valueOf((int)Math.round(getAmount()));
		} else {
			return CommonsConstants.DECIMALFORMAT.format(getAmount());
		}
	}*/
	
	/*@Transient
	public void setDispamount(String amount) {
		setAmount(CommonsUtils.convertToDouble(amount));
	}*/





	public static Comparator<ExpensePayout> PaymentTypeComparator = new Comparator<ExpensePayout>() {
	    public int compare(ExpensePayout expense1, ExpensePayout expense2) {
	      String paytype1 = expense1.getPaytype().toUpperCase();
	      String paytype2 = expense2.getPaytype().toUpperCase();
	      return paytype1.compareTo(paytype2);
	    }
	};
}